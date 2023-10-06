package com.example.service.springbootrewards.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    @JsonInclude
    @Transient
    private Long rewardPoints;

    @JsonInclude
    @Transient
    private Double totalPurchases;

    public Customer() {
        super();
    }

    public Customer(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Long getRewardPoints() {
        if (transactions == null || transactions.isEmpty()) {
            return 0L;
        }

        return transactions.stream()
                .map(x -> x.getPoints().intValue())
                .reduce(0, Integer::sum)
                .longValue();
    }

    public Double getTotalPurchases() {
        if (transactions == null || transactions.isEmpty()) {
            return 0.0;
        }

        return transactions.stream()
                .map(x -> x.getTotal().doubleValue())
                .reduce(0.0, Double::sum);
    }
}