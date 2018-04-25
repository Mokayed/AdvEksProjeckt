/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.demo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.IFirebasePersistence;
import persistence.Persistence;
import persistence.admin.Admin;
import persistence.admin.AdminFactory;
import persistence.impl.AdminFactoryImpl;
import persistence.implemations.FilePersistence;
import persistence.implemations.FirebasePersistence;

/**
 *
 * @author MoK
 */
public class DemoPut
 {  
    public static void main(String[] args) throws IOException
    {
       
        AdminFactory factory = AdminFactoryImpl.getInstance();
        
        Admin mo = factory.newAdmin("Lasse", "Andersen", "admin", "434334,343433", "5534343,3434343");
        
        IFirebasePersistence savetofirebase = new FirebasePersistence();
        
        savetofirebase.putInFirebase(mo);
        
        
  
        Persistence storage =  new FilePersistence(Paths.get("C:\\tmp\\storage"));
       
        try {
            storage.put(42);
        } catch (IOException ex) {
            Logger.getLogger(DemoPut.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
      
        
    }