package nju.iip.POS;

import java.util.ArrayList;
import java.util.List;


/**
 * @description 帖子类
 * @author wangqiang
 * @since 2014-11-7
 */
public class Post {
	/**
	 * 帖子对应的词序列
	 */
	private List<String>words_sequence;
	
	/**
	 * 帖子所属类别
	 */
	private String post_id;
	
	
	
	
	/**
	 * @description 构造函数
	 * @param id
	 * @param word_list
	 */
	public Post(String id,List<String> word_list){
		this.post_id=id;
		this.words_sequence=word_list;
	}
	
	/**
	 * @decription 返回帖子词序列
	 * @return
	 */
	public List<String>get_words_sequence(){
		return this.words_sequence;
	}
	
	
	/**
	 * @decription 返回帖子所属类别
	 * @return
	 */
	public String get_post_id(){
		return this.post_id;
	}
	
	
	

}
