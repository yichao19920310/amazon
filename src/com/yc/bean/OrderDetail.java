/**  
 * @Title: OrderDetail.java  
 * @Package com.yc.bean  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月23日  
 * @version V1.0  
*/  
package com.yc.bean;

/**  
 * @ClassName: OrderDetail  
 * @Description: 订单详情实体类 
 * @author admin  
 * @date 2018年1月23日  
 *    
*/
public class OrderDetail {
	
	private int hod_id;
	private int ho_id;
	private int hp_id;
	private int hod_quantity;
	private float hod_cost;
	private Product product;
	public int getHod_id() {
		return hod_id;
	}
	public void setHod_id(int hod_id) {
		this.hod_id = hod_id;
	}
	public OrderDetail(int hp_id, int hod_quantity, float hod_cost) {
		super();
		this.hp_id = hp_id;
		this.hod_quantity = hod_quantity;
		this.hod_cost = hod_cost;
	}
	public int getHo_id() {
		return ho_id;
	}
	public void setHo_id(int ho_id) {
		this.ho_id = ho_id;
	}
	public int getHp_id() {
		return hp_id;
	}
	public void setHp_id(int hp_id) {
		this.hp_id = hp_id;
	}
	public int getHod_quantity() {
		return hod_quantity;
	}
	public void setHod_quantity(int hod_quantity) {
		this.hod_quantity = hod_quantity;
	}
	public float getHod_cost() {
		return hod_cost;
	}
	public void setHod_cost(float hod_cost) {
		this.hod_cost = hod_cost;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrderDetail(int hod_id, int ho_id, int hp_id, int hod_quantity, float hod_cost) {
		super();
		this.hod_id = hod_id;
		this.ho_id = ho_id;
		this.hp_id = hp_id;
		this.hod_quantity = hod_quantity;
		this.hod_cost = hod_cost;
	}
	public OrderDetail() {
		super();
	}
	public OrderDetail(int ho_id, int hp_id, int hod_quantity, float hod_cost) {
		super();
		this.ho_id = ho_id;
		this.hp_id = hp_id;
		this.hod_quantity = hod_quantity;
		this.hod_cost = hod_cost;
	}
	@Override
	public String toString() {
		return "OrderDetail [hod_id=" + hod_id + ", ho_id=" + ho_id + ", hp_id=" + hp_id + ", hod_quantity="
				+ hod_quantity + ", hod_cost=" + hod_cost + "]";
	}
	
}
