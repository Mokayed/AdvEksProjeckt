/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import persistence.admin.Admin;

/**
 *
 * @author MoK
 */
public interface IFirebasePersistence {
     public void putInFirebase(Admin admin);
     public void getFromFirebase(Admin admin);
     //these two method should not be void..?
}
