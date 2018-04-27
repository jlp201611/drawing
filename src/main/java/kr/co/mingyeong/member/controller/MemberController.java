package kr.co.mingyeong.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.mingyeong.member.model.Member;
import kr.co.mingyeong.member.model.MemberSearch;
import kr.co.mingyeong.member.service.IMemberService;

@Controller
public class MemberController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "MemberService")
	private IMemberService service;

	// 인덱스
	@RequestMapping("/")
	public ModelAndView index(ModelAndView modelAndView, HttpServletRequest req, HttpServletResponse resp) {
		Member loginInfo = (Member) req.getSession().getAttribute("loginInfo");
		log.debug("loginInfo => {}", loginInfo);
		log.debug("request.getServletContext() => {}", req.getServletContext());
		Boolean login = false;
		RedirectView rdv = new RedirectView();
		try {
			login = (Boolean) req.getSession().getAttribute("login");
			if (login) {
				modelAndView.setViewName("index");
			} else {
				rdv.setUrl("/login");
				modelAndView.setView(rdv);
			}
		} catch (NullPointerException e) {
			// TODO 로그인 유무 익셉션
			rdv.setUrl("/login");
			modelAndView.setView(rdv);
		} catch (Exception e) {
			// TODO: handle exception;
			e.printStackTrace();
			rdv.setUrl("/login");
			modelAndView.setView(rdv);
		}

		log.debug("로그인 유무 => {}", login);

		return modelAndView;
	}

	// 로그인페이지
	@RequestMapping(value = "/login")
	public ModelAndView logIn(ModelAndView modelAndView, @RequestParam HashMap<String, Object> params,
			HttpServletRequest req) {
		log.debug("loginInfo => {}", String.valueOf(req.getSession().getAttribute("loginInfo")));

		if (StringUtils.isEmpty(req.getSession().getAttribute("loginInfo"))) { // 로그인 정보가 없다면
			modelAndView.setViewName("login/login");
		} else { // 로그인되어있다면
			RedirectView rdv = new RedirectView();
			rdv.setUrl("/");
			modelAndView.setView(rdv);
		}
		;
		return modelAndView;
	}

	// 로그인 처리
	@RequestMapping(value = "/loginProc", method = RequestMethod.POST)
	public ModelAndView logInProd(ModelAndView modelAndView, Member params, HttpServletRequest req,
			HttpServletResponse resp) {
		log.debug("logInProd => {}", params.toString());

		RedirectView rdv = new RedirectView();
		try {
			Member loginInfo = service.login(params);
			if (StringUtils.isEmpty(loginInfo)) { // 로그인 실패
				req.getSession().setAttribute("login", false);
				rdv.setUrl("/login");
				modelAndView.setView(rdv);
				modelAndView.addObject("message", "아이디와 비밀번호를 확인해 주세요");
			} else { // 로그인 성공
				req.getSession().setAttribute("login", true);
				req.getSession().setAttribute("loginInfo", loginInfo);
				rdv.setUrl("/");
				modelAndView.setView(rdv);
			}
		} catch (Exception e) {
			// TODO loginProc 익셉션
			e.printStackTrace();
			log.error(e.getMessage(), 2);
			rdv.setUrl("/login");
			modelAndView.setView(rdv);
		}
		return modelAndView;
	}

	// 로그아웃
	@RequestMapping(value = "/logout")
	public ModelAndView logOut(ModelAndView modelAndView, HttpServletRequest req, HttpServletResponse resp) {

		req.getSession().setAttribute("login", false);
		req.getSession().setAttribute("loginInfo", null);
		RedirectView rdv = new RedirectView();
		rdv.setUrl("/login");
		modelAndView.setView(rdv);
		return modelAndView;
	}

	// 회원가입 폼
	@RequestMapping(value = "/join")
	public ModelAndView join(ModelAndView modelAndView) {
		modelAndView.setViewName("login/join");
		return modelAndView;
	}

	// 회원가입
	@RequestMapping(value = "/joinProc", method = RequestMethod.POST)
	public ModelAndView insertMember(ModelAndView modelAndView, Member member) {
		log.debug("join =>{}", member.toString());
		RedirectView rdv = new RedirectView();
		try {
			int checkId = service.checkID(member);
			if(checkId>=1) {
				rdv.setUrl("/join");
				modelAndView.addObject("checkID","아이디가 중복되었습니다.");
				modelAndView.setView(rdv);
			}else {
				service.insertMember(member);
				rdv.setUrl("/login");
				modelAndView.setView(rdv);
			}
		} catch (Exception e) {
			// TODO 회원가입 익셉션
			e.printStackTrace();
			rdv.setUrl("/join");
			modelAndView.setView(rdv);
		}
		return modelAndView;

	}

	// 아이디 중복체크
	
	@RequestMapping(value = "/checkID", method = RequestMethod.POST) // 리스폰스 해더에 Content-Type를 html/text가 아니라json으로
	public @ResponseBody String checkID(
			
			Member member, Model model) throws Exception {
		
		log.debug("dd => {}", model);
		log.debug("member => {}", member.toString());
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		try {
			int result = service.checkID(member);

			if (result >= 1 ? false : true) { // 아이디 중복
				map.put("result", true);
				map.put("message", "사용가능한 아이디 입니다.");
			} else { // 가입 가능 아이디
				map.put("result", false);
				map.put("message", "중복된 아이디 입니다");
			}

		} catch (Throwable e) {
			map.put("result", false);
			map.put("message", "중복체크 익셉션 발생" + e.getMessage());
		}
		return mapper.writeValueAsString(map);

	}

	// 회원리스트
	@RequestMapping("/memberList")
	public ModelAndView memberList(ModelAndView modelAndView, @ModelAttribute("search") MemberSearch memberSearch,
			HttpServletRequest request) {
		// 한페이지목록
		memberSearch.setListSize(10);
		memberSearch.setPageSize(5);
		memberSearch.setting(service.getMemberCount(memberSearch));
		log.debug("memberlist => {}", memberSearch.toString());
		List<Member> result = service.getMemberList(memberSearch);
		log.debug("result <= {}", result);

		modelAndView.addObject("result", result);
		modelAndView.setViewName("member/memberList");
		return modelAndView;
	}

	// 회원상세보기
	@RequestMapping("/memberView")
	public ModelAndView memberview(ModelAndView modelAndView, Member params, HttpServletRequest request) {
		try {
			if (StringUtils.isEmpty(params.getMem_id())) {
				modelAndView.addObject("msg", "아이디 값이 없음");
			} else {
				Member result = service.getMember(params);
				log.debug("result <= {}", result);
				modelAndView.addObject("result", result);
				modelAndView.setViewName("member/memberView");
			}
		} catch (Exception e) {
			// TODO 회원상세 익셉션
			e.printStackTrace();
		}
		return modelAndView;
	}

	// 관리자가 회원 삭제
	@RequestMapping(value = "/memberDeleteAdmin")
	public ModelAndView adminDelete(ModelAndView modelAndView, Member params) {
		log.debug("adminDelete => {}", params.toString());
		try {
			service.adminDelete(params);
			RedirectView rdv = new RedirectView();
			rdv.setUrl("/memberList");
			modelAndView.setView(rdv);
		} catch (Exception e) {
			// TODO 관리자 회원 삭제 익셉션
			e.printStackTrace();
		}
		return modelAndView;
	}
}
