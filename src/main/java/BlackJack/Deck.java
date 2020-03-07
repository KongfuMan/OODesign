package BlackJack;

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

    private Deck(){
        players = new ArrayList<>();
        cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++){
            for (int j = 0; j < 4; j++){
                cards.add(new Card(Suit.values()[j], i));
            }
        }
    }

    public static synchronized Deck getInstance(){
        if (instance == null){
            instance = new Deck();
        }
        return instance;
    }

    /** Use case1 : initialize
     *  add players(添加玩家，同时玩家加入游戏）
     *  shuffle(洗牌)
     *  place bets (下注）
     *  insert cards (发牌）
     *
     * */
    public void initialize(){

    }

    public void shuffleCards(){
        Collections.shuffle(cards);
    }

    public void joinPlayer(Player player){
        if (player == null){
            throw new IllegalArgumentException();
        }
        players.add(player);
        player.joinGame(this);
    }

    public void insertCards(){

    }

}
