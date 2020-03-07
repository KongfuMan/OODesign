package BlackJack;

import BlackJack.Exceptions.NotEnoughCardExceptionn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 表示牌桌，也就是真个纸牌系统
 *
 *
 * */
public class Deck {
    private static Deck instance = null;
    private List<Player> players;
    private List<Card> cards;
    private Dealer dealer;

    // current balance of bet pool
    private int totalBets;

    private int stoppCount;

    private void resetCards(){
        cards.clear();
        for (int i = 1; i <= 13; i++){
            for (int j = 0; j < 4; j++){
                cards.add(new Card(Suit.values()[j], i));
            }
        }
    }

    private Deck(){
        dealer = Dealer.getInstance(this);
        players = new ArrayList<>();
        cards = new ArrayList<>();
        totalBets = 0;
        resetCards();
    }

    /**
     * Singleton Pattern.
     * */
    public static synchronized Deck getInstance(){
        if (instance == null){
            instance = new Deck();
        }
        return instance;
    }

    /** Use case1 : initialize
     *  1.1 add players(添加玩家，同时玩家加入游戏）and dealer
     *  1.2 shuffle(洗牌)
     *  1.3 place bets (下注）
     *  1.4 deal initial cards (初始发牌两张）
     *
     * */
    public void initialize(){

    }

    /**
     * 1.1 add players(添加玩家，同时玩家加入游戏）
     */
    public void addPlayer(Player player){
        if (player == null){
            throw new IllegalArgumentException();
        }
        players.add(player);
        player.joinGame(this);
    }

    public void addDealer(Dealer dealer){
        if (dealer == null){
            throw new IllegalArgumentException();
        }
        this.dealer = dealer;
        this.dealer.joinGame(this);
    }

    public void shuffleCards(){
        Collections.shuffle(cards);
    }

    /**
     * 初始给每个玩家和dealer各发两张牌
     *
     * */
    public void dealInitialCards() throws NotEnoughCardExceptionn {
        for (int i = 0; i < 2; i++){
            dealer.insertCard(dealNextCard());
            for (Player player : players){
                player.insertCard(dealNextCard());
            }
        }
    }

    /**
     * 从牌堆里抽一张牌。玩家也需要调用这个函数来获取一张牌
     * */
    public Card dealNextCard() throws NotEnoughCardExceptionn {
        if (cards.size() == 0){
            throw new NotEnoughCardExceptionn();
        }
        Card card = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return card;
    }

    /**
    * when all the players stop dealing, compare their score with dealer
     *
    * */
    public void compareResult(){
        for (Player player : players){
            if (dealer.isLargerThan(player)){
                //TODO: player lose all his current Bets
                player.updateBets(-player.getCurrentBets());
            }else{
                // TODO: player add subtract 2 * player.currBets
                player.updateBets(player.getCurrentBets() * 2);
            }
        }
    }

    public void increaseStopDealing(){
        stoppCount++;
        if (stoppCount == players.size()){
            compareResult();
        }
    }

}
