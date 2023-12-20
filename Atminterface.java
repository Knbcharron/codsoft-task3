import java.util.Scanner;
class Bankaccount
{
    private double balance;
    public Bankaccount(double balance)
    {
        this.balance = balance;
    }
    public double getbalance()
    {
        return balance;
    }
    public void deposite(double amount)
    {
        balance += amount;
    }
    public boolean withdraw(double amount)
    {
        if(amount <= balance)
        {
            balance -= amount;
            return true;
        }
        return false;
    }
}
class Atm
{
    private Bankaccount account;
    private Scanner SC;
    public Atm(Bankaccount account)
    {
        this.account = account;
        this.SC = new Scanner(System.in);
    }
    public void displayoptions()
    {
        System.out.println("1. WITHDRAW");
        System.out.println("2. DEPOSIT");
        System.out.println("3. CHECK BALANCE");
        System.out.println("Coose An Option : ");
    }
    public void procesoption(int option)
    {
        switch (option) 
        {
            case 1 :
            System.out.println("Enter Amount To Withdraw :");
            double WithdrawAmount = SC.nextDouble();
            if(account.withdraw(WithdrawAmount))
            {
                System.out.println("withdrawl successful.current balance:"+account.getbalance());
            }
            else
            {
                System.out.println("Insufficient funds!");
            }
            break;
            case 2 :
            System.out.println("Enter amount to deposite :");
            double depositeamount = SC.nextDouble();
        account.deposite(depositeamount);
        System.out.println("Deposit Successful.Current balance :"+account.getbalance());
        break;
        case 3:
        System.out.println("Your Current Balance Is :"+account.getbalance());
        break;
        default:
        System.out.println("Invalid Option!");
            
        }

    }
}
class Atminterface
{
    public static void main(String[] args)
     {
        Bankaccount userAccount = new Bankaccount(2500);
        Atm atm = new Atm(userAccount);
        Scanner SC = new Scanner(System.in);
        boolean exit = false;
        while(!exit)
        {
            atm.displayoptions();
            int option = SC.nextInt();
            atm.procesoption(option);
            System.out.println("Do YOU want To Perform another New Transaction?(YES/NO)");
            String continueoption = SC.next();
            if(!continueoption.equalsIgnoreCase("YES"))
            {
                exit = true;
                System.out.println("THANKS YOU FOR USING THE ATM");
            }
        }
        SC.close();
    }
}