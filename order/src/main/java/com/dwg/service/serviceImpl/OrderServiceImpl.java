package com.dwg.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dwg.clients.UserClient;
import com.dwg.entity.Order;
import com.dwg.entity.vo.OrderVO;
import com.dwg.mapper.OrderMapper;
import com.dwg.pojo.User;
import com.dwg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Autrui
 * @since 2022-12-05
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;

    @Override
    public OrderVO selectOrderById(Long orderId) {
        Order order = orderMapper.selectById(orderId);
        User user = userClient.findById(order.getUserId());
        return new OrderVO(order, user);
    }

    @Override
    public User getUser(Long userId) {
        return userClient.findById(userId);
    }
}
