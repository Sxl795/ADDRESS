package ssl;

public class PostQueryCondition {
	private int postqueryField=1;
	private String postqueryValue="";
	
	public int getPostqueryField() {
		return postqueryField;
	}
	public void setPostqueryField(int postqueryField) {
		this.postqueryField = postqueryField;
	}
	public String getPostqueryValue() {
		return postqueryValue;
	}
	public void setPostqueryValue(String postqueryValue) {
		this.postqueryValue = postqueryValue;
	}

	public boolean postsatisfy(PostDataBean post){
		switch(postqueryField){
		case 1:return true;
		case 2:return post.getPostername().contains(postqueryValue);
		case 3:return post.getPosttitle().contains(postqueryValue);
		case 4:return post.getPostconts().contains(postqueryValue);
		}
		return false;
	}
}
