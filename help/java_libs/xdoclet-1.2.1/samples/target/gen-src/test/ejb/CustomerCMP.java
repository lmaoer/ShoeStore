/*
 * Generated by XDoclet - Do not edit!
 */
package test.ejb;

/**
 * CMP layer for Customer.
 * @xdoclet-generated at 28-04-04
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.1
 */
public class CustomerCMP
   extends test.ejb.CustomerBean
   implements javax.ejb.EntityBean
{
   public int version = 0;

   public float credit;
   public java.lang.String[][] array;
   public byte[] image;
   public float tax;
   public java.lang.String id;
   public java.lang.String name;
   public java.lang.String firstName;
   public java.lang.String phone;
   public java.lang.String fax;
   public java.util.Date creationDate;

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion( int version )
   {
      this.version = version;
      makeDirty();
   }

   public float getCredit() 
   {
      return this.credit;
   }

   public void setCredit( float credit ) 
   {
      this.credit = credit;
      makeDirty();
   }
   public java.lang.String[][] getArray() 
   {
      return this.array;
   }

   public byte[] getImage() 
   {
      return this.image;
   }

   public float getTax() 
   {
      return this.tax;
   }

   public java.lang.String getId() 
   {
      return this.id;
   }

   public void setId( java.lang.String id ) 
   {
      this.id = id;
      makeDirty();
   }
   public java.lang.String getName() 
   {
      return this.name;
   }

   public void setName( java.lang.String name ) 
   {
      this.name = name;
      makeDirty();
   }
   public java.lang.String getFirstName() 
   {
      return this.firstName;
   }

   public void setFirstName( java.lang.String firstName ) 
   {
      this.firstName = firstName;
      makeDirty();
   }
   public java.lang.String getPhone() 
   {
      return this.phone;
   }

   public void setPhone( java.lang.String phone ) 
   {
      this.phone = phone;
      makeDirty();
   }
   public java.lang.String getFax() 
   {
      return this.fax;
   }

   public void setFax( java.lang.String fax ) 
   {
      this.fax = fax;
      makeDirty();
   }
   public java.util.Date getCreationDate() 
   {
      return this.creationDate;
   }

   public void setCreationDate( java.util.Date creationDate ) 
   {
      this.creationDate = creationDate;
      makeDirty();
   }

   public boolean isModified()
   {
      return dirty;
   }

   protected void makeDirty()
   {
      dirty = true;
   }

   protected void makeClean()
   {
      dirty = false;
   }

   private boolean dirty = false;

   public test.interfaces.CustomerData getData()
   {
      test.interfaces.CustomerData dataHolder = null;
      try
      {
         dataHolder = new test.interfaces.CustomerData();

         dataHolder.setCredit( getCredit() );
         dataHolder.setArray( getArray() );
         dataHolder.setImage( getImage() );
         dataHolder.setTax( getTax() );
         dataHolder.setId( getId() );
         dataHolder.setName( getName() );
         dataHolder.setFirstName( getFirstName() );
         dataHolder.setPhone( getPhone() );
         dataHolder.setFax( getFax() );
         dataHolder.setCreationDate( getCreationDate() );

         dataHolder.setVersion(getVersion());
      }
      catch (RuntimeException e)
      {
         throw new javax.ejb.EJBException(e);
      }

      return dataHolder;
   }

   public void setData( test.interfaces.CustomerData dataHolder )
   {
      if( getVersion() != dataHolder.getVersion() )
         throw new IllegalStateException( "Wrong version. Had " + getVersion() + ", got " + dataHolder.getVersion() );

      try
      {
         setCredit( dataHolder.getCredit() );
         setName( dataHolder.getName() );
         setFirstName( dataHolder.getFirstName() );
         setPhone( dataHolder.getPhone() );
         setFax( dataHolder.getFax() );
         setCreationDate( dataHolder.getCreationDate() );

      }
      catch (Exception e)
      {
         throw new javax.ejb.EJBException(e);
      }
   }

   /**
    * Generated ejbPostCreate for corresponding ejbCreate method.
    *
    * @see #ejbCreate(test.interfaces.CustomerNormalValue data)
    */
   public void ejbPostCreate(test.interfaces.CustomerNormalValue data)
   {
   }

   public void ejbLoad() 
   {
      makeClean();
   }

   public void ejbStore() throws javax.ejb.EJBException
   {
      if (isModified())
      {
         super.ejbStore();
         setVersion( getVersion() + 1 );
         makeClean();
      }
   }

   public void ejbActivate() throws javax.ejb.EJBException
   {
      super.ejbActivate();
   }

   public void ejbPassivate() throws javax.ejb.EJBException
   {
      super.ejbPassivate();

      CustomerLightValue = null;
      CustomerNormalValue = null;
      CustomerValue = null;
   }

   public void setEntityContext(javax.ejb.EntityContext ctx) throws javax.ejb.EJBException
   {
      super.setEntityContext(ctx);
   }

   public void unsetEntityContext() throws javax.ejb.EJBException
   {
      super.unsetEntityContext();
   }

   public void ejbRemove() throws javax.ejb.EJBException, javax.ejb.RemoveException
   {
      super.ejbRemove();

   }

 /* Value Objects BEGIN */

   public void addAccount(test.interfaces.AccountValue added)
   throws javax.ejb.FinderException
   {
	  try
	  {
		  test.interfaces.AccountPK pk = new test.interfaces.AccountPK(added.getId());

		 test.interfaces.AccountLocalHome home = test.interfaces.AccountUtil.getLocalHome();

		 test.interfaces.AccountLocal relation = home.findByPrimaryKey(pk);
		getAccounts().add(relation);
	  }
	  catch (Exception e){
		 if (e instanceof javax.ejb.FinderException)
			throw (javax.ejb.FinderException)e;
		 else
			throw new javax.ejb.EJBException(e);
	  }
   }

   public void removeAccount(test.interfaces.AccountValue removed)
   throws javax.ejb.RemoveException
   {
	  try
	  {
		  test.interfaces.AccountPK pk = new test.interfaces.AccountPK(removed.getId());

		 test.interfaces.AccountLocalHome home = test.interfaces.AccountUtil.getLocalHome();

		test.interfaces.AccountLocal relation = home.findByPrimaryKey(pk);
		getAccounts().remove(relation);
	  }
	  catch (Exception e){
		 if (e instanceof javax.ejb.RemoveException)
			throw (javax.ejb.RemoveException)e;
		 else
			throw new javax.ejb.EJBException(e);
	  }
   }

   public void addShippingAddress(test.interfaces.AddressValue added)
   throws javax.ejb.CreateException
   {
	  try
	  {
		  java.lang.String pk = added.getId();

		 test.interfaces.AddressLocalHome home = test.interfaces.AddressUtil.getLocalHome();

		 test.interfaces.AddressLocal relation = home.create(added);
		getShippingAddresses().add(relation);
	  }
	  catch (Exception e){
		 if (e instanceof javax.ejb.CreateException)
			throw (javax.ejb.CreateException)e;
		 else
			throw new javax.ejb.EJBException(e);
	  }
   }

   public void removeShippingAddress(test.interfaces.AddressValue removed)
   throws javax.ejb.RemoveException
   {
	  try
	  {
		  java.lang.String pk = removed.getId();

		 test.interfaces.AddressLocalHome home = test.interfaces.AddressUtil.getLocalHome();

		test.interfaces.AddressLocal relation = home.findByPrimaryKey(pk);
		getShippingAddresses().remove(relation);
		relation.remove();
	  }
	  catch (Exception e){
		 if (e instanceof javax.ejb.RemoveException)
			throw (javax.ejb.RemoveException)e;
		 else
			throw new javax.ejb.EJBException(e);
	  }
   }

   public void updateShippingAddress(test.interfaces.AddressValue updated)
   throws javax.ejb.FinderException
   {
	  try
	  {
		  java.lang.String pk = updated.getId();

		 test.interfaces.AddressLocalHome home = test.interfaces.AddressUtil.getLocalHome();

		test.interfaces.AddressLocal relation = home.findByPrimaryKey(pk);
		relation.setAddressValue(updated);
	  }
	  catch (Exception e){
		 if (e instanceof javax.ejb.FinderException)
			throw (javax.ejb.FinderException)e;
		 else
			throw new javax.ejb.EJBException(e);
	  }
   }

   private test.interfaces.CustomerLightValue CustomerLightValue = null;

   public test.interfaces.CustomerLightValue getCustomerLightValue()
   {
      CustomerLightValue = new test.interfaces.CustomerLightValue();
      try
         {
            CustomerLightValue.setCredit( getCredit() );
            CustomerLightValue.setId( getId() );

            CustomerLightValue.setVersion(getVersion());
         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return CustomerLightValue;
   }
   private test.interfaces.CustomerNormalValue CustomerNormalValue = null;

   public test.interfaces.CustomerNormalValue getCustomerNormalValue()
   {
      CustomerNormalValue = new test.interfaces.CustomerNormalValue();
      try
         {
            CustomerNormalValue.setCredit( getCredit() );
            CustomerNormalValue.setId( getId() );
            CustomerNormalValue.setName( getName() );
            CustomerNormalValue.setFirstName( getFirstName() );
            CustomerNormalValue.clearAccountViews();
            java.util.Iterator iAccountView = getAccounts().iterator();
            while (iAccountView.hasNext()){
                CustomerNormalValue.addAccountView( ((test.interfaces.AccountLocal)iAccountView.next()).getAccountValue() );
            }
            CustomerNormalValue.cleanAccountView();
            CustomerNormalValue.clearShippingAddressValues();
            java.util.Iterator iShippingAddressValue = getShippingAddresses().iterator();
            while (iShippingAddressValue.hasNext()){
                CustomerNormalValue.addShippingAddressValue( ((test.interfaces.AddressLocal)iShippingAddressValue.next()).getAddressValue() );
            }
            CustomerNormalValue.cleanShippingAddressValue();

            CustomerNormalValue.setVersion(getVersion());
         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return CustomerNormalValue;
   }
   private test.interfaces.CustomerValue CustomerValue = null;

   public test.interfaces.CustomerValue getCustomerValue()
   {
      CustomerValue = new test.interfaces.CustomerValue();
      try
         {
            CustomerValue.setCredit( getCredit() );
            CustomerValue.setId( getId() );
            CustomerValue.setName( getName() );
            CustomerValue.setFirstName( getFirstName() );
            CustomerValue.setPhone( getPhone() );
            CustomerValue.setFax( getFax() );
            CustomerValue.clearAccountViews();
            java.util.Iterator iAccountView = getAccounts().iterator();
            while (iAccountView.hasNext()){
                CustomerValue.addAccountView( ((test.interfaces.AccountLocal)iAccountView.next()).getAccountValue() );
            }
            CustomerValue.cleanAccountView();
            CustomerValue.clearShippingAddressValues();
            java.util.Iterator iShippingAddressValue = getShippingAddresses().iterator();
            while (iShippingAddressValue.hasNext()){
                CustomerValue.addShippingAddressValue( ((test.interfaces.AddressLocal)iShippingAddressValue.next()).getAddressValue() );
            }
            CustomerValue.cleanShippingAddressValue();

            CustomerValue.setVersion(getVersion());
         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return CustomerValue;
   }

   public void setCustomerNormalValue( test.interfaces.CustomerNormalValue valueHolder )
   throws test.interfaces.ApplicationException{
      validate(valueHolder);
	  if( getVersion() != valueHolder.getVersion() )
		 throw new IllegalStateException( "Wrong version. Had " + getVersion() + ", got " + valueHolder.getVersion() );

	  try
	  {
		 setCredit( valueHolder.getCredit() );
		 setName( valueHolder.getName() );
		 setFirstName( valueHolder.getFirstName() );

	  {

		 java.util.Iterator iAccountView = valueHolder.getAddedAccountViews().iterator();
		 while (iAccountView.hasNext())
		 {
			test.interfaces.AccountValue o = (test.interfaces.AccountValue)iAccountView.next();
			addAccount(o);
		 }
		 iAccountView = valueHolder.getRemovedAccountViews().iterator();
		 while (iAccountView.hasNext())
		 {
			test.interfaces.AccountValue o = (test.interfaces.AccountValue)iAccountView.next();
			removeAccount(o);
		 }
	  }
	  // Anonymous block to allow variable declations without conflicts
	  {

		 java.util.Iterator iShippingAddressValue = valueHolder.getUpdatedShippingAddressValues().iterator();
		 while (iShippingAddressValue.hasNext())
		 {
			test.interfaces.AddressValue o = (test.interfaces.AddressValue)iShippingAddressValue.next();
			updateShippingAddress(o);
		 }
		 iShippingAddressValue = valueHolder.getAddedShippingAddressValues().iterator();
		 while (iShippingAddressValue.hasNext())
		 {
			test.interfaces.AddressValue o = (test.interfaces.AddressValue)iShippingAddressValue.next();
			addShippingAddress(o);
		 }
		 iShippingAddressValue = valueHolder.getRemovedShippingAddressValues().iterator();
		 while (iShippingAddressValue.hasNext())
		 {
			test.interfaces.AddressValue o = (test.interfaces.AddressValue)iShippingAddressValue.next();
			removeShippingAddress(o);
		 }
	  }
	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

}
