package com.company;
import java.io.Writer;

public class Student extends Thread{
    private Current_Account SCA;
    private Transaction[] transactions;
    private String[] transactions_type;
    private Writer writer;
    public Student(ThreadGroup tg,String n,Current_Account ca,Writer w) {
        super(tg, n);
        this.SCA = ca;
        writer = w;
    }
    public void fillTransactions(Transaction[] t, String[] tt) {
        transactions = t;
        transactions_type = tt;
    }
    public void run(){
        for(int i = 0; i < 6; i++){
            if(transactions_type[i] == "Deposit") {
                System.out.println(this.getName() + " starting to deposit");
                System.out.println(this.getName() + " depositing");
                try {
                    writer.write(this.getName() + " starting to deposit" + "\r\n");
                    writer.write(this.getName() + " depositing" + "\r\n");
                } catch (Exception e) {

                }
                SCA.deposit(transactions[i]);
            }
            else if(transactions_type[i] == "Withdrawal"){
                if (SCA.getBalance() >= transactions[i].getAmount()){
                    System.out.println(this.getName() + " starting to withdraw");
                    System.out.println(this.getName() + " withdrawing");
                    try {
                        writer.write(this.getName() + " starting to withdraw" + "\r\n");
                        writer.write(this.getName() + " withdrawing" + "\r\n");
                    }catch (Exception e){

                    }
                    SCA.withdrawal(transactions[i]);
                }
                else{
                    while(SCA.getBalance() < transactions[i].getAmount()){
                        try {
                            sleep((int) Math.floor(Math.random() * 5000));
                        } catch (InterruptedException ex) {}
                    }
                    System.out.println(this.getName() + " starting to withdraw");
                    System.out.println(this.getName() + " withdrawing");
                    try {
                        writer.write(this.getName() + " starting to withdraw" + "\r\n");
                        writer.write(this.getName() + " withdrawing" + "\r\n");
                    }catch (Exception e){

                    }
                    SCA.withdrawal(transactions[i]);
                }
            }
            if (i!=5) {
                try {
                    sleep((int) Math.floor(Math.random() * 5000));
                } catch (InterruptedException ex) {
                }
            }
            if(transactions_type[i] == "Deposit") {
                System.out.println(this.getName() + " Finished Depositing");
                try {
                    writer.write(this.getName() + " Finished Depositing" + "\r\n");
                }catch (Exception e){

                }
            }
            else if(transactions_type[i] == "Withdrawal"){
                System.out.println(this.getName() + " Finished withdrawing");
                try {
                    writer.write(this.getName() + " Finished withdrawing" + "\r\n");
                }catch (Exception e){

                }
            }
        }
        System.out.println("Student Transactions Finished.(End of the Thread)");
        try {
            writer.write("Student Transactions Finished.(End of the Thread)" + "\r\n");
        }catch (Exception e){

        }
    }
}