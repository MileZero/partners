/*
 * Copyright (c) MileZero. All Rights Reserved
 */

package com.mz.partners.resources;

import com.mz.partners.business.CandyBusiness;
import com.mz.partners.models.model.CandyPojo;
import com.mz.partners.api.CandyApi;
import com.mz.partners.resources.transforms.CandyPojoTransform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

@Service
public class Candy implements CandyApi {
    private static final Logger log = LoggerFactory.getLogger(Candy.class);

    private final CandyBusiness handler;

    @Autowired
    public Candy(CandyBusiness businessHandler) {
        handler = businessHandler;
    }

    @Override
    public Response put(
            String candyId,
            CandyPojo candy) {
        try {
            com.mz.partners.model.CandyPojo candyPojo = CandyPojoTransform.fromExternal(candy);
            handler.eat(candyPojo, candyId);

            return Response.accepted().build();
        } catch (RuntimeException re) {
            log.error("Unhandled exception", re);
            return Response.serverError().build();
        }
    }

    @Override
    public Response get(String candyId) {
        try {
            return Response.ok(handler.giveAway(candyId)).build();
        } catch (RuntimeException re) {
            log.error("Unhandled exception", re);
            return Response.serverError().build();
        }
    }
}
