package com.bootcamp;

import com.bootcamp.model.ProductClient;
import com.bootcamp.repository.IProductClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableCaching
public class MicroserviceProductClientApplication
//        implements CommandLineRunner
{

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private IProductClientRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProductClientApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        ProductClient productClient = new ProductClient();
//        productClient.setIdClient("638e1f0df55f9276341bc62c");
//        productClient.setIdProduct("638e0d1343742c1abbec2d1b");
//        productClient.setDateCreated("2022-12-14 16:42:13");
//        repository.save(productClient).subscribe();
//        LOG.info("Done saving productClient. Data: {}.", repository.findAll());
//    }
}
