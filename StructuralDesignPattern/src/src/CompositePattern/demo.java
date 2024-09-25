package CompositePattern;

public class demo {
    public static void main(String[] args) {
        System.out.println("--- Composite Design Pattern ---");
        Directory movieDirectory = new Directory("Movies");
        FileSystem movie1 = new File("Inception.mp4");
        movieDirectory.add(movie1);
        Directory comedyMovies = new Directory("Comedy-Movies");
        FileSystem movie2 = new File("Phir Hera Pheri.mp4");
        comedyMovies.add(movie2);
        movieDirectory.add(comedyMovies);
        movieDirectory.ls();
    }
}

