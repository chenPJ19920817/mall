package com.xxmzz.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.xxmzz.common.IpUtil;
import com.xxmzz.component.JwtTokenUtil;
import com.xxmzz.dto.UmsAdminParam;
import com.xxmzz.entity.UmsAdmin;
import com.xxmzz.entity.UmsAdminLoginLog;
import com.xxmzz.entity.UmsAdminRoleRelation;
import com.xxmzz.entity.UmsRole;
import com.xxmzz.mapper.UmsAdminLoginLogMapper;
import com.xxmzz.mapper.UmsAdminMapper;
import com.xxmzz.mapper.UmsAdminRoleRelationMapper;
import com.xxmzz.service.UmsAdminRoleRelationService;
import com.xxmzz.service.UmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-02-08
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    /*private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminService umsAdminService;
    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private UmsAdminRoleRelationService umsAdminRoleRelationService;
    @Autowired
    private UmsAdminLoginLogMapper loginLogMapper;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin umsAdmin = new UmsAdmin().selectOne(Wrappers.lambdaQuery(UmsAdmin.class)
                .eq(UmsAdmin::getUsername, username)
                .last(" limit 1 "));
        if(ObjectUtil.isNotNull(umsAdmin)) {
            return  umsAdmin;
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        List<UmsAdmin> umsAdmins = new UmsAdmin().selectList(Wrappers.lambdaQuery(UmsAdmin.class)
                .eq(UmsAdmin::getUsername, umsAdmin.getUsername()));
        if (umsAdmins.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                //Asserts.fail("密码不正确");
            }
            if(!userDetails.isEnabled()){
                //Asserts.fail("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
            insertLoginLog(username);
        } catch (Exception e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    *//**
     * 添加登录记录
     * @param username 用户名
     *//*
    private void insertLoginLog(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        if(admin==null) return;
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(IpUtil.getClinetIpByReq(request));
        loginLogMapper.insert(loginLog);
    }

    *//**
     * 根据用户名修改登录时间
     *//*
    private void updateLoginTimeByUsername(String username) {
        UmsAdmin record = new UmsAdmin();
        record.setLoginTime(new Date());
        new UmsAdmin().update(Wrappers.lambdaUpdate(UmsAdmin.class)
                        .eq(UmsAdmin::getUsername,username)
                .set(UmsAdmin::getLoginTime,new Date()));
    }

    *//*@Override
    public String refreshToken(String oldToken) {
        return jwtTokenUtil.refreshHeadToken(oldToken);
    }*//*

    @Override
    public UmsAdmin getItem(Long id) {
        return umsAdminService.getItem(id);
    }

    @Override
    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        Integer start = (pageNum-1) * pageSize;
        Integer end = start + pageSize;
        List<UmsAdmin> umsAdmins = new UmsAdmin().selectList(Wrappers.lambdaQuery(UmsAdmin.class)
                .like(UmsAdmin::getUsername, keyword)
                .last(" limit "+ start +"," + end));
        return umsAdmins;
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        admin = umsAdminService.getItem(id);
        int count = 0;
        if(ObjectUtil.isNotNull(admin)){
            if(!admin.getPassword().equals(admin.getPassword())){
                //与原加密密码不同的需要加密修改
                if(StrUtil.isEmpty(admin.getPassword())){
                    admin.setPassword(null);
                }else{
                    admin.setPassword(passwordEncoder.encode(admin.getPassword()));
                    admin.updateById();
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        List<UmsAdminRoleRelation> umsAdminRoleRelations = new UmsAdminRoleRelation().selectList(Wrappers.lambdaQuery(UmsAdminRoleRelation.class)
                .eq(UmsAdminRoleRelation::getAdminId, adminId));
        if(CollectionUtil.isNotEmpty(umsAdminRoleRelations)){
            List<Long> ids = umsAdminRoleRelations.stream().map(UmsAdminRoleRelation::getId).collect(Collectors.toList());
            umsAdminRoleRelationService.removeByIds(ids);
        }
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            umsAdminRoleRelationService.saveBatch(list);
        }
        return count;
    }*/
}
