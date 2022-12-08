package com.dwg.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Autrui
 * @since 2022-12-07
 */
@Data
public class User implements Serializable {
    private Long id;

    private String username;

    private String address;


}
