package com.kh.java.board.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/fileDownload.do")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String fileName = request.getParameter("filename");
		
//		String path = request.getServletContext().getRealPath("/upload");
		String path = "/Users/yunseokjeon/git/khServlet/khWorkspace/myWebProject/web/upload";
		
		ServletOutputStream dos = response.getOutputStream();
		response.addHeader("Content-Disposition",
				"attachment; filename=\""+new String(fileName.getBytes("utf-8"), "utf-8")+"\"");
		
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
