package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberDTO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet(urlPatterns = {"/join", "/joinForm", "/idCheck"})
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
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
		
		// 회원가입 페이지 이동
		if(reqUri.equals(contextPath + "/joinForm")) {
			request.getRequestDispatcher("join.jsp").forward(request, response);
		}
		
		// 회원가입
		if(reqUri.equals(contextPath + "/join")) {
			String id = request.getParameter("id");
			if(memberDAO.idCheck(id) == true) {
				request.setAttribute("msg", "아이디가 중복됩니다.");
				request.getRequestDispatcher("joinAlert.jsp").forward(request, response);
			}
			else {
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				if (join(id, pwd, name) == 1) {
					request.setAttribute("msg", "회원가입 성공");
					request.getRequestDispatcher("joinAlert.jsp").forward(request, response);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public int join(String id, String pwd, String name) {
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPassword(pwd);
		member.setName(name);
		int result = memberDAO.join(member);
		
		return result;
	}
}
