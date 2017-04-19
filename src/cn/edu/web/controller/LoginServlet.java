package cn.edu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.service.IUserService;
import cn.edu.service.impl.UserServiceImpl;
import cn.edu.vo.hibernate.User;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("userName");
        String password = request.getParameter("userPwd");
        
        IUserService service = new UserServiceImpl();
        User user = service.loginUser(username, password);
		if(user==null){
			String message = "对不起，用户名或密码有误！！请重新登录！";
			request.setAttribute("message",message);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", user);
		if(user.getUserName().equals("admin")){
			request.getSession().setAttribute("admin", 1);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
