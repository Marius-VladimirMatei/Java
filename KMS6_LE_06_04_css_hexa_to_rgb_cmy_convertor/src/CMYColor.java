public class CMYColor {
    private double cyan;
    private double magenta;
    private double yellow;

    public CMYColor(double cyan, double magenta, double yellow) {
        this.cyan = cyan;
        this.magenta = magenta;
        this.yellow = yellow;
    }

    public double getCyan() { return cyan; }
    public double getMagenta() { return magenta; }
    public double getYellow() { return yellow; }

    @Override
    public String toString() {
        return String.format("CMY(%.2f%%, %.2f%%, %.2f%%)", cyan, magenta, yellow);
    }
}
