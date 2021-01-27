/*
 * Copyright (c) MileZero. All Rights Reserved
 */

package com.mz.partners.models.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CandyPojo {

    @NotNull
    @Size(min = 5, max = 10)
    private String name;

    public CandyPojo(){}

    public CandyPojo(String name) {
        this.name = name;
    }

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}
}
