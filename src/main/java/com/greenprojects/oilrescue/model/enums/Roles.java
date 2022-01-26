package com.greenprojects.oilrescue.model.enums;

public enum Roles {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER"),
    ROLE_MANAGER("ROLE_USER");

    private final String role;

    Roles(final String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
