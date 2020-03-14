package com.mvc2.member.vo;

public class LsjMemberVO {
	// 초기화
	private String lmem;
	private String lid;
	private String lpw;
	private String lname;
	private String lgender;
	private String lbirth;
	private String lemail;
	private String lhp;
	private String lpostno;
	private String laddr;
	private String laddr1;
	private String limage;
	private String ldeleteyn;
	private String linsertdate;
	private String lupdatedate;

	public String getLmem() {
		return lmem;
	}

	public void setLmem(String lmem) {
		this.lmem = lmem;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getLpw() {
		return lpw;
	}

	public void setLpw(String lpw) {
		this.lpw = lpw;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLgender() {
		return lgender;
	}

	public void setLgender(String lgender) {
		this.lgender = lgender;
	}

	public String getLbirth() {
		return lbirth;
	}

	public void setLbirth(String lbirth) {
		this.lbirth = lbirth;
	}

	public String getLemail() {
		return lemail;
	}

	public void setLemail(String lemail) {
		this.lemail = lemail;
	}

	public String getLhp() {
		return lhp;
	}

	public void setLhp(String lhp) {
		this.lhp = lhp;
	}

	public String getLpostno() {
		return lpostno;
	}

	public void setLpostno(String lpostno) {
		this.lpostno = lpostno;
	}

	public String getLaddr() {
		return laddr;
	}

	public void setLaddr(String laddr) {
		this.laddr = laddr;
	}

	public String getLaddr1() {
		return laddr1;
	}

	public void setLaddr1(String laddr1) {
		this.laddr1 = laddr1;
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
		return "LsjMemberVO [lmem=" + lmem + ", lid=" + lid + ", lpw=" + lpw + ", lname=" + lname + ", lgender="
				+ lgender + ", lbirth=" + lbirth + ", lemail=" + lemail + ", lhp=" + lhp + ", lpostno=" + lpostno
				+ ", laddr=" + laddr + ", laddr1=" + laddr1 + ",limage=" + limage + ", ldeleteyn=" + ldeleteyn
				+ ", linsertdate=" + linsertdate + ", lupdatedate=" + lupdatedate + "]";
	}

}
