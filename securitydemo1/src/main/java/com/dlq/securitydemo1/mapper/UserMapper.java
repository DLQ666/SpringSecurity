package com.dlq.securitydemo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dlq.securitydemo1.entity.UmsUser;
import org.apache.ibatis.annotations.Mapper;

/**
 *@description:
 *@author: Hasee
 *@create: 2021-08-12 16:13
 */
@Mapper
public interface UserMapper extends BaseMapper<UmsUser> {
}
