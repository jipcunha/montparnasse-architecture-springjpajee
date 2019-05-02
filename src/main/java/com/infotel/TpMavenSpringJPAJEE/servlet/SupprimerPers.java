package com.infotel.TpMavenSpringJPAJEE.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infotel.TpMavenSpringJPAJEE.metier.Personne;
import com.infotel.TpMavenSpringJPAJEE.service.Iservice;
import com.infotel.TpMavenSpringJPAJEE.service.ServiceImpl;

/**
 * Servlet implementation class SupprimerPers
 */
@WebServlet("/SupprimerPers")
public class SupprimerPers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");   
	
	Iservice service = context.getBean("serviceImpl", ServiceImpl.class);
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerPers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Personne p = service.getPersonne(Integer.parseInt(request.getParameter("idPers")));
		service.supprimerPersonne(p);

		// 3 - pr�paration � l'envoi
		request.setAttribute("personnes", service.findAllPersonnes());
		// 4- appel de la jsp
		request.getRequestDispatcher("personnes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
