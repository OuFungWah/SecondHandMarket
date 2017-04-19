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
import cn.edu.vo.hibernate.User;

/**
 * Servlet implementation class BookDelServlet
 */
@WebServlet("/bookdel.do")
public class BookDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = (String)request.getParameter("bookId");
		IBookService service = new BookServiceImpl();
		service.deleteBook(bookId);
		User user = (User)request.getSession().getAttribute("user");
		String userId = user.getId();
		List<Book> bookList = service.getBookList(userId);
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
