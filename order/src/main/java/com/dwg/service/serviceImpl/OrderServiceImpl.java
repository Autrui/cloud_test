package com.dwg.service.serviceImpl;

import com.dwg.entity.Order;
import com.dwg.mapper.OrderMapper;
import com.dwg.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Autrui
 * @since 2022-12-05
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
