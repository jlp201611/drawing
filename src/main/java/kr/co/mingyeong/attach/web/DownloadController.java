package kr.co.mingyeong.attach.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mingyeong.attach.service.IAttachService;
import kr.co.mingyeong.attach.vo.Attach;

@Controller
public class DownloadController {

	private Logger log = LoggerFactory.getLogger(DownloadController.class);
	
	@Resource(name="IAttachService")
	private IAttachService service;
		
	@RequestMapping("/fileFolder/photo/{atch_id}")
	public void download(@PathVariable("atch_id") int atch_id
			                , HttpServletResponse resp ) throws Exception{

		if( atch_id < 1){
			printMessage(resp, "정상적인 요청이 아닙니다.");
			return ;
		}
		
		// 서비스를 통해 첨부파일 가져오기 
		Attach result = service.getAttach(atch_id);	
		log.debug("download : result <= {} ",result);
		if(result == null){
			// 해당 첨부파일이 존재하지 않을 때
			printMessage(resp, "(첨부)해당 첨부파일이 존재하지 않습니다.");
			return;
		}		
		try {
			// 파일명 그대로 내보내면, 한글이 깨져보입니다.
			String fileName = new String( 
	                             result.getAtch_orig_name().getBytes("utf-8"),"iso-8859-1" );
			String saveFile = result.getAtch_save_path() + File.separatorChar + result.getAtch_save_name();
			log.info(saveFile);
			File f = new File(saveFile);
			if( ! f.isFile() ){
				printMessage(resp, "1111해당 첨부파일이 존재하지 않습니다.");
				return;
			}			
			// 브라우저에 파일을 내보내기위한 헤더 설정 
			resp.setHeader("Content-Type", "application/octet-stream;");
			resp.setHeader("Content-Disposition", "attachment;filename=\""+ fileName + "\";");		
			resp.setHeader("Content-Transfer-Encoding", "binary;");
			resp.setContentLength( (int)f.length() ); // 진행율
			resp.setHeader("Pragma", "no-cache;");
			resp.setHeader("Expires", "-1;");
			
			FileUtils.copyFile(f , resp.getOutputStream() );
			
			resp.getOutputStream().close();
/*			try {
				// 다운로드 횟수 증가 
				service.increaseDownCnt(atch_id);
			} catch (Exception e) {
				//e.printStackTrace();
				log.error(e.getMessage(), e);
			}*/
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			resp.reset();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500		
		}
		return;
	}
	
	private void printMessage(HttpServletResponse resp, String msg) throws Exception {
		resp.setCharacterEncoding("utf-8");		
		resp.setHeader("Content-Type", "text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script type='text/javascript'> ");
		out.println("alert('" + msg + "');             " );
		out.println("history.back();                   " );
		out.println("</script>                         " );
		out.println("<h4>첨부파일 문제 " + msg  +"</h4> ");
		out.println("<button onclick='history.back()'>뒤로이동</button>");
	}
	
	
}