package com.tutorialsninja.utils;

import java.io.File;
import java.nio.file.Paths;

public class FileUtils {
    public static String getOsSafePath(String path) {
        return Paths.get(path).toString().replace("/", File.separator);
    }

    public static String getDownloadDir() {
        return getOsSafePath(ConfigReader.getProperty("download.dir"));
    }

    public static String getScreenshotDir() {
        return getOsSafePath(ConfigReader.getProperty("screenshot.dir"));
    }
}
