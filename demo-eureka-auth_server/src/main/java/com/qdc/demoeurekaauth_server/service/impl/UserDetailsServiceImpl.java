package com.qdc.demoeurekaauth_server.service.impl;

import com.qdc.demoeurekaauth_server.pojo.Role;
import com.qdc.demoeurekaauth_server.pojo.User;
import com.qdc.demoeurekaauth_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;
    /**
     *
     * @param username 用户登录的用户名
     * @return
     * @throws UsernameNotFoundException 当用户查询失败，抛出的异常
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userService.getUser(username);
        System.out.println(user+"aaaaaa");
        if(user==null || user.getId()<1){
            throw new UsernameNotFoundException("username not found:"+username);
        }
        /**
         * 查询成功，用户存储，需要匹配用户名和密码是否正确。
         * 匹配密码，是由SpringSecurity内部逻辑自动完成，只需要把查询的用户名正确密码返回即可。
         * 返回结果，是有UserDetails接口实现类型User，构造的时候需要提供7个参数
         * 用户名、密码、已启用帐户、账户是否过期、账户凭证是否过期、账户是否被锁定、登录用户权限集合
         */

       return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
               true,true,true,true,
               getGrantedAuthorites(user));


    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorites(User user) {
        Set<GrantedAuthority> authorities=new HashSet<>();
        for(Role role:user.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE"+role.getName()));
            System.out.println(role);
        }
        return  authorities;


    }
}
