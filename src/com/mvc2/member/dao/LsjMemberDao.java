package com.mvc2.member.dao;

import java.util.ArrayList;

import com.mvc2.member.vo.LsjMemberVO;

public interface LsjMemberDao {
	// insert, update, delete
	public boolean insertLsjMem(LsjMemberVO lvo);
	public boolean updateLsjMem(LsjMemberVO lvo);
	public boolean deleteLsjMem(LsjMemberVO lvo);
	
	// select, search, likeSearch
	public ArrayList<LsjMemberVO> selectLsjMem();
	public ArrayList<LsjMemberVO> searchLsjMem(LsjMemberVO lvo);
	public ArrayList<LsjMemberVO> likeSearchLsjMem(LsjMemberVO lvo);
	public ArrayList<LsjMemberVO> selectSearchLsjMem(LsjMemberVO lvo);
	
	// login
	public ArrayList<LsjMemberVO> loginLsjMem(LsjMemberVO lvo);
	
	// idCheck
	public int idCheckLsjMem(LsjMemberVO lvo);
}// end of LsjMemberDao interface
