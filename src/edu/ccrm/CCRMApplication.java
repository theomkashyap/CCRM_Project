package edu.ccrm;

import edu.ccrm.cli.ConsoleManager;
import edu.ccrm.config.AppConfig;

/**
 * Main entry point for the Campus Course & Records Manager (CCRM) application.
 * This class initializes the application configuration and starts the console manager.
 */
public class CCRMApplication {

    /**
     * The main method that launches the application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Initialize the Singleton AppConfig
        AppConfig config = AppConfig.getInstance();
        config.loadConfiguration();

        // Create and run the console-based user interface
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.start();
    }
}