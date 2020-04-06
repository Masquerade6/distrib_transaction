package com.mobei.hmily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableAspectJAutoProxy
@ComponentScan({"com.mobei.hmily.service", "org.dromara.hmily"})
public class Bank2TccServer {
	public static void main(String[] args) {
		SpringApplication.run(Bank2TccServer.class, args);
	}
}
