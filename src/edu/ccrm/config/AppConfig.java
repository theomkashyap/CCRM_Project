package edu.ccrm.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Singleton class for application-wide configuration.
 * Manages paths for data storage and backups.
 */
public final class AppConfig {
    // 1. Eager initialization of the Singleton instance
    private static final AppConfig INSTANCE = new AppConfig();

    private String dataDirectory;
    private String backupDirectory;

    // 2. Private constructor to prevent instantiation
    private AppConfig() {
        // Default values
        this.dataDirectory = "app-data/exports";
        this.backupDirectory = "app-data/backups";
    }

    // 3. Public static method to get the single instance
    public static AppConfig getInstance() {
        return INSTANCE;
    }

    /**
     * Loads configuration and ensures necessary directories exist.
     */
    public void loadConfiguration() {
        try {
            Files.createDirectories(Paths.get(dataDirectory));
            Files.createDirectories(Paths.get(backupDirectory));
            System.out.println("Configuration loaded. Data directory is ready.");
        } catch (IOException e) {
            System.err.println("FATAL: Could not create necessary application directories.");
            e.printStackTrace();
            System.exit(1); // Exit if we can't create directories
        }
    }

    public String getDataDirectory() {
        return dataDirectory;
    }

    public String getBackupDirectory() {
        return backupDirectory;
    }
}