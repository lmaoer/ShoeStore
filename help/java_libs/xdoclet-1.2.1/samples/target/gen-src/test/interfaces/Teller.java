/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Remote interface for Teller.
 * @xdoclet-generated at 28-04-04
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.1
 */
public interface Teller
   extends javax.ejb.EJBObject
{
   /**
    * Transfer money between accounts.
    */
   public void transfer( test.interfaces.Account from,test.interfaces.Account to,float amount )
      throws java.rmi.RemoteException;

   /**
    * Deposit account.
    */
   public void deposit( test.interfaces.Account account,float amount )
      throws java.rmi.RemoteException;

}
