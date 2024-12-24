package com.switchfully.parkshark_2024_10.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RoleTest {
    @Test
    void hasPermission() {
        Role role = Role.MANAGER;
        Permission permission = Permission.CAN_VIEW_DIVISIONS;

        assertTrue(role.hasPermission(permission));
    }
}