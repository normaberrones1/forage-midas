package com.jpmc.midascore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import com.jpmc.midascore.foundation.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaTransactionListener {

    @Value("${general.kafka-topic}")
    private String topic;

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "${general.kafka-group-id}")
    public void eventListener(String transaction) {
        log.info("Received transaction: " + transaction);
        System.out.println("Received transaction: " + transaction);
    }





}
