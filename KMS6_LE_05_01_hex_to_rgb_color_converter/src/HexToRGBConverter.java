public class HexToRGBConverter implements ColorConverter {

    public Color convert(String hexCode) {
        // Trim the whitespace
        hexCode = hexCode.trim();

        // Remove the # symbol if exists
        if (hexCode.startsWith("#")) {
            hexCode = hexCode.substring(1); // Creates a substring (a new string from the original string starting at
                                            // index 1
        }

        // Check if the hex code is valid
        if (hexCode.length() != 6) {
            throw new IllegalArgumentException("Hexcode must be 6 characters (#FF1234 or FF1234)");
        }

        // Extracts the specified positions from the string
        // Converts the extracted values which are in base 16 to integers of base 10
        int red = Integer.valueOf(hexCode.substring(0, 2), 16);
        int green = Integer.valueOf(hexCode.substring(2, 4), 16);
        int blue = Integer.valueOf(hexCode.substring(4, 6), 16);

        return new Color(red, green, blue);

    }
}