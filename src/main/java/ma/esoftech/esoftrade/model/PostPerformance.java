package ma.esoftech.esoftrade.model;

public class PostPerformance {

	private long time=0;
	private Poste post;
	public PostPerformance(long time, Poste post) {
		super();
		this.time = time;
		this.post = post;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public Poste getPost() {
		return post;
	}
	public void setPost(Poste post) {
		this.post = post;
	}
	
}
