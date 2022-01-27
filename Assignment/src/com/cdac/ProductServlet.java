package com.cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ProductServlet extends HttpServlet

{   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
              
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
		
        String action = request.getServletPath();
        
        
        
        if(action.equals("/AddProduct"))
        {
        	insertPro(request,response);
        	
        }else if(action.equals("/viewProduct"))
        {
      	  
        	
        	listStu(request,response);
        	
     	}else if(action.equals("/delete"))
     	{
	     	deletePro(request,response); 
     		
       	}else if(action.equals("/searchProduct"))
 	        {
     	            searchPro(request,response); 
        	}
        
	     else if(action.equals("/editProduct"))
          {
                 editPro(request,response); 
	      }
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
              
		 doPost(request,response);
		
	}   
	
	
    protected void insertPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
     
		  int pid=Integer.parseInt(request.getParameter("pid"));  
     String pname=request.getParameter("pname");  
	     int pprice = Integer.parseInt(request.getParameter("pprice"));	 
	     int pquantity = Integer.parseInt(request.getParameter("pquantity"));
      int pdiscount = Integer.parseInt(request.getParameter("pdiscount"));
      ProductHibernate shb = new ProductHibernate();
	      
	      
	      Product p = new Product();
	      p.setPid(pid);
	      p.setPname(pname);
          p.setPprice(pprice);
          p.setPquantity(pquantity);
	      p.setPdiscount(pdiscount);
	      //passing object into the function
	         
	       shb.insertProduct(p);
	       out.println("record inserted");
	       RequestDispatcher rd= request.getRequestDispatcher("Welcome.html");
			rd.include(request, response);
		
	}
	protected void listStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		  ProductHibernate shb = new ProductHibernate();
     
		 List<Product> product=shb.viewProduct();
		 
		 
	       HttpSession session=request.getSession();
	       session.setAttribute("product", product);
	      
	       RequestDispatcher rd= request.getRequestDispatcher("viewProduct.jsp");
			rd.forward(request, response);
			
	}
    
	protected void deletePro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		
		    response.setContentType("text/html");  
            PrintWriter out1=response.getWriter();  
 
          ProductHibernate shb = new ProductHibernate();

	     	int pid = Integer.parseInt(request.getParameter("pid"));
	
		  
	       shb.deleteProduct(pid);
	       out1.println("Product Deleted Succesfully");
	       RequestDispatcher rd= request.getRequestDispatcher("Welcome.html");
			rd.include(request, response);

	}
protected void searchPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		
		    response.setContentType("text/html");  
            PrintWriter out2=response.getWriter();  
 
          ProductHibernate shb = new ProductHibernate();

	     	int pid = Integer.parseInt(request.getParameter("pid"));
	
	     	      List<Product> product=shb.searchProduct(pid);     
			       HttpSession session=request.getSession();
			       session.setAttribute("productlist", product);		 
			      
			       RequestDispatcher rd= request.getRequestDispatcher("searchedProduct.jsp");
					rd.forward(request, response);
	     	}
	     		
	
protected void editPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 

{
	
	    response.setContentType("text/html");  
        PrintWriter out1=response.getWriter();  
        

		  int pid=Integer.parseInt(request.getParameter("pid"));  
   String pname=request.getParameter("pname");  
	     int pprice = Integer.parseInt(request.getParameter("pprice"));	 
	     int pquantity = Integer.parseInt(request.getParameter("pquantity"));
    int pdiscount = Integer.parseInt(request.getParameter("pdiscount"));

      ProductHibernate shb = new ProductHibernate();
      
      Product p = new Product();
      p.setPid(pid);
      p.setPname(pname);
      p.setPprice(pprice);
      p.setPquantity(pquantity);
      p.setPdiscount(pdiscount);
      //passing object into the function
         
  	    List<Product> products=shb.editProduct(p);
        out1.println("record updated Succesfully");

	       HttpSession session=request.getSession();
	       session.setAttribute("products", products);
	    
         RequestDispatcher rd= request.getRequestDispatcher("editedProduct.jsp");
		 rd.include(request, response);

}
}