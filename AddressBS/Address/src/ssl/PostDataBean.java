package ssl;

public class PostDataBean {
	private static int currentId=0;
	private int id;
	private String postername;
	private String posttitle;
	private String postconts;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostername() {
		return postername;
	}
	public void setPostername(String postername) {
		this.postername = postername;
	}
	public String getPosttitle() {
		return posttitle;
	}
	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}
	public String getPostconts() {
		return postconts;
	}
	public void setPostconts(String postconts) {
		this.postconts = postconts;
	}
	
	public PostDataBean(String postername,String posttitle,String postconts){
		this();
		this.postername=postername;
		this.posttitle=posttitle;
		this.postconts=postconts;
	}
	public PostDataBean(){
		currentId ++;
		id=currentId;
	}
}
