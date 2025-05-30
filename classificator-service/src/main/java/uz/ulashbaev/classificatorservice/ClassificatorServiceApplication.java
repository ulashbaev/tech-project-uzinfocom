package uz.ulashbaev.classificatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClassificatorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassificatorServiceApplication.class, args);
    }

}
