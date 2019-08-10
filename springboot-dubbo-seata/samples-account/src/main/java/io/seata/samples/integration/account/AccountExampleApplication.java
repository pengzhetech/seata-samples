package io.seata.samples.integration.account;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "io.seata.samples.integration.account")
@EnableDiscoveryClient
@MapperScan({"io.seata.samples.integration.account.mapper"})
@EnableDubbo(scanBasePackages = "io.seata.samples.integration.account")
public class AccountExampleApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountExampleApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting~~~~~~~~~~~~~~~~");
        SpringApplication.run(AccountExampleApplication.class, args);
    }

}

