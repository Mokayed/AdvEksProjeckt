/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.demo;

import java.io.IOException;
import java.util.Date;
import persistence.Persistence;
import persistence.admin.Admin;
import persistence.admin.AdminFactory;
import persistence.impl.AdminFactoryImpl;

import persistence.implemations.FirebasePersistence;

/**
 *
 * @author MoK
 */
public class DemoPut {

    public static void main(String[] args) throws IOException {
//adding user Mo Kayed into firebase by userid4.
        AdminFactory factory = AdminFactoryImpl.getInstance();
        Admin mo = factory.newAdmin("Mo", "Kayed", new Date(0));

        Persistence firebasestorage = new FirebasePersistence(mo);

        firebasestorage.put(4);

    }

}
