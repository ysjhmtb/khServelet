package com.kh.java.gallery.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.java.board.model.vo.BoardVo;
import com.kh.java.common.MyRenamePolicy;
import com.kh.java.gallery.model.service.GalleryService;
import com.kh.java.gallery.model.vo.AttachmentVo;
import com.kh.java.member.model.vo.MemberVo;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/writeGallery.do")
public class WriteGalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteGalleryServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//파일 업로드/다운로드 -> cos.jar 
		//1. 파일 사이즈 설정
		int maxSize = 1024 * 1024 * 10;
		//2. 파일 전송 시 enctype 정상적으로 설정 되었는지 확인
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)){
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "전송 데이터의 타입을 확인하십시오!!");
			view.forward(request, response);
		}
		//3. 파일 저장 경로 설정
		String root = request.getServletContext().getRealPath("/");
		String path = root + "upload_gallery/";
		
		//4. request -> multipartrequest
		//filerenamePolicy -> FileRenamePolicy 상속 -> rename() override
		MultipartRequest mRequest = new MultipartRequest(request,
															path, maxSize, "UTF-8", new MyRenamePolicy());
		//전송 값을 변수에 저장
		//객체 2개 -> 게시판에 추가할 객체, attachment 추가할 객체(list)
		String title = mRequest.getParameter("title");
		String content = mRequest.getParameter("content");
		String userId 
				= ((MemberVo)(request.getSession().getAttribute("user"))).getUserId();
		System.out.println(userId);
		BoardVo b = new BoardVo(title, content, userId);
		b.setAttachFile("");
		
		//파일 정보 객체 변환
		ArrayList<String> oldNames = new ArrayList<String>();
		ArrayList<String> newNames = new ArrayList<String>();
		Enumeration<String> fileNameEnum = mRequest.getFileNames();
		
//		while(fileNameEnum.hasMoreElements()){
//			String fileName = fileNameEnum.nextElement();
//			System.out.println(fileName);
//			//현재 저장된 파일 이름, 기존 client의 파일 이름 리스트에 저장
//			newNames.add(mRequest.getFilesystemName(fileName));
//			oldNames.add(mRequest.getOriginalFileName(fileName));
//		};
		
		for(int i = 0 ; fileNameEnum.hasMoreElements() ; i++){
			fileNameEnum.nextElement();
			newNames.add(mRequest.getFilesystemName("galleryImage" + (i + 1)));
			oldNames.add(mRequest.getOriginalFileName("galleryImage" + (i + 1)));
		}
		
		//attachMent 객체를 담은 list
		ArrayList<AttachmentVo> list = new ArrayList<AttachmentVo>();
		AttachmentVo temp = null;
		for(int i = 0; i < newNames.size() ; i++){
			temp = new AttachmentVo();
			temp.setChangeName(newNames.get(i));
			temp.setOriginName(oldNames.get(i));
			temp.setPath(path);
			
			list.add(temp);
		}
		
		int result = new GalleryService().insertAttach(b, list);
		
		String url = "";
		if(0 < result){
			response.sendRedirect("/mwp/galleryList.do");
		}else{
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사진 게시글 작성 실패!!");
			view = request.getRequestDispatcher(url);
			view.forward(request, response);
		}
	}
}







