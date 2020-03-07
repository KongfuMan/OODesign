package BlackJack;

import java.util.List;


/**
 * 表示玩家或dealer的手牌
 *
 *
 * */
public class Hand {
    List<Card> cards;

    public void insertCard(Card card){
        if (card == null){
            throw new IllegalArgumentException();
        }
        cards.add(card);
    }

    /**
     *
     *
     *
     * */
    public int getScore(){
        int total = 0;
        for (Card card : cards){
            total += card.getValue();
        }
        return total;
    }
}
