package BlackJack;

import BlackJack.Exceptions.AleadyStoppedDealingException;
import BlackJack.Exceptions.DealCardToStopDealingPlayerException;
import BlackJack.Exceptions.NotEnoughCardExceptionn;

public class Player {
    private Hand hand;
    private Deck deck;
    private int totalBets;

    //玩家已经下的bets
    private int currBets;

    /**
     * 玩家在玩游戏的过程中可以停止叫牌，
     * 停止叫牌就意味着说他要跟dealer进行比较，
     * 结果要么赢了，或者输了，然后他就结束了本局
     *
     * */
    private boolean stopDealing;

    public Player(int totalBets){
        hand = new Hand();
        currBets = 0;
        stopDealing = false;
        this.totalBets = totalBets;
    }

    /**
     * Player join the game
     *
     * */
    public void joinGame(Deck deck){
        this.deck = deck;
    }


    /**
     * Player get a piece of card from deck
     * 这是player主动的行为，每个player都可以决定要不要发牌
     *
     * */
    public void insertCard(Card card){
        hand.insertCard(card);
    }

    /**
     * Initially assign bets to each Player
     * */
    public void placeBets(int bets){
        totalBets = bets;
        currBets = 0;
    }

    public void dealBets(int bets){
        totalBets -= bets;
        currBets += bets;
    }

    /** 在游戏进行的过程之中，玩家决定是否需要发一张拍
     *
     * */
    public void dealNextCard() throws NotEnoughCardExceptionn, DealCardToStopDealingPlayerException {
        if (!stopDealing){
            throw new DealCardToStopDealingPlayerException();
        }
        insertCard(deck.dealNextCard());
    }

    public void stopDealing() throws AleadyStoppedDealingException {
        if (stopDealing){
            throw new AleadyStoppedDealingException();
        }
        stopDealing = true;
        deck.increaseStopDealing();
    }

    public int getScore(){
        return hand.getScore();
    }

    public int getCurrentBets(){
        return currBets;
    }

    public void updateBets(int diff){
        totalBets += diff;
    }
}
