package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * @author amy
 * @date 2019/8/26 18:23
 */
public class C3P0Util {
    private static DataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource ( "mysql");
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
