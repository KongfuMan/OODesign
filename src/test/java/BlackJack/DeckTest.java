package BlackJack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeckTest {

    @Test
    public void testSingleton() {
        Deck instance1 = Deck.getInstance();
        Deck instance2 = Deck.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    public void test_player(){
    }
}