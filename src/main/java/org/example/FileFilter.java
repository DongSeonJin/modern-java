package org.example;

import java.io.File;

public class FileFilter {
    File[] hiddenFiles = new File(".").listFiles(File::isHidden);
}
