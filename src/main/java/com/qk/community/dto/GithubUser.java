package com.qk.community.dto;

import lombok.Data;

@Data
public class GithubUser {
    private String name;
    private String bio;
    private Long id;
    private String avatarUrl;
}
