package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.UserBean;

/**
 * Servlet implementation class SearchallServlet
 */
public class SearchallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SearchallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		List<UserBean> userAll = ud.getUserAll();
		request.setAttribute("userAll", userAll);
		request.getRequestDispatcher("showall.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
