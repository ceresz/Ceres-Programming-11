import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DepositTest {
    Deposit newDeposit;

    @Before
    public void setup() {
        newDeposit = new Deposit(400.00, new Date(), Customer.CHECKING);
    }

    @Test
    public void testDepositToString(){
        //tests if the Deposit.toString() method returns correctly
        assertEquals(newDeposit.toString(), "Deposit of: $" + 400.00 + " Date: " + new Date() + " into account: " + Customer.CHECKING);
    }
}