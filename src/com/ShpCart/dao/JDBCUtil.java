package com.ShpCart.dao;

import com.ShpCart.entity.Products;

import java.lang.reflect.*;
import java.sql.*;
import java.util.*;


public class JDBCUtil {
	

	public static String driver = "com.mysql.jdbc.Driver";

	public static String url = "jdbc:mysql://localhost:3306/ShpCartDB?serverTimezone=GMT&useSSL=false";

	public static String name = "root";

	public static String pwd = "123456";


	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, name, pwd);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public static void close(Connection conn,Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public static int execUpdate(String sql){

		Connection conn = getConn();

		Statement stmt = null;
		
		try {

			stmt = conn.createStatement();

			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{

			close(conn,stmt,null);
		}
		
		return 0;
	}
	

	public static int preparedUpdate(String sql,Object...args){

		Connection conn = getConn();

		PreparedStatement stmt = null;
		
		try {

			stmt = conn.prepareStatement(sql);
			

			for (int i = 0; i < args.length; i++) {
				stmt.setObject(i+1, args[i]);
			}
			

			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{

			close(conn,stmt,null);
		}
		
		return 0;
	}
	

	public static  <T> List<T> preparedQuery(Class<T> classObj,String sql,Object...args){
		Connection conn = getConn();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				stmt.setObject(i+1, args[i]);
			}
			rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			List<T> list = new ArrayList<T>();
			
			while(rs.next()){
				T obj = (T)classObj.getConstructor().newInstance();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String fieldName = rsmd.getColumnName(i);
					Field field = classObj.getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(obj, rs.getObject(i));
				}
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{

			close(conn,stmt,rs);
		}
		
		return null;
	}
	
	/*
	//ִ�в�ѯ�ķ���(Ԥ�����ע��)
	public static <T> List<T> preparedQuery(Class<T> classObj,String sql,Object...args){
		//��ȡ���Ӷ���
		Connection conn = getConn();
		//�������ִ�ж���(Ԥ����)
		PreparedStatement stmt = null;
		//������������
		ResultSet rs = null;
		
		try {
			//��ȡ���ִ�ж���(Ԥ����)
			stmt = conn.prepareStatement(sql);
			
			//���ò���
			for (int i = 0; i < args.length; i++) {
				stmt.setObject(i+1, args[i]);
			}
			
			//���ͽ��յ�����䵽���ݿⲢִ��
			rs = stmt.executeQuery();
			
			//��ȡ���������������Ϣ�Ķ���
			ResultSetMetaData rsmd = rs.getMetaData();
			
			List<T> list = new ArrayList<T>();
			
			while(rs.next()){
				//ͨ�����䶯̬��ȡ����Ϣ����������
				T obj = classObj.getConstructor().newInstance();
				//ѭ��һ��ȡ��ǰ�е�һ������
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					//��ȡ��i�е�����
					String dbFieldName = rsmd.getColumnName(i);
					//ͨ�������ȡ�������������
					Field[] fields = classObj.getDeclaredFields();
					
					for(Field field : fields){
						//�жϵ�ǰ�������Ƿ���FieldName���͵�ע��
						if(field.isAnnotationPresent(FieldName.class)){
							//��ȡע����Ϣ
							String fieldName = field.getAnnotation(FieldName.class).value();
							//�ж�ע���ֵ�Ƿ������ݿ����ֶ���һ��
							if(dbFieldName.equals(fieldName)){
								field.setAccessible(true);
								field.set(obj, rs.getObject(i));
								break;
							}
						}
					}
				}
				
				list.add(obj);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//�ͷ���Դ
			close(conn,stmt,rs);
		}
		
		return null;
	}
	*/
}
