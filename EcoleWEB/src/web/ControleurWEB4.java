package web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Etudiant;
import metier.entities.Paiement;


import metier.EtudiantLocal;

/**
 * Servlet implementation class ControleurWEB4
 */
@WebServlet(name = "CS3",urlPatterns ={"/controleur3"})
public class ControleurWEB4 extends HttpServlet {
	@EJB
	private EtudiantLocal metier;
	Date date= new Date();
	java.sql.Date sqldate = new java.sql.Date(date.getTime());
	
        public ControleurWEB4() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 if (request.getParameter("action3").equals("Recherche")) {
			 if (request.getParameter("refPaiement").length()!=0) {
		    	Long refPaiement= (long) Integer.parseInt(request.getParameter("refPaiement"));
				Paiement pp = metier.getPaiement(refPaiement);		
				request.setAttribute("refPaiement", pp.getRefPaiement());
				request.setAttribute("montant", pp.getMontant());
				request.setAttribute("datePaiement", pp.getDatePaiement());
				request.setAttribute("mois", pp.getMois());
				request.setAttribute("refEtudiant", pp.getEtudiant());
			 }

			}
			   if (request.getParameter("action3").equals("Consulter")) {
			    	Long refPaiement= (long) Integer.parseInt(request.getParameter("refPaiement"));
					Paiement pp = metier.getPaiement(refPaiement);		
					request.setAttribute("refPaiement", pp.getRefPaiement());
					request.setAttribute("montant", pp.getMontant());
				
					request.setAttribute("datePaiement", pp.getDatePaiement());
					request.setAttribute("mois", pp.getMois());
					request.setAttribute("refEtudiant", pp.getEtudiant());
					System.out.println(pp.getEtudiant());
				

				}
			   if (request.getParameter("action3").equals("Supprimer")) {
					
				   Long refPaiement= (long) Integer.parseInt(request.getParameter("refPaiement"));
			   		metier.SuprimerPaiement(refPaiement);	 
			
			     }
			if (request.getParameter("montant").length()!=0) {
			    
			    if (request.getParameter("action3").equals("Ajouter")) {
					Paiement p = new Paiement();
					p.setMontant(Double.parseDouble(request.getParameter("montant")));
					p.setDatePaiement(sqldate);
					p.setMois(request.getParameter("mois"));
					Long refEtudiant= (long) Integer.parseInt(request.getParameter("refEtudiant"));
					Etudiant et= metier.getEtudiant(refEtudiant);
					p.setEtudiant(et);
					metier.addPaiement(p, refEtudiant);
				}
			    if (request.getParameter("action3").equals("Modifier")) {
			    	Long refPaiement= (long) Integer.parseInt(request.getParameter("refPaiement"));
					Paiement p = new Paiement();
					p.setMontant(Double.parseDouble(request.getParameter("montant")));
					p.setDatePaiement(sqldate);
					p.setMois(request.getParameter("mois"));
					Long refEtudiant= (long) Integer.parseInt(request.getParameter("refEtudiant"));
					Etudiant et= metier.getEtudiant(refEtudiant);
					p.setEtudiant(et);
					metier.ModifierPaiement(refPaiement,p);
				}
			    
			    }
			 
			 
			    if (request.getParameter("action3").equals("Lister"))
			      {
			    List<Paiement> prods = metier.listePaiement();
				request.setAttribute("paiement", prods);

			    }
			    List<Paiement> prods = metier.listePaiement();
			  	request.setAttribute("paiement", prods);
			  	

			  	 System.out.println("\n Hello");
				

			request.getRequestDispatcher("VuePaiment.jsp").forward(request, response);

	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			}

}
