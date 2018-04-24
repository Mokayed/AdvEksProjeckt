/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.impl;

/**
 *
 * @author MoK
 */



import java.util.Date;
import persistence.admin.Admin;
import persistence.admin.AdminFactory;


/**
 *
 * @author Tobias
 */
public class AdminFactoryImpl implements AdminFactory
{
      private static AdminFactory instance;
       private AdminFactoryImpl()
    {
    }

    @Override
    public Admin newAdmin(String firstName, String lastName, Date birthdate)
    {
        return new AdminImpl(firstName, lastName, birthdate);
    }
    
     public static AdminFactory getInstance()
    {
        if(instance == null)
        {
            instance = new AdminFactoryImpl();
        }
        return instance;
    }
    

   private static class AdminImpl implements Admin
    {
        private final String firstName;
        private final String lastName;
        private final Date birthDate;

        public AdminImpl(String firstName, String lastName, Date birthDate)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
        }
        
        
        @Override
        public String getFirstName()
        {
            return firstName;
        }

        @Override
        public String getLastName()
        {
            return lastName;
        }

        @Override
        public Date getBirthDate()
        {
            return birthDate;
        }
        
        @Override
        public String toString()
        {
            return firstName + " " + lastName + " " + birthDate;
        }
    }
}
