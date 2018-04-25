package kr.co.mingyeong.common;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSizeUtil {
	private static Logger log = LoggerFactory.getLogger(FileSizeUtil.class);
	// 파일 크기가 300byte 이면 -> 300byt  | 1024byte -> 1kb | 1024Kb -> 1Mb | 1024Mb -> 1Gb | 1024Gb -> 1Tb 
	
	public static String fancySize(double size) { //실수가 표현되지 않아서 double로 받음 /  정수 / 정수 를 나누었을경우 소숫점은 나오지 않음ㅋㅋㅋㅋㅋ
		log.debug("fancySize => {}",size);
		
		//1024 미만
		DecimalFormat df = new DecimalFormat("###,###.00"); //0.000000 이렇게 나올수 있으니까
		
		if(size < 1024) {
			return (long)size + "Bytes";

		}else if(size < (1024*1024)){ //1Kb면
			return df.format(size/1024) + "Kb";
		
		}else if (size < (1024*1024*1024)){	
			return df.format(size/(1024*1024)) + "Mb";
		
		}else {
			return df.format(size/(1024*1024*1024)) + "Gb";
		}
		
	}
	
	
}// class end
