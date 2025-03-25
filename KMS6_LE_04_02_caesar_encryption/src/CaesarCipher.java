
// Class designed for the encryption logic of ASCII code



class CaesarCipher {

    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    public String encrypt(String text) {
        // String to loop through each character and apply the shift to each character
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            // Shift uppercase letters (A-Z)
            if (Character.isUpperCase(currentChar)) {
                char ch = (char)(((int) currentChar + shift - 65) % 26 + 65);
                result = result + ch;

                // Shift lowercase letters (a-z)
            } else if (Character.isLowerCase(currentChar)) {
                char ch = (char)(((int) currentChar + shift - 97) % 26 + 97);
                result = result + ch;

            } else {
                // For non-letter characters, append as is.
                result = result + currentChar;
            }
        }
        return result;
    }
}
