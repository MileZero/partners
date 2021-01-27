/*
 * Copyright (c) MileZero. All Rights Reserved
 */

package com.mz.partners.resources.transforms;

import com.mz.partners.models.model.CandyPojo;

public class CandyPojoTransform {

    public static com.mz.partners.model.CandyPojo fromExternal(CandyPojo candyPojoExternal) {
        com.mz.partners.model.CandyPojo candyPojo = new com.mz.partners.model.CandyPojo();
        candyPojo.setName(candyPojoExternal.getName());
        return candyPojo;
    }
}
