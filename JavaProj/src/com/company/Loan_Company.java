package com.company;
import java.io.Writer;

public class Loan_Company extends Thread{
    private Current_Account LCA;
    private String company_name;
    private Transaction[] transactions;
    private Writer writer;
    public Loan_Company(ThreadGroup tg,String n,Current_Account ca,String cn,Writer w){
        super(tg,n);
        this.LCA = ca;
        this.company_name = cn;
        this.writer = w;
    }
    public void fillLoan(Transaction[] t){
        transactions = t;
    }
    public void run(){
        for(int i = 0; i < 3; i++){
            System.out.println("Student Loan Company starting to deposit");
            System.out.println("Student Loan Company depositing");
            try {
                writer.write("Student Loan Company starting to deposit" + "\r\n");
                writer.write("Student Loan Company depositing" + "\r\n");
            }catch (Exception e) {

            }
            LCA.deposit(transactions[i]);
            if (i!=2) {
                try {
                    sleep((int) Math.floor(Math.random() * 5000));
                } catch (InterruptedException ex) {
                }
            }
            System.out.println("Student Loan Company Finished Depositing");
            try {
                writer.write("Student Loan Company Finished Depositing"+ "\r\n");
            }catch (Exception e) {

            }
        }
        System.out.println("Loan Company Transactions Done.(End of the Thread)");
        try {
            writer.write("Loan Company Transactions Done.(End of the Thread)" + "\r\n");
        }catch (Exception e) {

        }
    }
}