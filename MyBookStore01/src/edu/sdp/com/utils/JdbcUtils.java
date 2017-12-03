package edu.sdp.com.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	// default-config，在c3p0的配置文件中，因为是使用默认的，所以不需要在ComboPooledDataSource中传入参数
	private static DataSource c3p0 = new ComboPooledDataSource();
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

	/**
	 * 通过数据源获取数据库链接对象
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection connection = threadLocal.get();
		if (connection == null) {
			try {
				connection = c3p0.getConnection();
				threadLocal.set(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return connection;
	}

	/**
	 * 关闭数据库链接，该方法只是将链接对象放到数据库连接池中，并没有销毁
	 * 
	 * @param connection
	 */
	public static void closeConnection(Connection connection) {
		connection = threadLocal.get();
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 清除当前线程中的map中存放的数据
		threadLocal.remove();

	}
}
