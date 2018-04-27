package kr.co.mingyeong.photo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IPhotoMapper {
	
	//글등록
	public void insertPhoto(HashMap<String, Object> params) throws Exception;
	
	//리스트
	public List<HashMap<String,Object>> getPhotoList(HashMap<String, Object> params);

}
