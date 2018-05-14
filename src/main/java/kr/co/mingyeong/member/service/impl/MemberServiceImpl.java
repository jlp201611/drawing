package kr.co.mingyeong.member.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mingyeong.member.mapper.IMemberMapper;
import kr.co.mingyeong.member.model.Member;
import kr.co.mingyeong.member.model.MemberSearch;
import kr.co.mingyeong.member.service.IMemberService;

@Service("MemberService")
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	private IMemberMapper mapper;
		
	private Logger log = LoggerFactory.getLogger(this.getClass());

	//페이징
	@Override
	public int getMemberCount(MemberSearch params) {
		int resutl = mapper.getMemberCount(params);
		log.debug("result <= {}",String.valueOf(resutl));
		return resutl;
	}	
	
	@Override
	public Member login(Member parmas) throws Exception {
		Member result = mapper.login(parmas);
		mapper.loginAccess(parmas.getMem_id());
		log.debug("result <= {}",result);
		return result;
	}

	//리스트
	@Override
	public List<Member> getMemberList(MemberSearch memberSearch) {
		List<Member> resutl = mapper.getMemberList(memberSearch);
		log.debug("result <= {}",resutl);
		return resutl;
	}

	@Override
	public Member getMember(Member params) throws Exception {
		log.debug("getMember => mem_id : {}",params.getMem_id());
		Member result = mapper.getMember(params);
		return result;
	}

	@Override
	public void adminDelete(Member params) throws Exception {
		mapper.adminDelete(params);
		
	}

	@Override
	public void insertMember(Member params) throws Exception {
		mapper.insertMember(params);
		
	}

	@Override
	public int checkID(HashMap<String, Object> params) throws Exception {
		int result = mapper.checkID(params);
		log.debug("아이디체크< = {}", result);
		return result;
	}
	

	
	

}
