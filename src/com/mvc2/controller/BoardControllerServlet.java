package com.mvc2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc2.board.dao.LsjBoardDao;
import com.mvc2.board.dao.LsjBoardDaoImpl;
import com.mvc2.board.vo.LsjBoardVO;
import com.mvc2.common.utils.FilePath;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/*Servlet implementation class join*/

@WebServlet("/board")
public class BoardControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// reset
		String chkInLno = req.getParameter("chkInLno");
		String downloadPath = FilePath.DOWNLOAD_FILEPATH;
		String uploadPath = FilePath.UPLOAD_FILEPATH;
		int size = 100*1024*1024;
		String isud = "";
		String lno = "";
		String lsubject = "";
		String lname = "";
		String lpw = "";
		String lmemo = "";
		String limage = "";
		String lfilename = "";
		String ldeleteyn = "";
		String linsertdate = "";
		String lupdatedate = "";

		// instance
		LsjBoardDao ldao = new LsjBoardDaoImpl();
		LsjBoardVO lbvo = new LsjBoardVO();
		
		// multipart 아닐 때
		if(!req.getContentType().toLowerCase().startsWith("multipart/form-data")){
			
			// isud type 받기
			isud = req.getParameter("ISUD_TYPE");
			
			// validation
			
			lno = req.getParameter("lno");
			lsubject = req.getParameter("lsubject");
			lname = req.getParameter("lname");
			lpw = req.getParameter("lpw");
			lmemo = req.getParameter("lmemo");
			ldeleteyn = req.getParameter("ldeleteyn");
			linsertdate = req.getParameter("linsertdate");
			lupdatedate = req.getParameter("lupdatedate");
			
			// selectAll
			if("BSA".equals(isud.toUpperCase())){
				System.out.println("(log) servlet selectAll >>> ");
				
				ArrayList<LsjBoardVO> aList = ldao.selectAllLsjBoard();
				System.out.println("(log) aList.size() >>> " + aList.size());
				System.out.println("(log) data >>> " + aList.toString());
				
				// setAttribute key,value
				req.setAttribute("aList", aList);
				RequestDispatcher rd = req.getRequestDispatcher("/board/boardLsjSelectAll.jsp");
				rd.forward(req, resp);
				
				System.out.println("(log) servlet selectAll <<< ");
			}
			
			// update
			if("BU".equals(isud.toUpperCase())){
				System.out.println("(log) servlet update >>> ");
				
				lbvo.setLno(chkInLno);
				lbvo.setLsubject(lsubject);
				lbvo.setLname(lname);
				lbvo.setLpw(lpw);
				lbvo.setLname(lname);
				lbvo.setLdeleteyn(ldeleteyn);
				lbvo.setLinsertdate(linsertdate);
				lbvo.setLupdatedate(lupdatedate);
				lbvo.setLimage(downloadPath);
				
				System.out.println("chkInLno >>> " + chkInLno);
				
				ArrayList<LsjBoardVO> aList = ldao.selectLsjBoard(lbvo);
				
				if(aList.size()>=1) {
					req.setAttribute("aList", aList);
					RequestDispatcher rd = req.getRequestDispatcher("/board/boardLsjUpdate.jsp");
					rd.forward(req, resp);
				}else{
					System.out.println("	Error >>> ");
				}
				
				System.out.println("(log) servlet update <<< ");
			}
			
			// delete
			if("BD".equals(isud.toUpperCase())){
				System.out.println("(log) servlet delete >>> ");
				
				lbvo.setLno(chkInLno);
				System.out.println("(log) chkInLno >>> " + chkInLno);
				
				int lCnt = ldao.deleteLsjBoard(lbvo);
				
				if(lCnt>=1){
					System.out.println("	삭제완료");
					
					req.setAttribute("lCnt", lCnt);
					RequestDispatcher rd = req.getRequestDispatcher("/board/boardLsjSelectAll.jsp");
					rd.forward(req, resp);
				}else{
					System.out.println("삭제 실패 ");
					out.println("<script>alert('실패'); history.go(-1); </script>");
				}
				
				System.out.println("(log) servlet delete <<< ");
			}
			
			if("BW".equals(isud.toUpperCase())){
				System.out.println("(log) servlet update form >>>");
				System.out.println("(log) servlet update form <<<");
			}
			
		}else if(req.getContentType().toLowerCase().startsWith("multipart/form-data")){
			try{
				//내장형 object Request 함수
				MultipartRequest mt = new MultipartRequest(req,uploadPath,size,"UTF-8",new DefaultFileRenamePolicy());
				
				isud = mt.getParameter("ISUD_TYPE");
				lno = mt.getParameter("lno");
				lpw = mt.getParameter("lpw");
				lname = mt.getParameter("lname");
				limage = mt.getParameter("limage");
				lfilename = mt.getFilesystemName(limage);
				ldeleteyn = mt.getParameter("ldeleteyn");
				linsertdate = mt.getParameter("linsertdate");
				lupdatedate = mt.getParameter("lupdatedate");
		
				System.out.println(">><<<" + uploadPath);
				System.out.println(">>>>"+limage);
				System.out.println(">>>>"+lfilename);
				if(isud!=null){
					
					// insert
					if("BI".equals(isud.toUpperCase())){
						System.out.println("(log) servlet isnert >>> ");
						
						// 초기화 후 담기
						lbvo.setLsubject(lsubject);
						lbvo.setLname(lname);
						lbvo.setLpw(lpw);
						lbvo.setLmemo(lmemo);
						lbvo.setLimage(lfilename);
						
						// int 변수에 담아주기
						int lCnt = ldao.insertLsjBoard(lbvo);
						System.out.println("lCnt >>> " + lCnt);
						
						if(lCnt>=1){
							System.out.println("	글등록 완료");
							req.setAttribute("lCnt", lCnt);
							RequestDispatcher rd = req.getRequestDispatcher("/board/boardLsjInsert.jsp");
							rd.forward(req, resp);
						}else {
							System.out.println("	글등록 실패");
							RequestDispatcher rd = req.getRequestDispatcher("index.html");
							rd.forward(req, resp);
						}
						System.out.println("(log) servlet isnert <<< ");
					}
					
					// updateOk
					if("BUOK".equals(isud.toUpperCase())){
						System.out.println("(log) servlet updateOk >>> ");
				
						lbvo.setLno(lno);
						lbvo.setLsubject(lsubject);
						lbvo.setLname(lname);
						lbvo.setLpw(lpw);
						lbvo.setLmemo(lmemo);
						lbvo.setLimage(uploadPath);
						
						System.out.println("(log) lno >>> " + lno);
						
						int lCnt = ldao.updateLsjBoard(lbvo);
						
						if(lCnt>=1){
							System.out.println("lno >> " + lno);
							System.out.println("	수정 완료");
							
							ArrayList<LsjBoardVO> aList = ldao.selectLsjBoard(lbvo);
							req.setAttribute("aList", aList);
							
							RequestDispatcher rd = req.getRequestDispatcher("/board/boardLsjSelect.jsp");
							rd.forward(req, resp);
						}else {
							System.out.println("	수정 실패");
							out.println("<script>alert('수정 실패'); history.go(-1); </script>");
						}
						
						System.out.println("(log) servlet updateOk <<< ");
					}
				}else{
					out.println("ISUD Check >>>");
					System.out.println("ISUD Check >>> ");
				}
			}catch(Exception e){
				System.out.println("	Error >>> " + e.getMessage());
			}
			
		}
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

		
}
