package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;

/**
 * Servlet implementation class DengluServlet
 */
public class DengluServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DengluServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		 
		UserDao ud = new UserDaoImpl();
		if(ud.login(name,pwd)) {
			request.setAttribute("message","»¶Ó­ÓÃ»§,"+name);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else {
			request.setAttribute("message","µÇÂ¼Ê§°Ü£¡");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
