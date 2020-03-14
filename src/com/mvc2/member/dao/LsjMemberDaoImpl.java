package com.mvc2.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mvc2.common.utils.LsjChaebun;
import com.mvc2.common.utils.LsjConnProperty;
import com.mvc2.member.sql.LsjMemberQueryMap;
import com.mvc2.member.vo.LsjMemberVO;

public class LsjMemberDaoImpl implements LsjMemberDao {

	// insert
	@Override
	public boolean insertLsjMem(LsjMemberVO lvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjMemberDaoImpl.insertLsjMem(LsjMemberVO lvo) >>>");
		
		// 데이터 들어왔는지 확인
		ArrayList<LsjMemberVO> aList = new ArrayList<LsjMemberVO>();
		System.out.println("	Data Check >>> " + aList.toString());
		
		// 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete = count에 결과값 담아주기, count=int
		int lCnt = 0;
		
		// 로직구현
		try{
			System.out.println("(log) LsjMemberDaoImpl.insertLsjMem(LsjMemberVO lvo) try >>> ");
			
			// 연결
			conn = LsjConnProperty.getConnection();
			System.out.println("(log) conn >>> " + conn);
			
			// Auto commint setting 
			// 여러 개의 쿼리 문장이 하나의 작업에 수행되어야 하기 때문에 자동커밋 방지를 위해 false로 지정
			conn.setAutoCommit(false);
			
			// 쿼리 가져오기
			pstmt = conn.prepareStatement(LsjMemberQueryMap.lsjMemberInsertQuery());
			
			// set으로 초기화 get으로 리턴
			pstmt.setString(1, LsjChaebun.memberChaebun()); // lmem = 채번 리턴해주기
			pstmt.setString(2, lvo.getLid());
			pstmt.setString(3, lvo.getLpw());
			pstmt.setString(4, lvo.getLname());
			pstmt.setString(5, lvo.getLgender());
			pstmt.setString(6, lvo.getLbirth());
			pstmt.setString(7, lvo.getLemail());
			pstmt.setString(8, lvo.getLhp());
			pstmt.setString(9, lvo.getLpostno());
			pstmt.setString(10, lvo.getLaddr());
			pstmt.setString(11, lvo.getLimage());
			pstmt.setString(12, "Y");
			
			// lCnt에 결과값 담기
			lCnt = pstmt.executeUpdate();
					
			// 결과 다 담았으니 커밋 true로 변경
			boolean autoCommit = !conn.getAutoCommit();
			System.out.println("(log) autoCommit >>> " + autoCommit);
			if(autoCommit){
				// db commit
				conn.commit();
				System.out.println("(log) insert check >>> " + lCnt);
		
				// 연결닫기
				LsjConnProperty.conClose(conn, pstmt);
			}
			
			System.out.println("(log) LsjMemberDaoImpl.insertLsjMem(LsjMemberVO lvo) try <<< ");
		} catch(Exception e){
			System.out.println("	LsjMemberDaoImpl.insertLsjMem(LsjMemberVO lvo) Error >>> " + e.getMessage());
		} finally {
			// 연결 닫기
			LsjConnProperty.conClose(conn, pstmt);
		}
		
		// 결과값 없으면 return false
		if(lCnt==0) return false;
		
		System.out.println("(log) LsjMemberDaoImpl.insertLsjMem(LsjMemberVO lvo) <<<");

		return true;
	}// end of LsjMemberDaoImpl.insertLsjMem(LsjMemberVO lvo)

	// update
	@Override
	public boolean updateLsjMem(LsjMemberVO lvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjMemberDaoImpl.updateLsjMem(LsjMemberVO lvo) >>>");
		
		// 데이터 확인
		// update 필요한 데이터 = name, hp, pw
		System.out.println("(log) LsjMemberDaoImpl.updateLsjMem(LsjMemberVO lvo) lname >>> " + lvo.getLname());
		System.out.println("(log) LsjMemberDaoImpl.updateLsjMem(LsjMemberVO lvo) lhp >>> " + lvo.getLhp());
		System.out.println("(log) LsjMemberDaoImpl.updateLsjMem(LsjMemberVO lvo) lpw >>> " + lvo.getLpw());
		
		// 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete = count에 결과값 담아주기, count=int
				int lCnt = 0;
				
				// 로직구현
				try{
					System.out.println("(log) LsjMemberDaoImpl.updateLsjMem(LsjMemberVO lvo) try >>> ");
					
					// 연결
					conn = LsjConnProperty.getConnection();
					System.out.println("(log) conn >>> " + conn);
					
					// Auto commint setting 
					// 여러 개의 쿼리 문장이 하나의 작업에 수행되어야 하기 때문에 자동커밋 방지를 위해 false로 지정
					conn.setAutoCommit(false);
					
					// 쿼리 가져오기
					pstmt = conn.prepareStatement(LsjMemberQueryMap.lsjMemberUpdateQuery());
					System.out.println("(log) pstmt >>> " + pstmt);
					
					// set으로 초기화 get으로 리턴
					pstmt.setString(1, lvo.getLpw());
					pstmt.setString(2, lvo.getLname());
					pstmt.setString(3, lvo.getLemail());
					pstmt.setString(4, lvo.getLhp());
					pstmt.setString(5, lvo.getLpostno());
					pstmt.setString(6, lvo.getLaddr());
					pstmt.setString(7, lvo.getLmem());
					
					// lCnt에 결과값 담기
					lCnt = pstmt.executeUpdate();
							
					// 결과 다 담았으니 커밋 true로 변경
					boolean autoCommit = !conn.getAutoCommit();
					System.out.println("(log) autoCommit >>> " + autoCommit);
					if(autoCommit){
						// db commit
						conn.commit();
						System.out.println("(log) insert check >>> " + lCnt);
				
						// 연결닫기
						LsjConnProperty.conClose(conn, pstmt);
					}
					
					System.out.println("(log) LsjMemberDaoImpl.updateLsjMem(LsjMemberVO lvo) try <<< ");
				} catch(Exception e){
					System.out.println("	LsjMemberDaoImpl.updateLsjMem(LsjMemberVO lvo) Error >>> " + e.getMessage());
				} finally {
					// 연결 닫기
					LsjConnProperty.conClose(conn, pstmt);
				}
				
				// 결과값 없으면 return false
				if(lCnt==0) return false;

		System.out.println("(log) LsjMemberDaoImpl.updateLsjMem(LsjMemberVO lvo) <<<");
		
		return true;
	}// end of LsjMemberDaoImpl.updateLsjMem(LsjMemberVO lvo)

	// delete
	@Override
	public boolean deleteLsjMem(LsjMemberVO lvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjMemberDaoImpl.deleteLsjMem(LsjMemberVO lvo) >>>");
		
		// 데이터 확인
		// delete 필요한 데이터 = name
		System.out.println("(log) LsjMemberDaoImpl.updateLsjMem(LsjMemberVO lvo) lname >>> " + lvo.getLname());
		
		// 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete = count에 결과값 담아주기, count=int
		int lCnt = 0;
		
		// 로직구현
		try{
			System.out.println("(log) LsjMemberDaoImpl.deleteLsjMem(LsjMemberVO lvo) try >>> ");
			
			// 연결
			conn = LsjConnProperty.getConnection();
			System.out.println("(log) conn >>> " + conn);
			
			// Auto commint setting 
			// 여러 개의 쿼리 문장이 하나의 작업에 수행되어야 하기 때문에 자동커밋 방지를 위해 false로 지정
			conn.setAutoCommit(false);
			
			// 쿼리 가져오기
			pstmt = conn.prepareStatement(LsjMemberQueryMap.lsjMemberDeleteQuery());
			System.out.println("(log) pstmt >>> " + pstmt);
			
			// set으로 초기화 get으로 리턴
			pstmt.setString(1, lvo.getLmem());
			
			// lCnt에 결과값 담기
			lCnt = pstmt.executeUpdate();
					
			// 결과 다 담았으니 커밋 true로 변경
			boolean autoCommit = !conn.getAutoCommit();
			System.out.println("(log) autoCommit >>> " + autoCommit);
			if(autoCommit){
				// db commit
				conn.commit();
				System.out.println("(log) insert check >>> " + lCnt);
		
				// 연결닫기
				LsjConnProperty.conClose(conn, pstmt);
			}
			
			System.out.println("(log) LsjMemberDaoImpl.deleteLsjMem(LsjMemberVO lvo) try <<< ");
		} catch(Exception e){
			System.out.println("	LsjMemberDaoImpl.deleteLsjMem(LsjMemberVO lvo) Error >>> " + e.getMessage());
		} finally {
			// 연결 닫기
			LsjConnProperty.conClose(conn, pstmt);
		}
		
		// 결과값 없으면 return false
		if(lCnt==0) return false;

		System.out.println("(log) LsjMemberDaoImpl.deleteLsjMem(LsjMemberVO lvo) <<<");
		return true;
	}// end of LsjMemberDaoImpl.deleteLsjMem(LsjMemberVO lvo)

	// select
	@Override
	public ArrayList<LsjMemberVO> selectLsjMem() {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjMemberDaoImpl.selectLsjMem() >>>");
		
		//초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LsjMemberVO> aList = null;
		LsjMemberVO lmvo = null;
		
		try {
			
			// DB연결
			conn = LsjConnProperty.getConnection();
			System.out.println("conn >>> " + conn);
			
			// pstmt에 해당쿼리문을 불러오고 담는다
			pstmt = conn.prepareStatement(LsjMemberQueryMap.lsjMemberSelectQuery());
			System.out.println("pstmt >>> " + pstmt);
			System.out.println("(log) LsjMemberQueryMap.lsjMemberSelectQuery() >>> " +LsjMemberQueryMap.lsjMemberSelectQuery());
			
			// rsRs에 결과값을 담는다
			rsRs = pstmt.executeQuery();
			System.out.println("rss >>> " + rsRs);
			
			// rsRs가 null이 아니면 실행
			if(rsRs !=null) {
				
				//alist를 인스턴스한다
				aList = new ArrayList<LsjMemberVO>();
				
				//while문, 무한반복문으로  rsRs에 담긴 값들을 불러온다
				while(rsRs.next()) {
						
					// 값을 담기위해 lmvo를 인스턴스한다
						lmvo = new LsjMemberVO();
					
					// set으로 초기화 후 get으로 담는다
					lmvo.setLmem(rsRs.getString("LMEM"));
					lmvo.setLid(rsRs.getString("LID"));
					lmvo.setLpw(rsRs.getString("LPW"));
					lmvo.setLname(rsRs.getString("LNAME"));
					lmvo.setLgender(rsRs.getString("LGENDER"));
					lmvo.setLbirth(rsRs.getString("LBIRTH"));
					lmvo.setLemail(rsRs.getString("LEMAIL"));
					lmvo.setLhp(rsRs.getString("LHP"));
					lmvo.setLpostno(rsRs.getString("LPOSTNO"));
					lmvo.setLaddr(rsRs.getString("LADDR"));
					lmvo.setLimage(rsRs.getString("LIMAGE"));
					lmvo.setLdeleteyn(rsRs.getString("LDELETEYN"));
					lmvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
					lmvo.setLupdatedate(rsRs.getString("LUPDATEDATE"));
					
					aList.add(lmvo);
				}
				System.out.println("(log) alist.size >>> " + aList.size());
			}
		} catch (Exception e) {
			System.out.println("error >>> " + e.getMessage());
		}finally {
			//연결닫기
			LsjConnProperty.conClose(conn, pstmt, rsRs);
		}
		System.out.println("(log) LsjMemberDaoImpl.selectLsjMem() <<< ");
		
		//결과값을 aList으로 리턴한다
		return aList;
	}

	// search
	@Override
	public ArrayList<LsjMemberVO> searchLsjMem(LsjMemberVO lvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjMemberDaoImpl.searchLsjMem(LsjMemberVO lvo) >>>");
		
		// search에 필요한 데이터 = name , 데이터 확인하기
		System.out.println("(log) LsjMemberDaoImpl.searchLsjMem(LsjMemberVO lvo) lname >>> " + lvo.getLname());

		//초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LsjMemberVO> aList = null;
		LsjMemberVO lmvo = null;
		
		try {
			
			//DB연결
			conn = LsjConnProperty.getConnection();
			System.out.println("(log) conn >>> " + conn);
			
			//pstmt에 해당쿼리문을 불러오고 담는다
			pstmt = conn.prepareStatement(LsjMemberQueryMap.lsjMemberSearchQuery());
			System.out.println("(log) LsjMemberQueryMap.LsjMemberSearchQuery() >>> " +LsjMemberQueryMap.lsjMemberSearchQuery());
			
			//쿼리문에 작성한 검색할 항목을 pstmt에 set으로 초기화 후 get으로 리턴한다
			pstmt.setString(1, lvo.getLname());
			
			// rsRs에 결과값을 담는다
			rsRs = pstmt.executeQuery();
			System.out.println("rss >>> " + rsRs);
			
			// rsRs가 null이 아니면 실행
			if(rsRs !=null) {
				
				//alist를 인스턴스한다
				aList = new ArrayList<LsjMemberVO>();
				
				//while문, 무한반복문으로  rsRs에 담긴 값들을 불러온다
				while(rsRs.next()) {
						
					// 값을 담기위해 lmvo를 인스턴스한다
						lmvo = new LsjMemberVO();
					
					// set으로 초기화 후 get으로 담는다
					lmvo.setLmem(rsRs.getString("LMEM"));
					lmvo.setLid(rsRs.getString("LID"));
					lmvo.setLpw(rsRs.getString("LPW"));
					lmvo.setLname(rsRs.getString("LNAME"));
					lmvo.setLgender(rsRs.getString("LGENDER"));
					lmvo.setLbirth(rsRs.getString("LBIRTH"));
					lmvo.setLemail(rsRs.getString("LEMAIL"));
					lmvo.setLhp(rsRs.getString("LHP"));
					lmvo.setLpostno(rsRs.getString("LPOSTNO"));
					lmvo.setLaddr(rsRs.getString("LADDR"));
					lmvo.setLdeleteyn(rsRs.getString("LDELETEYN"));
					lmvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
					lmvo.setLupdatedate(rsRs.getString("LUPDATEDATE"));
					
					aList.add(lmvo);
				}
				System.out.println("(log) alist.size >>> " + aList.size());
			}
		} catch (Exception e) {
			System.out.println("error >>> " + e.getMessage());
		}finally {
			//연결닫기
			LsjConnProperty.conClose(conn, pstmt, rsRs);
		}
		System.out.println("(log) LsjMemberDaoImpl.searchLsjMem() <<< ");
		
		//결과값을 aList으로 리턴한다
		return aList;
	}// end of LsjMemberDaoImpl.searchLsjMem(LsjMemberVO lvo)

	// likeSearch
	@Override
	public ArrayList<LsjMemberVO> likeSearchLsjMem(LsjMemberVO lvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjMemberDaoImpl.likeSearchLsjMem(LsjMemberVO lvo) >>>");
		
		// search에 필요한 데이터 = name , 데이터 확인하기
		System.out.println("(log) LsjMemberDaoImpl.likeSearchLsjMem(LsjMemberVO lvo) lname >>> " + lvo.getLname());

		//초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LsjMemberVO> aList = null;
		LsjMemberVO lmvo = null;
		
		try {
			
			//DB연결
			conn = LsjConnProperty.getConnection();
			System.out.println("(log) conn >>> " + conn);
			
			//pstmt에 해당쿼리문을 불러오고 담는다
			pstmt = conn.prepareStatement(LsjMemberQueryMap.lsjMemberLikeSearchQuery());
			System.out.println("(log) LsjMemberQueryMap.LsjMemberLikeSearchQuery() >>> " +LsjMemberQueryMap.lsjMemberLikeSearchQuery());
			
			//쿼리문에 작성한 검색할 항목을 pstmt에 set으로 초기화 후 get으로 리턴한다
			pstmt.setString(1, lvo.getLname());
			
			// rsRs에 결과값을 담는다
			rsRs = pstmt.executeQuery();
			System.out.println("rsRs >>> " + rsRs);
			
			// rsRs가 null이 아니면 실행
			if(rsRs !=null) {
				
				//alist를 인스턴스한다
				aList = new ArrayList<LsjMemberVO>();
				
				//while문, 무한반복문으로  rsRs에 담긴 값들을 불러온다
				while(rsRs.next()) {
						
					// 값을 담기위해 lmvo를 인스턴스한다
					lmvo = new LsjMemberVO();
					
					// set으로 초기화 후 get으로 담는다
					lmvo.setLmem(rsRs.getString("LMEM"));
					lmvo.setLid(rsRs.getString("LID"));
					lmvo.setLpw(rsRs.getString("LPW"));
					lmvo.setLname(rsRs.getString("LNAME"));
					lmvo.setLgender(rsRs.getString("LGENDER"));
					lmvo.setLbirth(rsRs.getString("LBIRTH"));
					lmvo.setLemail(rsRs.getString("LEMAIL"));
					lmvo.setLhp(rsRs.getString("LHP"));
					lmvo.setLpostno(rsRs.getString("LPOSTNO"));
					lmvo.setLaddr(rsRs.getString("LADDR"));
					lmvo.setLimage(rsRs.getString("LIMAGE"));
					lmvo.setLdeleteyn(rsRs.getString("LDELETEYN"));
					lmvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
					lmvo.setLupdatedate(rsRs.getString("LUPDATEDATE"));
					
					aList.add(lmvo);
				}
				System.out.println("(log) alist.size >>> " + aList.size());
			}
		} catch (Exception e) {
			System.out.println("error >>> " + e.getMessage());
		}finally {
			//연결닫기
			LsjConnProperty.conClose(conn, pstmt, rsRs);
		}
		System.out.println("(log) LsjMemberDaoImpl.likeSearchLsjMem() <<< ");
		
		return aList;
	}// end of LsjMemberDaoImpl.likeSearchLsjMem(LsjMemberVO lvo)

	// login
	@Override
	public ArrayList<LsjMemberVO> loginLsjMem(LsjMemberVO lvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjMemberDaoImpl.loginLsjMem(LsjMemberVO lvo) >>>");
		
		// 데이터 확인하기
		System.out.println("(log) LsjMemberDaoImpl.loginLsjMem(LsjMemberVO lvo) lid >>> " + lvo.getLid());
		System.out.println("(log) LsjMemberDaoImpl.loginLsjMem(LsjMemberVO lvo) lpw >>> " + lvo.getLpw());

		// 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LsjMemberVO> aList = null;
		LsjMemberVO lmvo = null;
		
		// 로직구현
		// data null check
		if(lvo!=null){
			try{
				// 연결
				conn = LsjConnProperty.getConnection();
				System.out.println("(log) conn >>> " + conn);
				
				// 쿼리가져오기
				pstmt = conn.prepareStatement(LsjMemberQueryMap.lsjMemberLoginQuery());
				System.out.println("(log) pstmt >>> " + pstmt);
				
				// setting
				pstmt.setString(1, lvo.getLid());
				pstmt.setString(2, lvo.getLpw());
				
				// 결과값 받기
				rsRs = pstmt.executeQuery();
				System.out.println("(log) rsRs >>> " + rsRs);
				
				// data null check
				if(rsRs!=null){
					System.out.println("(log) LsjMemberDaoImpl.loginLsjMem() if(rsRs!=null) >>> ");
					
					// data check
					System.out.println("(log) LsjMemberDaoImpl.loginLsjMem() lid >>> " + lvo.getLid());
					System.out.println("(log) LsjMemberDaoImpl.loginLsjMem() lpw >>> " + lvo.getLpw());
					
					// aList instance
					aList = new ArrayList<LsjMemberVO>();
					
					// 결과값이 존재하면 수행
					while(rsRs.next()){
						lmvo = new LsjMemberVO();
						
						// set으로 초기화 get으로 리턴
						lmvo.setLid(rsRs.getString("LID"));
						lmvo.setLpw(rsRs.getString("LPW"));
						
						// aList에 결과 담기
						aList.add(lmvo);
					}
					System.out.println("(log) aList.size >>> " + aList.size());
					System.out.println("(log) LsjMemberDaoImpl.loginLsjMem() if(rsRs!=null) <<< ");
				}
				
				// 연결 닫기
				LsjConnProperty.conClose(conn, pstmt, rsRs);
			}catch(Exception e){
				System.out.println("	Error >>> " + e.getMessage());
			}finally {
				// 연결 닫기
				LsjConnProperty.conClose(conn, pstmt, rsRs);
			}
		}
		System.out.println("(log) LsjMemberDaoImpl.loginLsjMem(LsjMemberVO lvo) <<<");
		
		return aList;
	}// end of LsjMemberDaoImpl.loginLsjMem(LsjMemberVO lvo)

	@Override
	public ArrayList<LsjMemberVO> selectSearchLsjMem(LsjMemberVO lvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjMemberDaoImpl.selectSearchLsjMem(LsjMemberVO lvo) >>>");
		
		// reset
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LsjMemberVO> aList = null;
		LsjMemberVO lmvo = null;
		
		try{
			// 연결
			conn = LsjConnProperty.getConnection();
			
			// 쿼리가져오기
			pstmt = conn.prepareStatement(LsjMemberQueryMap.lsjMemberSelectSearchQuery());
			
			// setting
			pstmt.setString(1, lvo.getLmem());
			
			// 결과값 받기
			rsRs = pstmt.executeQuery();
			
			// data null check
			if(rsRs!=null){
				System.out.println("(log) LsjMemberDaoImpl.selectSearchLsjMem() if(rsRs!=null) >>> ");
				
				// data check
				System.out.println("(log) LsjMemberDaoImpl.selectSearchLsjMem() lmem >>> " + lvo.getLmem());
				
				// aList instance
				aList = new ArrayList<LsjMemberVO>();
				
				// 결과값이 존재하면 수행
				while(rsRs.next()){
					lmvo = new LsjMemberVO();
					
					// set으로 초기화 후 get으로 담는다
					lmvo.setLmem(rsRs.getString("LMEM"));
					lmvo.setLid(rsRs.getString("LID"));
					lmvo.setLpw(rsRs.getString("LPW"));
					lmvo.setLname(rsRs.getString("LNAME"));
					lmvo.setLgender(rsRs.getString("LGENDER"));
					lmvo.setLbirth(rsRs.getString("LBIRTH"));
					lmvo.setLemail(rsRs.getString("LEMAIL"));
					lmvo.setLhp(rsRs.getString("LHP"));
					lmvo.setLpostno(rsRs.getString("LPOSTNO"));
					lmvo.setLaddr(rsRs.getString("LADDR"));
					lmvo.setLimage(rsRs.getString("LIMAGE"));
					lmvo.setLdeleteyn(rsRs.getString("LDELETEYN"));
					lmvo.setLinsertdate(rsRs.getString("LINSERTDATE"));
					lmvo.setLupdatedate(rsRs.getString("LUPDATEDATE"));
					
					// aList에 결과 담기
					aList.add(lmvo);
				}
				System.out.println("(log) aList.size >>> " + aList.size());
				System.out.println("(log) LsjMemberDaoImpl.selectSearchLsjMem() if(rsRs!=null) <<< ");
			}
			
			// 연결 닫기
			LsjConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e){
			System.out.println("	Error >>> " + e.getMessage());
		}finally {
			// 연결 닫기
			LsjConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		System.out.println("(log) LsjMemberDaoImpl.selectSearchLsjMem(LsjMemberVO lvo) <<<");
		return aList;
	}// end of LsjMemberDaoImpl.selectSearchLsjMem(LsjMemberVO lvo)

	@Override
	public int idCheckLsjMem(LsjMemberVO lvo) {
		// TODO Auto-generated method stub
		System.out.println("(log) LsjMemberDaoImpl.idCheckLsjMem(LsjMemberVO lvo) >>>");
		
		// reset
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<LsjMemberVO> aList = null;
		LsjMemberVO lmvo = null;
		
		if(lvo!=null){
			try{
				// 연결
				conn = LsjConnProperty.getConnection();
				
				// 쿼리가져오기
				pstmt = conn.prepareStatement(LsjMemberQueryMap.lsjMemberIdCheckQuery());
				
				// setting
				pstmt.setString(1, lvo.getLid());
				
				// 결과값 받기
				rsRs = pstmt.executeQuery();
				
				if(rsRs.next() || lvo.getLid().equals("")){
					return 0;
				}else{
					return 1;
				}
				
			}catch(Exception e){
				System.out.println("	Error >>> " + e.getMessage());
			}finally{
				// 연결 닫기
				LsjConnProperty.conClose(conn, pstmt, rsRs);
			}
		}
		
		System.out.println("(log) LsjMemberDaoImpl.idCheckLsjMem(LsjMemberVO lvo) <<<");
		// db 오류
		return -1;
	}// end of LsjMemberDaoImpl.idCheckLsjMem(LsjMemberVO lvo)

}
