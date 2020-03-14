package com.mvc2.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mvc2.board.sql.LsjBoardQueryMap;
import com.mvc2.board.vo.LsjBoardVO;
import com.mvc2.common.utils.LsjChaebun;
import com.mvc2.common.utils.LsjConnProperty;

public class LsjBoardDaoImpl implements LsjBoardDao {

	@Override
	public int insertLsjBoard(LsjBoardVO lbvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjBoardDaoImpl.insertLsjBoard(LsjBoardVO lbvo) >>>");
		
		// reset
		Connection conn = null;
		PreparedStatement pstmt = null;
		int lCnt = 0;
		
		// logic
		try{
			// connection
			conn = LsjConnProperty.getConnection();
			// commit setting
			conn.setAutoCommit(false);
			// query invoke
			pstmt = conn.prepareStatement(LsjBoardQueryMap.lsjBoardInsertQuery());
			
			// data setting
			pstmt.setString(1, LsjChaebun.boardChaebun()); // chaebun invoke
			pstmt.setString(2, lbvo.getLsubject());
			pstmt.setString(3, lbvo.getLname());
			pstmt.setString(4, lbvo.getLpw());
			pstmt.setString(5, lbvo.getLmemo());
			pstmt.setString(6, lbvo.getLimage());
			pstmt.setString(7, "Y");
			
			// count 변수에 결과값 담기
			lCnt = pstmt.executeUpdate();
			
			// 결과값 담았으면 commit
			if(!conn.getAutoCommit()){
				// commit
				conn.commit();
				System.out.println("(log) insert check >>> " + lCnt);
				
				//  connection close
				LsjConnProperty.conClose(conn, pstmt);
			}
		}catch(Exception e){
			System.out.println("	Error >>> " + e.getMessage());
		}finally {
			// connection close
			LsjConnProperty.conClose(conn, pstmt);
		}
		
		if(lCnt == 0) {
			return 0;
		}
		
		System.out.println("(log) LsjBoardDaoImpl.insertLsjBoard(LsjBoardVO lbvo) <<<");
		return lCnt;
	}

	@Override
	public int updateLsjBoard(LsjBoardVO lbvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjBoardDaoImpl.updateLsjBoard(LsjBoardVO lbvo) >>>");
		// reset
				Connection con = null;
				PreparedStatement pstmt = null;
				int lCnt = 0;

				// logic
				try {
					// connect
					con = LsjConnProperty.getConnection();
					// 결과값 다 들어오기 전까지 자동커밋 X
					con.setAutoCommit(false);
					// 쿼리가져오기
					pstmt = con.prepareStatement(LsjBoardQueryMap.lsjBoardUpdateQuery());

					// setting (placeholder 순서)
					pstmt.setString(1, lbvo.getLsubject());
					pstmt.setString(2, lbvo.getLmemo());
					pstmt.setString(3, lbvo.getLimage());
					pstmt.setString(4, lbvo.getLno());

					// 결과값 담기
					lCnt = pstmt.executeUpdate();

					// boolean으로 로그확인하고 true면 AutoCommit
					boolean b = !con.getAutoCommit();
					System.out.println("(log) !con.getAutoCommit >>> " + b);

					// Autocommit (!=true면 false, false면 true)
					if (!con.getAutoCommit()) {
						// db commit
						con.commit();
						System.out.println("	UPDATE 되었습니다 >>> " + lCnt);
					}
					// connection close
					LsjConnProperty.conClose(con, pstmt);
				} catch (Exception e) {
					System.out.println("	Error >>> " + e.getMessage());
				} finally {
					// connection close
					LsjConnProperty.conClose(con, pstmt);
				}

				// return 값이 0이면 return값 없음
				if (lCnt == 0) {
					return 0;
				}
		System.out.println("(log) LsjBoardDaoImpl.updateLsjBoard(LsjBoardVO lbvo) <<<");
		return lCnt;
	}

	@Override
	public int deleteLsjBoard(LsjBoardVO lbvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjBoardDaoImpl.deleteLsjBOard(LsjBoardVO lbvo) >>>");
		// reset
		Connection con = null;
		PreparedStatement pstmt = null;
		int lCnt = 0;
		
		// logic
		try{
			// connect
			con = LsjConnProperty.getConnection();
			// autocommit false
			con.setAutoCommit(false);
			// 쿼리가져오기
			pstmt = con.prepareStatement(LsjBoardQueryMap.lsjBoardDeleteQuery());
			
			// setting
			pstmt.setString(1, lbvo.getLno());
			
			// 결과값 count에 담기
			lCnt = pstmt.executeUpdate();
			
			// AutoCommit check and setting
			boolean b = !con.getAutoCommit();
			System.out.println("(log) !con.getAutoCommit >>> " + b);
			// AutoCommit
			if(!con.getAutoCommit()){
				// db commit
				con.commit();
				System.out.println("	DELETE 되었습니다 " + lCnt);
			}
			// connect close
			LsjConnProperty.conClose(con, pstmt);
		}catch(Exception e){
			System.out.println("	Error >>> " + e.getMessage());
		}finally{
			// connect close
			LsjConnProperty.conClose(con, pstmt);
		}
		
		// 결과값 0이면 리턴 X
		if(lCnt==0){
			return 0;
		}
		System.out.println("(log) LsjBoardDaoImpl.deleteLsjBOard(LsjBoardVO lbvo) <<<");
		return lCnt;
	}

	@Override
	public ArrayList<LsjBoardVO> selectAllLsjBoard() {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjBoardDaoImpl.selectAllLsjBoard() >>>");
		
		// reset
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LsjBoardVO> aList = null;
		LsjBoardVO lbvo = null;
		
		try{
			// connection
			conn = LsjConnProperty.getConnection();
			// query invoke
			pstmt = conn.prepareStatement(LsjBoardQueryMap.lsjBoardSelectAllQuery());
			//  결과값 담기
			rsRs = pstmt.executeQuery();
			
			// data null check
			if(rsRs!=null){
				// instance
				aList = new ArrayList<LsjBoardVO>();
				
				while(rsRs.next()){
					// instance
					lbvo = new LsjBoardVO();
					
					// data reset, return
					lbvo.setLno(rsRs.getString("LNO"));
					lbvo.setLsubject(rsRs.getString("LSUBJECT"));
					lbvo.setLname(rsRs.getString("LNAME"));
					lbvo.setLmemo(rsRs.getString("LMEMO"));
					lbvo.setLimage(rsRs.getString("LIMAGE"));
					lbvo.setLdeleteyn(rsRs.getString("LDELETEYN"));
					lbvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
					lbvo.setLupdatedate(rsRs.getString("LUPDATEDATE"));
					
					// aList에 data 담기
					aList.add(lbvo);
				}
				System.out.println("(log) aList.size() >>> " + aList.size());
			}
			
			// connection close
			LsjConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e){
			System.out.println("	Error >>> " + e.getMessage());
		}finally{
			LsjConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		System.out.println("(log) LsjBoardDaoImpl.selectAllLsjBoard() <<<");
		return aList;
	}

	@Override
	public ArrayList<LsjBoardVO> selectLsjBoard(LsjBoardVO lbvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjBoardDaoImpl.selectLsjBoard(LsjBoardVO lbvo) >>>");
		// reset
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LsjBoardVO> aList = null;
		LsjBoardVO lbvo_ = null;

		// logic
		try {
			// connect
			con = LsjConnProperty.getConnection();
			// query 가져오기
			pstmt  = con.prepareStatement(LsjBoardQueryMap.lsjBoardSelectQuery());
			// setting
			pstmt.setString(1, lbvo.getLno());
			// 결과값 담기
			rsRs = pstmt.executeQuery();
			
			// data null check
			if(rsRs!=null){
				// aList instance
				aList = new ArrayList<LsjBoardVO>();
				
				// rsRs next값 존재하면 수행
				while(rsRs.next()){
					// value object instance
					lbvo_ = new LsjBoardVO();
					
					// set으로 초기화 get으로 리턴
					lbvo_.setLno(rsRs.getString("LNO"));
					lbvo_.setLsubject(rsRs.getString("LSUBJECT"));
					lbvo_.setLname(rsRs.getString("LNAME"));
					lbvo_.setLpw(rsRs.getString("LPW"));
					lbvo_.setLmemo(rsRs.getString("LMEMO"));
					lbvo_.setLimage(rsRs.getString("LIMAGE"));
					lbvo_.setLdeleteyn(rsRs.getString("LDELETEYN"));
					lbvo_.setLinsertdate(rsRs.getString("LINSERTDATE"));
					lbvo_.setLupdatedate(rsRs.getString("LUPDATEDATE"));
					
					// aList에 데이터 담기
					aList.add(lbvo_);
				}
				// aList size check
				System.out.println("(log) aList.size() >>> " + aList.size());
			}
			
			// connect close
			LsjConnProperty.conClose(con, pstmt, rsRs);
		} catch (Exception e) {
			System.out.println("	Error >>> " + e.getMessage());
		} finally {
			// connect close
			LsjConnProperty.conClose(con, pstmt, rsRs);
		}
		System.out.println("(log) LsjBoardDaoImpl.selectLsjBoard(LsjBoardVO lbvo) <<<");
		return aList;
	}

}
