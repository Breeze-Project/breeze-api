package org.breeze.api.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface RowMapper<T> {

    @NotNull
    T mapRow(@NotNull ResultSet resultSet) throws SQLException;
}
