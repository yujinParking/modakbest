package com.modak.board.service;

import java.util.List;
import java.util.Map;

import com.modak.board.bean.BoardDTO;
import com.modak.board.bean.BoardAllDTO;

public interface BoardService {
	
	//공통 영역: 시작 =================================
	//공통 영역: 끝 =================================

	//풍혁 : 시작 =================================
		public String getUserWriteTablelist(int pg, String sortOption);
		
		public String getUserSearchWriteTablelist(int pg, String keyword, String sortOption);
		
		public String getBoardPagingList(int pg, String sortOption);
		
		public void boardWrite(BoardDTO boardDTO);
		
		public String getBoardSearchPagingList(int pg, String keyword, String sortOption);
		
//		public String getHomeBoardList(int boardNum);
		
		public String getUserNameByUserId(int board_uid);

//		public String getBoardSortList(String sortOption);
	
		public void update(Map<String, String> map);
	//풍혁 : 끝 =================================

	
	// 정수 : 시작  ###################### 
		// 글번호로 (글번호, DTO) 가져오기
		public BoardDTO getBoardContent(int board_id);
		
		public List<BoardDTO> getBoardReviewList(Map<String,Integer> map);

		public int recommendCheck(Map<String, Object> map);

		public void increaseRecommend(Map<String, Object> map);

		public void recommendCancel(Map<String, Object> map);

		public void addVote(Map<String, Object> map);

		public void deleteVote(Map<String, Object> map);

		public BoardDTO boardEditForm(int board_id);

		public void boardEdit(BoardDTO boardDTO);

		public void boardDelete(int board_id);

		
	// 정수 : 끝  ###################### 

		
		// 기진 " 시작 ##########################			
		 
    public List<BoardAllDTO> getBoardAllList(); 
		public List<BoardDTO> getUserPageArticle(Map<String, Object> map);

		// 기진 " 끝 ##########################			

}
