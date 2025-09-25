package edu.ccrm.io;

import edu.ccrm.config.AppConfig;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {

    public void performBackup() throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        Path sourceDir = Paths.get(AppConfig.getInstance().getDataDirectory());
        Path backupDir = Paths.get(AppConfig.getInstance().getBackupDirectory(), "backup_" + timestamp);

        Files.createDirectories(backupDir);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDir)) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry)) {
                    Files.copy(entry, backupDir.resolve(entry.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
        System.out.println("Backup created successfully at: " + backupDir);
    }
}