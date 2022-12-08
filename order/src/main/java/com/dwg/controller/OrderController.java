package com.dwg.controller;

import com.dwg.entity.Order;
import com.dwg.entity.vo.OrderVO;
import com.dwg.pojo.User;
import com.dwg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Autrui
 * @since 2022-12-05
 */
@RestController
@RequestMapping("/order")
// @RefreshScope
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Value("${pattern.dateformat}")
    String date;

    //@GetMapping("{id}")
    //public User getOrderNameById(@PathVariable Long id) {
    //    return orderService.getUser(id);
    //}

    @RequestMapping("now")
    public String now(){
        return date;
    }

    @GetMapping("{orderId}")
    public OrderVO getDetailOrder(@PathVariable(value = "orderId") Long orderId) {
        return orderService.selectOrderById(orderId);
    }
}
