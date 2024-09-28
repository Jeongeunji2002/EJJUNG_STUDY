/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-09-10 05:59:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.dto.User;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("member.model.dto.User");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	//로그인 상태를 확인하기 위해서 세션 객체에 저장된 로그인한 회원의 정보를 추출
	User loginUser = (User)session.getAttribute("loginUser");

      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>first</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("div.lineA {\r\n");
      out.write("	height: 100px;\r\n");
      out.write("	border: 1px solid gray;\r\n");
      out.write("	float: left;\r\n");
      out.write("	position: relative;\r\n");
      out.write("	left: 120px;\r\n");
      out.write("	margin: 5px;\r\n");
      out.write("	padding: 5px;\r\n");
      out.write("}\r\n");
      out.write("div#banner {\r\n");
      out.write("	width: 500px;\r\n");
      out.write("	padding: 0;\r\n");
      out.write("}\r\n");
      out.write("div#banner img {\r\n");
      out.write("	width: 450px;\r\n");
      out.write("	height: 80px;\r\n");
      out.write("	padding: 0;\r\n");
      out.write("	margin-top: 10px;\r\n");
      out.write("	margin-left: 25px;\r\n");
      out.write("}\r\n");
      out.write("div#loginBox {\r\n");
      out.write("	width: 280px;\r\n");
      out.write("	font-size: 10pt;\r\n");
      out.write("	text-align: left;\r\n");
      out.write("	padding-left: 20px;\r\n");
      out.write("}\r\n");
      out.write("div#loginBox button {\r\n");
      out.write("	width: 250px;\r\n");
      out.write("	height: 35px;\r\n");
      out.write("	background-color: navy;\r\n");
      out.write("	color: white;\r\n");
      out.write("	margin-top: 10px;\r\n");
      out.write("	margin-bottom: 15px;\r\n");
      out.write("	font-size: 14pt;\r\n");
      out.write("	font-weight: bold;\r\n");
      out.write("	cursor: pointer;  /* 손가락모양 : 클릭 가능한 버튼으로 표시함 */\r\n");
      out.write("}\r\n");
      out.write("div#loginBox a {\r\n");
      out.write("	text-decoration: none;\r\n");
      out.write("	color: navy;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function movePage(){\r\n");
      out.write("	//자바스크립트로 페이지 연결 또는 서블릿 컨트롤러 연결 요청시에는\r\n");
      out.write("	//location 객체의 href 속성을 사용함 => 상대경로, 절대경로 둘 다 사용 가능함\r\n");
      out.write("	location.href = \"/first/views/member/loginPage.html\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>firstServletProject : first</h1>\r\n");
      out.write("<hr>\r\n");
      out.write("<header>\r\n");
      out.write("	<div id=\"banner\" class=\"lineA\">\r\n");
      out.write("		<img src=\"/first/resources/images/photo2.jpg\">\r\n");
      out.write("	</div>\r\n");
      out.write("	");
 if(loginUser == null){  //로그인 하지 않은 상태일 때 
      out.write("\r\n");
      out.write("		<div id=\"loginBox\" class=\"lineA\">\r\n");
      out.write("			first 사이트 방문을 환영합니다.<br>\r\n");
      out.write("			<button onclick=\"movePage();\">first 로그인</button> <br>\r\n");
      out.write("			");
      out.write("\r\n");
      out.write("			<a href=\"/first/views/member/enrollPage.html\">회원가입</a>\r\n");
      out.write("			");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	");
 }else{  //로그인 했을 때 
      out.write("\r\n");
      out.write("		<div id=\"loginBox\" class=\"lineA\">\r\n");
      out.write("			");
      out.print( loginUser.getUserName() );
      out.write(" 님 &nbsp; \r\n");
      out.write("			<a href=\"/first/logout\">로그아웃</a> <br>\r\n");
      out.write("			메일 0, 쪽지 0\r\n");
      out.write("		</div>\r\n");
      out.write("	");
 } 
      out.write("\r\n");
      out.write("	\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
