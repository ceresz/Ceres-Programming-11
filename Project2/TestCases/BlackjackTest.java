import com.example.project2.Card;
import com.example.project2.Deck;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BlackjackTest {
    ArrayList<Card> cardTestSet;
    Card cardAce;
    Card cardTwo;
    Deck deck = new Deck();

    @Before
    public void setup(){
        cardTestSet = new ArrayList<Card>();
        cardAce = new Card(0,"Ace", 11);
        cardTwo = new Card(1,"Two", 2);
    }

    @Test
    public void testAddCard(){
        //test if set is empty
        assertEquals(cardTestSet.size(),0);
        assertFalse(cardTestSet.contains(cardAce));

        //test add one card to set
        cardTestSet.add(cardAce);
        assertEquals(cardTestSet.size(), 1);
        assertFalse(cardTestSet.contains(cardTwo));

        //test add card value
        int total = deck.addCards(cardTestSet);
        assertEquals(total, 11);

    }

    @Test
    public void testGetRandom(){
        //test if random card is in the deck
        Card random1 = deck.getRandom();
        assertTrue(deck.contains(random1));

    }

    @Test
    public void testSetFaceValueToCard(){
        //sets value and face of card
        Card cardThree = new Card();
        cardThree.setFace("Three");
        cardThree.setValue(3);
        assertEquals(cardThree.getFace(),"Three");
        assertNotEquals(cardThree.getValue(),4);
    }
}
