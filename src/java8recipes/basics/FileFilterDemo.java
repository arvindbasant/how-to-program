package java8recipes.basics;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileFilterDemo {

    public static void main(String[] args) {
        File directory = new File("src/java8recipes/basics");
        String[] names = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        System.out.println(Arrays.asList(names));

        FilenameFilter filenameFilter = (dir, name) -> name.endsWith(".java");
        names = directory.list(filenameFilter);

        System.out.println(Arrays.asList(names));
    }
}
