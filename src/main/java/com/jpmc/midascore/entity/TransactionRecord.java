package com.jpmc.midascore.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
@Entity
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserRecord sender;

    @ManyToOne
    private UserRecord receiver;

    private float amount;

    private float incentive;

    public TransactionRecord(UserRecord sender, UserRecord receiver, float amount, float incentive) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.incentive = incentive;
    }

}
