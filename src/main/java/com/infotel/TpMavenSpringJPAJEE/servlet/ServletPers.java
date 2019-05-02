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
 * Servlet implementation class ServletPers
 */
@WebServlet("/ServletPers")
public class ServletPers extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	Iservice service = context.getBean("serviceImpl", ServiceImpl.class);

      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
		//1. recuperation des donnes
		String nom = null;
		String prenom = null;
		int age = 0;
		int id = 0;		
		
		if(request.getParameter("nom") != null) {
		
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		age = Integer.parseInt(request.getParameter("age"));
	
		
		//2.envoyer les donnees � la couche service
		Personne p = context.getBean("personne", Personne.class);		
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setAge(age);	


		if(request.getParameter("ajouter") != null) {
			service.ajouterPersonne(p); 
		}
		
		if(request.getParameter("modifier") != null) {
			id = Integer.parseInt(request.getParameter("id")); //id c'est le name du hidden input id
			p.setIdPersonne(id);
			service.modifierPersonne(p);		
		} 	
		}
		
		//3. preparer � l'envoi
		request.setAttribute("personnes", service.findAllPersonnes());
		
		//4. appel � la jsp
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
