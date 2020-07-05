package com.sakeriniwebsite.emusicstore.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Authorities {
    @Id
    @GeneratedValue
    private int authoritiesId;
    private String username;
    private String authority;
}
