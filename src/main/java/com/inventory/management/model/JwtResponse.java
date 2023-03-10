package com.inventory.management.model;

public class JwtResponse {

    private AppUser user;
    private String jwtToken;

    public JwtResponse(AppUser user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
