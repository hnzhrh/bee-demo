package com.hnzhrh.bee.start;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication(scanBasePackages = {"com.hnzhrh"})
@EnableConfigurationProperties
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.hnzhrh"})
@EnableKnife4j
@EnableSwagger2WebMvc
@MapperScan("com.hnzhrh.**.mapper")
public class BeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeeApplication.class, args);
    }
}
