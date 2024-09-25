package FacadePattern.facade;

import FacadePattern.*;

public class VideoConversionFacade {
    public void convertVideo(String filename, String format) {
        System.out.println("VideoConversionFacade: conversion started...");
        VideoFile file = new VideoFile(filename);
        Codec sourceCodec = CodecFactory.extract(file);
        System.out.println("VideoConversionFacade: conversion completed to => " + sourceCodec.getType());
    }
}
