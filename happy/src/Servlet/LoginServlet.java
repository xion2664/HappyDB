package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login", "/loginForm"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberDAO memberDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        memberDAO = MemberDAO.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String contextPath = request.getContextPath();
		String reqUri = request.getRequestURI();
		
		// 로그인 페이지 이동
		if(reqUri.equals(contextPath + "/loginForm")) {
			response.sendRedirect("login.jsp");
		}
			
		// 로그인
		if(reqUri.equals(contextPath + "/login")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			int check = Check(id, pwd);
			if(check == 1) {
				request.setAttribute("userId", id);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}
			else if(check == 0) {
				request.setAttribute("msg", "비밀번호가 틀립니다.");
				request.getRequestDispatcher("loginAlert.jsp").forward(request, response);
			}
			else if(check == -1){
				request.setAttribute("msg", "존재하지않는 아이디입니다. 회원가입하시겠습니까?");
				request.getRequestDispatcher("loginAlert.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public int Check(String id, String pwd) { 
		int result = memberDAO.login(id, pwd);
		return result;
	}
}
