package com.mvc2.board.vo;

public class LsjBoardVO {
	private String lno;
	private String lsubject;
	private String lname;
	private String lpw;
	private String lmemo;
	private String limage;
	private String ldeleteyn;
	private String linsertdate;
	private String lupdatedate;
	public String getLno() {
		return lno;
	}
	public void setLno(String lno) {
		this.lno = lno;
	}
	public String getLsubject() {
		return lsubject;
	}
	public void setLsubject(String lsubject) {
		this.lsubject = lsubject;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLpw() {
		return lpw;
	}
	public void setLpw(String lpw) {
		this.lpw = lpw;
	}
	public String getLmemo() {
		return lmemo;
	}
	public void setLmemo(String lmemo) {
		this.lmemo = lmemo;
	}
	public String getLimage() {
		return limage;
	}
	public void setLimage(String limage) {
		this.limage = limage;
	}
	public String getLdeleteyn() {
		return ldeleteyn;
	}
	public void setLdeleteyn(String ldeleteyn) {
		this.ldeleteyn = ldeleteyn;
	}
	public String getLinsertdate() {
		return linsertdate;
	}
	public void setLinsertdate(String linsertdate) {
		this.linsertdate = linsertdate;
	}
	public String getLupdatedate() {
		return lupdatedate;
	}
	public void setLupdatedate(String lupdatedate) {
		this.lupdatedate = lupdatedate;
	}
	
	@Override
	public String toString() {
		return "LsjBoardVO [lno=" + lno + ", lsubject=" + lsubject + ", lname=" + lname + ", lpw=" + lpw + ", lmemo="
				+ lmemo + ", limage=" + limage + ", ldeleteyn=" + ldeleteyn + ", linsertdate=" + linsertdate
				+ ", lupdatedate=" + lupdatedate + "]";
	}
}
