import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class WithdrawTest {
    Withdraw newWithdraw;

    @Before
    public void setup() {
        newWithdraw = new Withdraw(400.00, new Date(), Customer.CHECKING);
    }

    @Test
    public void testWithdrawToString() {
        //tests if the Withdraw.toString() method returns correctly
        assertEquals(newWithdraw.toString(), "Withdrawal of: $" + 400.00 + " Date: " + new Date() + " into account: " + Customer.CHECKING);
    }
}