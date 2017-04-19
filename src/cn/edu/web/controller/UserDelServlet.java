package cn.edu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.dao.IUserDao;
import cn.edu.dao.impl.UserDaoImpl;
import cn.edu.service.IUserService;
import cn.edu.service.impl.UserServiceImpl;
import cn.edu.vo.hibernate.User;

/**
 * Servlet implementation class UserDelServlet
 */
@WebServlet("/userdel.do")
public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = (String)request.getParameter("userId");
		IUserService service = new UserServiceImpl();
		service.deleteUser(userId);
		List<User> userList = service.getUserList();
		request.getSession().setAttribute("userList", userList);
		request.getRequestDispatcher("/WEB-INF/pages/userlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
