package com.dwg.service;

import com.dwg.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dwg.entity.vo.OrderVO;
import com.dwg.pojo.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Autrui
 * @since 2022-12-05
 */
public interface OrderService extends IService<Order> {
    OrderVO selectOrderById(Long orderId);

    User getUser(Long userId);

}
