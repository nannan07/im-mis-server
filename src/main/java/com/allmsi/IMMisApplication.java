package com.allmsi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@MapperScan("com.allmsi.**.dao")
public class IMMisApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(IMMisApplication.class).web(true).run(args);
	}
}