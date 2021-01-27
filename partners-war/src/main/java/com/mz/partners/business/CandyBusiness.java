/*
 * Copyright (c) MileZero. All Rights Reserved
 */

package com.mz.partners.business;

import com.mz.metrics.service.Metrics;
import com.mz.metrics.service.Timed;
import com.mz.partners.model.CandyPojo;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandyBusiness {
    private final Metrics metrics;
    private final Map<String, CandyPojo> masterList;

    @Autowired
    public CandyBusiness(Metrics metrics) {
        this.metrics = metrics;
        this.masterList = new HashMap<>();
    }

    @Timed(beanName = "cloudWatchClient")
    public void eat(CandyPojo candy, String candyId) {
        final String method = "eat";
        if ("Beets".equals(candy.getName())) {
            throw new IllegalArgumentException("You tried to trick me.");
        }
        masterList.put(candyId, candy);
        metrics.incCounter(CandyBusiness.class, masterList.size(), method, "listSize");
    }

    public CandyPojo giveAway(String candyId) {
        return this.masterList.get(candyId);
    }
}
