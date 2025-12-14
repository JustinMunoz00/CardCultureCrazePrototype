import java.util.ArrayList; 
import java.util.HashMap;
public class Doudizhu {
    private ArrayList<ArrayList<Integer>> playerHands = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> deck = new ArrayList<Integer>();
    private HashMap<Integer, String> cardValue;
    private int[] landlordCards = new int[3];
    private int landLord;

    public Doudizhu (){
        for (int i = 0; i < 3; i++){
            playerHands.add(new ArrayList<Integer>());
        }
        newDeck();
        System.out.print("Hello players! DouDizhu essentially a chinese version of poker. It is a 3 player game where 1 player is the landowner who the other 2 will compete against. \nThe landowner starts out with 3 extra cards that they have to reveal to the other 2 players. The goal of all players is to use all their cards. \nIf either the land ownner ");
        System.out.print("or 1 of the other 2 players reach this goal the game ends. Only 1 of the 2 players are required to win for both to win. \nThe landowner always starts first and can choose how they want to play (single, double, triple, straight). \nAll other players have to place the same type as the land owner (if the landowner plays doubles they have to play doubles). \nIf you are the last person to put down a card then you restart the pile and can play whatever you would like. \n\n");
    }

    private void newDeck(){
        for (int i = 1; i < 14; i++){
            for (int n = 0; n < 4; n++){
                deck.add(i);
            }
        }
        deck.add(14);
        deck.add(15);

        cardValue = new HashMap<Integer, String>();
        cardValue.put(1, "3");
        cardValue.put(2, "4");
        cardValue.put(3, "5");
        cardValue.put(4, "6");
        cardValue.put(5, "7");
        cardValue.put(6, "8");
        cardValue.put(7, "9");
        cardValue.put(8,"10");
        cardValue.put(9,"Jack");
        cardValue.put(10,"Queen");
        cardValue.put(11,"King");
        cardValue.put(12,"Ace");
        cardValue.put(13,"2");
        cardValue.put(14,"Black Joker");
        cardValue.put(15,"Red Joker");
    }

    public void deal(){
        for (int i = 0; i < 3; i++){
            int n = (int) (Math.random()*(54-i));
            landlordCards[i] = deck.get(n);
            deck.remove(n);
        }
        for (int i = 0; i < 17; i++){
            for (int n = 0; n < 3; n++){
                int x = (int) (Math.random()*(deck.size()));
                int card = deck.get(x);
                playerHands.get(n).add(card);
                deck.remove(x);
            }
        }
        landLord = (int) (Math.random()*3) + 1;
        System.out.println("Player " + landLord + " is the landlord!");
        System.out.print("The three cards were: ");
        for (int i : landlordCards){
            String card = cardValue.get(i);
            System.out.print(card + " ");
        }
        System.out.println();
        for (int i = 0; i < 3; i++){
            playerHands.get(landLord-1).add(landlordCards[i]);
        }
    }

    private void sortHands(){
        for (int m = 0; m < 3; m++){
            ArrayList<Integer> currentHand = playerHands.get(m);
            int n = currentHand.size();
            for (int i = 0; i < n; ++i) {
                int key = currentHand.get(i);
                int j = i - 1;
            while (j >= 0 && currentHand.get(j) > key) {
                currentHand.set(j+1, currentHand.get(j));
                j = j - 1;
            }
            currentHand.set(j+1, key);
            }
        }
    }
    public void showHands(){
        sortHands();
        for (int player = 0; player < 3; player++){
            System.out.print("Player " + (player+1) + ": ");
            for (int i = 0; i < playerHands.get(player).size(); i++){
                String card = cardValue.get(playerHands.get(player).get(i));
                System.out.print(card + ", ");
            }
            System.out.println();
        }
    }

    public void place(int player, int card){
        System.out.println("Player " + player + " placed a " + cardValue.get(card - 2));
    }


}