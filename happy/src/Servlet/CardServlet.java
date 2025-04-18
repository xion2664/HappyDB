package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CardDAO;
import DTO.CardDTO;

/**
 * Servlet implementation class CardServlet
 */
@WebServlet(urlPatterns = {"/cardForm", "/insertCard", "/userCard", "/delete", "/updateForm", "/updateCard", "/searchCard", "/sort"})
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CardDAO cardDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardServlet() {
        super();
        cardDAO = CardDAO.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); 
		
		String contextPath = request.getContextPath();
		String reqUri = request.getRequestURI();
		HttpSession session = request.getSession();
		
		String userId = (String)session.getAttribute("userId");
		request.setAttribute("userId", userId);
		List<CardDTO> userCard = null;
		
		// 명함 추가 페이지 이동
		if(reqUri.equals(contextPath + "/cardForm")) {
			request.getRequestDispatcher("insertCard.jsp").forward(request, response);
		}
		
		// 명함 추가
		if(reqUri.equals(contextPath + "/insertCard")) {
			CardDTO bean = new CardDTO();
			bean.setName((String)request.getParameter("name"));
			bean.setMobile((String)request.getParameter("mobile"));
			bean.setTel((String)request.getParameter("tel"));
			bean.setAddress((String)request.getParameter("address"));
			bean.setEmail((String)request.getParameter("email"));
			bean.setCompany((String)request.getParameter("company"));
			bean.setStaff((String)request.getParameter("staff"));
			bean.setUserId(userId);
			if(cardDAO.insertCard(bean) == 1) {
				userCard = cardDAO.getCardList(userId);
				request.setAttribute("userCard", userCard);
				request.getRequestDispatcher("userCard.jsp").forward(request, response);
			}
			else
			{
				System.out.println("error");
			}
		}
		
		// 명함 리스트 페이지
		if(reqUri.equals(contextPath + "/userCard")) {
			userCard = cardDAO.getCardList(userId);
			request.setAttribute("userCard", userCard);
			request.getRequestDispatcher("userCard.jsp").forward(request, response);
		}
		
		// 명함 삭제
		if(reqUri.equals(contextPath + "/delete")) {
			int num = Integer.parseInt(request.getParameter("num"));
			
			if(cardDAO.deleteCard(userId, num) == 1) {
				userCard = cardDAO.getCardList(userId);
				request.setAttribute("userCard", userCard);
				request.getRequestDispatcher("userCard.jsp").forward(request, response);
			}
			else {
				System.out.println("error");
			}
		}
		
		// 명함 수정 페이지 이동
		if(reqUri.equals(contextPath + "/updateForm")) {
			int num = Integer.parseInt(request.getParameter("num"));
			CardDTO upCard = cardDAO.getCard(userId, num);
			request.setAttribute("upCard", upCard);
			request.setAttribute("key", num);
			request.getRequestDispatcher("updateCard.jsp").forward(request, response);
		}
		
		// 명함 수정
		if(reqUri.equals(contextPath + "/updateCard")) {
			int num = ((Integer)session.getAttribute("key")).intValue();
			CardDTO bean = new CardDTO();
			bean.setName((String)request.getParameter("name"));
			bean.setMobile((String)request.getParameter("mobile"));
			bean.setTel((String)request.getParameter("tel"));
			bean.setAddress((String)request.getParameter("address"));
			bean.setEmail((String)request.getParameter("email"));
			bean.setCompany((String)request.getParameter("company"));
			bean.setStaff((String)request.getParameter("staff"));
			bean.setUserId(userId);
			bean.setId(num);
			cardDAO.updateCard(bean, bean.getId());
			
			userCard = cardDAO.getCardList(userId);
			request.setAttribute("userCard", userCard);
			request.getRequestDispatcher("userCard.jsp").forward(request, response);
		}
		
		// 명함 검색
		if(reqUri.equals(contextPath + "/searchCard")) {
			String cri = (String)request.getParameter("cri");
			String key = (String)request.getParameter("key");
			
			userCard = cardDAO.searchCardList(userId, key, cri);
			
			if(!userCard.isEmpty()) {
				request.setAttribute("userCard", userCard);
				request.getRequestDispatcher("userCard.jsp").forward(request, response);
			}
			else { // 명함 검색 값이 없을 때
				request.setAttribute("msg", "해당하는 명함이 없습니다.");
				request.setAttribute("userCard", userCard);
				request.getRequestDispatcher("userCard.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
