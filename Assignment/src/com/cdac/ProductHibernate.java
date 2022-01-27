package com.cdac;

import java.util.List;

import javax.servlet.RequestDispatcher;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

public class ProductHibernate 
{
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
   SessionFactory factory = meta.getSessionFactoryBuilder().build();  
   Session session = factory.openSession();
   Transaction t = session.beginTransaction();
   Criteria crit = session.createCriteria(Product.class);
	public void insertProduct(Product p)
	{
		 
        
        session.save(p);
        t.commit();
       
        session.close();
            
	}
	
	
	public List<Product> viewProduct()
	{
//		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//         Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();
        
     //   Criteria crit = session.createCriteria(Product.class);
     	List<Product> product = crit.list();
        return product;
       		     
	}
	
	public void deleteProduct(int p) {
//		
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
//       SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//       Session session = factory.openSession();
//       Transaction t = session.beginTransaction();
//	
//    
  	
	     Product s = (Product)session.get(Product.class, p);
 	
        session.delete(s);
	
      	System.out.println("Product deleted");
 	
       	t.commit();
 		
	
	session.close();
  	
     
		
	}

	public List<Product>  searchProduct(int pid)
	{
//		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//         Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();
//        
      //  Product s = (Product)session.get(Product.class, pid);
       
        
    //    Criteria crit = session.createCriteria(Product.class);
       crit.add(Restrictions.eq("pid",pid));
     	List<Product> product = crit.list();
        return product;
       		     
	}
	public List<Product> editProduct(Product p)
	{
//		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//         Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();
//        
        session.update(p);
        t.commit();
       
       //   session.close();
        
    //    Criteria crit = session.createCriteria(Product.class);
     	List<Product> products = crit.list();
     	
        return products;
      
	}

	
	
}
