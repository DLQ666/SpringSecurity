package com.dlq.securitydemo1.controller;

import com.dlq.securitydemo1.entity.UmsUser;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *@program: SpringSecurity
 *@description:
 *@author: Hasee
 *@create: 2021-08-08 14:10
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello security";
    }

    @GetMapping("/index")
    public String index(){
        return "hello index";
    }

    @GetMapping("/update")
    //@Secured({"ROLE_sale","ROLE_hr"})
    //@PreAuthorize("hasAnyAuthority('admins')")
    @PostAuthorize("hasAnyAuthority('manager')")
    public String update(){
        System.out.println("update。。。。。。");
        return "hello update";
    }

    @GetMapping("getAll")
    @PostAuthorize("hasAnyAuthority('admins')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<UmsUser> getAllUser(){
        ArrayList<UmsUser> list = new ArrayList<>();
        list.add(new UmsUser(1L,"admin1","6666"));
        list.add(new UmsUser(2L,"admin2","888"));
        System.out.println(list);
        return list;
    }
}
