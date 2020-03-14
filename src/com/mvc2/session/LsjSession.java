package com.mvc2.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class LsjSession {
	
	/* user id 정보를 관리할 세션 이름 정의 */
	private static final String sessionID = "SESSIONID";
	
	/* kill session = 세션에 담긴 정보 지우기 */
	/*
		@param : lReq	servlet request
		@return : servlet request가 null이면 false return, 아니면 세션에 담긴 정보 지우고 true return
		@exception : Exception
	*/
	public static boolean killSession(final HttpServletRequest lReq) throws Exception{
		System.out.println("(log) killSession >>> ");
		
		if(lReq==null) return false;
		
		try{
			// session get
			HttpSession lSession = lReq.getSession(true);
			// kill
			lSession.invalidate();
		}catch(Exception e){
			// exception 던지기
			throw e;
		}
		
		System.out.println("(log) killSession <<< ");
		
		return true;
	}

	/* user id 정보 세션에 담음 */
	/*
		@param : lReq	servlet request
		@param : userID user id
		@return : servlet request가 null이면 false return, 아니면 세션에 담긴 정보 지우고 true return
		@exception : Exception
	*/
	public static boolean setSession(final HttpServletRequest lReq, final String userID) throws Exception{
		System.out.println("(log) setSession >>> ");
		
		if(lReq==null) return false;
		// user id null 또는 trim(앞 뒤 공백제거) 후 길이가 0이면 return false
		if(userID==null || userID.trim().length()==0) return false;
		
		HttpSession lSession = lReq.getSession(true);
		
		try{
			// 정보 관리할 세션이름, userid
			lSession.setAttribute(sessionID, userID);
			// 유효한 시간
			lSession.setMaxInactiveInterval(60*180);
		}catch(Exception e){
			throw e;
		}
		
		System.out.println("(log) setSession <<< ");
		
		return true;
	}
	
	/* user id 정보 세션에서 가져옴 */
	/*
		@param : lReq	servlet request
		@return : servlet request가 null이면 빈 문자열 return, 아니면 세션이 가지고 있는 user id return
		@exception : Exception
	*/
	public static String getSession(final HttpServletRequest lReq) throws Exception{
		System.out.println("(log) getSession >>> ");
		
		if(lReq==null) return "";
		
		String strSession;
		HttpSession lSession = lReq.getSession(false);
		
		try{
			strSession = (String)lSession.getAttribute(sessionID);
		}catch(Exception e){
			throw e;
		}
		
		System.out.println("(log) getSession <<< ");
		
		return strSession;
		
	}
}
