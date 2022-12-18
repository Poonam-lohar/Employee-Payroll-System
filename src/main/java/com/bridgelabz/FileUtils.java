package com.bridgelabz;

import java.io.File;

public class FileUtils {

    /**
     * creating a boolean type method name as deleteFiles, its output is true or false type
     * @param contentToDelete in file
     * @return delete content
     */
    public static boolean deleteFiles(File contentToDelete) {

        File[] allContents = contentToDelete.listFiles();

        if (allContents != null) {

            for (File eachFile : allContents) {
                deleteFiles(eachFile);
            }
        }
        return contentToDelete.delete();
    }
}
