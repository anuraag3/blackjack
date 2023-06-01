package blackjack;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.lang3.tuple.Pair;


public class Player extends Players {
    
    public Player() {
        super();
    }

    public Pair<List<Card>, Boolean> playTurn(List<Card> playingCards) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean playerBusted = false;
        while (true) {
            System.out.print("Enter a command: ");
            try {
                String action = reader.readLine();
                if (action.equals("hit")) {
                    Pair<Card, List<Card>> result = assignNewCard(playingCards);
                    playingCards = result.getRight();
                    System.out.println("YOUR NEXT CARD " + result.getLeft().toString());
                    System.out.println("YOUR TOTAL COUNT: " + super.getTotalCountWithAceOptions());
                    if (super.getTotalCount() > 21) {
                        System.out.println("YOUR SCORE IS: " + super.getTotalCount() + " AND YOU HAVE BUSTED!");
                        playerBusted = true;
                        break;
                    }
                } else if (action.equals("stand")) {
                    break;
                } else {
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return Pair.of(playingCards, playerBusted);
    }

}
