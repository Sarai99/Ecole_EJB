package web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Matiere;
import metier.EtudiantLocal;


/**
 * Servlet implementation class ControleurWEB3
 */
@WebServlet(name = "CS2",urlPatterns ={"/controleur2"})
public class ControleurWEB3 extends HttpServlet {
	@EJB
	private EtudiantLocal metier;
	
    public ControleurWEB3() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		    if (request.getParameter("action2").equals("Recherche")) {
		    	if (request.getParameter("refMatiere").length()!=0) {
		    	Long refMatiere= (long) Integer.parseInt(request.getParameter("refMatiere"));
				Matiere pp = metier.getMatiere(refMatiere);		
				request.setAttribute("refMatiere", pp.getRefMatiere());
				request.setAttribute("description", pp.getDescription());
				request.setAttribute("coef", pp.getCoef());
		    	}

			}
			   if (request.getParameter("action2").equals("Consulter")) {
			    	Long refMatiere= (long) Integer.parseInt(request.getParameter("refMatiere"));
					Matiere pp = metier.getMatiere(refMatiere);		
					request.setAttribute("refMatiere", pp.getRefMatiere());
					request.setAttribute("description", pp.getDescription());
					request.setAttribute("coef", pp.getCoef());
					
				}
			   if (request.getParameter("action2").equals("Supprimer")) {
					
				   Long refMatiere= (long) Integer.parseInt(request.getParameter("refMatiere"));
			   		metier.SuprimerMatiere(refMatiere);	 
			
			     }
			     
			if (request.getParameter("description").length()!=0) {
			    
			    if (request.getParameter("action2").equals("Ajouter")) {
					Matiere p = new Matiere();
					p.setDescription(request.getParameter("description"));
					p.setCoef((long)Integer.parseInt(request.getParameter("coef")));
					
					metier.addMatiere(p);
				}
			    if (request.getParameter("action2").equals("Modifier")) {
			    	Long refMatiere= (long) Integer.parseInt(request.getParameter("refMatiere"));
					Matiere p = new Matiere();
					p.setDescription(request.getParameter("description"));
					p.setCoef((long)Integer.parseInt(request.getParameter("coef")));
					metier.ModifierMatiere(refMatiere, p);
				}
			    
			    }
			 
			 
			     if (request.getParameter("action2").equals("Lister"))
			      {
			    List<Matiere> prods = metier.listeMatiere();
				request.setAttribute("matiere", prods);

			    }
			    
			    List<Matiere> prods = metier.listeMatiere();
			  	request.setAttribute("matiere", prods);
			  	

			  	 System.out.println("\n Hello");
				

			request.getRequestDispatcher("VueMatiere.jsp").forward(request, response);

	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
