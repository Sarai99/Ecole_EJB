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
import metier.entities.Notes;

/**
 * Servlet implementation class ControleurWEB6
 */
@WebServlet(name = "CS5",urlPatterns ={"/controleur5"})
public class ControleurWEB6 extends HttpServlet {
	@EJB
	private EtudiantLocal metier;   
    
    public ControleurWEB6() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if (request.getParameter("action5").equals("Recherche")) {
			{
				if (request.getParameter("refEtudiant").length()!=0) {
	    	Long refEtudiant= (long) Integer.parseInt(request.getParameter("refEtudiant"));
			
			List<Notes> prods = metier.listNotes1(refEtudiant);
			request.setAttribute("notes1", prods);

		}
		}
		}
		request.getRequestDispatcher("BulletinEtudiant.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
