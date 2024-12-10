package web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.entities.Etudiant;
import metier.entities.Matiere;
import metier.entities.Notes;


import metier.EtudiantLocal;
/**
 * Servlet implementation class ControleurWEB5
 */
@WebServlet(name = "CS4",urlPatterns ={"/controleur4"})
public class ControleurWEB5 extends HttpServlet {
	@EJB
	private EtudiantLocal metier;
    
    public ControleurWEB5() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
               
		    
		    if (request.getParameter("action4").equals("Ajouter")) {
		    	if (request.getParameter("refEtudiant").length()!=0) {
		    	Notes p = new Notes();
				Long refMatiere= (long) Integer.parseInt(request.getParameter("refMatiere"));
				Matiere m= metier.getMatiere(refMatiere);
				p.setMatiere(m);
				p.setValeur(Double.parseDouble(request.getParameter("valeur")));
				Long refEtudiant= (long) Integer.parseInt(request.getParameter("refEtudiant"));
				Etudiant et= metier.getEtudiant(refEtudiant);
				p.setEtudiant1(et);
				metier.addNotes(p, refEtudiant, refMatiere);
			}
		    }
		    if (request.getParameter("action4").equals("Modifier")) {
		    	if (request.getParameter("refEtudiant").length()!=0) {
		    	Long idNote= (long) Integer.parseInt(request.getParameter("idNote"));
				Notes p = new Notes();
				Long refMatiere= (long) Integer.parseInt(request.getParameter("refMatiere"));
				Matiere m= metier.getMatiere(refMatiere);
				p.setMatiere(m);
				p.setValeur(Double.parseDouble(request.getParameter("valeur")));
				Long refEtudiant= (long) Integer.parseInt(request.getParameter("refEtudiant"));
				Etudiant et= metier.getEtudiant(refEtudiant);
				p.setEtudiant1(et);
				metier.ModifierNotes(idNote,p);
			} 
		    
		    }
		if (request.getParameter("action4").equals("Recherche")) {
			if (request.getParameter("idNote").length()!=0) {
	    	Long idNote= (long) Integer.parseInt(request.getParameter("idNote"));
			Notes pp = metier.getNotes(idNote);		
			request.setAttribute("idNote", pp.getIdNote());
			request.setAttribute("refMatiere", pp.getMatiere());
			request.setAttribute("valeur", pp.getValeur());
			request.setAttribute("refEtudiant", pp.getEtudiant1());
			
			}
		}
		   if (request.getParameter("action4").equals("Consulter")) {
		    	Long idNote= (long) Integer.parseInt(request.getParameter("idNote"));
				Notes pp = metier.getNotes(idNote);		
				request.setAttribute("idNote", pp.getIdNote());
				request.setAttribute("refMatiere", pp.getMatiere());
			
				request.setAttribute("valeur", pp.getValeur());
				request.setAttribute("refEtudiant", pp.getEtudiant1());
				System.out.println(pp.getEtudiant1());
			

			}
		   if (request.getParameter("action4").equals("Supprimer")) {
				
			    Long idNote= (long) Integer.parseInt(request.getParameter("idNote"));
		   		metier.SuprimerNotes(idNote);	 
		
		     }
		    
		 
		 
		    if (request.getParameter("action4").equals("Lister"))
		      {
		    List<Notes> prods = metier.listeNotes();
			request.setAttribute("notes", prods);

		    }
		    List<Notes> prods = metier.listeNotes();
		  	request.setAttribute("notes", prods);
		  	

		  	 System.out.println("\n Hello");
			

		request.getRequestDispatcher("VueNotes.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
