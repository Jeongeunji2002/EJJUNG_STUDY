package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.exception.MemberException;
import member.model.dto.User;
import member.model.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식으로 전송보낸 요청을 받는 메소드임
		
		// request 매개변수 : 
		// 사용자 브라우저 뷰 페이지 input 으로 입력된 값 또는 쿼리스트링(?이름=전송값&이름=전송값&...)으로 전달된 값을
		// 담아서 서블릿으로 가지고 오는 객체
		// 전송방식이 get 이면 request head 에 전송정보와 전송값이 기록되어 전송됨 => 브라우저 url 상에 보여짐
		// 전송방식이 post 이면 request body 에 전송값이 인코딩되어서 기록되어 전송됨 => url 상에 안 보여짐
		// 서버측의 연결대상 정보도 함께 기록 저장됨
		
		// response 매개변수 : 
		// 서비스를 요청한 클라이언트 정보를 가지고 있다 (클라이언트 ip 주소 등)
		// 웹에서는 클라이언트와 서버 간의 (request, response) 가 쌍으로 요청과 응답을 위해서 왔다갔다한다
		
		// 로그인 처리용 컨트롤러 ---------------------------------------------------
		// 컨트롤러의 코드 작성 순서와 내용은 비슷함 => 웹의 흐름을 빨리 파악해야 함
		
		// 1. 전송은 값에 한글이 있다면 인코딩 처리함
		request.setCharacterEncoding("UTF-8"); // view 페이지의 문자셋과 맞춰줌
		
		// 2. 전송은 값 꺼내서, 변수 또는 DTO 객체에 저장 처리한다 : request.getParameter("전송보낸이름") : String 반환
		// String userId = request.getParameter("userid"); // view 의 input 의 name 속성의 이름으로 값을 꺼냄 (오타주의)
		// String userPwd = request.getParameter("userpwd");
		
		// System.out.println("------------login------------ \n userId : " + userId + "\nuserPwd : " + userPwd);
		
		// 객체에 저장한다면
		User user = new User();
		user.setUserId(request.getParameter("userid"));
		user.setUserPwd(request.getParameter("userpwd"));
		
		System.out.println("login : " + user);
				
		try {
			// 3. 모델측 서비스 클래스의 메소드를 실행하고 결과받기
			// 메소드 실행 시 값 또는 객체를 전달함
			User loginUser = new MemberService().selectLogin(user);
			
			// 결과값 확인
			System.out.println("loginUser : " + loginUser);
			
			// 4. 받은 결과를 가지고 성공 또는 실패 페이지 내보내기
			if(loginUser != null) { //성공시
				
			} else { //실패시
				// views/common/error.jsp 를 내보냄 + 오류 메세지(에러 이유)도 함께 전송 보냄
				// 내보낼 뷰 페이지와 같이 보낼 데이터가 있을 때는, RequestDispatcher 클래스를 사용함
				//  => 상대경로만 사용할 수 있음
				// 모든 컨트롤러(서블릿)의 실행 위치는 root (content directory : webapp) 에서 실행되고 있음
				
				// 내보낼 뷰 지정함 : 상대경로만 사용 가능함
				RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
				// 뷰와 함께 내보낼 데이터 처리 : request 객체에 저장함 => Map 구조임 (key, value)
				// setAttribute("key", value object); 사용함
				request.setAttribute("message", "로그인 실패, 아이디와 비밀번호를 다시 확인하세요.");
				
				// 로그인을 요청한 클라이언트로 내보냄
				view.forward(request, response);
			}
			
		} catch (MemberException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 전송보낸 요청을 받는 메소드
		doGet(request, response); // doGet() 메소드 쪽으로 전송은 정보를 넘김
	}

}
