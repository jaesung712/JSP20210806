package com.koreait.reply;

public class ReplyDTO {
	private int reidx;
	private String userid;
	private String content;
	private String regdate;
	private int boardidx;
	public int getReidx() {
		return reidx;
	}
	public void setReidx(int reidx) {
		this.reidx = reidx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public int getBoardidx() {
		return boardidx;
	}
	public void setBoardidx(int boardidx) {
		this.boardidx = boardidx;
	}
	@Override
	public String toString() {
		return "ReplyDTO [reidx=" + reidx + ", userid=" + userid + ", content=" + content + ", regdate=" + regdate
				+ ", boardidx=" + boardidx + "]";
	}
	
	
}
