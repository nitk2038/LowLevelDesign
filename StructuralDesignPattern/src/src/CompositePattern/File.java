package CompositePattern;

public class File implements FileSystem{
    String filename;
    public File(String filename) {
        this.filename = filename;
    }

    public void ls() {
        System.out.println(filename);
    }
}
