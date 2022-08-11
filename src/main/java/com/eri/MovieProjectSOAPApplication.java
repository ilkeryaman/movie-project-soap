package com.eri;

import com.eri.bottomup.controller.impl.MovieControllerImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class MovieProjectSOAPApplication implements CommandLineRunner {

    @Value("${soap.bottomup.url}")
    private String url;

    public static void main(String[] args) {
        SpringApplication.run(MovieProjectSOAPApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        publishWebService();
    }

    private void publishWebService(){
        Endpoint.publish(url, new MovieControllerImpl());
    }
}