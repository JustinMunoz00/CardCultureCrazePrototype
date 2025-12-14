import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Doudizhu game = new Doudizhu();
        game.deal();
        game.showHands();
        System.out.println("what card would you like to play");
        game.place(2, s.nextInt());
        System.out.println("what card would you like to play");
        game.place(3, s.nextInt());
        System.out.println("what card would you like to play");
        game.place(1, s.nextInt());
        //Blackjack game2 = new Blackjack();
        //game2.deal("hit");
        //System.out.println("would you like to hit or stand?");
        //while (game2.gameStatus()){
            //game2.deal(s.nextLine());
            //System.out.println("would you like to hit or stand?");
        //}
        s.close();
    }
}