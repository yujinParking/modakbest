package com.modak.user.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.modak.user.bean.UserAllDTO;
import com.modak.user.bean.UserDTO;

@Repository
@Transactional
public class UserDAOMyBatis implements UserDAO {
	//공통 영역 : 시작 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		@Autowired
		private SqlSession sqlSession;	

	//공통 영역 : 끝 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	//연수 : 시작(220706) ====================================
		@Override
		public UserAllDTO getUser(String user_email) {
			return sqlSession.selectOne("userSQL.getUser", user_email);
		}
		
	    //@@@@@@@@@@@@  연수 회원정보 수정창 전면수정(220710) @@@@@@@@@@@@
		@Override
		public UserAllDTO userUpdate_nicknameCheck(String user_nickname) {			
			return sqlSession.selectOne("userSQL.userUpdate_nicknameCheck", user_nickname);
		}

		@Override
		public UserAllDTO userUpdate_emailCheck(String user_email) {
			return sqlSession.selectOne("userSQL.userUpdate_emailCheck", user_email);
		}
	
		@Override
		public void update_userImg(UserAllDTO userAllDTO) {
			sqlSession.update("userSQL.update_userImg", userAllDTO);
			
		}
		
		@Override
		public void update_userInfo(UserAllDTO userAllDTO) {
			sqlSession.update("userSQL.update_userInfo", userAllDTO);			
		}

		@Override
		public void update_userEmail(Map<String, String> map) {
			sqlSession.update("userSQL.update_userEmail", map);
			
		}
	    //@@@@@@@@@@@@  연수 회원정보 수정창 전면수정(220710) @@@@@@@@@@@@

		@Override
		public UserDTO checkPwd(String user_email) {
			return sqlSession.selectOne("userSQL.checkPwd", user_email);
		}

		@Override
		public void pwdChangeComplete(Map<String, String> map) {
			sqlSession.update("userSQL.pwdChangeComplete", map);
			
		}
		
		@Override
		public void delete(String user_email) {
			sqlSession.delete("userSQL.delete", user_email);		
		}
	//연수 : 끝(220706)====================================

	
	//유진 : 시작 0706====================================
		@Override
		public void user_register(UserAllDTO userAllDTO) {
			sqlSession.insert("userSQL.user_register",userAllDTO);		
		}

		@Override
		public UserAllDTO userSignup_emailCheck(String user_email) {
			return sqlSession.selectOne("userSQL.userSignup_emailCheck",user_email);
		}
		
		@Override
		public UserAllDTO userSignup_nicknameCheck(String user_nickname) {		
			return sqlSession.selectOne("userSQL.userSignup_nicknameCheck", user_nickname);
		}

		@Override
		public UserDTO getUserInformation(String user_email) {
			return sqlSession.selectOne("userSQL.getUserInformation", user_email);
		}
		
	//유진 : 끝 0706====================================
	

	// 기진 : 시작  @@@@@@@@@@@@@@@@@@@@
		@Override
		public UserAllDTO login(String user_email) {
			return sqlSession.selectOne("userSQL.login", user_email);
		}
		
	// 기진 : 끝 @@@@@@@@@@@@@@@@@@@@@@@
	
	//풍혁 : 시작 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%	
		@Override
		public int getUserIdByEmail(String session_email) {
			
			return sqlSession.selectOne("userSQL.getUserIdByEmail", session_email);
		}
		
		@Override
		public String getUserNameByUserId(int board_uid) {
			
			return sqlSession.selectOne("userSQL.getUserNameByUserId",board_uid);
		}
	//풍혁 : 끝 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%	






}
