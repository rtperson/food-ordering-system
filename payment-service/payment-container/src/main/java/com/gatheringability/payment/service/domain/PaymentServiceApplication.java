package com.gatheringability.payment.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.gatheringability.payment.service.dataaccess")
@EntityScan(basePackages = "com.gatheringability.payment.service.dataaccess")
@SpringBootApplication(scanBasePackages = "com.gatheringability")
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }
}
