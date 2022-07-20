package com.modak.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modak.comment.bean.CommentDTO;
import com.modak.comment.service.CommentService;
import com.modak.user.service.UserService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping(value = "comment")
public class CommentClassController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	

		@PostMapping(value = "commentClassWrite")
		@ResponseBody
		public void commentClassWrite(@ModelAttribute CommentDTO commentDTO) {
			
			commentService.commentClassWrite(commentDTO);
			commentService.increaseCommentCount(commentDTO.getCmt_bid());
			
			return ;
		}
		
		@PostMapping(value = "getClassCommentListByBoardId")
		@ResponseBody
		public List<CommentDTO> getClassCommentListByBoardId(@RequestParam int cmt_bid) {
			
			List<CommentDTO> list = commentService.getClassCommentListByBoardId(cmt_bid);
			
			return list;
		}

		
		@PostMapping(value = "getClassCommentContentById", produces = "application/text; charset=UTF-8")
		@ResponseBody
		public String getClassCommentContentById(@RequestParam int cmt_id) {
			
			return commentService.getClassCommentContentById(cmt_id);
		}
		
		@PostMapping(value = "commentClassUpdate")
		@ResponseBody
		public void commentClassUpdate(@RequestParam int cmt_id, @RequestParam String cmt_content) {
			
			System.out.println("\n @LOG@ comment...commentClassUpdate : " + cmt_id + " cmt_ content : "+ cmt_content);
			commentService.commentClassUpdate(cmt_id, cmt_content);
			
			return ;
		}
		
		@PostMapping(value = "commentClassDelete")
		@ResponseBody
		public void commentClassDelete(@RequestParam int cmt_id, @RequestParam int cmt_bid) {
			
			System.out.println("\n @LOG@ comment...delete : " + cmt_id + cmt_bid);
			
			commentService.commentClassDelete(cmt_id);
			commentService.decreaseCommentCount(cmt_bid);
			
			return ;
		}
		
	
}