package com.sakeriniwebsite.emusicstore.service;


import com.sakeriniwebsite.emusicstore.model.MyUserDetails;
import com.sakeriniwebsite.emusicstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Autowired
    AuthorityService authorityService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        String authorities = authorityService.getAllAuthoritiesString().toString();
        user.setRoles(authorities);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(user);
    }


}
