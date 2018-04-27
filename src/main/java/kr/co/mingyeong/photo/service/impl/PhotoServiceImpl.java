package kr.co.mingyeong.photo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.attachment.AttachmentMarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mingyeong.attach.mapper.IAttachMapper;
import kr.co.mingyeong.attach.vo.Attach;
import kr.co.mingyeong.photo.mapper.IPhotoMapper;
import kr.co.mingyeong.photo.service.IPhotoService;

@Service("IPhotoService")
public class PhotoServiceImpl implements IPhotoService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private IPhotoMapper photomapper;
	
	@Autowired
	private IAttachMapper attachMapper;
	
	//사진등록
	@Override
	public void insertPhoto(HashMap<String, Object> params, List<Attach> attachFiles) throws Exception {
		log.debug("insertPhoto : params => {}",params);
		//포토게시판 등록
		photomapper.insertPhoto(params);
		//attachFiles.put("atch_ref_no", params.get("pt_no"));
		//파일첨부게시판 등록
		int i = 0;
		for(Attach attach : attachFiles) {
			attach.setAtch_ref_no((int)params.get("pt_no"));
			if(i == 0) {
				attach.setAtch_photo_rep("Y");
			}else {
				attach.setAtch_photo_rep("N");
			}
			i++;
			attachMapper.insertAttach(attach);
		}
	}

	@Override
	public List<HashMap<String, Object>> getPhotoList(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		log.debug("getPhotoList => {}", params);
		List<HashMap<String, Object>> result = new ArrayList();
		result = photomapper.getPhotoList(params);
		log.debug("getPhotoList : result <= {}", params);
		return result;
	}

}
