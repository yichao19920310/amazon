package com.yc.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author Administrator
 *
 */
public class DbHelper {

	// --�½ڿ� ʹ��Properties�����ļ�.���ĸ������Ƶ������ļ���.
	

	private Connection mConnection;

	/**
	 * ���غ����ݿ�����Ӷ���.
	 * 
	 * @return
	 */
	public Connection getConnection() {
		if (mConnection == null) {
			
			try {
				Properties p = new Properties();
				File f = new File("configs/config.properties");
				InputStream is = new FileInputStream(f);
				p.load(is);
				String driver =p.getProperty("DRIVER");
				String url =p.getProperty("URL");
				String user =p.getProperty("USER");
				String pwd =p.getProperty("PWD");
				// --Ϊ�˼������.�ǿ��Բ�д��.Ŀ���Ǽ�������.
				Class.forName(driver);
				mConnection = DriverManager.getConnection(url, user, pwd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {				
				e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}

		return mConnection;

	}

}
