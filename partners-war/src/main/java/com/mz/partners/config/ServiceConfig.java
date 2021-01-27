/*
 * Copyright (c) MileZero. All Rights Reserved
 */

package com.mz.partners.config;
import com.mz.core.common.MZForkJoinPool;
import com.mz.core.jersey.ws.server.vitalsigns.VitalSign;
import com.mz.core.jersey.ws.server.ZeroConfig;
import com.mz.metrics.service.cloudwatch.CloudWatchConfig;

import java.util.concurrent.ForkJoinPool;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Service Spring configuration class.
 * Imports Spring Config classes of dependencies.
 * Creates beans used by the service.
 */
@Configuration
@ComponentScan({
    "com.mz.partners.business",
    "com.mz.partners.config",
    "com.mz.partners.resources",
})
@Import({
    ZeroConfig.class,
    CloudWatchConfig.class
})
@Slf4j
public class ServiceConfig {
    @Value("${server.workerthreads}")
    private int workers;

    @Bean(name="workerThreads")
    public ForkJoinPool subWorkerThreadPool() {
        log.info("Found worker pool size ({})", workers);
        return new MZForkJoinPool(workers);
    }

    @Bean
    public VitalSign<Number> getThreadPoolVitalSign (ForkJoinPool workerThreads) {
        return () -> workerThreads.getActiveThreadCount();
    }
}
