package com.example.service.springbootrewards.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public abstract class Reward {
    // Including Jackson serialization
    @JsonInclude
    protected Long points;

    public abstract Long getPoints();
}