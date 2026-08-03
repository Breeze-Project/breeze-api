package org.breeze.api.database;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public interface DatabaseService {

    void connect(@NotNull DatabaseConfig config);

    void shutdown();

    boolean isConnected();

    @NotNull
    Optional<DataSource> getDataSource();

    @NotNull
    Optional<DatabaseVendor> getVendor();

    int executeUpdate(@NotNull String sql, @NotNull Object... params);

    @NotNull
    <T> Optional<T> queryFirst(@NotNull String sql, @NotNull RowMapper<T> mapper, @NotNull Object... params);

    @NotNull
    <T> List<T> query(@NotNull String sql, @NotNull RowMapper<T> mapper, @NotNull Object... params);

    @NotNull
    <T> T inTransaction(@NotNull TransactionCallback<T> callback);
}
