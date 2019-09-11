package offcn_filter02.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3P0Utils {
	
	private static DataSource ds;
	
	static{
		ds = new ComboPooledDataSource ("mysql");
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection(){
		
		Connection conn = null;
		
		try{
			conn = ds.getConnection();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}

}
