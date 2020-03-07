package BlackJack;

import BlackJack.Exceptions.NotEnoughCardExceptionn;

public class Dealer {
    private static Dealer dealer;
    private Hand hand;
    private Deck deck;

    private Dealer(Deck deck){
        hand = new Hand();
        this.deck = deck;
    }

    public synchronized static Dealer getInstance(Deck deck){
        if (dealer == null){
            dealer = new Dealer(deck);
        }
        return dealer;
    }

    public void insertCard(Card card){
        hand.insertCard(card);
    }

    public void joinGame(Deck deck){
        this.deck = deck;
    }

    public void dealNextCard() throws NotEnoughCardExceptionn {
        hand.insertCard(deck.dealNextCard());
    }

    public boolean isLargerThan(Player player){
        return hand.getScore() > player.getScore();
    }
}
