package com.todoapp.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todoapp.dao.logindao;
import com.todoapp.model.login;


@WebServlet("/login")
public class LoginContrroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    private logindao LoginDao;



    public void init() {
        LoginDao = new logindao();
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginContrroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	response.sendRedirect("login/login.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      authenticate(request, response);
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) {
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		login LoginBean=new login();
		LoginBean.setUsername(username);
		LoginBean.setPassword(password);
		
		
	     try { 
	    		 if(LoginDao.validate(LoginBean)){
	    			 RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.jsp");
         dispatcher.forward(request, response);
	    	 
	     }else {
	    	
	    	 
	    	 HttpSession session = request.getSession();
	    	 PrintWriter out=response.getWriter();
	    	 out.print("ERROR");
	     }
	     }catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

  		// TODO Auto-generated method stub
		
	}

}













