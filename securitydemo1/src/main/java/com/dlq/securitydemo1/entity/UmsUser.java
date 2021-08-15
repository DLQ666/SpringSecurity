package com.dlq.securitydemo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@program: SpringSecurity
 *@description:
 *@author: Hasee
 *@create: 2021-08-12 16:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsUser {

    private Long id;
    private String username;
    private String password;

}
