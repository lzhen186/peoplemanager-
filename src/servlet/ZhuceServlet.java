package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.UserBean;

/**
 * Servlet implementation class ZhuceServlet
 */
public class ZhuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ZhuceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String home = request.getParameter("home");
		String info = request.getParameter("info");
		
		UserBean user = new UserBean(name,pwd,sex,home,info);
		
		UserDao ud = new UserDaoImpl();
		
		if(ud.register(user)) {
			request.setAttribute("username", name);
			request.setAttribute("message", "×¢²á³É¹¦");
		}else {
			request.setAttribute("message", "×¢²áÊ§°Ü");
		}
		request.getRequestDispatcher("index.jsp").forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
