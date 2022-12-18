package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class NIOFileAPITest {

    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {

        /*
        Checking if file exist
        */

        Path homaPath = Paths.get(HOME);
        Assertions.assertTrue(Files.exists(homaPath));

        /*
        delete files and check file not exist
         */

        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (Files.exists(playPath))
            FileUtils.deleteFiles(playPath.toFile());
        Assertions.assertTrue(Files.notExists(playPath));

        /*
        Create directory
         */

        Files.createDirectory(playPath);
        Assertions.assertTrue(Files.exists(playPath));

        /*
        create files
         */

        IntStream.range(0, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "temp" + cntr);
            Assertions.assertTrue(Files.notExists(tempFile));

            /*
            Use try catch block for Exception handling
             */

            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
            }
            Assert.assertTrue(Files.exists(tempFile));
        });

        /*
        List Files, Directories as well as Files with extension
         */

        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);

    }
}