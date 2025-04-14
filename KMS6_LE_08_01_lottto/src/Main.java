import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Lottery Game!");
        LotteryGame game = new LotteryGame();
        int[] result = game.play();
        System.out.println("Your sorted lottery numbers are: " + Arrays.toString(result));
    }
}