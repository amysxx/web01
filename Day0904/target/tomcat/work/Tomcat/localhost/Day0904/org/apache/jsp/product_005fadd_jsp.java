/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-12 05:44:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\"  />\r\n");
      out.write("<script src=\"js/My97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("  $(function(){\r\n");
      out.write("\t  \r\n");
      out.write("\t  $.getJSON('CategoryServlet',{\"fun\":\"findall\"},function(data){\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  var str = \"\";\r\n");
      out.write("\t\t  for(var i=0;i<data.length;i++){\r\n");
      out.write("\t\t\t  str = str+\"<option value='\"+data[i].id+\"'>\"+data[i].categoryName+\"</option>\";\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  $('#cid').html($('#cid').html()+str);\r\n");
      out.write("\t  });\r\n");
      out.write("\t  \r\n");
      out.write("  })\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t <div class=\"formbody\">\r\n");
      out.write("      <div class=\"formtitle\"><span>商品信息</span></div>\r\n");
      out.write("\t\t<form action=\"ProductServlet\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t    <ul class=\"forminfo\">\r\n");
      out.write("\t    \t \r\n");
      out.write("\t    \t <!-- 商品分类信息 -->\r\n");
      out.write("\t    \t <li>\r\n");
      out.write("\t    \t \t<label>商品分类</label>\r\n");
      out.write("\t    \t \t<select name=\"cid\" class=\"dfinput\" id=\"cid\">\r\n");
      out.write("\t    \t \t\t<option value='0'>请选择</option>\r\n");
      out.write("\t    \t \t</select>\r\n");
      out.write("\t    \t </li>\r\n");
      out.write("\t    \t \r\n");
      out.write("\t    \t \r\n");
      out.write("\t\t    <li><label>商品名称</label><input name=\"pname\" type=\"text\" class=\"dfinput\" /><i>商品名称不能超过30个字符</i></li>\r\n");
      out.write("\t\t    <li><label>颜色</label><input name=\"color\" type=\"text\" class=\"dfinput\" /></li>\r\n");
      out.write("\t\t    <li><label>单价</label><input name=\"price\" type=\"text\" class=\"dfinput\" /></li>\r\n");
      out.write("\t\t    <li><label>简介</label>\r\n");
      out.write("\t\t    \t<textarea name=\"description\" cols=\"10\" rows=\"10\" class=\"textinput\" style=\"height: 80px\"></textarea>\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t    <li><label>商品展示图</label>\r\n");
      out.write("\t\t    \t<input name=\"pic\" type=\"file\"/><font style=\"color: red\"></font>\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t    <li><label>商品小类别</label>\r\n");
      out.write("\t\t\t    <cite>\r\n");
      out.write("\t\t\t\t    <input name=\"state\" type=\"radio\" value=\"0\" checked=\"checked\" />正常&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t    <input name=\"state\" type=\"radio\" value=\"1\" />热门产品\r\n");
      out.write("\t\t\t\t    <input name=\"state\" type=\"radio\" value=\"2\" />为你推荐\r\n");
      out.write("\t\t\t\t    <input name=\"state\" type=\"radio\" value=\"3\" />新品\r\n");
      out.write("\t\t\t\t    <input name=\"state\" type=\"radio\" value=\"4\" />小米明星单品\r\n");
      out.write("\t\t\t    </cite>\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t    <li><label>型号</label><input name=\"version\" type=\"text\" class=\"dfinput\" /></li>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    <li><label>生产日期</label>\r\n");
      out.write("\t\t    \t<input class=\"Wdate dfinput\"  style=\"width: 345px;height: 32px;line-height: 32px;\" onclick=\"WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})\" name=\"product_date\" type=\"text\" />\r\n");
      out.write("\t\t    </li>\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    <li><label>&nbsp;</label><input type=\"submit\"  value=\"确认保存\"/></li>\r\n");
      out.write("\t    </ul>\r\n");
      out.write("    </form>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}