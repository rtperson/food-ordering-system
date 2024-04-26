package com.gatheringability.kafka.consumer;

import org.apache.avro.specific.SpecificRecordBase;

public interface KafkaConsumer<T extends SpecificRecordBase> {
   // void receive(List<T> messages, List<Long> keys, List<>)
}
