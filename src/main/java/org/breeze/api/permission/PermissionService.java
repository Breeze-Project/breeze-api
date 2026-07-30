package org.breeze.api.permission;

import java.util.UUID;

public interface PermissionService {

    boolean hasPermission(UUID playerId, String permission);

    boolean hasPermission(UUID playerId, Permission permission);
}
