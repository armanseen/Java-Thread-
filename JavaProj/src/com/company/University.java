package com.company;
import java.io.Writer;

public class University extends Thread{
    private Current_Account SCA;
    private String university_name;
    private Transaction[] transactions;
    private Writer writer;
    public University(ThreadGroup tg,String n,Current_Account ca, String un , Writer w){
        super(tg,n);
        this.SCA = ca;
        this.university_name = un;
        this.university_name = un;
        this.writer = w;
    }
    public void fillUniversityTransactions(Transaction[] t){
        transactions = t;
    }
    public void run(){
        for(int i = 0; i < 3; i++){
            if (SCA.getBalance() >= transactions[i].getAmount()){
                System.out.println("University attempts to withdraw fees");
                System.out.println("University withdrawing fees");
                try {
                    writer.write("University attempts to withdraw fees" + "\r\n");
                    writer.write("University withdrawing fees" + "\r\n");
                }catch (Exception e) {

                }
                SCA.withdrawal(transactions[i]);
            }
            else{
                while(SCA.getBalance() < transactions[i].getAmount()){
                    try {
                        sleep((int) Math.floor(Math.random() * 5000));
                    } catch (InterruptedException ex) {}
                }
                System.out.println("University attempts to withdraw fees");
                System.out.println("University withdrawing fees");
                try {
                    writer.write("University attempts to withdraw fees" + "\r\n");
                    writer.write("University withdrawing fees" + "\r\n");
                }catch (Exception e) {

                }
                SCA.withdrawal(transactions[i]);
            }
            if (i!=2) {
                try {
                    sleep((int) Math.floor(Math.random() * 5000));
                } catch (InterruptedException ex) {
                }
            }
            System.out.println("University Finished Withdrawing");
            try {
                writer.write("University Finished Withdrawing" + "\r\n");
            }catch (Exception e) {

            }
        }
        System.out.println("University Transactions Finished.(End of the Thread)");
        try {
            writer.write("University Transactions Finished.(End of the Thread)" + "\r\n");
        }catch (Exception e) {

        }
    }
}