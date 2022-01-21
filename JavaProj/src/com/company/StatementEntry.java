/** *********************************************************************
 * File:	StatementEntry.java   [class]
 * Author:	P. Howells	
 * Contents:	7SENG007W REF/DEF CWK:  Banking System
 *		This provides the basic data structure for a single
 *              bank account statement entry.
 * Date:	10/6/19
 ************************************************************************ */

package com.company;
public class StatementEntry 
{

    private final char TAB = '\t' ;

    private final String CustomerID ;
    private final int    amount ;
    private final int    currentBal ;


    public StatementEntry( String CID, int amount, int currentBal )
    {
        this.CustomerID = CID ;
        this.amount     = amount ;
        this.currentBal = currentBal ;
    }


    public String getCustomer()      { return CustomerID ; }
    public int    getAmount()        { return amount ;     }
    public int    getCurrentBalance(){ return currentBal ; }


    public String toStringOLD( )
    {
        return  new String(  "Customer: " + CustomerID + ","  + TAB + 
                             "Amount: "   + amount     + ", " + TAB + 
                             "Balance: "  + currentBal 
                          ) ;
    }

}

