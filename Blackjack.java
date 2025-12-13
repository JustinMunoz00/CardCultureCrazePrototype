import java.util.ArrayList;
import java.util.HashMap;

public class Blackjack{
    private ArrayList<Integer> deck = new ArrayList<Integer>();
    private HashMap<Integer, Integer> cardValue;
    private int playerHandValue = 0;
    private int dealerHandValue = 0;
    private boolean playerstands = false;
    private boolean dealerstands = false;
    private boolean end = false;

    public Blackjack(){
        newDeck();
        System.out.println("In blackjack the goal is to get as close to 21 without going over 21. You can 'hit', which means drawing a card from the deck, or 'stand', which stops you from drawing \n any more cards. \n You play against the dealer who also has the same goal. If the dealer goes over 21 while you are under 21 then you win and vice versa. \n If you or the dealer stands the other can keep hitting until they get enough cards to have a value grater than the others value. If you do that without going over 21 \nyou also win.");

    }
    private void newDeck(){
        for (int i = 2; i < 15; i++){
            for (int n = 0; n < 4; n++){
                deck.add(i);
            }
        }

        cardValue = new HashMap<Integer, Integer>();
        cardValue.put(2,2);
        cardValue.put(3, 3);
        cardValue.put(4, 4);
        cardValue.put(5, 5);
        cardValue.put(6, 6);
        cardValue.put(7, 7);
        cardValue.put(8, 8);
        cardValue.put(9, 9);
        cardValue.put(10,10);
        cardValue.put(11,10);
        cardValue.put(12,10);
        cardValue.put(13,10);
        cardValue.put(14,11);
    }

    public void deal(String answer){
        playerstands = answer.equals("stand");
        dealerstands = dealerHandValue > 18;
        if (!playerstands){
                int x = (int) (Math.random()*(deck.size()));
                int card = deck.get(x);
                playerHandValue+= (cardValue.get(card));
                deck.remove(x);
        }
        if (!dealerstands){
                int x = (int) (Math.random()*(deck.size()));
                int card = deck.get(x);
                dealerHandValue+= (cardValue.get(card));
                deck.remove(x);
        }
        System.out.println("player: " + playerHandValue + "\n Dealer: " + dealerHandValue);
        if (dealerstands && (dealerHandValue < playerHandValue) || dealerHandValue > 21 || playerHandValue == 21) {
            System.out.println("Player Wins!");
            end = true;
        }
    }

    public boolean gameStatus(){
        return end == false;
    }
    
}