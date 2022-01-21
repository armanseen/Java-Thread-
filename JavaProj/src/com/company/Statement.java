/** *********************************************************************
 * File:	Statement.java	  [class]
 * Author:	P. Howells	
 * Contents:	7SENG007W  REF/DEF CWK:  Banking System
 *		Provides the data structure for a bank account statement.
 * Date:	10/6/19
 ************************************************************************ */

package com.company;

import java.io.Writer;

public class  Statement
{

  /********* private Instance Variables *********/ 

    private final char TAB       = '\t' ;
    private final int  MAX_TRANS = 20 ;

    private final StatementEntry[] statement = new StatementEntry[ MAX_TRANS ] ;

    private final String accountHolder ;
    private final int    accountNumber ;

    private int transactionCount = 0 ;

    private Writer writer;

    /********* public Constructor Method *********/

    public Statement (String accountHolder, int accountNumber , Writer w)
    {
        this.accountHolder = accountHolder ;
        this.accountNumber = accountNumber ;
        this.writer = w;
    }


    /********* public Modifier Methods *********/ 

    public void addTransaction( String CID, int amount, int balance ) 
    {
	// Create a new statement entry & add to the statement
	
	statement[ transactionCount ] = new StatementEntry( CID, amount, balance ) ;
	
	transactionCount++ ;
    }
    

    public void print ( ) {
        try {
            System.out.println();
            writer.write("\r\n");

            System.out.println("Statement for " + accountHolder +
                    "'s Account: " + accountNumber);
            writer.write("Statement for " + accountHolder +
                    "'s Account: " + accountNumber+"\r\n");

            System.out.println("================================================");
            writer.write("================================================"+"\r\n");
            System.out.format("%1$-20s %2$10s  %3$13s", "Customer", "Amount", "Balance");
            writer.write("Customer            "+"Amount          "+"Balance              "+"\r\n");
            System.out.println();
            writer.write("\r\n");
            System.out.println("================================================");
            writer.write("================================================"+"\r\n");

            for (int tid = 0; tid < transactionCount; tid++) {
                //	    System.out.println( statement[ tid ] ) ;
                System.out.format("%1$-20s %2$10d  %3$10d",
                        statement[tid].getCustomer(),
                        statement[tid].getAmount(),
                        statement[tid].getCurrentBalance());
                writer.write(
                        statement[tid].getCustomer()+"            "+
                        statement[tid].getAmount()+"          "+
                        statement[tid].getCurrentBalance()+"             "+"\r\n");
                System.out.println();
                writer.write("\r\n");
            }

            System.out.println("================================================");
            writer.write("================================================"+"\r\n");
            System.out.println();
            writer.write("\r\n");
        }catch(Exception e) {

        }
    }
}


