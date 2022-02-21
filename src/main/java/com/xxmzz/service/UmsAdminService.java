package com.xxmzz.service;

import com.xxmzz.dto.UmsAdminParam;
import com.xxmzz.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxmzz.entity.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-02-08
 */
public interface UmsAdminService extends IService<UmsAdmin> {
    /**
     * 根据用户名获取后台管理员
     *//*
    UmsAdmin getAdminByUsername(String username);

    *//**
     * 注册功能
     *//*
    UmsAdmin register(UmsAdminParam umsAdminParam);

    *//**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     *//*
    String login(String username,String password);

    *//**
     * 刷新token的功能
     * @param oldToken 旧的token
     *//*
    String refreshToken(String oldToken);

    *//**
     * 根据用户id获取用户
     *//*
    UmsAdmin getItem(Long id);

    *//**
     * 根据用户名或昵称分页查询用户
     *//*
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    *//**
     * 修改指定用户信息
     *//*
    int update(Long id, UmsAdmin admin);

    *//**
     * 删除指定用户
     *//*
    int delete(Long id);

    *//**
     * 修改用户角色关系
     *//*
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);*/
}
