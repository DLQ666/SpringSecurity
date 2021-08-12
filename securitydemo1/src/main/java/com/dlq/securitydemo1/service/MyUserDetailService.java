package com.dlq.securitydemo1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dlq.securitydemo1.entity.UmsUser;
import com.dlq.securitydemo1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@program: SpringSecurity
 *@description:
 *@author: Hasee
 *@create: 2021-08-12 15:22
 */
@Service("userDetailsService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用 userMapper 中方法，根据用户名查询数据库
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        QueryWrapper<UmsUser> wrapper = new QueryWrapper<>();
        // where username=？
        wrapper.eq("username", username);
        UmsUser umsUser = userMapper.selectOne(wrapper);
        //判断
        if (umsUser == null){//数据库没有用户名，认证失败
            throw new UsernameNotFoundException("用户名不存在！");
        }
        //从查询数据库返回user对象，得到用户名和密码，返回
        return new User(umsUser.getUsername(),
                new BCryptPasswordEncoder().encode(umsUser.getPassword()), auths);
    }
}
