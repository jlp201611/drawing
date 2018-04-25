package kr.co.mingyeong.board.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BoardController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping(value="/photoProc", method=RequestMethod.POST)
	public ModelAndView photoInsert(ModelAndView modelAndView, HashMap<String, Object> params) {
		log.debug("photoInsert => {}", params );
		
		RedirectView rdv = new RedirectView();
		
		rdv.setUrl("/photoList");
		modelAndView.setView(rdv);
		return modelAndView;
	}

}
