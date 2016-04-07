package com.astontech.hr.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by deretayl1 on 3/31/2016.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.astontech.hr.domain"})
@EnableJpaRepositories(basePackages = {"com.astontech.hr.repositories."})
public class RepositoryConfiguration {

}