package web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.EtudiantLocal;
import metier.entities.Etudiant;

/**
 * Servlet implementation class ControleurWEB2
 */
@WebServlet(name = "CS1",urlPatterns ={"/controleur1"})
public class ControleurWEB2 extends HttpServlet {
       
	@EJB
	private EtudiantLocal metier;
    public ControleurWEB2() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			
			   if (request.getParameter("action1").equals("Recherche")) {
				   
				   if (request.getParameter("refEtudiant").length()!=0) {
		    	Long refEtudiant= (long) Integer.parseInt(request.getParameter("refEtudiant"));
				Etudiant pp = metier.getEtudiant(refEtudiant);		
				request.setAttribute("refEtudiant", pp.getRefEtudiant());
				request.setAttribute("prenom", pp.getPrenom());
				request.setAttribute("nom", pp.getNom());
				request.setAttribute("departement", pp.getDepartement());
				request.setAttribute("scolarite", pp.getScolarite());
				request.setAttribute("groupe", pp.getGroupe());
				request.setAttribute("code", pp.getCode());

			}
			  }
			   if (request.getParameter("action1").equals("Consulter")) {
			    	Long refEtudiant= (long) Integer.parseInt(request.getParameter("refEtudiant"));
					Etudiant pp = metier.getEtudiant(refEtudiant);		
					request.setAttribute("refEtudiant", pp.getRefEtudiant());
					request.setAttribute("prenom", pp.getPrenom());
					request.setAttribute("nom", pp.getNom());
					request.setAttribute("departement", pp.getDepartement());
					request.setAttribute("scolarite", pp.getScolarite());
					request.setAttribute("groupe", pp.getGroupe());
					request.setAttribute("code", pp.getCode());

				}
			   if (request.getParameter("action1").equals("Supprimer")) {
					
				   Long refEtudiant= (long) Integer.parseInt(request.getParameter("refEtudiant"));
				
			   		metier.SuprimerEtudiant(refEtudiant);	 
			
			     }
			if (request.getParameter("nom").length()!=0) {
			    
			    if (request.getParameter("action1").equals("Ajouter")) {
					Etudiant p = new Etudiant();
					p.setNom(request.getParameter("nom"));
					p.setPrenom(request.getParameter("prenom"));
					p.setDepartement(request.getParameter("departement"));
					p.setScolarite(Double.parseDouble(request.getParameter("scolarite")));
					p.setGroupe(request.getParameter("groupe"));
					p.setCode(request.getParameter("code"));
					metier.addEtudiant(p);
				}
			    if (request.getParameter("action1").equals("Modifier")) {
			    	Long refEtudiant= (long) Integer.parseInt(request.getParameter("refEtudiant"));
					Etudiant p = new Etudiant();
					p.setNom(request.getParameter("nom"));
					p.setPrenom(request.getParameter("prenom"));
					p.setDepartement(request.getParameter("departement"));
					p.setScolarite(Double.parseDouble(request.getParameter("scolarite")));
					p.setGroupe(request.getParameter("groupe"));
					p.setCode(request.getParameter("code"));
					metier.ModifierEtudiant(refEtudiant,p);
				}
			    
			    }
			 
			 
			    if (request.getParameter("action1").equals("Lister"))
			      {
			    List<Etudiant> prods = metier.listeEtudiant();
				request.setAttribute("etudiant", prods);

			    }
			    List<Etudiant> prods = metier.listeEtudiant();
			  	request.setAttribute("etudiant", prods);
			  	

			  	 System.out.println("\n Hello");
				

			request.getRequestDispatcher("VueEtudiant1.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	

}
