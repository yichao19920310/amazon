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
	  private Date birthday;
	  private String hu_identity_Code;
	  private String hu_email;
	  private String hu_mobile;
	  private String hu_address;
	  private int hu_status;
}
