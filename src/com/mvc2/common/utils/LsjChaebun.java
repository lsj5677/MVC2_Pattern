package com.mvc2.common.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mvc2.board.sql.LsjBoardQueryMap;
import com.mvc2.member.sql.LsjMemberQueryMap;

public abstract class LsjChaebun {
	
	// 채번 앞에 이니셜 붙이기
	public static final String MEMBER_CHAEBUN = "M";
	public static final String BOARD_CHAEBUN = "B";
	
	// 날짜포맷
	public static String ymdFormat(){
		System.out.println("(log) LsjChaebun.ymdFormat() >>> ");
		
		// 참조변수 d 선언 후 인스턴스
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		// 변수선언 후 함수호출
		String date = sdf.format(d);
		
		System.out.println("(log) LsjChaebun.ymdFormat() <<< ");

		// yyyyMMdd format한 함수 담긴 변수 date 리턴
		return date;
	}// end of LsjChaebun.ymdFormat()
	
	// 숫자 자릿수에 따라 0 붙이기
	public static String commNum(String commNO){
		System.out.println("(log) LsjChaebun.commNO() >>> ");
		
		// 숫자 길이가(자릿수가) 한 개 일때 000+숫자
		if(1==commNO.length()){
			commNO = "000"+commNO;
		}

		// 숫자 길이가(자릿수가) 두 개 일때 00+숫자
		if(2==commNO.length()){
			commNO = "00"+commNO;
		}

		// 숫자 길이가(자릿수가) 세 개 일때 0+숫자
		if(3==commNO.length()){
			commNO = "0"+commNO;
		}
		
		System.out.println("(log) LsjChaebun.commNO() <<< ");
		
		return commNO;
	}// end of LsjChaebun.commNum()
	
	// 날짜+자릿수 조합
	public static String memberChaebun(){
		System.out.println("(log) LsjChaebun.memberChaebun() >>>");
		
		// 초기화 //
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String commNO = "";
		
		// try catch
		try{
			// 연결
			conn = LsjConnProperty.getConnection();
			System.out.println("(log) 연결 성공 >>>");
			
			// pstmt에 LsjMemberQueryMap class LSJ_MEMBER_CHAEBUN 함수 호출
			pstmt = conn.prepareStatement(LsjMemberQueryMap.LSJ_MEMBER_CHAEBUN);
			System.out.println("(log) Chaebun >>> \n " + LsjMemberQueryMap.LSJ_MEMBER_CHAEBUN );
			
			// 결과값 rsRs에 담기
			rsRs = pstmt.executeQuery();
			System.out.println("(log) rsRs >>> " + rsRs);
			
			// data null값 체크
			if(rsRs!=null){
				while(rsRs.next()){
					commNO = rsRs.getString("COMMNO");
				}
			}
			System.out.println("(log) commNO >>> " + commNO);
			
			// chaebun setting
			commNO = MEMBER_CHAEBUN + LsjChaebun.ymdFormat() + LsjChaebun.commNum(commNO);
			System.out.println("(log) chaebunSetting commNO >>> " + commNO);
			
			// 연결 닫기
			LsjConnProperty.conClose(conn, pstmt, rsRs);
			
		}catch(Exception e){
			System.out.println("LsjChaebun.ymdNum() catch : Error >>> " + e.getMessage());
		}finally {
			// 연결 닫기
			LsjConnProperty.conClose(conn, pstmt, rsRs);
		}
 		
		System.out.println("(log) LsjChaebun.ymdNum() <<<");
		
		// 조합 된 채번 리턴
		return commNO;
	}// end of LsjChaebun.ymdNum()
	
	// 날짜+자릿수 조합
		public static String boardChaebun(){
			System.out.println("(log) LsjChaebun.boardChaebun() >>>");
			
			// 초기화 //
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rsRs = null;
			String commNO = "";
			
			// try catch
			try{
				// 연결
				conn = LsjConnProperty.getConnection();
				System.out.println("(log) 연결 성공 >>>");
				
				// pstmt에 LsjBoardQueryMap class LSJ_BOARD_CHAEBUN 함수 호출
				pstmt = conn.prepareStatement(LsjBoardQueryMap.LSJ_BOARD_CHAEBUN);
				System.out.println("(log) Chaebun >>> \n " + LsjBoardQueryMap.LSJ_BOARD_CHAEBUN );
				
				// 결과값 rsRs에 담기
				rsRs = pstmt.executeQuery();
				System.out.println("(log) rsRs >>> " + rsRs);
				
				// data null값 체크
				if(rsRs!=null){
					while(rsRs.next()){
						commNO = rsRs.getString("COMMNO");
					}
				}
				System.out.println("(log) commNO >>> " + commNO);
				
				// chaebun setting
				commNO = BOARD_CHAEBUN + LsjChaebun.ymdFormat() + LsjChaebun.commNum(commNO);
				System.out.println("(log) chaebunSetting commNO >>> " + commNO);
				
				// 연결 닫기
				LsjConnProperty.conClose(conn, pstmt, rsRs);
				
			}catch(Exception e){
				System.out.println("LsjChaebun.ymdNum() catch : Error >>> " + e.getMessage());
			}finally {
				// 연결 닫기
				LsjConnProperty.conClose(conn, pstmt, rsRs);
			}
	 		
			System.out.println("(log) LsjChaebun.boardChaebun() <<<");
			
			// 조합 된 채번 리턴
			return commNO;
		}// end of LsjChaebun.ymdNum()
	public static void main(String[] args){
		String memberChaebun = LsjChaebun.memberChaebun();
		System.out.println("memberChaebun >>> " + memberChaebun);
		
		String boardChaebun = LsjChaebun.boardChaebun();
		System.out.println("boardChaebun >>> " + boardChaebun);
				
	}
}
