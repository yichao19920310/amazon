/**  
 * @Title: news.java  
 * @Package com.yc.bean  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.bean;

import java.sql.Date;

/**  
 * @ClassName: news  
 * @Description: 新闻实体类
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public class News {
	
	private int hn_id;
	private String hn_title;
	private String hn_content;
	private Date hn_create_time;
	public News(int hn_id, String hn_title, String hn_content, Date hn_create_time) {
		super();
		this.hn_id = hn_id;
		this.hn_title = hn_title;
		this.hn_content = hn_content;
		this.hn_create_time = hn_create_time;
	}
	public News() {
		super();
	}
	public int getHn_id() {
		return hn_id;
	}
	public void setHn_id(int hn_id) {
		this.hn_id = hn_id;
	}
	public String getHn_title() {
		return hn_title;
	}
	public void setHn_title(String hn_title) {
		this.hn_title = hn_title;
	}
	public String getHn_content() {
		return hn_content;
	}
	public void setHn_content(String hn_content) {
		this.hn_content = hn_content;
	}
	public Date getHn_create_time() {
		return hn_create_time;
	}
	public void setHn_create_time(Date hn_create_time) {
		this.hn_create_time = hn_create_time;
	}
	@Override
	public String toString() {
		return "news [hn_id=" + hn_id + ", hn_title=" + hn_title + ", hn_content=" + hn_content + ", hn_create_time="
				+ hn_create_time + "]";
	}
	
}
