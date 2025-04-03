public class HexToRGBConverter {
    public static RGBColor convert(String input) {
        if (input == null || !input.startsWith("#")) {
            throw new IllegalArgumentException("Color code must start with '#'!");
        }

        int length = input.length();
        // Valid lengths: 4 (#rgb), 5 (#rgba), 7 (#rrggbb), or 9 (#rrggbbaa)
        if (length != 4 && length != 5 && length != 7 && length != 9) {
            throw new IllegalArgumentException("Color code must be 4, 5, 7, or 9 characters long.");
        }

        String redStr, greenStr, blueStr;
        if (length == 4 || length == 5) {
            // For shorthand formats, duplicate each digit.
            redStr = "" + input.charAt(1) + input.charAt(1);
            greenStr = "" + input.charAt(2) + input.charAt(2);
            blueStr = "" + input.charAt(3) + input.charAt(3);
        } else {
            // For full formats, extract two characters per component.
            redStr = input.substring(1, 3);
            greenStr = input.substring(3, 5);
            blueStr = input.substring(5, 7);
        }

        int red, green, blue;
        try {
            red = Integer.parseInt(redStr, 16);
            green = Integer.parseInt(greenStr, 16);
            blue = Integer.parseInt(blueStr, 16);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Color code contains invalid hexadecimal characters.");
        }

        return new RGBColor(red, green, blue);
    }
}
