package io.github.isandratskiy.rest.junit5.feature.parallel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ParallelExecutionExampleTest {
    @Test
    void writeAndReadFile(@TempDir Path tempDir) throws Exception {
        Path testFile = tempDir.resolve("test.txt");

        Files.write(testFile, asList("foo", "bar"));

        List<String> actualLines = Files.readAllLines(testFile);
        assertIterableEquals(asList("foo", "bar"), actualLines);
        assertEquals("test.txt", testFile.getFileName().toString());
    }
}
