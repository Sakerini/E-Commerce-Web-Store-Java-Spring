package com.sakeriniwebsite.emusicstore.model;

import com.sakeriniwebsite.emusicstore.service.AuthorityService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private int userId;
    private String username;
    private String password;
    private boolean enabled;
    private int customerId;
    private String roles;

}
