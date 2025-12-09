import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Doudizhu game = new Doudizhu();
        game.deal();
        game.showHands();
        s.close();
    }
}