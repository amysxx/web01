package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author amy
 * @date 2019/8/28 18:03
 */
@WebServlet("/downloadServlet")
public class downServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //从超链获取取filename的值,通过请求域对象来获取
        String filename = request.getParameter ("filename");
        String agent = request.getHeader ("User-Agent");

        System.out.println ("下载文件名:"+filename );
        //获取需要下载到文件的路径
        String folderPath = this.getServletContext ().getRealPath ("/download");
        System.out.println ("获取其文件下载的路径:"+folderPath );

        //使用文件输入流fileinputstream构造文件全路径
        InputStream is = new FileInputStream (folderPath+"/"+filename);

        /*
         //文件下载中文件名乱码问题
                1.firefox解决乱码问题  需要设置编码形式为iso-8859-1,因为下载源来自于tomcat,
                tomcat的内置编码为iso-8859-1;
                new String(filename.getBytes(),"iso-8859-1");
                2.IE url编码方式解决
                URLEncoder.encode(filename,"iso-8859-1");
         */
        //filename = new String(filename.getBytes (),"UTF-8");
        if(agent.contains ("Firefox")) {
            filename = new String(filename.getBytes(),"iso-8859-1");
        }else{
            filename = URLEncoder.encode(filename,"UTF-8");
        }
        //为响应头设置编码方式

        response.setHeader ("Content-Disposition","attachment;filename="+filename);
        //获得响应体的输出流 有两种,一种是字节流ServletOutputStream 一种是字符流PrintWriter
        /*
        需要从流中读取文件,直接获取响应的输出流
         */
        OutputStream os = response.getOutputStream ();

        int len = -1;
        byte[] buff = new byte[1024];
        while((len=is.read (buff))!=-1){
            os.write (buff,0,len);
        }

        os.close ();
        is.close ();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost (request,response);
    }
}
