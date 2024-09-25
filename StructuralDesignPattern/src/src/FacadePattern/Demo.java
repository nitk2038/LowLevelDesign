package FacadePattern;

import FacadePattern.facade.VideoConversionFacade;

public class Demo {
    public static void main(String[] args) {
        System.out.println("--Facade Pattern---");
        VideoConversionFacade converter = new VideoConversionFacade();
        converter.convertVideo("youtubevideo.ogg", "mp4");
    }
}
