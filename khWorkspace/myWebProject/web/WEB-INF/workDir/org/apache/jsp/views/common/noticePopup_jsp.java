/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.52
 * Generated at: 2018-07-13 10:31:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.java.notice.model.vo.NoticeVo;

public final class noticePopup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.java.notice.model.vo.NoticeVo");
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

      out.write('\n');
      out.write('\n');

	NoticeVo notice = (NoticeVo)request.getAttribute("notice");

      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>공지사항 팝업!!</title>\n");
      out.write("<script type=\"text/javascript\" src=\"/mwp/js/jquery-3.3.1.min.js\"></script>\n");
      out.write("<style>\n");
      out.write(".outer{\n");
      out.write("\twidth:300px;\n");
      out.write("\theight:600px;\n");
      out.write("\tbackground:black;\n");
      out.write("\tcolor:white;\n");
      out.write("\tmargin-left:auto;\n");
      out.write("\tmargin-right:auto;\n");
      out.write("\tborder:1px solid white;\n");
      out.write("}\n");
      out.write(".tableArea{\n");
      out.write("\twidth:300px;\n");
      out.write("\theight:400px;\n");
      out.write("\tmargin:auto;\n");
      out.write("\tborder:1px solid white;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<script>\n");
      out.write("\t$(function(){\n");
      out.write("\t\t$(\"#closeBtn\").click(function(){\n");
      out.write("\t\t\tif($(\"#dayCheck\").prop(\"checked\")){\n");
      out.write("\t\t\t\tlocalStorage.setItem(\"dayCheck\",new Date());\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tclose();\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"outer\">\n");
      out.write("\t<h2 align=\"center\">최근 공지사항</h2>\n");
      out.write("\t<div class=\"tableArea\">\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th width=\"50\">제 목 : </th>\n");
      out.write("\t\t\t\t<!--<td>");
      out.print(notice.getTitle() );
      out.write("</td>-->\n");
      out.write("\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th>내용</th>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${notice.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t</div>\n");
      out.write("\t<input type=\"checkbox\" id=\"dayCheck\"/> 오늘 하루 동안 열지 않기\n");
      out.write("\t<button id=\"closeBtn\">닫기</button>\t\t\n");
      out.write("</div>\t\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
