package com.hfcsbc.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**  
 * 封装工具类 SecurityUtils
 */  
public final class SecurityUtils {

    /**  
     * 获取当前用户名
     * @return java.lang.String
     * @date 2018/3/19 14:02
     */  
    public static String getCurrentUserUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
             currentUserName = authentication.getName();

        }
        return currentUserName;
    }

}
