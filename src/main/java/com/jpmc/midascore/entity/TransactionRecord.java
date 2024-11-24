package com.jpmc.midascore.entity;

import jakarta.persistence.Entity;
import org.h2.engine.User;

@Entity
public class TransactionRecord {

    private UserRecord sender;

    private UserRecord recipient;

    private float amount;

    private long id;


}
