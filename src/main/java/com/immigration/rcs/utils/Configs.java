package com.immigration.rcs.utils;

public class Configs {
    // Database Configuration
    public static final String DB_URL = "jdbc:sqlserver://10.4.0.152:1433;databaseName=RCS_LOGS;encrypt=true;trustServerCertificate=true";
    public static final String DB_USERNAME = "sa";
    public static final String DB_PASSWORD = "epp@2018";
    public static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DB_POOL_NAME = "CONNECTION_POOL_2";
    public static final int DB_MAXIMUM_POOL_SIZE = 10;
    public static final int DB_MINIMUM_IDLE = 5;
    public static final int DB_CONNECTION_TIMEOUT = 30000;
    public static final int DB_IDLE_TIMEOUT = 120000;
    public static final int DB_MAX_LIFETIME = 1800000;
    public static final int DB_LEAK_DETECTION_THRESHOLD = 180000;
}
