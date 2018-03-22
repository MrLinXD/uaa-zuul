package com.hfcsbc.security;

import com.hfcsbc.domain.SysUser;
import com.hfcsbc.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

/** 提供自定义用户信息获取服务
 * Created by wangyunfei on 2017/6/9.
 */
//@Service("userDetailsService")
//@Slf4j
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private  SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String lowcaseUsername = username.toLowerCase();
        Optional<SysUser> realUser = sysUserRepository.findOneWithRolesByUsername(lowcaseUsername);



        return realUser.map(user -> {
            Set<GrantedAuthority> grantedAuthorities = user.getAuthorities();
            return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("用户" + lowcaseUsername + "不存在!"));
    }
}
