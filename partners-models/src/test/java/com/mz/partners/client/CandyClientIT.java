/*
 * Copyright (c) MileZero. All Rights Reserved
 */

package com.mz.partners.client;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class CandyClientIT extends CandyClientIntegrationTestBase {

    @Ignore
    @Test
    public void testPutAndGetCandy() throws Exception {
        /*CandyPojo candy = new CandyPojo();
        candy.setName("pits");
        client.put("test2", candy);

        Response response = client.get("test2");
        CandyPojo retrieved = (CandyPojo) response.getEntity();
        Assert.assertEquals(retrieved.getName(), candy.getName());*/
    }
}
