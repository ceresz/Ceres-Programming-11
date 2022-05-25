import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: nothing
    //Modifies: this
    //Effects: will return the deposit in specified format
    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date: " + date + " into account:" + account;
    }
}
