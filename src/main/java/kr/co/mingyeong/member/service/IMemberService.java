package kr.co.mingyeong.member.service;

import java.util.HashMap;
import java.util.List;

import kr.co.mingyeong.member.model.Member;
import kr.co.mingyeong.member.model.MemberSearch;

public interface IMemberService {
	
	//로그인
	public Member login(Member parmas) throws Exception;
	
	//리스트
	public List<Member> getMemberList(MemberSearch params);
	
	//상세보기
	public Member getMember(Member params) throws Exception;
	
	//관리자 회원 삭제
	public void adminDelete(Member params) throws Exception;
	
	//페이징
	public int getMemberCount(MemberSearch params);
	
	//회원가입
	public void insertMember(Member member) throws Exception;
	
	//아이디체크
	public int checkID(HashMap<String, Object> params) throws Exception;
	
}
