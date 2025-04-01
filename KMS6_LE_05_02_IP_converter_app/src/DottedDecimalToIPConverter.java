// Class designed to convert the user input from a dotted-decimal format to an IP address object.

public class DottedDecimalToIPConverter implements IPAddressConverter {

    @Override
    public IPAddress convert(String input) {
        // Trim the white space at the beginning and end of the input and split it by
        // dots.
        // Array created to store the parts of the IP address.
        String[] parts = input.trim().split("\\.");

        // Check if the input has exactly 4 parts.
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid IP format.");
        }

        // Parse each new part as an octet and store it in a variable.
        int firstOctet = parseOctet(parts[0]);
        int secondOctet = parseOctet(parts[1]);
        int thirdOctet = parseOctet(parts[2]);
        int fourthOctet = parseOctet(parts[3]);

        // Create an IPAddress object using the parsed octets.
        return new IPAddress(firstOctet, secondOctet, thirdOctet, fourthOctet);
    }

    // Parses an octet string to an integer and checks if it is the range of 0 - 255.
    private int parseOctet(String octet) {
        int value = Integer.parseInt(octet);
        if (value < 0 || value > 255) {
            throw new IllegalArgumentException("Octets must be between 0 and 255.");
        }
        return value;
    }
}
