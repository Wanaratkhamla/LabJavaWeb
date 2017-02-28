package Model;

public class Forum {
	private int fid;
	private String detail;
	private String author;
	private int love;
	private String post_date;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public String getPost_date() {
		return post_date;
	}
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
}
