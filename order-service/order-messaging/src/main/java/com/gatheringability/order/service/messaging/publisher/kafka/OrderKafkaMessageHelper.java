package com.gatheringability.order.service.messaging.publisher.kafka;

import com.gatheringability.kafka.order.avro.model.PaymentRequestAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class OrderKafkaMessageHelper {

    public<T> BiConsumer<SendResult<String, T>, Throwable>
    getKafkaCallback(String requestTopicName, T requestAvroModel, String orderId, String requestAvroModelName) {
        return (result, ex) -> {
            if (ex == null) {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("Received new metadata. Order ID: {}, Topic: {}; Partition {}; Offset {}; Timestamp {}, at time {}",
                        orderId,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp(),
                        System.nanoTime());
            } else {
                log.error("Error occurred while sending {} to topic {}",
                        requestAvroModelName, requestTopicName, ex);
            }
        };
    }
}
