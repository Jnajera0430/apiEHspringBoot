package com.hexagonal.api.domain.models;


public class AdditionalTasksInfo {
    private final Long userId;
    private final String username;
    private final String userEmail;

    public AdditionalTasksInfo(Long userId, String username, String userEmail) {
        this.userId = userId;
        this.username = username;
        this.userEmail = userEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    
}