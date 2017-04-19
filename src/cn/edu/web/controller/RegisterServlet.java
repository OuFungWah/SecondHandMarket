package cn.edu.web.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.exception.UserExistException;
import cn.edu.service.IUserService;
import cn.edu.service.impl.UserServiceImpl;
import cn.edu.util.WebUtils;
import cn.edu.vo.hibernate.User;
import cn.edu.web.formbean.RegisterFormBean;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5508856500463737081L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		RegisterFormBean formbean = new RegisterFormBean();
		String userName = request.getParameter("userName");
		formbean.setUserName(userName);
        String userPwd = request.getParameter("userPwd");
        formbean.setUserPwd(userPwd);
        String confirmPwd = request.getParameter("confirmPwd");
        formbean.setConfirmPwd(confirmPwd);
        String email = request.getParameter("email");
        formbean.setEmail(email);
        String className = request.getParameter("className");
        formbean.setClassName(className);
		if (formbean.validate() == false) {
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		try {
			//把formbean中的属性复制到user中（有相同属性的那些）
			BeanUtils.copyProperties(user, formbean);
			//给新用户分配一个id
			user.setId(WebUtils.makeId("U"));
			//给新用户初始化余额
			user.setBalance(new BigDecimal(100.00));
			IUserService service = new UserServiceImpl();
			service.registerUser(user);
			String message = "注册成功，您可以登录了！";
			request.setAttribute("message",message);
			request.getRequestDispatcher("/index.jsp").forward(request,response);

		} catch (UserExistException e) {
			formbean.getErrors().put("userName", "用户名已存在");
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); 
			request.setAttribute("message", "注册失败，请稍后重试！");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		}
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
