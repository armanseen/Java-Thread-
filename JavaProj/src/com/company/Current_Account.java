package com.company;
import java.io.Writer;

public class Current_Account implements BankAccount{

    private int balance;
    private int account_number;
    private String account_holder;
    private Statement statement;

    public Current_Account(int b,int an,String ah , Writer w){
        this.balance = b;
        this.account_number = an;
        this.account_holder = ah;
        statement = new Statement(ah,an,w);
    }

    public int getBalance( ) {
        return balance;
    }

    public int getAccountNumber( ) {
        return account_number;
    }

    public String getAccountHolder( ) {
        return account_holder;
    }


    public void deposit( Transaction t ) {
        this.balance+=t.getAmount();
        statement.addTransaction(t.getCID(),t.getAmount(),this.balance);
    }

    public void withdrawal( Transaction t ) {
        this.balance-=t.getAmount();
        statement.addTransaction(t.getCID(), t.getAmount(), this.balance);
    }

    public boolean isOverdrawn() {
        return true;
    }

    public void printStatement( ) {
        statement.print();

    }
}