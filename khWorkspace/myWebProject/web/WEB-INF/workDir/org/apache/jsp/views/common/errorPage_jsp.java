/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.52
 * Generated at: 2018-06-05 07:58:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.java.member.model.vo.MemberVo;

public final class errorPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/common/header.jsp", Long.valueOf(1528183327000L));
    _jspx_dependants.put("/views/common/footer.jsp", Long.valueOf(1527851360000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.java.member.model.vo.MemberVo");
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

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");

	String msg = (String) request.getAttribute("msg");


      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>에러 페이지.</title>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("\t.outer{\n");
      out.write("\t\twidth: 600px;\n");
      out.write("\t\theight: 500px;\n");
      out.write("\t\tbackground:black;\n");
      out.write("\t\tcolor:white;\n");
      out.write("\t\tmargin-left:auto;\n");
      out.write("\t\tmargin-right:auto;\n");
      out.write("\t\tpadding:20px;\n");
      out.write("\t\tborder: 1px solid white;\n");
      out.write("\t}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\n");

	MemberVo member = (MemberVo)session.getAttribute("user");


      out.write("\n");
      out.write("\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("\n");
      out.write("\tbody{\n");
      out.write("\t\tbackground:url(\"/mwp/images/background.jpg\") no-repeat;\n");
      out.write("\t\tbackground-size:cover;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.wrap{\n");
      out.write("\t\tbackground:black;\n");
      out.write("\t\twidth:100%;\n");
      out.write("\t\theight:50px;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.menu{\n");
      out.write("\t\tbackground:black;\n");
      out.write("\t\tcolor:white;\n");
      out.write("\t\twidth:150px;\n");
      out.write("\t\theight:50px;\n");
      out.write("\t\tvertical-align:middle;\n");
      out.write("\t\ttext-align:center;\n");
      out.write("\t\tdisplay:table-cell;\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.nav{\n");
      out.write("\t\twidth:600px;\n");
      out.write("\t\tmagin-left:auto;\n");
      out.write("\t\tmargin-right:auto;\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.menu:hover{\n");
      out.write("\t\n");
      out.write("\t\tbackground:lightgray;\n");
      out.write("\t\tcolor:orangered;\n");
      out.write("\t\tfont-weight:bold;\n");
      out.write("\t\tcursor:pointer;\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.loginArea > #loginForm, .userInfo{\n");
      out.write("\t\tfloat:right;\n");
      out.write("\t\t\n");
      out.write("\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t#memberLoginBtn, #memberJoinBtn, #memberInfoBtn, #memberLogoutBtn {\n");
      out.write("\t\n");
      out.write("\t\tdisplay:inline-block;\n");
      out.write("\t\tvertical-align:middle;\n");
      out.write("\t\ttext-align:center;\n");
      out.write("\t\tcursor:pointer;\n");
      out.write("\t\twidth:150px;\n");
      out.write("\t\theight:30px;\n");
      out.write("\t\tborder-radius:5px;\n");
      out.write("\t\tbackground:orangered;\n");
      out.write("\t\tcolor:white;\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.tile{\n");
      out.write("\t\n");
      out.write("\t\twidth:150px;\n");
      out.write("\t\theight:150px;\n");
      out.write("\t\tbackground:black;\n");
      out.write("\t\tdisplay:inline-block;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.first-line{\n");
      out.write("\t\tmargin-up:10%;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t.tile-menu:hover{\n");
      out.write("\t\n");
      out.write("\t\tbackground:skyblue;\n");
      out.write("\t\tcursor:pointer;\n");
      out.write("\t\tcolor:white;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.notile{\n");
      out.write("\t\tvisibility:hidden;\n");
      out.write("\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.tile1{\n");
      out.write("\t\tbackground:darkgray;\n");
      out.write("\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.footer{\n");
      out.write("\t\n");
      out.write("\t\tposition:fixed;\n");
      out.write("\t\tleft:0;\n");
      out.write("\t\tbottom:0;\n");
      out.write("\t\tbackground:brown;\n");
      out.write("\t\tcolor:white;\n");
      out.write("\t\ttext-align:center;\n");
      out.write("\t\twidth:100%;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\t<script\n");
      out.write("\t  src=\"https://code.jquery.com/jquery-3.3.1.js\"\n");
      out.write("\t  integrity=\"sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=\"\n");
      out.write("\t  crossorigin=\"anonymous\"></script>\n");
      out.write("\t  \n");
      out.write("\t<script>\n");
      out.write("\t\tfunction login(){\n");
      out.write("\t\t\t$(\"#loginForm\").submit();\n");
      out.write("\t\t\t\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\tfunction logout(){\n");
      out.write("\t\t\tlocation.href = \"/mwp/logout.do\";\n");
      out.write("\t\t\t\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\tfunction join(){\n");
      out.write("\t\t\tlocation.href = \"/mwp/views/member/memberJoin.jsp\"\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\tfunction mainPage(){\n");
      out.write("\t\t\t//request.getContextPath() : /mwp\n");
      out.write("\t\t\t//location.href = \"/mwp/index.jsp\";\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t/*\n");
      out.write("\t\t\trequest.getContextPath() : 프로젝트의 context path 반환.\n");
      out.write("\n");
      out.write("\t\t\t/example\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\trequest.getRequestURI() : 웹 전체 경로 반환.\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t/example/index.jsp\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\trequest.getHeader(\"REFERER\") : 요청을 한 부모요청의 URL 반환.\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t현재 페이지 : localhost:8080/example/test1.do\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t요청 페이지 : localhost:8080/example/test.do\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tlocalhost:8080/example/test.do 반환.\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\trequest.getRealPath(\"/\") : 서버 또는 로컬의 웹앱 서버의 docBase 설정값 반환.\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t요청  : localhost:8080/example/test.jsp\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t반환 : D:/Project/webapps/example\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t*/\n");
      out.write("\t\t\tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/index.jsp\";\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\tfunction myInfo(){\n");
      out.write("\t\t\tlocation.href = \"/mwp/views/member/memberUpdate.jsp\"\n");
      out.write("\t\t\t\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("  \n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<h1 align = \"center\">My Web Project</h1>\n");
      out.write("\t<div class = \"loginArea\">\n");
      out.write("\t\n");
      out.write("\t");
if(member == null) {
      out.write("\n");
      out.write("\t\n");
      out.write("\t\t<form id = \"loginForm\" action = \"/mwp/login.do\" method = \"post\">\n");
      out.write("\t\t\t<table>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>id :</td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t<input type = \"text\" name = \"userId\">\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>password :</td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t<input type = \"password\" name = \"userPwd\">\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td colspan = \"2\">\n");
      out.write("\t\t\t\t\t\t<div id = \"memberLoginBtn\" onclick = \"login()\">sign in</div>\n");
      out.write("\t\t\t\t\t\t<div id = \"memberJoinBtn\" onclick = \"join()\">sign up</div>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\n");
      out.write("\t\t</form>\n");
      out.write("\t\t\n");
      out.write("\t\t");
} else{
      out.write("\n");
      out.write("\t\t\t<div class=\"userInfo\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<p>");
      out.print( member.getUserName() );
      out.write("님 방문을 환영합니다.</p>\n");
      out.write("\t\t\t\t<div id=\"memberInfoBtn\" onclick=\"myInfo();\">정보 수정.</div>\n");
      out.write("\t\t\t\t<div id=\"memberLogoutBtn\" onclick=\"logout();\">로그 아웃.</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t");
} 
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("\t<br>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\t<div class=\"outer\">\n");
      out.write("\t\t<h1>서비스 에러 발생!!!</h1>\n");
      out.write("\t\t<h3>ERROR : ");
      out.print( msg );
      out.write("</h3>\n");
      out.write("\t\t<h4>해당 사항 관련 문의는 010-1234-5678 로 연락 바랍니다.</h4>\n");
      out.write("\t\t<!-- <a href=\"/mwp/index.jsp\">메인 페이지로 이동.</a> -->\n");
      out.write("\t</div>\n");
      out.write("\t");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<br> <br> <br> <br> <br> <br> <br>\n");
      out.write("\n");
      out.write("\t<div class = \"footer\">\n");
      out.write("\t\t<p>@copyright 2018</p>\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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