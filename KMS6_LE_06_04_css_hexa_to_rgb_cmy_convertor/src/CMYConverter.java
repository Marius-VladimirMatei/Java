public class CMYConverter {
    public static CMYColor convert(RGBColor color) {
        double cyan = ((255 - color.getRed()) / 255.0) * 100;
        double magenta = ((255 - color.getGreen()) / 255.0) * 100;
        double yellow = ((255 - color.getBlue()) / 255.0) * 100;
        return new CMYColor(cyan, magenta, yellow);
    }
}
