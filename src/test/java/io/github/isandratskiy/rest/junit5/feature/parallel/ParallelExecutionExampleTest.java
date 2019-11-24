package io.github.isandratskiy.rest.junit5.feature.parallel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.*;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class ParallelExecutionExampleTest {
    @Test
    @DisplayName("can write and read in temporary directory file")
    void writeAndReadFile(@TempDir Path tempDir) throws Exception {
        Path testFile = tempDir.resolve("test.txt");
        write(testFile, asList("foo", "bar"));
        List<String> actualLines = readAllLines(testFile);
        assertAll(
                () -> assertIterableEquals(asList("foo", "bar"), actualLines),
                () -> assertEquals("test.txt", testFile.getFileName().toString())
        );
    }
}
