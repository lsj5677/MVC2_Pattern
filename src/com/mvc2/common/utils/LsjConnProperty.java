package com.mvc2.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class LsjConnProperty {
	
	// Data Source //
	
	// 드라이버 정보
	public static final String ORACLE11G_JDBCDRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// URL(local) 정보
	public static final String ORACLE11G_URL = "jdbc:oracle:thin:@127.0.0.1:1521:orclBNY";
	
	// 계정정보
	public static final String ORACLE11G_ID = "scott";
	public static final String ORACLE11G_PW = "tiger";
	
	// throw Exception
	public static Connection getConnection() throws Exception {
		System.out.println("(log) LsjConnProperty.getConnection() >>> ");
		
		// 변수선언
		Connection con = null;
		
		// Class.forName() 사용해서 드라이버 찾기
		Class.forName(ORACLE11G_JDBCDRIVER);
		
		// DriverManager.getConnection() 사용해서 정보들(URL,ID,PW) 연결, 변수 con에 담기
		con = DriverManager.getConnection(ORACLE11G_URL,ORACLE11G_ID,ORACLE11G_PW);
		
		System.out.println("(log) LsjConnProperty.getConnection() <<< ");

		// 정보 담아 연결한 변수 con으로 리턴
		return con;
	} // end of LsjConnProperty.getConnection()
	
	// conClose 사용해서 연결 닫아주기
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs){
		System.out.println("(log) LsjConnProperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) >>> ");
		
		//try catch
		try{
			System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) try >>> ");
			
			// ResultSet이 null이 아닐 때 실행
			if(rsRs!=null){
				System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) if(rsRs!=null) >>> ");
				
				try{
					// rsRs 닫기
					rsRs.close();
					// rsRs 값 = null
					rsRs = null;
				}catch(Exception e){
					System.out.println("	rsRs!=null Error >>> " + e.getMessage());
				} // end of if(rsRs!=null) try catch
				
				System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) if(rsRs!=null) <<< ");
			} // end of if(rsRs!=null)
			
			// preparedStatement가 null이 아닐 때 실행
			if(pstmt!=null){
				System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) if(pstms!=null) >>> ");
				
				try{
					// pstmt 닫기
					pstmt.close();
					// pstmt 값 = null
					pstmt = null;
				}catch(Exception e){
					System.out.println("	pstmt!=null Error >>> " + e.getMessage());
				}
				
				System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) if(pstms!=null) <<< ");
			}// end of if(pstmt!=null)

			// Connection이 null이 아닐 때 실행
			if(conn!=null){
				System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) if(conn!=null) >>> ");
				
				try{
					// conn 닫기
					conn.close();
					// conn 값 = null
					conn = null;
				}catch(Exception e){
					System.out.println("	conn!=null Error >>> " + e.getMessage());
				}
				
				System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) if(conn!=null) <<< ");
			}
			
			System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) try <<< ");
		}catch(Exception e){
			System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) catch >>> ");
			
			System.out.println("	Error >>> " + e.getMessage());
			
			System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) catch <<< ");
		}
		
		System.out.println("(log) LsjConnProperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs) <<< ");
	}// end of LsjConnProperty.conClose(Connection con, PreparedStatement pstmt, ResultSet rsRs)
	
	
	public static void conClose(Connection conn, PreparedStatement pstmt){
		System.out.println("(log) LsjConnProperty.conClose(Connection conn, PreparedStatement pstmt >>> ");
		
		//try catch
				try{
					System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt) try >>> ");
					
					// preparedStatement가 null이 아닐 때 실행
					if(pstmt!=null){
						System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt) if(pstms!=null) >>> ");
						
						try{
							// pstmt 닫기
							pstmt.close();
							// pstmt 값 = null
							pstmt = null;
						}catch(Exception e){
							System.out.println("	pstmt!=null Error >>> " + e.getMessage());
						}
						
						System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt) if(pstms!=null) <<< ");
					}// end of if(pstmt!=null)

					// Connection이 null이 아닐 때 실행
					if(conn!=null){
						System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt) if(conn!=null) >>> ");
						
						try{
							// conn 닫기
							conn.close();
							// conn 값 = null
							conn = null;
						}catch(Exception e){
							System.out.println("	conn!=null Error >>> " + e.getMessage());
						}
						
						System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt) if(conn!=null) <<< ");
					}
					
					System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt) try <<< ");
				}catch(Exception e){
					System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt) catch >>> ");
					
					System.out.println("	Error >>> " + e.getMessage());
					
					System.out.println("(log) LsjConnproperty.conClose(Connection con, PreparedStatement pstmt) catch <<< ");
				}
		
		System.out.println("(log) LsjConnProperty.conClose(Connection conn, PreparedStatement pstmt <<< ");
	}// end of conClose(Connection conn, PreparedStatement pstmt)
			
}// end of LsjConnProperty class
