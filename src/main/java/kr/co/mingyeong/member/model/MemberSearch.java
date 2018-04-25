package kr.co.mingyeong.member.model;

import kr.co.mingyeong.common.Paging;

public class MemberSearch extends Paging {

	private String searchWord = "";
	private String searchType = "";
	
	@Override
	public String toString() {
		String toString =  String.format("totalRowCount:%s, totalPageCount:%s, listSize:%s, startRow:%s, endRow:%s,"
										+ "currentPage:%s,startPage:%s,endPage:%s,pageSize:%s,"
										+ " searchType:%s, searchWord:%s"
						,getTotalRowCount(),getTotalPageCount(),getListSize(),getStartRow(),getEndRow(),getCurrentPage(),getStartPage(),getEndPage(),getPageSize(),getSearchType(),getSearchWord());
		return toString;
	}
	
	
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
}
