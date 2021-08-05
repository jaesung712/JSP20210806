package com.koreait.board;

public class BoardDTO {
	private int idx;
	private String userid;
	private String title;
	private String content;
	private String regdate;
	private int hit;
	private int like;
	private String file;
	int totalCount;
	int start;
	int pagePerCount;
	String pageNum;
	String replycnt_str;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPagePerCount() {
		return pagePerCount;
	}
	public void setPagePerCount(int pagePerCount) {
		this.pagePerCount = pagePerCount;
	}
	
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	
	public String getReplycnt_str() {
		return replycnt_str;
	}
	public void setReplycnt_str(String replycnt_str) {
		this.replycnt_str = replycnt_str;
	}
	@Override
	public String toString() {
		return "BoardDTO [idx=" + idx + ", userid=" + userid + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", hit=" + hit + ", like=" + like + ", file=" + file + ", totalCount="
				+ totalCount + ", start=" + start + ", pagePerCount=" + pagePerCount + ", pageNum=" + pageNum
				+ ", replycnt_str=" + replycnt_str + "]";
	}
	
	
	
	
	
}