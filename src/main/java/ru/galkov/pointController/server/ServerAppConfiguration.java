package ru.galkov.pointController.server;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.galkov.pointController.server")
@PropertySource("application.properties")
public class ServerAppConfiguration {



}
