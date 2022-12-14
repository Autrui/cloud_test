package com.dwg.clients;

import com.dwg.config.DefaultFeignConfiguration;
import com.dwg.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Autrui
 * @date 2022/12/8
 */

//单个client配置
@FeignClient(value = "user", configuration = DefaultFeignConfiguration.class)
//@FeignClient("user")
public interface UserClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

}
