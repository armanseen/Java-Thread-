package com.company;
import java.io.Writer;
public class Parents extends Thread{
    private Current_Account child_current_account;
    private String mother_name;
    private String father_name;
    private Transaction[] transactions;
    private Writer writer;
    public Parents(ThreadGroup tg,String n,Current_Account s, String mn, String fn,Writer w){
        super(tg,n);
        this.child_current_account = s;
        this.father_name = mn;
        this.mother_name = fn;
        this.writer = w;
    }
    public void fillTopUpGift(Transaction[] t){
        transactions = t;
    }
    public void run(){
        for(int i = 0; i < 2; i++){
            System.out.println("Student's Parents starting to Deposit a gift");
            System.out.println("Student's Parents Depositing Gift");
            try {
                writer.write("Student's Parents starting to Deposit a gift" + "\r\n");
                writer.write("Student's Parents Depositing Gift" + "\r\n");
            }catch (Exception e){

            }
            child_current_account.deposit(transactions[i]);
            if (i!=1) {
                try {
                    sleep((int) Math.floor(Math.random() * 5000));
                } catch (InterruptedException ex) {
                }
            }
            System.out.println("Student's Parents finished Depositing");
            try {
                writer.write("Student's Parents finished Depositing" + "\r\n");
            }catch (Exception e){

            }
        }
        System.out.println("Parents Transactions Finished.(End of the Thread)");
        try {
            writer.write("Parents Transactions Finished.(End of the Thread)" + "\r\n");
        }catch (Exception e) {

        }
    }
}