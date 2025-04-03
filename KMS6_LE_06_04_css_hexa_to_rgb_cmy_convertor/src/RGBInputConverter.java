public class RGBInputConverter {
    public static RGBColor convert(String input) {
        // Replace commas with spaces and split the input into parts.
        input = input.replace(",", " ");
        String[] parts = input.trim().split("\\s+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Please enter exactly three values for R, G, and B.");
        }
        int red, green, blue;
        try {
            red = Integer.parseInt(parts[0]);
            green = Integer.parseInt(parts[1]);
            blue = Integer.parseInt(parts[2]);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("RGB values must be integers.");
        }
        // Validate the range 0-255.
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new IllegalArgumentException("RGB values must be between 0 and 255.");
        }
        return new RGBColor(red, green, blue);
    }
}
