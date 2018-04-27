package kr.co.mingyeong.photo.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.co.mingyeong.attach.vo.Attach;
import kr.co.mingyeong.common.FileSizeUtil;
import kr.co.mingyeong.member.model.Member;
import kr.co.mingyeong.photo.service.IPhotoService;

@Controller
public class PhotoController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "IPhotoService")
	private IPhotoService service;

	// 글등록
	@RequestMapping(value = "/photoInsert", method = RequestMethod.POST)
	public ModelAndView photoInsert(ModelAndView modelAndView, @RequestParam HashMap<String, Object> params,
			@RequestParam(value = "attachFiles", required = false) Part[] parts, HttpServletRequest req) {

		log.debug("photoInsert: 첨부파일 개수 => {}개", parts.length);

		// 세션에 저장되어 있는 정보 가져오기
		Member loginInfo = (Member) req.getSession().getAttribute("loginInfo");
		log.debug("loginInfo => {}", loginInfo);
		// 세션에값을 HashMap에 저장
		params.put("pt_mem_id", loginInfo.getMem_id());
		params.put("pt_ip", req.getRemoteAddr());
		log.debug("photoInsert:params => {}", params);
		// 첨부파일 start
		List<Attach> attachFiles = new ArrayList();
		// HashMap<String, Attach> attachFiles = new HashMap<>();
		try {
			// 첨부파일 Start
			if (parts != null) {
				int i = 0;
				for (Part part : parts) {
					if (part != null && StringUtils.isNotBlank(part.getSubmittedFileName())) {
						Attach attach = new Attach();
						attach.setAtch_mem_id(String.valueOf(params.get("pt_mem_id")));
						attach.setAtch_orig_name(part.getSubmittedFileName());
						attach.setAtch_file_size((int) part.getSize()); // long으로 했어야 했는데 잘못만들어서 int 로 형변환
						attach.setAtch_divsion(String.valueOf(params.get("atch_divsion")));// 이렇게 글씨로 쓰는건
						attach.setAtch_fancy_size(FileSizeUtil.fancySize(part.getSize()));
						attach.setAtch_content_type(part.getContentType());
						// 파일저장
						// 임시파일을 어디에 떨굴꺼냐?????
						// 지금은 임의로 그냥 랜덤으로 부여ㅎㅎㅎ
						Date date = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
						String yyyyMMdd = sdf.format(date);

						String save_name = String.format("%s_%s_%d.%s", attach.getAtch_mem_id(), yyyyMMdd, i++, part
								.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf(".") + 1)); // 저장할
																														// 파일
																														// 이름(날자기준,
																														// 파일명
																														// 기준등)
																														// 지금껀
																														// 대충만들었데ㅜㅜㅜㅜ
																														// 올라온
																														// 파일에
																														// 연월이를
																														// 붙여주거나
																														// 하는게
																														// 좋다

						String save_path = "D:\\Program Files\\Tomcat\\fileFolder\\photo";
						attach.setAtch_save_name(save_name);
						attach.setAtch_save_path(save_path);
						log.debug("파일정보 => {}", attach.toString());

						// 파일 저장

						String fileName = String.format("%s%s%s", save_path, File.separatorChar, save_name);
						FileUtils.copyInputStreamToFile(part.getInputStream(), new File(fileName));
						// 파일저장 END
						attachFiles.add(attach);
					} // if
				} // for
			} // if

			// 첨부파일end
			log.debug("attachFiles :: => {}", attachFiles);
			service.insertPhoto(params, attachFiles);
		} catch (Exception e) {
			// TODO 인서트 익셉션
			log.debug("익셉션 => {}", e);

		}
		RedirectView rdv = new RedirectView();
		rdv.setUrl("/photoList");
		modelAndView.setView(rdv);
		return modelAndView;
	}

	// 리스트
	@RequestMapping(value = "/photoList")
	public ModelAndView photoList(ModelAndView modelAndView, HttpServletRequest req) {

		try {
			// 세션에 저장되어 있는 정보 가져오기
			Member loginInfo = (Member) req.getSession().getAttribute("loginInfo");
			log.debug("loginInfo => {}", loginInfo);

			// 세션에값을 HashMap에 저장
			HashMap<String, Object> params = new HashMap();
			params.put("mem_id", loginInfo.getMem_id());
			log.debug("photoList =>{}", params);

			List<HashMap<String, Object>> result = service.getPhotoList(params);

			for (HashMap<String, Object> hashMap : result) {
				log.debug("==== {}", hashMap);
				log.debug("{}", hashMap.get("PT_CONTENT"));
			}

			log.debug("PhotoList : result => {}", result);
			modelAndView.addObject("result", result);
			modelAndView.setViewName("photo/photoList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RedirectView rev = new RedirectView();
			rev.setUrl("/");

			modelAndView.setView(rev);
		}

		return modelAndView;
	}

}
