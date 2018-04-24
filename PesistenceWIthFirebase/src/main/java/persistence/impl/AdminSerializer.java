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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Date;
import persistence.Serializer;
import persistence.admin.Admin;
import persistence.admin.AdminFactory;


/**
 *
 * @author Tobias
 */
public class AdminSerializer implements Serializer<Admin>
{
    private static Serializer<Admin> instance;
    private final AdminFactory factory;

    private AdminSerializer(AdminFactory factory)
    {
        this.factory = factory;
    }
    
    
    @Override
    public void serialize(Admin dataObj, DataOutput out) throws IOException
    {
        out.writeUTF(dataObj.getFirstName());
        out.writeUTF(dataObj.getLastName());
        out.writeLong(dataObj.getBirthDate().getTime());
 
    }

    @Override
    public Admin deserialize(DataInput in) throws IOException
    {
        String firstName = in.readUTF();
        String lastName = in.readUTF();
        Date birthDate = new Date(in.readLong());
   
        return factory.newAdmin(firstName, lastName, birthDate);
    }
    
    public static Serializer<Admin> getInstance()
    {
        if(instance == null)
        {
            instance = new AdminSerializer(AdminFactoryImpl.getInstance());
        }
        return instance;
    }
    
}
