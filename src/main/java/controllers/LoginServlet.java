package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.LoginService;
import services.LoginServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet({"/login" , "/login.html"})
public class LoginServlet extends HttpServlet {
    final static String USERNAME ="admin";
    final static String PASSWORD ="12345";

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException {
        //Cookie[] cookies = req.getCookies() != null ? req.getCookies(): new Cookie[0];
        /*Optional<String> cookieOptional= Arrays.stream(cookies)
                .filter(c-> "username".equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();*/
            //Creamos el nuevo objeto de la cookie
            LoginService auth = new LoginServiceImplement();
            Optional<String> cookieOptional = auth.getUsername(req);
        if(cookieOptional.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Bienvenido</title>");
        out.println("</head>");
        out.println("<body>");
       out.println("<h1>Hola " + cookieOptional.get()+ " ya iniciaste sesion anteriormente!</h1>");
       out.println("<p> <a href'"+req.getContextPath()+"/index.html'>Volver al incio</a> </p>");
       out.println("</body>");
        out.println("</html>");
         }
        } else {
                getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
@Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals(USERNAME) && password.equals(PASSWORD)){
            Cookie usernameCookie = new Cookie("username", username);
            resp.addCookie(usernameCookie);
            resp.setContentType("text/html;charset=UTF-8");
            try(PrintWriter out = resp.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Bienvenido a la app</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Bienvenido a mi APP!</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            resp.sendRedirect(req.getContextPath()+"/login.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo Siento no tiene acceso" );
        }
        }
}
