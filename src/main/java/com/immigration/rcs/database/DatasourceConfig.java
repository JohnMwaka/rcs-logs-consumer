package com.immigration.rcs.database;

import com.immigration.rcs.utils.Configs;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Isolation;

@Configuration
public class DatasourceConfig {

    @Bean
    public HikariDataSource getDatasource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(Configs.DB_URL);
        config.setUsername(Configs.DB_USERNAME);
        config.setPassword(Configs.DB_PASSWORD);
        config.setDriverClassName(Configs.DB_DRIVER);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setMaximumPoolSize(Configs.DB_MAXIMUM_POOL_SIZE);
        config.setPoolName(Configs.DB_POOL_NAME);
        config.setAutoCommit(true);
        config.setConnectionTimeout(Configs.DB_CONNECTION_TIMEOUT);
        config.setIdleTimeout(Configs.DB_IDLE_TIMEOUT);
        config.setMinimumIdle(Configs.DB_MINIMUM_IDLE);
        config.setMaxLifetime(Configs.DB_MAX_LIFETIME);
        config.setLeakDetectionThreshold(Configs.DB_LEAK_DETECTION_THRESHOLD);
        config.setTransactionIsolation(String.valueOf(Isolation.READ_COMMITTED.value()));
        return new HikariDataSource(config);
    }
}
