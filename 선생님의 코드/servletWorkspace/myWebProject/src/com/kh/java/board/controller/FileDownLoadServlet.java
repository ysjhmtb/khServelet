package com.kh.java.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileDownload.do")
public class FileDownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileDownLoadServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String fileName = request.getParameter("filename");
		
		String path = request.getServletContext().getRealPath("/upload");
		
		ServletOutputStream dos = response.getOutputStream();
		response.addHeader("Content-Disposition",
				"attachment; filename=\""+new String(fileName.getBytes("utf-8"), "ISO-8859-1")+"\"");
		
		File downFile = new File(path + "/" + fileName);
		response.setContentLength((int)downFile.length());
		
		BufferedInputStream bis = 
					new BufferedInputStream(new FileInputStream(downFile));
		int readData = 0;
		while((readData = bis.read()) != -1){
			dos.write(readData);
		}
		dos.close();
		bis.close();
	}
}














