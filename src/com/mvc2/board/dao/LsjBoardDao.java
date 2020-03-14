package com.mvc2.board.dao;

import java.util.ArrayList;

import com.mvc2.board.vo.LsjBoardVO;

public interface LsjBoardDao {
	// insert
	public int insertLsjBoard(LsjBoardVO lbvo);
	// update
	public int updateLsjBoard(LsjBoardVO lbvo);
	// delete
	public int deleteLsjBoard(LsjBoardVO lbvo);
	// selectAll
	public ArrayList<LsjBoardVO> selectAllLsjBoard();
	// select
	public ArrayList<LsjBoardVO> selectLsjBoard(LsjBoardVO lbvo);
}
