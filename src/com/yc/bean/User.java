/**  
 * @Title: User.java  
 * @Package com.yc.bean  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author admin  
 * @date 2018年1月17日  
 * @version V1.0  
*/  
package com.yc.bean;

import java.sql.Date;

/**
 * 
 * @ClassName: User  
 * @Description: 用户实体类  
 * @author admin  
 * @date 2018年1月17日  
 *
 */
public class User {
	/*HU_USER_ID       NUMBER(10)  PRIMARY KEY,--用户id
	  HU_USER_NAME     VARCHAR2(20) not null,
	  HU_PASSWORD      VARCHAR2(20) not null,
	  HU_SEX           CHAR(2) not null,
	  HU_BIRTHDAY      DATE,
	  HU_IDENTITY_CODE VARCHAR2(60),
	  HU_EMAIL         VARCHAR2(80),
	  HU_MOBILE        VARCHAR2(11),
	  HU_ADDRESS       VARCHAR2(200) not null,
	  HU_STATUS        NUMBER(6) not null*/
	  private int hu_user_id;
	  private String hu_user_name;
	  private String hu_password;
	  private String hu_sex;
	  private Date hu_birthday;
	  private String hu_identity_Code;
	  private String hu_email;
	  private String hu_mobile;
	  private String hu_address;
	  private int hu_status;
	@Override
	public String toString() {
		return "User [hu_user_id=" + hu_user_id + ", hu_user_name=" + hu_user_name + ", hu_password=" + hu_password
				+ ", hu_sex=" + hu_sex + ", hu_birthday=" + hu_birthday + ", hu_identity_Code=" + hu_identity_Code
				+ ", hu_email=" + hu_email + ", hu_mobile=" + hu_mobile + ", hu_address=" + hu_address + ", hu_status="
				+ hu_status + "]";
	}
	public int getHu_user_id() {
		return hu_user_id;
	}
	public void setHu_user_id(int hu_user_id) {
		this.hu_user_id = hu_user_id;
	}
	public String getHu_user_name() {
		return hu_user_name;
	}
	public void setHu_user_name(String hu_user_name) {
		this.hu_user_name = hu_user_name;
	}
	public String getHu_password() {
		return hu_password;
	}
	public void setHu_password(String hu_password) {
		this.hu_password = hu_password;
	}
	public String getHu_sex() {
		return hu_sex;
	}
	public void setHu_sex(String hu_sex) {
		this.hu_sex = hu_sex;
	}
	public Date getHu_birthday() {
		return hu_birthday;
	}
	public void setHu_birthday(Date hu_birthday) {
		this.hu_birthday = hu_birthday;
	}
	public String getHu_identity_Code() {
		return hu_identity_Code;
	}
	public void setHu_identity_Code(String hu_identity_Code) {
		this.hu_identity_Code = hu_identity_Code;
	}
	public String getHu_email() {
		return hu_email;
	}
	public void setHu_email(String hu_email) {
		this.hu_email = hu_email;
	}
	public String getHu_mobile() {
		return hu_mobile;
	}
	public void setHu_mobile(String hu_mobile) {
		this.hu_mobile = hu_mobile;
	}
	public String getHu_address() {
		return hu_address;
	}
	public void setHu_address(String hu_address) {
		this.hu_address = hu_address;
	}
	public int getHu_status() {
		return hu_status;
	}
	public void setHu_status(int hu_status) {
		this.hu_status = hu_status;
	}
	public User(String hu_user_name, String hu_password) {
		super();
		this.hu_user_name = hu_user_name;
		this.hu_password = hu_password;
	}
	public User(String hu_user_name, String hu_password, String hu_sex, Date hu_birthday, String hu_identity_Code,
			String hu_email, String hu_mobile, String hu_address) {
		super();
		this.hu_user_name = hu_user_name;
		this.hu_password = hu_password;
		this.hu_sex = hu_sex;
		this.hu_birthday = hu_birthday;
		this.hu_identity_Code = hu_identity_Code;
		this.hu_email = hu_email;
		this.hu_mobile = hu_mobile;
		this.hu_address = hu_address;
	}
	public User() {
		super();
	}
	public User(int hu_user_id, String hu_user_name, String hu_password, String hu_sex, Date hu_birthday,
			String hu_identity_Code, String hu_email, String hu_mobile, String hu_address, int hu_status) {
		super();
		this.hu_user_id = hu_user_id;
		this.hu_user_name = hu_user_name;
		this.hu_password = hu_password;
		this.hu_sex = hu_sex;
		this.hu_birthday = hu_birthday;
		this.hu_identity_Code = hu_identity_Code;
		this.hu_email = hu_email;
		this.hu_mobile = hu_mobile;
		this.hu_address = hu_address;
		this.hu_status = hu_status;
	}
}
