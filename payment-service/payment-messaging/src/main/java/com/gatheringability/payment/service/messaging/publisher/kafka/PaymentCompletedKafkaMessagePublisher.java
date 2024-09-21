package com.gatheringability.payment.service.messaging.publisher.kafka;

import com.gatheringability.kafka.order.avro.model.PaymentRequestAvroModel;
import com.gatheringability.kafka.order.avro.model.PaymentResponseAvroModel;
import com.gatheringability.kafka.producer.KafkaMessageHelper;
import com.gatheringability.kafka.producer.service.KafkaProducer;
import com.gatheringability.payment.service.domain.config.PaymentServiceConfigData;
import com.gatheringability.payment.service.domain.event.PaymentCompletedEvent;
import com.gatheringability.payment.service.domain.ports.output.message.publisher.PaymentCompletedMessagePublisher;
import com.gatheringability.payment.service.messaging.mapper.PaymentMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentCompletedKafkaMessagePublisher implements PaymentCompletedMessagePublisher {

    private final PaymentMessagingDataMapper paymentMessagingDataMapper;
    private final KafkaProducer<String, PaymentResponseAvroModel> kafkaProducer;
    private final PaymentServiceConfigData paymentServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;

    public PaymentCompletedKafkaMessagePublisher(PaymentMessagingDataMapper paymentMessagingDataMapper,
                                                 KafkaProducer<String, PaymentResponseAvroModel> kafkaProducer,
                                                 PaymentServiceConfigData paymentServiceConfigData, KafkaMessageHelper kafkaMessageHelper) {
        this.paymentMessagingDataMapper = paymentMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.paymentServiceConfigData = paymentServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(PaymentCompletedEvent domainEvent) {
        String orderId = domainEvent.getPayment().getOrderId().getValue().toString();

        log.info("Received Payment Completed event for orderId: {}", orderId);

        try {
            PaymentResponseAvroModel paymentResponseAvroModel =
                    paymentMessagingDataMapper.paymentCompletedEventToPaymentResponseAvroModel(domainEvent);
            kafkaProducer.send(paymentServiceConfigData.getPaymentResponseTopicName(),
                            orderId,
                            paymentResponseAvroModel,
                            kafkaMessageHelper.getKafkaCallback(paymentServiceConfigData.getPaymentResponseTopicName(),
                                    paymentResponseAvroModel,
                                    orderId,
                                    "PaymentResponseAvroModel"));
            log.info("PaymentResponseAvroModel sent to kafka for orderId: {}", orderId);
        } catch (Exception e) {
            log.error("error while sending PaymentResponseAvroModel " +
                    "to Kafka for order id: {}, error: {}, exception: {}", orderId, e.getMessage(), e.getClass().toString());
        }
    }
}
