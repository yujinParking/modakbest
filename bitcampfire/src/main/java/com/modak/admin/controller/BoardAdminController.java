package com.modak.admin.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modak.board.bean.BoardDTO;
import com.modak.board.service.BoardService;

@Controller
@RequestMapping(value = "admin")
public class BoardAdminController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "adminBoardAllList")
	public String adminBoardAllList() {
		//System.out.println("adminBoardAllList 왔따!!!!!");
		return "/admin/adminBoardAllList";
	}
	
	// board 정보 전체 가져오기
	@PostMapping(value = "getBoardAllList")
	@ResponseBody // 에이작스로 간다.
	public List<BoardDTO> adminAllList() { 
		
			List<BoardDTO> list = new ArrayList<>();
			
			List<BoardDTO> informList = boardService.informList();
			List<BoardDTO> reviewList = boardService.reviewList(); 
			List<BoardDTO> qnaList = boardService.qnaList();
			List<BoardDTO> freeList = boardService.freeList(); 
			
			
			// list 합침. 
			list.addAll(informList); 
			list.addAll(reviewList);
			list.addAll(qnaList);
			list.addAll(freeList);
			
			for(BoardDTO dto: list) {
				System.out.println(dto);
			}
			
			//System.out.println("@@@@@@@@@@@@@@list.get(0).getBoard_date_created()" +list.get(0).getBoard_date_created() );
			
			Collections.sort(list);
			
//			Map<String, List<BoardAllDTO>> map = new HashMap<>();
//			map.put("informList", informList);
//			map.put("reviewList", reviewList); // 앞에있는 건 key, 
//			map.put("qnaList", qnaList);
//			map.put("freeList", freeList);
		return list;
		
	}
}








