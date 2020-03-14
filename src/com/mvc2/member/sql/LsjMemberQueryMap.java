package com.mvc2.member.sql;

public abstract class LsjMemberQueryMap {
	
	// SUBSTR 이용해서 쪼개기
	public static final String LSJ_MEMBER_CHAEBUN = "SELECT /*+ INDEX DESC (A SYS_C0011065) */"
													+ "NVL(MAX(SUBSTR(A.LMEM,-4)),0)+1  COMMNO FROM MEMBER_LSJ_MVC2 A";
	
	public static String lsjMemberInsertQuery(){
		System.out.println("(log) LsjMemberQueryMap.LsjMemberInsertQuery() >>> ");
		
		// StringBuffer 인스턴스 후 append 사용해서 문자열 붙이기
		StringBuffer sb = new StringBuffer();

		sb.append("INSERT INTO MEMBER_LSJ_MVC2 (	\n");
		sb.append(" 				LMEM			\n");
		sb.append(" 			   ,LID				\n");
		sb.append(" 			   ,LPW				\n");
		sb.append(" 			   ,LNAME			\n");
		sb.append(" 			   ,LGENDER			\n");
		sb.append(" 			   ,LBIRTH			\n");
		sb.append(" 			   ,LEMAIL			\n");
		sb.append(" 			   ,LHP				\n");
		sb.append(" 			   ,LPOSTNO			\n");
		sb.append(" 			   ,LADDR			\n");
		sb.append("				   ,LIMAGE			\n");
		sb.append(" 			   ,LDELETEYN		\n");
		sb.append(" 			   ,LINSERTDATE		\n");
		sb.append(" 			   ,LUPDATEDATE		\n");
		sb.append(" 			   )				\n");
		sb.append(" VALUES (						\n");
		sb.append(" 			   ?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,?				\n");
		sb.append(" 			  ,SYSDATE			\n");
		sb.append(" 			  ,SYSDATE		)	\n");
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberInsertQuery() <<< ");
		
		return sb.toString();
	}// LsjMemberQueryMap.LsjMemberInsertQuery()
	
	public static String lsjMemberUpdateQuery(){
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberUpdateQuery() >>> ");
		
		// StringBuffer 인스턴스 후 append 사용해서 문자열 붙이기
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE MEMBER_LSJ_MVC2 				\n");
		sb.append(" SET									\n");
		sb.append("     LPW = ?							\n");
		sb.append("    ,LNAME = ?						\n");
		sb.append("    ,LEMAIL = ?						\n");
		sb.append("    ,LHP = ?							\n");
		sb.append("    ,LPOSTNO = ?						\n");
		sb.append("    ,LADDR = ?						\n");
		sb.append("    ,LUPDATEDATE = SYSDATE			\n");
		sb.append(" WHERE LMEM = ?						\n");
		sb.append(" AND	  LDELETEYN = 'Y'				\n");
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberUpdateQuery() <<< ");
		
		return sb.toString();
	}// LsjMemberQueryMap.LsjMemberUpdateQuery()
	
	public static String lsjMemberDeleteQuery(){
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberDeleteQuery() >>> ");
		
		// StringBuffer 인스턴스 후 append 사용해서 문자열 붙이기
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE MEMBER_LSJ_MVC2 			\n");
		sb.append(" SET								\n");
		sb.append("     LDELETEYN = 'N'				\n");
		sb.append("    ,LUPDATEDATE = SYSDATE		\n");
		sb.append(" WHERE LMEM = ?					\n");
		sb.append(" AND	  LDELETEYN = 'Y'			\n");
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberDeleteQuery() <<< ");
		
		return sb.toString();
	}// LsjMemberQueryMap.LsjMemberDeleteQuery()
	
	public static String lsjMemberSelectQuery(){
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberSelectQuery() >>> ");
		
		// StringBuffer 인스턴스 후 append 사용해서 문자열 붙이기
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT							\n");
		sb.append(" 	 A.LMEM			LMEM		\n");
		sb.append("     ,A.LID			LID			\n");
		sb.append("     ,A.LPW			LPW			\n");
		sb.append("     ,A.LNAME		LNAME		\n");
		sb.append("     ,A.LGENDER		LGENDER		\n");
		sb.append("     ,A.LBIRTH		LBIRTH		\n");
		sb.append("     ,A.LEMAIL		LEMAIL		\n");
		sb.append("     ,A.LHP			LHP			\n");
		sb.append("     ,A.LPOSTNO		LPOSTNO		\n");
		sb.append("     ,A.LADDR		LADDR		\n");
		sb.append("		,A.LIMAGE		LIMAGE		\n");
		sb.append("     ,A.LDELETEYN	LDELETEYN	\n");
		sb.append("     ,TO_CHAR(A.LINSERTDATE, 'YYYY-MM-DD') LINSERTDATE	\n");
		sb.append("     ,TO_CHAR(A.LUPDATEDATE, 'YYYY-MM-DD') LUPDATEDATE	\n");
		sb.append(" FROM	MEMBER_LSJ_MVC2 A		\n");
		sb.append(" WHERE	1=1						\n");
		sb.append(" AND A.LDELETEYN = 'Y'			\n");
		sb.append(" ORDER BY 1						\n");
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberSelectQuery() <<< ");
		return sb.toString();
	}// LsjMemberQueryMap.LsjMemberSelectQuery()
	
	public static String lsjMemberSearchQuery(){
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberSearchQuery() >>> ");
		
		// StringBuffer 인스턴스 후 append 사용해서 문자열 붙이기
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT							\n");
		sb.append(" 	 A.LMEM			LMEM		\n");
		sb.append("     ,A.LID			LID			\n");
		sb.append("     ,A.LPW			LPW			\n");
		sb.append("     ,A.LNAME		LNAME		\n");
		sb.append("     ,A.LGENDER		LGENDER		\n");
		sb.append("     ,A.LBIRTH		LBIRTH		\n");
		sb.append("     ,A.LEMAIL		LEMAIL		\n");
		sb.append("     ,A.LHP			LHP			\n");
		sb.append("     ,A.LPOSTNO		LPOSTNO		\n");
		sb.append("     ,A.LADDR		LADDR		\n");
		sb.append("		,A.LIMAGE		LIMAGE		\n");
		sb.append("     ,A.LDELETEYN	LDELETEYN	\n");
		sb.append("     ,TO_CHAR(A.LINSERTDATE, 'YYYY-MM-DD') LINSERTDATE	\n");
		sb.append("     ,TO_CHAR(A.LUPDATEDATE, 'YYYY-MM-DD') LUPDATEDATE	\n");
		sb.append(" FROM	MEMBER_LSJ_MVC2 A		\n");
		sb.append(" WHERE	1=1						\n");
		sb.append(" AND A.LNAME = ?					\n");
		sb.append(" AND A.LDELETEYN = 'Y'			\n");
		sb.append(" ORDER BY 1						\n");
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberSearchQuery() <<< ");
		return sb.toString();
	}// LsjMemberQueryMap.LsjMemberSearchQuery()
	
	public static String lsjMemberLikeSearchQuery(){
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberLikeSearchQuery() >>> ");
		
		// StringBuffer 인스턴스 후 append 사용해서 문자열 붙이기
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT							\n");
		sb.append(" 	 A.LMEM			LMEM		\n");
		sb.append("     ,A.LID			LID			\n");
		sb.append("     ,A.LPW			LPW			\n");
		sb.append("     ,A.LNAME		LNAME		\n");
		sb.append("     ,A.LGENDER		LGENDER		\n");
		sb.append("     ,A.LBIRTH		LBIRTH		\n");
		sb.append("     ,A.LEMAIL		LEMAIL		\n");
		sb.append("     ,A.LHP			LHP			\n");
		sb.append("     ,A.LPOSTNO		LPOSTNO		\n");
		sb.append("     ,A.LADDR		LADDR		\n");
		sb.append("		,A.LIMAGE		LIMAGE		\n");
		sb.append("     ,A.LDELETEYN	LDELETEYN	\n");
		sb.append("     ,TO_CHAR(A.LINSERTDATE, 'YYYY-MM-DD') LINSERTDATE	\n");
		sb.append("     ,TO_CHAR(A.LUPDATEDATE, 'YYYY-MM-DD') LUPDATEDATE	\n");
		sb.append(" FROM	MEMBER_LSJ_MVC2 A		\n");
		sb.append(" WHERE	1=1						\n");
		sb.append(" AND A.LNAME LIKE ? || '%'		\n");
		sb.append(" AND A.LDELETEYN = 'Y'			\n");
		sb.append(" ORDER BY 1						\n");
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberLikeSearchQuery() <<< ");
		return sb.toString();
	}// LsjMemberQueryMap.LsjMemberLikeSearchQuery()
	
	public static String lsjMemberLoginQuery(){
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberLoginQuery() >>> ");
		
		// StringBuffer 인스턴스 후 append 사용해서 문자열 붙이기
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT							\n");
		sb.append("      A.LID			LID			\n");
		sb.append("     ,A.LPW			LPW			\n");
		sb.append("     ,A.LDELETEYN	LDELETEYN	\n");
		sb.append(" FROM	MEMBER_LSJ_MVC2 A		\n");
		sb.append(" WHERE	1=1						\n");
		sb.append(" AND A.LID = ?					\n");
		sb.append(" AND A.LPW = ?					\n");
		sb.append(" AND A.LDELETEYN = 'Y'			\n");
		
		System.out.println("(log) LsjMemberQueryMap.LsjMemberLoginQuery() <<< ");
		return sb.toString();
	}// LsjMemberQueryMap.LsjMemberLoginQuery()
	
	public static String lsjMemberIdCheckQuery(){
		System.out.println("(log) LsjMemberQueryMap.lsjMemberIdCheckQuery() >>>");

		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT							\n");
		sb.append("      A.LID			LID			\n");
		sb.append("     ,A.LDELETEYN	LDELETEYN	\n");
		sb.append(" FROM	MEMBER_LSJ_MVC2 A		\n");
		sb.append(" WHERE	1=1						\n");
		sb.append(" AND A.LID = ?					\n");
		sb.append(" AND A.LDELETEYN = 'Y'			\n");
		
		System.out.println("(log) LsjMemberQueryMap.lsjMemberIdCheckQuery() <<<");
		return sb.toString();
	}// end of LsjMemberQueryMap.lsjMemberIdCheckQuery()
	
	public static String lsjMemberSelectSearchQuery(){
		System.out.println("(log) LsjMemberQueryMap.lsjMemberSelectSearchQuery() >>>");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT							\n");
		sb.append(" 	 A.LMEM			LMEM		\n");
		sb.append("     ,A.LID			LID			\n");
		sb.append("     ,A.LPW			LPW			\n");
		sb.append("     ,A.LNAME		LNAME		\n");
		sb.append("     ,A.LGENDER		LGENDER		\n");
		sb.append("     ,A.LBIRTH		LBIRTH		\n");
		sb.append("     ,A.LEMAIL		LEMAIL		\n");
		sb.append("     ,A.LHP			LHP			\n");
		sb.append("     ,A.LPOSTNO		LPOSTNO		\n");
		sb.append("     ,A.LADDR		LADDR		\n");
		sb.append(" 	,A.LIMAGE		LIMAGE		\n");
		sb.append("     ,A.LDELETEYN	LDELETEYN	\n");
		sb.append("     ,TO_CHAR(A.LINSERTDATE, 'YYYY-MM-DD') LINSERTDATE	\n");
		sb.append("     ,TO_CHAR(A.LUPDATEDATE, 'YYYY-MM-DD') LUPDATEDATE	\n");
		sb.append(" FROM	MEMBER_LSJ_MVC2 A		\n");
		sb.append(" WHERE	1=1						\n");
		sb.append(" AND A.LMEM = ?					\n");
		sb.append(" AND A.LDELETEYN = 'Y'			\n");
		sb.append(" ORDER BY 1						\n");
		
		System.out.println("(log) LsjMemberQueryMap.lsjMemberSelectSearchQuery() <<<");
		return sb.toString();
	}// end of LsjMemberQueryMap.lsjMemberSelectSearchQuery()
}
