package edu.ccrm.util;

/**
 * Utility class to hold ANSI escape codes for coloring console text.
 */
public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String CYAN = "\033[0;36m";    // CYAN

    // Bold
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
}