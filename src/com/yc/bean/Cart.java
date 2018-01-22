/**  
 * @Title: Cart.java  
 * @Package com.yc.bean  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月22日  
 * @version V1.0  
*/  
package com.yc.bean;

/**  
 * @ClassName: Cart  
 * @Description: 购物车实体类  
 * @author admin  
 * @date 2018年1月22日  
 *    
*/
public class Cart {

	private int id;
	private int pid;
	private int quantity;
	private int userId;
	private Product product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart(int id, int pid, int quantity, int userId) {
		super();
		this.id = id;
		this.pid = pid;
		this.quantity = quantity;
		this.userId = userId;
	}
	public Cart() {
		super();
	}
	public Cart(int pid, int quantity, int userId) {
		super();
		this.pid = pid;
		this.quantity = quantity;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", pid=" + pid + ", quantity=" + quantity + ", userId=" + userId + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
