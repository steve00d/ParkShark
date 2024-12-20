package com.switchfully.parkshark_2024_10.auth;

import java.util.ArrayList;
import java.util.List;

public enum Role {

    MANAGER(
            Permission.CAN_CREATE_DIVISIONS,
            Permission.CAN_VIEW_DIVISIONS,
            Permission.CAN_VIEW_PARKING_LOTS
    ),
    MEMBER(

    );

    private final List<Permission> permissions = new ArrayList<>();

    Role(Permission... permissions) {
        this.permissions.addAll(List.of(permissions));
    }

    public boolean hasPermission(Permission permission) {
        return this.permissions.stream().anyMatch(p -> p.equals(permission));
    }
}
