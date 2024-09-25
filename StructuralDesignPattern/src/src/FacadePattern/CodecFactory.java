package FacadePattern;

public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if(type.equals("mp4")) {
            System.out.println("codecFactory: extracting mpe4g audio...");
            return new MPEG4CompressionCodec();
        } else {
            System.out.println("codecFactory: extracting ogg audio...");
            return new OGGCompresionCodec();
        }
    }
}
