package com.mvc2.board.sql;

public abstract class LsjBoardQueryMap {
	// SUBSTR 이용해서 chaebun logic
	public static final String  LSJ_BOARD_CHAEBUN = "SELECT /*+ INDEX DESC (A SYS_C0011065) */"
													+"NVL(MAX(SUBSTR(LNO,-4)),0)+1  COMMNO FROM BOARD_LSJ_MVC2";	
	
	//insert
	public static String lsjBoardInsertQuery(){
		System.out.println("(log) LsjBoardQueryMap.LsjBoardInsertQuery() >>>");
		
		// StringBuffer instance
		StringBuffer sb = new StringBuffer();
		
		sb.append(" INSERT INTO BOARD_LSJ_MVC2	(	\n");
		sb.append("				LNO					\n");
		sb.append("			   ,LSUBJECT			\n");
		sb.append("			   ,LNAME				\n");
		sb.append("			   ,LPW					\n");
		sb.append("			   ,LMEMO				\n");
		sb.append("			   ,LIMAGE				\n");
		sb.append("			   ,LDELETEYN			\n");
		sb.append("			   ,LINSERTDATE			\n");
		sb.append("			   ,LUPDATEDATE	  )		\n");
		sb.append(" VALUES (						\n");
		sb.append("				?					\n");
		sb.append("			   ,?					\n");
		sb.append("			   ,?					\n");
		sb.append("			   ,?					\n");
		sb.append("			   ,?					\n");
		sb.append("			   ,?					\n");
		sb.append(" 		   ,?					\n");
		sb.append("			   ,SYSDATE				\n");
		sb.append("			   ,SYSDATE	  )			\n");		
		
		System.out.println("(log) LsjBoardQueryMap.LsjBoardInsertQuery() <<<");
		
		// toString 으로 형변환 해주기
		return sb.toString();
	}// LsjBoardQueryMap.LsjBoardInsertQuery() 
	
	//update
	public static String lsjBoardUpdateQuery(){
		System.out.println("(log) LsjBoardQueryMap.LsjBoardUpdateQuery() >>>");
		
		// StringBuffer class instance
		StringBuffer sb = new StringBuffer();
		
		sb.append(" UPDATE BOARD_LSJ_MVC2		\n");
		sb.append(" SET  LSUBJECT = ? 			\n");
		sb.append("     ,LMEMO = ? 				\n");
		sb.append("     ,LIMAGE = ? 				\n");
		sb.append("		,LUPDATEDATE = SYSDATE	\n");
		sb.append(" WHERE LNO = ?				\n");
		sb.append(" AND LDELETEYN = 'Y'			\n");
		
		System.out.println("(log) LsjBoardQueryMap.LsjBoardUpdateQuery() <<<");
		
		return sb.toString();
	}// LsjBoardQueryMap.LsjBoardUpdateQuery()  
	
	//delete
	public static String lsjBoardDeleteQuery(){
		System.out.println("(log) LsjBoardQueryMap.LsjBoardDeleteQuery() >>>");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" UPDATE BOARD_LSJ_MVC2		\n");
		sb.append(" SET							\n");
		sb.append("	  LDELETEYN = 'N'			\n");
		sb.append("	 ,LUPDATEDATE = SYSDATE		\n");
		sb.append(" WHERE LNO = ? 				\n");
		sb.append(" AND LDELETEYN = 'Y'			\n");
		
		System.out.println("(log) LsjBoardQueryMap.LsjBoardDeleteQuery() <<<");
		
		return sb.toString();
	}// LsjBoardQueryMap.LsjBoardDeleteQuery
	
	// selectAll
	public static String lsjBoardSelectAllQuery(){
		System.out.println("(log) LsjBoardInsertQuery.LsjBoardSelectAllQuery() >>>");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT							\n");
		sb.append("		 A.LNO			LNO			\n");
		sb.append("		,A.LSUBJECT		LSUBJECT	\n");
		sb.append("		,A.LNAME		LNAME		\n");
		sb.append("		,A.LPW			LPW			\n");
		sb.append("		,A.LMEMO		LMEMO		\n");
		sb.append("		,A.LIMAGE		LIMAGE		\n");
		sb.append("		,A.LDELETEYN	LDELETEYN	\n");
		sb.append("		,TO_CHAR(A.LINSERTDATE, 'YYYY-MM-DD') LINSERTDATE \n");
		sb.append("		,TO_CHAR(A.LUPDATEDATE, 'YYYY-MM-DD') LUPDATEDATE \n");
		sb.append("FROM BOARD_LSJ_MVC2 A			\n");
		sb.append("WHERE 1=1						\n");
		sb.append("AND A.LDELETEYN = 'Y'			\n");
		sb.append("ORDER BY 1						\n");
		
		System.out.println("(log) LsjBoardInsertQuery.LsjBoardSelectAllQuery() <<<");
		
		return sb.toString();
	}// end of LsjBoardInsertQuery.LsjBoardSelectAllQuery()
	
	// select
	public static String lsjBoardSelectQuery(){
		
		System.out.println("(log) LsjBoardInsertQuery.LsjBoardSelectQuery() >>>");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT							\n");
		sb.append("		 A.LNO			LNO			\n");
		sb.append("		,A.LSUBJECT		LSUBJECT	\n");
		sb.append("		,A.LNAME		LNAME		\n");
		sb.append("		,A.LPW			LPW			\n");
		sb.append("		,A.LMEMO		LMEMO		\n");
		sb.append("		,A.LIMAGE		LIMAGE		\n");
		sb.append("		,A.LDELETEYN	LDELETEYN	\n");
		sb.append("		,TO_CHAR(A.LINSERTDATE, 'YYYY-MM-DD') LINSERTDATE \n");
		sb.append("		,TO_CHAR(A.LUPDATEDATE, 'YYYY-MM-DD') LUPDATEDATE \n");
		sb.append("FROM BOARD_LSJ_MVC2 A			\n");
		sb.append("WHERE 1=1						\n");
		sb.append("AND A.LNO = ?					\n");
		sb.append("AND A.LDELETEYN = 'Y'			\n");
		sb.append("ORDER BY 1						\n");
		
		System.out.println("(log) LsjBoardInsertQuery.LsjBoardSelectQuery() <<<");	
		
		return sb.toString();
	}// end of LsjBoardInsertQuery.LsjBoardSelectQuery()
	
}
