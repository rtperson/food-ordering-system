package com.gatheringability.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class KafkaMessageHelper {

    public<T> BiConsumer<SendResult<String, T>, Throwable>
    getKafkaCallback(String requestTopicName, T avroModel, String orderId, String avroModelName) {
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
                        avroModelName, requestTopicName, ex);
            }
        };
    }
}
