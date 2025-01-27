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
import sun.invoke.empty.Empty;

@WebServlet(name = "CS",urlPatterns ={"/controleur"})
public class ControleurWEB extends HttpServlet {
	@EJB
	private EtudiantLocal metier;
    public ControleurWEB() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if (request.getParameter("action").equals("Consulter")) {
	    	Long refEtudiant= (long) Integer.parseInt(request.getParameter("refEtudiant"));
			Etudiant pp = metier.getEtudiant(refEtudiant);		
			request.setAttribute("refEtudiant", pp.getRefEtudiant());
			request.setAttribute("prenom", pp.getPrenom());
			request.setAttribute("nom", pp.getNom());
			request.setAttribute("departement", pp.getDepartement());
			request.setAttribute("scolarite", pp.getScolarite());
			request.setAttribute("groupe", pp.getGroupe());
			request.setAttribute("code", pp.getCode());
			//doGet(request, response);


		} 
		System.out.println("\n Hello 1");
	
		request.getRequestDispatcher("VueEtudiant.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	
    if (request.getParameter("nom").length()!=0) {
    
    if (request.getParameter("action").equals("Ajouter")) {
		Etudiant p = new Etudiant();
		p.setNom(request.getParameter("nom"));
		p.setPrenom(request.getParameter("prenom"));
		p.setDepartement(request.getParameter("departement"));
		p.setScolarite(Double.parseDouble(request.getParameter("scolarite")));
		p.setGroupe(request.getParameter("groupe"));
		p.setCode(request.getParameter("code"));
		metier.addEtudiant(p);
	}
    if (request.getParameter("action").equals("Modifier")) {
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
 
 
    if (request.getParameter("action").equals("Lister"))
      {
    List<Etudiant> prods = metier.listeEtudiant();
	request.setAttribute("etudiant", prods);

    }
    List<Etudiant> prods = metier.listeEtudiant();
  	request.setAttribute("etudiant", prods);
  	doGet(request, response);
  	 System.out.println("\n Hello");
	}


}
