package com.jpmc.midascore.producer;

import com.jpmc.midascore.foundation.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducer {
    private final String topic;
    private final KafkaTemplate<Object, String> kafkaTemplate;

    public KafkaProducer(@Value("${general.kafka-topic}") String topic, KafkaTemplate<Object, String> kafkaTemplate) {

        log.debug("Kafka");

        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String transactionLine) {
        String[] transactionData = transactionLine.split(", ");
        Transaction transaction = new Transaction(Long.parseLong(transactionData[0]),
                Long.parseLong(transactionData[1]), Float.parseFloat(transactionData[2]));

        kafkaTemplate.send(topic, transaction.toString());
    }
}