package BlackJack;

public class Player {
    private Hand hand;
    private Deck deck;

    /**
     * Player join the game
     *
     * */
    public void joinGame(Deck deck){
        this.deck = deck;
    }
}
