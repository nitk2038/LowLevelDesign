package ProxyPattern;

public class RealImage implements Image {
    private String imageName;
    public RealImage(String imageName) {
        this.imageName = imageName;
        loadImageFromDisk();
    }

    public void loadImageFromDisk() {
        System.out.println("Loading image from Disk .....");
    }

    @Override
    public void display() {
        System.out.println("Displaying Image: "+ imageName);
    }
}
