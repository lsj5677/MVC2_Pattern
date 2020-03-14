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

import com.mvc2.common.utils.FilePath;
import com.mvc2.member.dao.LsjMemberDao;
import com.mvc2.member.dao.LsjMemberDaoImpl;
import com.mvc2.member.vo.LsjMemberVO;
import com.mvc2.session.LsjSession;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/*Servlet implementation class join*/

@WebServlet("/member")
public class MemberControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// reset
		String chkInLmem = req.getParameter("chkInLmem");
		String downloadPath = FilePath.DOWNLOAD_FILEPATH;
		String uploadPath = FilePath.UPLOAD_FILEPATH;
		int size = 100*1024*1024;
		String isud = "";
		String lmem = "";
		String lid = "";
		String lpw = "";
		String lname = "";
		String lgender = "";
		String lbirth = "";
		String lemail ="";
		String lhp = "";
		String lpostno = "";
		String laddr = "";
		String laddr1 = "";
		String limage = "";
		String lfilename = "";
		String ldeleteyn = "";
		String linsertdate = "";
		String lupdatedate = "";

		// instance
		LsjMemberDao ldao = new LsjMemberDaoImpl();
		LsjMemberVO lvo = new LsjMemberVO();
		
		// multipart 아닐 때
		if(!req.getContentType().toLowerCase().startsWith("multipart/form-data")){
			
			// isud type 받기
			isud = req.getParameter("ISUD_TYPE");
			
			// validation
			
			lmem = req.getParameter("lmem");
			lid = req.getParameter("lid");
			lpw = req.getParameter("lpw");
			lname = req.getParameter("lname");
			lgender = req.getParameter("lgender");
			lbirth = req.getParameter("lbirth");
			lemail = req.getParameter("lemail");
			lhp = req.getParameter("lhp");
			lpostno = req.getParameter("lpostno");
			laddr = req.getParameter("laddr") + "" + req.getParameter("laddr1");
			limage = req.getParameter("limage");
			ldeleteyn = req.getParameter("ldeleteyn");
			linsertdate = req.getParameter("linsertdate");
			lupdatedate = req.getParameter("lupdatedate");
			
			// selectAll
			if("SA".equals(isud.toUpperCase())){
				System.out.println("(log) servlet selectAll >>> ");
				
				ArrayList<LsjMemberVO> aList = ldao.selectLsjMem();
				System.out.println("(log) aList.size() >>> " + aList.size());
				System.out.println("(log) data >>> " + aList.toString());
				
				// setAttribute key,value
				req.setAttribute("aList", aList);
				RequestDispatcher rd = req.getRequestDispatcher("/member/memberLsjSelectAll.jsp");
				rd.forward(req, resp);
				
				System.out.println("(log) servlet selectAll <<< ");
			}
			
			// update
			if("U".equals(isud.toUpperCase())){
				System.out.println("(log) servlet update >>> ");
				
				lvo.setLmem(chkInLmem);
				lvo.setLid(lid);
				lvo.setLpw(lpw);
				lvo.setLname(lname);
				lvo.setLgender(lgender);
				lvo.setLbirth(lbirth);
				lvo.setLemail(lemail);
				lvo.setLhp(lhp);
				lvo.setLpostno(lpostno);
				lvo.setLaddr(laddr);
				lvo.setLaddr1(laddr1);
				lvo.setLdeleteyn(ldeleteyn);
				lvo.setLinsertdate(linsertdate);
				lvo.setLupdatedate(lupdatedate);
				lvo.setLimage(downloadPath);
				
				System.out.println("chkInLmem >>> " + chkInLmem);
				
				ArrayList<LsjMemberVO> aList = ldao.selectSearchLsjMem(lvo);
				
				if(aList.size()>=1) {
					req.setAttribute("aList", aList);
					RequestDispatcher rd = req.getRequestDispatcher("/member/memberLsjUpdate.jsp");
					rd.forward(req, resp);
				}else{
					System.out.println("	Error >>> ");
				}
				
				System.out.println("(log) servlet update <<< ");
			}
			
			// delete
			if("D".equals(isud.toUpperCase())){
				System.out.println("(log) servlet delete >>> ");
				
				lvo.setLmem(chkInLmem);
				System.out.println("(log) chkInLmem >>> " + chkInLmem);
				
				boolean bFlag = ldao.deleteLsjMem(lvo);
				
				if(bFlag){
					System.out.println("	삭제완료");
					
					req.setAttribute("bFlag", bFlag);
					RequestDispatcher rd = req.getRequestDispatcher("/member/index.jsp");
					rd.forward(req, resp);
				}else{
					System.out.println("삭제 실패 ");
					out.println("<script>alert('실패'); history.go(-1); </script>");
				}
				
				System.out.println("(log) servlet delete <<< ");
			}
			
			// login
			if("LOGIN".equals(isud.toUpperCase())){
				System.out.println("(log) servlet login >>> ");
				
				// data check
				System.out.println("	lid >>> " + lid);
				System.out.println("	lpw >>> " + lpw);
				
				lvo.setLid(lid);
				lvo.setLpw(lpw);
				
				ArrayList<LsjMemberVO> aList = ldao.loginLsjMem(lvo);
				
				if(aList.size()==1){
					System.out.println("	로그인 성공");
					try{
						LsjSession.setSession(req, lid);
					}catch(Exception e){
						System.out.println("	Error >>> " + e.getMessage());
					}
					
					RequestDispatcher rd = req.getRequestDispatcher("/member/memberLsjLogin.jsp");
					rd.forward(req, resp);
				}else {
					System.out.println("	로그인 실패");
					RequestDispatcher rd = req.getRequestDispatcher("/member/index.jsp");
					rd.forward(req, resp);
				}
				System.out.println("(log) servlet login <<< ");
			}
			
			// idCheck
			if("idCheck".equals(isud)){
				System.out.println("(log) servlet idCheck >>> ");
				int idCheck = 0;
				System.out.println("	lid >>> " + lid);
				
				lvo.setLid(lid);
				
				idCheck = ldao.idCheckLsjMem(lvo);
				
				req.setAttribute("idCheck", idCheck);
				RequestDispatcher rd = req.getRequestDispatcher("/member/memberLsjIdCheck.jsp");
				rd.forward(req, resp);
				System.out.println("(log) servlet idCheck <<< ");
			}
		}else if(req.getContentType().toLowerCase().startsWith("multipart/form-data")){
			try{
				//내장형 object Request 함수
				MultipartRequest mt = new MultipartRequest(req,uploadPath,size,"UTF-8",new DefaultFileRenamePolicy());
				
				isud = mt.getParameter("ISUD_TYPE");
				lmem = mt.getParameter("lmem");
				lid = mt.getParameter("lid");
				lpw = mt.getParameter("lpw");
				lname = mt.getParameter("lname");
				lgender = mt.getParameter("lgender");
				lbirth = mt.getParameter("lbirth");
				lemail = mt.getParameter("lemail");
				lhp = mt.getParameter("lhp");
				lpostno = mt.getParameter("lpostno");
				laddr = mt.getParameter("laddr") +  " "+ mt.getParameter("laddr1");
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
					if("I".equals(isud.toUpperCase())){
						System.out.println("(log) servlet isnert >>> ");
						
						// 초기화 후 담기
						lvo.setLid(lid);
						lvo.setLpw(lpw);
						lvo.setLname(lname);
						lvo.setLgender(lgender);
						lvo.setLbirth(lbirth);
						lvo.setLemail(lemail);
						lvo.setLhp(lhp);
						lvo.setLpostno(lpostno);
						lvo.setLaddr(laddr);
						lvo.setLimage(lfilename);
						
						// bFlag에 insert 함수 담기
						boolean bFlag = ldao.insertLsjMem(lvo);
						
						if(bFlag){
							System.out.println("	회원등록 완료");
							req.setAttribute("bFlag", bFlag);
							RequestDispatcher rd = req.getRequestDispatcher("/member/memberLsjInsert.jsp");
							rd.forward(req, resp);
						}else {
							System.out.println("	회원등록 실패");
							RequestDispatcher rd = req.getRequestDispatcher("./index.html");
							rd.forward(req, resp);
						}
						System.out.println("(log) servlet isnert <<< ");
					}
					
					// select
					if("S".equals(isud.toUpperCase())){
						System.out.println("(log) servlet select >>> ");
						
						lvo.setLname(lname);
						System.out.println("(log) lname >>> " + lname);
						
						ArrayList<LsjMemberVO> aList = ldao.searchLsjMem(lvo);
						System.out.println("(log) aList.size() >>> " + aList.size());
						
						req.setAttribute("aList", aList);
						RequestDispatcher rd = req.getRequestDispatcher("/member/memberLsjSelect.jsp");
						rd.forward(req, resp);
						
						System.out.println("(log) servlet select <<< ");
					}
					
					
					
					// updateOk
					if("UOK".equals(isud.toUpperCase())){
						System.out.println("(log) servlet updateOk >>> ");
				
						lvo.setLmem(lmem);
						lvo.setLid(lid);
						lvo.setLpw(lpw);
						lvo.setLname(lname);
						lvo.setLgender(lgender);
						lvo.setLbirth(lbirth);
						lvo.setLemail(lemail);
						lvo.setLhp(lhp);
						lvo.setLpostno(lpostno);
						lvo.setLaddr(laddr);
						lvo.setLaddr1(laddr1);
						lvo.setLdeleteyn(ldeleteyn);
						lvo.setLinsertdate(linsertdate);
						lvo.setLupdatedate(lupdatedate);
						lvo.setLimage(uploadPath);
						
						System.out.println("(log) chkInLmem >>> " + chkInLmem);
						
						boolean bFlag = ldao.updateLsjMem(lvo);
						
						if(bFlag){
							System.out.println("lmem >> " + lmem);
							System.out.println("	수정 완료");
							
							ArrayList<LsjMemberVO> aList = ldao.selectSearchLsjMem(lvo);
							req.setAttribute("aList", aList);
							
							RequestDispatcher rd = req.getRequestDispatcher("/member/memberLsjSelect.jsp");
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
