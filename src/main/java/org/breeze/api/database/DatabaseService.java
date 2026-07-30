package org.breeze.api.database;

import org.jetbrains.annotations.NotNull;

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
}
