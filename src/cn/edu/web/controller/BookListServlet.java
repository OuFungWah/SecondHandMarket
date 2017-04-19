package cn.edu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.service.IBookService;
import cn.edu.service.impl.BookServiceImpl;
import cn.edu.vo.hibernate.Book;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/booklist.do")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = (String)request.getParameter("userId");
		String userName = (String)request.getParameter("userName");
		IBookService service = new BookServiceImpl();
		List<Book> bookList = service.getBookList(userId);
		request.getSession().setAttribute("userName", userName);
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
