package pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/tirage")
public class ServletPageAlea extends HttpServlet {

    public ServletPageAlea() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        this.getServletContext().getRequestDispatcher("/tirage.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  super.doPost(req, resp);
        String nombre = req.getParameter("nombre");
       // System.out.println(nombre);
        int nombreAleatoire = 0 + (int)(Math.random() * ((3 - 0) + 1));
        System.out.println(nombreAleatoire);
        String victory="défaite";
        if( Integer.parseInt(nombre) == nombreAleatoire ) {
            victory = "victoire";
            resp.sendRedirect("victoire.html");
        }
        else {
            // resp.getWriter().append("nombre choisi : " + nombre + " nombre tiré : " + nombreAleatoire + " " + victory);
            resp.sendRedirect("defaite.html");
        }
    }
}
