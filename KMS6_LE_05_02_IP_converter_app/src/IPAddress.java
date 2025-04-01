// Class designed to represent an IP address object
public class IPAddress {
    private int octet1;
    private int octet2;
    private int octet3;
    private int octet4;

    public IPAddress(int octet1, int octet2, int octet3, int octet4) {
        this.octet1 = octet1;
        this.octet2 = octet2;
        this.octet3 = octet3;
        this.octet4 = octet4;
    }

    // Converts each octet to an 8-bit binary string and joins them with dots.
    public String toBinaryString() {
        return String.format("%8s.%8s.%8s.%8s",
                Integer.toBinaryString(octet1),
                Integer.toBinaryString(octet2),
                Integer.toBinaryString(octet3),
                Integer.toBinaryString(octet4)).replace(' ', '0');
    }

    // Converts each octet to a 3-digit octal string and joins them with dots.
    public String toOctalString() {
        return String.format("%03o.%03o.%03o.%03o", octet1, octet2, octet3, octet4);
    }

    @Override
    public String toString() {
        return "Binary: " + toBinaryString() + "\nOctal: " + toOctalString();
    }
}
