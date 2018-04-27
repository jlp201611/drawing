package kr.co.mingyeong.attach.vo;

public class Attach {
	
	//맵버필드
	private int atch_id;
	private int atch_ref_no;
	private String atch_divsion = "";
	private String atch_save_path = "";
	private String atch_save_name = "";
	private String atch_orig_name = "";
	private int atch_file_size;
	private String atch_fancy_size = "";
	private String atch_content_type = "";
	private int atch_down_cnt;
	private String atch_reg_date = "";
	private String atch_photo_rep = "";
	private String atch_mem_id = "";
	
	
	public String getAtch_mem_id() {
		return atch_mem_id;
	}


	public void setAtch_mem_id(String atch_mem_id) {
		this.atch_mem_id = atch_mem_id;
	}


	//투스트링
	@Override
	public String toString() {
		
		String toString = String.format(""
				+ "ATCH_ID : %d"
				+ " , ATCH_REF_NO : %d"
				+ " , ATCH_DIVSION : %s"
				+ " , ATCH_SAVE_PATH : %s"
				+ " , ATCH_SAVE_NAME : %s"
				+ " , ATCH_ORIG_NAME : %s"
				+ " , ATCH_FILE_SIZE : %d"
				+ " , ATCH_FANCY_SIZE : %s"
				+ " , ATCH_CONTENT_TYPE : %s"
				+ " , ATCH_DOWN_CNT : %d"
				+ " , ATCH_REG_DATE : %s"
				+ " , ATCH_PHOTO_REP : %s ", 
				 getAtch_id()
				,getAtch_ref_no()
				,getAtch_divsion()
				,getAtch_save_path()
				,getAtch_save_name()
				,getAtch_orig_name()
				,getAtch_file_size()
				,getAtch_fancy_size()
				,getAtch_content_type()
				,getAtch_down_cnt()
				,getAtch_reg_date()
				,getAtch_photo_rep()
				);
		
		return toString;
	}
	
	
	//게터세터
	public int getAtch_id() {
		return atch_id;
	}
	public void setAtch_id(int atch_id) {
		this.atch_id = atch_id;
	}
	public int getAtch_ref_no() {
		return atch_ref_no;
	}
	public void setAtch_ref_no(int atch_ref_no) {
		this.atch_ref_no = atch_ref_no;
	}
	public String getAtch_divsion() {
		return atch_divsion;
	}
	public void setAtch_divsion(String atch_divsion) {
		this.atch_divsion = atch_divsion;
	}
	public String getAtch_save_path() {
		return atch_save_path;
	}
	public void setAtch_save_path(String atch_save_path) {
		this.atch_save_path = atch_save_path;
	}
	public String getAtch_save_name() {
		return atch_save_name;
	}
	public void setAtch_save_name(String atch_save_name) {
		this.atch_save_name = atch_save_name;
	}
	public String getAtch_orig_name() {
		return atch_orig_name;
	}
	public void setAtch_orig_name(String atch_orig_name) {
		this.atch_orig_name = atch_orig_name;
	}
	public int getAtch_file_size() {
		return atch_file_size;
	}
	public void setAtch_file_size(int atch_file_size) {
		this.atch_file_size = atch_file_size;
	}
	public String getAtch_fancy_size() {
		return atch_fancy_size;
	}
	public void setAtch_fancy_size(String atch_fancy_size) {
		this.atch_fancy_size = atch_fancy_size;
	}
	public String getAtch_content_type() {
		return atch_content_type;
	}
	public void setAtch_content_type(String atch_content_type) {
		this.atch_content_type = atch_content_type;
	}
	public int getAtch_down_cnt() {
		return atch_down_cnt;
	}
	public void setAtch_down_cnt(int atch_down_cnt) {
		this.atch_down_cnt = atch_down_cnt;
	}
	public String getAtch_reg_date() {
		return atch_reg_date;
	}
	public void setAtch_reg_date(String atch_reg_date) {
		this.atch_reg_date = atch_reg_date;
	}
	public String getAtch_photo_rep() {
		return atch_photo_rep;
	}
	public void setAtch_photo_rep(String atch_photo_rep) {
		this.atch_photo_rep = atch_photo_rep;
	}	
	
	

	
}
