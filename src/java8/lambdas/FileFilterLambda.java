package java8.lambdas;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.util.Objects;

public class FileFilterLambda {

    public static void main(String[] args) {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        FileFilter fileFilterLambda = path -> path.getName().endsWith(".java");

//        FileInputStream fis = new FileInputStream("input.log");

        String pathname = "/Users/akumar24/Documents/workspace/how-to-program/src/java8/lambdas";
        File dir = new File(pathname);
        File[] files = dir.listFiles(fileFilterLambda);

        Objects.requireNonNull(files);
        for (File file : files)
            System.out.println(file.getName());
    }
}
