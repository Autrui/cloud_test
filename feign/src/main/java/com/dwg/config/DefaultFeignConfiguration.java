package com.dwg.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author Autrui
 * @date 2022/12/8
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }

}
