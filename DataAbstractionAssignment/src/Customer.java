import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    public double getCheckingBalance() {
        return checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    Customer(){
        name = "";
        accountNumber = 1;
        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();
    }


    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.name = name;
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountNumber = accountNumber;
        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();
    }

    //Requires: amount >= 0, date, account
    //Modifies: deposits
    //Effects: adds amount to balance and returns new checking or saving balance
    public double deposit(double amount, Date date, String account){
        double returnValue = 0.00;
        if (amount >= 0){
            deposits.add(new Deposit(amount, new Date(), account));
            if(account.equals(Customer.CHECKING)) {
                checkBalance += amount;
                returnValue = checkBalance;
            }
            else if (account.equals(Customer.SAVING)){
                savingBalance += amount;
                returnValue = savingBalance;
            }
        }
        return returnValue;
    }

    //Requires: amount >= 0, date, account
    //Modifies: withdraws
    //Effects: withdraw certain amount from account and returns new checking or saving balance
    public double withdraw(double amount, Date date, String account){
        withdraws.add(new Withdraw(amount, date, account));
        double returnValue = 0.00;
        if (amount >= 0){
            if(checkOverdraft(amount, account)){
                if(account.equals(Customer.CHECKING)){
                    returnValue = checkBalance;
                }
                else if(account.equals(Customer.SAVING)){
                    returnValue = savingBalance;
                }
            }
            else{
                if(account.equals(Customer.CHECKING)){
                    checkBalance -= amount;
                    returnValue = checkBalance;
                }
                else if(account.equals(Customer.SAVING)){
                    savingBalance -= amount;
                    returnValue = savingBalance;
                }
            }
        }
        return returnValue;
    }

    //check overdraft of account
    private boolean checkOverdraft(double amount, String account){
        boolean answer = false;
        if(account.equals(Customer.CHECKING)){
            if((checkBalance - amount) < -100.00){
                answer = true;
            }
        }
        else if(account.equals(Customer.SAVING)){
            if((savingBalance - amount) < -100.00){
                answer = true;
            }
        }
        else{
            answer = false;
        }
        return answer;
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
