package kr.co.mingyeong.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mingyeong.member.model.Member;
import kr.co.mingyeong.member.model.MemberSearch;


@Mapper
public interface IMemberMapper {
	/**
	 * 로그인
	 * @param parmas
	 * @return
	 * @throws Exception
	 */
	public Member login(Member parmas) throws Exception;
	
	public List<Member> getMemberList(MemberSearch params);
	
	public Member getMember(Member params) throws Exception;
	
	public void adminDelete(Member params) throws Exception;
	
	//페이징
	public int getMemberCount(MemberSearch params);	
	
	//회원가입
	public void insertMember(Member params) throws Exception;
	
	//접속일
	public void loginAccess(String mem_id) throws Exception;
}
