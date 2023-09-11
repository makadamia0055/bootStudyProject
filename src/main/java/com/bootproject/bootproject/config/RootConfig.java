package com.bootproject.bootproject.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
