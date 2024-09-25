package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements  FileSystem{
    String directoryName;
    List<FileSystem> fileSystemList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystemObj) {
        fileSystemList.add(fileSystemObj);
    }

    public void ls() {
        System.out.println("[" + directoryName + " ]");
        for(FileSystem fileSystem: fileSystemList) {
            System.out.print("-- ");
            fileSystem.ls();
        }
    }
}
