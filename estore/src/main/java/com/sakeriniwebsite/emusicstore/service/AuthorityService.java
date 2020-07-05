package com.sakeriniwebsite.emusicstore.service;

import com.sakeriniwebsite.emusicstore.model.Authorities;

import java.util.List;

public interface AuthorityService {
    public void addAuthority(Authorities authority);
    Authorities getAuthorityById(int userId);
    List<Authorities> getAllAuthorities();
    String getAllAuthoritiesString();
}
