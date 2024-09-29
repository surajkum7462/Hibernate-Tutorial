package com.tut;




import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started...." );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // it is an interface
       SessionFactory factory=cfg.buildSessionFactory();
       
       System.out.println(factory);
       
       // Creating student
       
       Student st=new Student();
       st.setId(104);
       st.setName("Rahul Kumar");
       st.setCity("Mumbai");
       
       st.setId(105);
       st.setName("suraj Kumar");
       st.setCity("bbsr");
       
       
       st.setId(106);
       st.setName("Shivam Kumar");
       st.setCity("cttk");
       
       
       st.setId(105);
       st.setName("Chandan Kumar");
       st.setCity("puri");
       
       System.out.println(st);
       
       // Creating object od address class
       
       Address ad=new Address();
       ad.setStreet("Sahu Colony");
       ad.setCity("Giridih");
       ad.setOpen(true);
       ad.setAddedDate(new Date());
       ad.setX(54);
       
       // Reading Image
       
       FileInputStream fis=new FileInputStream("src/main/java/suraj.jpg");
       byte[] data =new byte[fis.available()];
       fis.read(data);
       ad.setImage(data);
       
       
       
       
       
       
       
       // Save table into database using session
       
       Session session=factory.openSession();
       
       //start the transaction
       Transaction tx=session.beginTransaction();
       
       // save the object
       
       session.save(st);
       session.save(ad);
       tx.commit();
       session.close();
       System.out.println("Done...");
       
       
        
      
       
    }
    
   
}
