package com.jpmc.midascore.listener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaTransactionListener {

    @Value("${general.kafka-topic}")
    private String topic;

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "${general.kafka-group-id}")
    public void eventListener(String transaction) {
        log.info("Received transaction: {},\n" + transaction, "Sender ID {},\n" + transaction.split(", ")[0],
                "Receiver ID {},\n" + transaction.split(", ")[1], "Amount {},\n" + transaction.split(", ")[2]);
        System.out.println("Received transaction: {}" + transaction);
        System.out.println("Sender ID: {}" + transaction.split(", ")[0]);
        System.out.println("Receiver ID: {}" + transaction.split(", ")[1]);
        System.out.println("Amount: {}" + transaction.split(", ")[2]);
    }
}