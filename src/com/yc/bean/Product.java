/**  
 * @Title: Product.java  
 * @Package com.yc.bean  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月19日  
 * @version V1.0  
*/  
package com.yc.bean;

/**  
 * @ClassName: Product  
 * @Description: 商品实体类 
 * @author admin  
 * @date 2018年1月19日  
 *    
*/
public class Product {
	
	private int hp_id;
	private String hp_name;
	private String hp_description;
	private float hp_price;
	private int hp_stock;
	private int hpc_id;
	private int hpc_child_id;
	private String hp_file_name;
	private Category parent_category;
	private Category child_category;	
	public Category getParent_category() {
		return parent_category;
	}
	public void setParent_category(Category parent_category) {
		this.parent_category = parent_category;
	}
	public Category getChild_category() {
		return child_category;
	}
	public void setChild_category(Category child_category) {
		this.child_category = child_category;
	}
	public Product(int hp_id, String hp_name, String hp_description, float hp_price, int hp_stock, int hpc_id,
			int hpc_child_id, String hp_file_name) {
		super();
		this.hp_id = hp_id;
		this.hp_name = hp_name;
		this.hp_description = hp_description;
		this.hp_price = hp_price;
		this.hp_stock = hp_stock;
		this.hpc_id = hpc_id;
		this.hpc_child_id = hpc_child_id;
		this.hp_file_name = hp_file_name;
	}
	public Product() {
		super();
	}
	public int getHp_id() {
		return hp_id;
	}
	public void setHp_id(int hp_id) {
		this.hp_id = hp_id;
	}
	public String getHp_name() {
		return hp_name;
	}
	public void setHp_name(String hp_name) {
		this.hp_name = hp_name;
	}
	public String getHp_description() {
		return hp_description;
	}
	public void setHp_description(String hp_description) {
		this.hp_description = hp_description;
	}
	public float getHp_price() {
		return hp_price;
	}
	public void setHp_price(float hp_price) {
		this.hp_price = hp_price;
	}
	public int getHp_stock() {
		return hp_stock;
	}
	public void setHp_stock(int hp_stock) {
		this.hp_stock = hp_stock;
	}
	public int getHpc_id() {
		return hpc_id;
	}
	public void setHpc_id(int hpc_id) {
		this.hpc_id = hpc_id;
	}
	public int getHpc_child_id() {
		return hpc_child_id;
	}
	public void setHpc_child_id(int hpc_child_id) {
		this.hpc_child_id = hpc_child_id;
	}
	public String getHp_file_name() {
		return hp_file_name;
	}
	public void setHp_file_name(String hp_file_name) {
		this.hp_file_name = hp_file_name;
	}
	@Override
	public String toString() {
		return "Product [hp_id=" + hp_id + ", hp_name=" + hp_name + ", hp_description=" + hp_description + ", hp_price="
				+ hp_price + ", hp_stock=" + hp_stock + ", hpc_id=" + hpc_id + ", hpc_child_id=" + hpc_child_id
				+ ", hp_file_name=" + hp_file_name + "]";
	}
	
}
