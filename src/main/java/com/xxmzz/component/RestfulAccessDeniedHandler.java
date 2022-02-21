package com.xxmzz.component;

import cn.hutool.json.JSONUtil;
import com.xxmzz.common.CommonResult;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当用户没有访问权限时的处理器，用于返回JSON格式的处理结果
 * @author CHEN-PJ
 * @title: RestfulAccessDeniedHandler
 * @projectName mall
 * @description: TODO
 * @date 2022/2/717:56
 */
/*@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
        httpServletResponse.getWriter().flush();
    }
}*/
