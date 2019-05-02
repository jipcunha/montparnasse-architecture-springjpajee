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
 * Servlet implementation class ModifierPers
 */
@WebServlet("/ModifierPers")
public class ModifierPers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");   
	
	Iservice service = context.getBean("serviceImpl", ServiceImpl.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierPers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		Personne p = service.affichagePersonne(Integer.parseInt(request.getParameter("idPers"))); //idPers vient de la jsp
		
		
		//3. preparer à l'envoi
		request.setAttribute("id", p.getIdPersonne());
		request.setAttribute("nom", p.getNom()); // "nom" est le name dans le formulaire
		request.setAttribute("prenom", p.getPrenom());
		request.setAttribute("age", p.getAge());
		
		request.setAttribute("personnes", service.findAllPersonnes());
		
		//4. appel à la jsp
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
