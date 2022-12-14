package com.dwg.controller;

import com.dwg.entity.vo.OrderVO;
import com.dwg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
    @Value("${pattern.dateformat}")
    String date;
    @Autowired
    private OrderService orderService;

    //@GetMapping("{id}")
    //public User getOrderNameById(@PathVariable Long id) {
    //    return orderService.getUser(id);
    //}

    @RequestMapping("now")
    public String now() {
        return date;
    }

    @GetMapping("{orderId}")
    public OrderVO getDetailOrder(@PathVariable(value = "orderId") Long orderId) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        map.put("2", "2");
        map.put("3", "2");
        map.forEach(
                (k, v) -> {
                    System.out.println("key=" + k + "    value=" + v);
                }
        );

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key=" + entry.getKey() + "    value=" + entry.getValue());
        }


        return orderService.selectOrderById(orderId);
    }
}
