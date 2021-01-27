/*
 * Copyright (c) MileZero. All Rights Reserved
 */

package com.mz.partners.client;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ActiveProfiles(profiles = "dev")
@ContextConfiguration(classes = {CandyTestClientConfig.class})
public abstract class CandyClientIntegrationTestBase extends AbstractJUnit4SpringContextTests {

}
