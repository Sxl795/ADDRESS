package ssl;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

import ssl.UserDataBean;

public class PostManagerBean {
	private List<PostDataBean> postList;


	public List<PostDataBean> getPostList() {
		return postList;
	}


	public void setPostList(List<PostDataBean> postList) {
		this.postList = postList;
	}


	public  PostManagerBean(){
		postList=new LinkedList<PostDataBean>();
		postList.add(new PostDataBean("小王","153642255","北京"));
		postList.add(new PostDataBean("小孙","123453244","山东"));
		postList.add(new PostDataBean("小李","233456674","济南"));
	}
	public void postdelete(int id){
		Iterator<PostDataBean> iter=postList.iterator();
		while(iter.hasNext()){
			PostDataBean post=iter.next();
			if(post.getId()==id){
				iter.remove();
				break;
			}
		}
	}
	
	public boolean add(PostDataBean post){
		postList.add(post);
		return true;
	}
	
	public PostDataBean get(int id){
		Iterator<PostDataBean> iter=postList.iterator();
		while(iter.hasNext()){
			PostDataBean post=iter.next();
			if(post.getId()==id){
				return post;
			}
		}
		return null;
	}
	
	public PostDataBean get(String postername){
		Iterator<PostDataBean> iter=postList.iterator();
		while(iter.hasNext()){
			PostDataBean post=iter.next();
			if(post.getPostername().equals(postername)){
				return post;
			}
		}
		return null;
	}
	
	public void postmodify(PostDataBean postdata){
		PostDataBean post=get(postdata.getPostername());
		post.setPosttitle(postdata.getPosttitle());
		post.setPostconts(postdata.getPostconts());
		
	}
	
	public List<PostDataBean> postquery(PostQueryCondition postcond){
		List<PostDataBean> postresult=new LinkedList<PostDataBean>();
		
		Iterator<PostDataBean> iter=postList.iterator();
		while(iter.hasNext()){
			PostDataBean post=iter.next();
			if(postcond.postsatisfy(post)) postresult.add(post);
		}
		return postresult;
	}
	
}
