package com.company;
import java.io.*;
import java.time.LocalTime;
import static java.lang.Thread.State.TERMINATED;

public class Banking_System {
    public static void main(String[] args) {
        try {
            //Create Timer
            System.out.println();
            LocalTime myObj = LocalTime.now();

            //Create File
            File f = new File("Texts\\Text.txt");
            f.createNewFile();
            FileWriter myWriter = new FileWriter("Texts\\Text.txt");
            System.getProperty("line.separator");

            //Time
            System.out.println("Starting Time : "+myObj);
            myWriter.write("Starting Time : "+myObj+"\r\n");
            System.out.println();
            myWriter.write("\r\n");

            //Current Account
            Current_Account CA = new Current_Account(0,100,"David",myWriter);
            System.out.println("Current Account Was Created");
            myWriter.write("Current Account Was Created\r\n");

            //Thread Groups
            ThreadGroup Humans = new ThreadGroup("Thread Group for Humans");
            System.out.println("Humans Thread Group Was Created");
            myWriter.write("Humans Thread Group Was Created\r\n");
            ThreadGroup Objects = new ThreadGroup("Thread Group for Objects");
            System.out.println("Objects Thread Group Was Created");
            myWriter.write("Objects Thread Group Was Created\r\n");

            //Threads
            Student student = new Student(Humans,"David",CA,myWriter);
            System.out.println("Student Thread Was Created");
            myWriter.write("Student Thread Was Created\r\n");
            Parents parents = new Parents(Humans,"David's Parents",CA,"Sarah","Jack",myWriter);
            System.out.println("Parents Thread Was Created");
            myWriter.write("Parents Thread Was Created\r\n");
            Loan_Company loan_company = new Loan_Company(Objects,"David's Loan",CA,"Barclays Bank",myWriter);
            System.out.println("Loan Company Thread Was Created");
            myWriter.write("Loan Company Thread Was Created\r\n");
            University university = new University(Objects,"University Courses",CA,"UOW",myWriter);
            System.out.println("University Thread Was Created");
            myWriter.write("University Thread Was Created\r\n");

            //Initialize Transactions
            Transaction[] student_transactions = {new Transaction("1123215648",50000),
                                                  new Transaction("2123412648",20000),
                                                  new Transaction("2123412648",2000),
                                                  new Transaction("1433712248",1000),
                                                  new Transaction("5823915647",100000),
                                                  new Transaction("9523225248",700)};
            String[] student_transactions_type = {"Deposit","Withdrawal","Withdrawal","Withdrawal","Deposit","Withdrawal"};
            System.out.println("Student transactions were initialized");
            myWriter.write("Student transactions were initialized\r\n");
            Transaction[] parents_transactions = {new Transaction("1324125648",1500),
                                                  new Transaction("7152232648",2000)};
            System.out.println("Parents transactions were initialized");
            myWriter.write("Parents transactions were initialized\r\n");
            Transaction[] loan_transactions = {new Transaction("2189232621",15000),
                                               new Transaction("4155262742",20000),
                                               new Transaction("3151232641",25000)};
            System.out.println("Loan Company transactions were initialized");
            myWriter.write("Loan Company transactions were initialized\r\n");
            Transaction[] university_transactions = {new Transaction("3112332611",5000),
                                                     new Transaction("4115297242",7000),
                                                     new Transaction("3211232641",9000)};
            System.out.println("University transactions were initialized");
            myWriter.write("University transactions were initialized\r\n");

            //Fill Transactions
            student.fillTransactions(student_transactions,student_transactions_type);
            System.out.println("Student transactions were filled");
            myWriter.write("Student transactions were filled\r\n");
            parents.fillTopUpGift(parents_transactions);
            System.out.println("Parents transactions were filled");
            myWriter.write("Parents transactions were filled\r\n");
            loan_company.fillLoan(loan_transactions);
            System.out.println("Loan Company transactions were filled");
            myWriter.write("Loan Company transactions were filled\r\n");
            university.fillUniversityTransactions(university_transactions);
            System.out.println("University transactions were filled");
            myWriter.write("University transactions were filled\r\n");

            //Run
            student.start();
            System.out.println("Starting Student Thread");
            myWriter.write("Starting Student Thread\r\n");
            parents.start();
            System.out.println("Starting Parents Thread");
            myWriter.write("Starting Parents Thread\r\n");
            loan_company.start();
            System.out.println("Starting Loan Company Thread");
            myWriter.write("Starting Loan Company Thread\r\n");
            university.start();
            System.out.println("Starting University Thread");
            myWriter.write("Starting University Thread\r\n");

            while (student.getState() != TERMINATED || parents.getState() != TERMINATED ||
                   loan_company.getState() != TERMINATED || university.getState() != TERMINATED) {}

            CA.printStatement();
            myObj = LocalTime.now();
            System.out.println("End at : "+myObj);
            myWriter.write("End at : "+myObj+"\r\n");
            myWriter.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
