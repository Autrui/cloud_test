package com.dwg.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dwg.entity.Order;
import com.dwg.pojo.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Autrui
 * @date 2022/12/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {

    private Order order;

    private User user;

}
