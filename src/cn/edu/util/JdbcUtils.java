package cn.edu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ����ӹ����࣬ʹ��c3p0
 * @author wangfang
 *
 */
public class JdbcUtils {
	
	private static ComboPooledDataSource ds = null;
    //�ھ�̬������д������ݿ����ӳ�
    static{
        try{
            //ͨ�����봴��C3P0���ݿ����ӳ�
            /*ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcstudy");
            ds.setUser("root");
            ds.setPassword("XDP");
            ds.setInitialPoolSize(10);
            ds.setMinPoolSize(5);
            ds.setMaxPoolSize(20);*/
            
            //ͨ����ȡC3P0��xml�����ļ���������Դ��C3P0��xml�����ļ�c3p0-config.xml�������srcĿ¼��
            //ds = new ComboPooledDataSource();//ʹ��C3P0��Ĭ����������������Դ
            ds = new ComboPooledDataSource("MySQL");//ʹ��C3P0��������������������Դ
            
        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
    * @Method: getConnection
    * @Description: ������Դ�л�ȡ���ݿ�����
    * @Anthor:�°�����
    * @return Connection
    * @throws SQLException
    */ 
    public static Connection getConnection() throws SQLException{
        //������Դ�л�ȡ���ݿ�����
        return ds.getConnection();
    }
    
    /**
    * @Method: release
    * @Description: �ͷ���Դ��
    * �ͷŵ���Դ����Connection���ݿ����Ӷ��󣬸���ִ��SQL�����Statement���󣬴洢��ѯ�����ResultSet����
    * @Anthor:�°�����
    *
    * @param conn
    * @param st
    * @param rs
    */ 
    public static void release(Connection conn,Statement st,ResultSet rs){
        if(rs!=null){
            try{
                //�رմ洢��ѯ�����ResultSet����
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //�رո���ִ��SQL�����Statement����
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try{
                //��Connection���Ӷ��󻹸����ݿ����ӳ�
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	public static void main(String[] args) {
		Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //��ȡ���ݿ�����
            conn = JdbcUtils.getConnection();
            String sql = "insert into user(name, password, email, birthday) values(?,?,?,?)";
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "root4");
            st.setString(2, "root");
            st.setString(3, "root@163.com");
            st.setString(4, "2014-09-08");
            st.executeUpdate();
            //��ȡ���ݿ��Զ����ɵ�����
            rs = st.getGeneratedKeys();
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //�ͷ���Դ
            JdbcUtils.release(conn, st, rs);
        }

	}

}
