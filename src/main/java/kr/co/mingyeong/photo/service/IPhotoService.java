package kr.co.mingyeong.photo.service;

import java.util.HashMap;
import java.util.List;

import kr.co.mingyeong.attach.vo.Attach;

public interface IPhotoService {
	//사진등록
	public void insertPhoto(HashMap<String, Object> params, List<Attach> attachFiles) throws Exception;
	
	//리스트
	public List<HashMap<String, Object>> getPhotoList(HashMap<String, Object> params);

}
