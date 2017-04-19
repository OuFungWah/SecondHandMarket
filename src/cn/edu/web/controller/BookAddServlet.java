package cn.edu.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.service.IBookService;
import cn.edu.service.IUserService;
import cn.edu.service.impl.BookServiceImpl;
import cn.edu.service.impl.UserServiceImpl;
import cn.edu.vo.hibernate.Book;
import cn.edu.vo.hibernate.User;

/**
 * Servlet implementation class BookAddServlet
 */
@WebServlet("/bookadd.do")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//每个用户只能为自己添加书本
		User user = (User)request.getSession().getAttribute("user");
		String bookName = (String)request.getParameter("bookName");
		String category = (String)request.getParameter("category");
		String keyword = (String)request.getParameter("keyword");
		String description = (String)request.getParameter("description");
		String priceStr = (String)request.getParameter("price");
		Double priceDou = Double.parseDouble(priceStr);
		IBookService service = new BookServiceImpl();
		Book book = service.generateBook(user, bookName, keyword, category, description, priceDou);
		IUserService uservice = new UserServiceImpl();
		uservice.addBook(user, book);
		List<Book> bookList = new ArrayList<Book>(user.getBooks());
//		String userId = user.getId();
//		String bookName = (String)request.getParameter("bookName");
//		String category = (String)request.getParameter("category");
//		String keyword = (String)request.getParameter("keyword");
//		String description = (String)request.getParameter("description");
//		String priceStr = (String)request.getParameter("price");
//		Double priceDou = Double.parseDouble(priceStr);
//		IBookService service = new BookServiceImpl();
//		service.addBook(user, bookName, keyword, category, description, priceDou);
//		List<Book> bookList = service.getBookList(userId);
		request.getSession().setAttribute("userName", user.getUserName());
		request.getSession().setAttribute("bookList", bookList);
		request.getRequestDispatcher("/WEB-INF/pages/booklist.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
