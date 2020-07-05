package com.sakeriniwebsite.emusicstore.service.impl;

import com.sakeriniwebsite.emusicstore.dao.AuthorityDAO;
import com.sakeriniwebsite.emusicstore.model.Authorities;
import com.sakeriniwebsite.emusicstore.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityDAO authorityDAO;

    @Override
    public void addAuthority(Authorities authority) {
        authorityDAO.save(authority);
    }

    @Override
    public Authorities getAuthorityById(int authorityId) {
        Optional<Authorities> result = authorityDAO.findById(authorityId);
        Authorities authority = null;
        if (result.isPresent()) {
            authority = result.get();
        } else {
            throw new RuntimeException("NOT FOUND AUTHORITY ID - " + authorityId);
        }

        return authority;
    }

    @Override
    public List<Authorities> getAllAuthorities() {
        return authorityDAO.findAll();
    }

    @Override
    public String getAllAuthoritiesString() {
        List<Authorities> authorities = getAllAuthorities();
        StringBuilder sb = new StringBuilder();
        for(Authorities authority : authorities) {
            sb.append(authority.getAuthority());
            sb.append(",");
        }

        return sb.toString();
    }
}
