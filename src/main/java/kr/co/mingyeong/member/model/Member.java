package kr.co.mingyeong.member.model;

public class Member {
	
	private String mem_id = "";
	private String mem_name = "";
	private String mem_pwd = "";
	private String mem_phone = "";
	private String mem_email = "";
	private String reg_date = "";
	private String access_date="";
	
	
	@Override
	public String toString() {
		String toString =  String.format("id:%s, pw:%s, name:%s, phone:%s, email:%s, reg_date:%s"
				,getMem_id(),getMem_pwd(),getMem_name(),getMem_phone(),getMem_email(),getReg_date());
		return toString;
	}
	
	public String getAccess_date() {
		return access_date;
	}

	public void setAccess_date(String access_date) {
		this.access_date = access_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

}
