/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.implemations;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.concurrent.CountDownLatch;
import persistence.DataIn;
import persistence.DataOut;
import persistence.Persistence;
import persistence.admin.Admin;

/**
 *
 * @author MoK
 */
public class FirebasePersistence implements Persistence {

    private Admin admin;

    public FirebasePersistence(Admin admins) {

        admin = admins;
    }

    public FirebaseDatabase firebaseDatabase;

    public void initFirebase() {
        try {
            // .setDatabaseUrl("https://fir-66f50.firebaseio.com") - Firebase project url.

            // Firebase private key(Generated while creating service account) file path.
            // .setServiceAccount(new FileInputStream(new File("filepath")))
            FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                    .setDatabaseUrl("https://finaleapp-dcad7.firebaseio.com")
                    .setServiceAccount(new FileInputStream(new File("C:\\Users\\MoK\\Documents\\NetBeansProjects\\Firebase\\finaleapp-dcad7-firebase-adminsdk-ultqu-62bc411e68.json")))
                    .build();

            FirebaseApp.initializeApp(firebaseOptions);
            firebaseDatabase = FirebaseDatabase.getInstance();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public DataOut put(long id) throws IOException {
        String name = "user" + id;

        if (id != 0) {

            initFirebase();

            DatabaseReference databaseReference = firebaseDatabase.getReference("/");

            DatabaseReference childReference = databaseReference.child("users").child(name);

            CountDownLatch countDownLatch = new CountDownLatch(1);

            childReference.setValue(admin, new DatabaseReference.CompletionListener() {

                @Override
                public void onComplete(DatabaseError de, DatabaseReference dr) {
                    System.out.println("Record saved!");

                    countDownLatch.countDown();
                }
            });
            try {
                //wait for firebase to saves record.
                countDownLatch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public DataIn get(long id) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
