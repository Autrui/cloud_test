package com.dwg.service.serviceImpl;

import com.dwg.entity.User;
import com.dwg.mapper.UserMapper;
import com.dwg.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
