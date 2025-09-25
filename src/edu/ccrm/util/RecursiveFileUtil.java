package edu.ccrm.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class RecursiveFileUtil {

    /**
     * Recursively calculates the size of a directory.
     * @param path The path to the directory.
     * @return The total size in bytes.
     * @throws IOException If an I/O error occurs.
     */
    public static long getDirectorySize(Path path) throws IOException {
        final AtomicLong size = new AtomicLong(0);

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                size.addAndGet(attrs.size());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                // Skip files that can't be accessed
                return FileVisitResult.CONTINUE;
            }
        });

        return size.get();
    }
}