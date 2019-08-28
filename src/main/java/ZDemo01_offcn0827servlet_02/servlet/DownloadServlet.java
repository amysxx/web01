package ZDemo01_offcn0827servlet_02.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownloadServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   this.doPost(request, response);
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filename =request.getParameter("filename");
		
		String folderPath = this.getServletContext().getRealPath("/download");
		
		InputStream is = new FileInputStream(folderPath+"/"+filename);
		
		filename = new String(filename.getBytes("UTF-8"),"iso-8859-1");
		
		response.addHeader("Content-Disposition","attachment;filename="+filename);
		
		OutputStream os = response.getOutputStream();
		
		int len=0;
		byte[] b = new byte[1024];
		
		while((len=is.read(b))!=-1){
			os.write(b,0, len);
		}
		
		is.close();
		os.close();
	}
}
