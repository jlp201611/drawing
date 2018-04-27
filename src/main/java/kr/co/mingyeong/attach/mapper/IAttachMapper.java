package kr.co.mingyeong.attach.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mingyeong.attach.vo.Attach;


/**
 * 첨부파일 처리 DAO<br>
 * MyBatis에 자동매핑 설정을 사용하므로, 인터페스 구현체는 생성안함
 * @author pc33
 */

@Mapper
public interface IAttachMapper {
	
	int insertAttach(Attach attach);
	int deleteAttach(int atch_id);
	/**
	 * 마스트테이블(게시판관련)
	 * @param atch_ref_no
	 * @return
	 */
	List<Attach> getAttachListByRefNo(int atch_ref_no);//상세보기시 글에 딸린 첨부파일을 보여 줘야 하기 때문에 글번호를 받아서 첨부파일을 찾는다
	
	
	
	//포토 게시판은 그냥 바로 저장만 하면 된다...???왜???
	/**
	 * 파일 다운로드<br>
	 * 해당 첨부파일 조회
	 * @param atch_id
	 * @return
	 */
	Attach getAttach(int atch_id);
	
	/**
	 * 다운로드 횟수증가
	 * @param atch_id
	 * @return
	 */
	int increaseDownCnt(int atch_id);
	

}
