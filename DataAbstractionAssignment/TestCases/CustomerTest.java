import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer newCustomer;

    @Before
    public void setup() {
        newCustomer = new Customer();
    }

    @Test
    public void testDeposit() {
        //adds new amount to deposits
        newCustomer.deposit(100.00, new Date(), Customer.CHECKING);
        double checkingBalance = newCustomer.getCheckingBalance();
        assertEquals(checkingBalance, 100.00, 0.01);

        //adds new deposit to savings
        newCustomer.deposit(50.00, new Date(), Customer.SAVING);
        double savingBalance = newCustomer.getSavingBalance();
        assertEquals(savingBalance, 50.00, 0.01);

        //checks amount >= 0
        newCustomer.deposit(-10.00, new Date(), Customer.CHECKING);
        assertEquals(checkingBalance, 100.00, 0.01);
    }

    @Test
    public void testWithdraw() {
        //adds amount to withdraw
        newCustomer.withdraw(10.00, new Date(), Customer.CHECKING);
        double checkingBalance = newCustomer.getCheckingBalance();
        assertEquals(checkingBalance, -10.00, 0.01);

        //withdraw from saving
        newCustomer.withdraw(5.00, new Date(), Customer.SAVING);
        double savingBalance = newCustomer.getSavingBalance();
        assertEquals(savingBalance, -5.00, 0.01);

        //checks amount >= 0
        newCustomer.withdraw(-20.00, new Date(), Customer.CHECKING);
        assertEquals(checkingBalance, -10.00, 0.01);

        //tests overdraft
        newCustomer.withdraw(100.00, new Date(), Customer.CHECKING);
        assertEquals(newCustomer.getCheckingBalance(), -10.00, 0.01);

    }
}
