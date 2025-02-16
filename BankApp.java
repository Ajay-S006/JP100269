package BasicPrograms;

import java.util.*;

public class BankApp
{
    public static void main(String[] args)
    {
        Scanner obj =new Scanner(System.in);
        BankAccount object = new BankAccount("Ajay", "0010");
        object.ShowMenu();

        
    }
}

class BankAccount
{
    int balance;
    int previousTransaction;
    String CustomerName;
    String CustomerID;

    BankAccount(String cname ,String cid)
    {
        CustomerName = cname;
        CustomerID = cid;
    }

    void deposit(int amount)
    {
        if(amount !=0)
        {
            balance = balance +amount;
            previousTransaction = amount;
        }
    }
    void withdraw(int amount)
    {
        if (amount!=0)
        {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    void getPreviousTransaction()
    {
        if(previousTransaction >0)
        {
            System.out.println("DEPOSITED :" + previousTransaction);
        }
        else if(previousTransaction<0)
        {
            System.out.println("WITHDRAWN :"+Math.abs(previousTransaction));
        }
        else 
        {
            System.out.println("NO TRANSACTION IS OCCURED");
        }
    }
    void ShowMenu()
    {
        char option ='\0';
        Scanner obj = new Scanner (System.in);
        System.out.println("WELCOME " + CustomerName);
        System.out.println("YOUR ID is "+CustomerID);
        System.out.println();
        System.out.println("A. CHECK BANK BALANCE");
        System.out.println("B. DEPOSIT");
        System.out.println("C. WITHDRAW");
        System.out.println("D. PREVIOUS TRANSACTION");
        System.out.println("E. EXIT");

        do
        {
            System.out.println("=================");
            System.out.println("ENTER OPTION");
            System.out.println("=================");
            option = obj.next().charAt(0);
            Character.toUpperCase(option);

            switch(option)
            {
                case'A' :
                System.out.println("==================");
                System.out.println("Balance is :"+balance);
                System.out.println("==================");
                System.out.println();
                break;

                case'B':

                System.out.println("=============================");
                System.out.println("Enter the Amount to deposit :");
                System.out.println("=============================");
                int amount = obj.nextInt();
                deposit(amount);
                System.out.println();
                break;

                case'C':
                System.out.println("============================");
                System.out.println("Enter the amount to withdraw");
                System.out.println("============================");
                int amount2 = obj.nextInt();
                withdraw(amount2);
                System.out.println();
                break;

                case'D':
                System.out.println("=============");
                getPreviousTransaction();
                System.out.println("=============");
                System.out.println();
                break;

                case'E':
                System.out.println("=============");
                break;

                default:
                System.out.println("INVALID OPTION ! TRY AGAIN LATER");
                break;

            }
        }
        while (option !='E');

    }

}