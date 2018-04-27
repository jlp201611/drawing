package kr.co.mingyeong.attach.service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mingyeong.attach.mapper.IAttachMapper;
import kr.co.mingyeong.attach.service.IAttachService;
import kr.co.mingyeong.attach.vo.Attach;

@Service(value="IAttachService")
public class AttachServiceImpl implements IAttachService {
	
	@Autowired
	private IAttachMapper mapper;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
     
	/* (non-Javadoc)
	 * @see kr.co.mingyeong.attach.service.IAttachService#getAttach(int)
	 */
	@Override
	public Attach getAttach(int atch_id) {
		log.debug("getAttach => {}",atch_id);
    	Attach result = mapper.getAttach(atch_id);
    	log.debug("getAttach : result <= {}", result);
    	
		return result;
    }
    /* (non-Javadoc)
	 * @see kr.co.mingyeong.attach.service.IAttachService#increaseDownCnt(int)
	 */
    @Override
	public void increaseDownCnt(int atch_id) {
    	mapper.increaseDownCnt(atch_id);
    }
}
