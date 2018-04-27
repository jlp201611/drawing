package kr.co.mingyeong.attach.service;

import kr.co.mingyeong.attach.vo.Attach;

public interface IAttachService {

	Attach getAttach(int atch_id);

	void increaseDownCnt(int atch_id);

}