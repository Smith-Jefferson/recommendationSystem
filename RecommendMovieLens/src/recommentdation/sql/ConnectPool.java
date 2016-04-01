package recommentdation.sql;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.activation.DataSource;

/**
 * 实现DataSource接口的简单连接池
 */
public class ConnectPool implements DataSource {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/movielens";  
	private static final String user = "root";
	private static final String pswd = "root";
 
	// 连接池队列
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	private static ConnectPool instance = new ConnectPool();
 
	/**
	 * 获取数据源单例
	 */
	public static ConnectPool instance() {
		if (instance == null)
			instance = new ConnectPool();
		return instance;
	}
 
	/**
	 * 获取一个数据库连接
	 */
	public Connection getConnection() throws SQLException {
		synchronized (pool) {
			if (pool.size() > 0) {
				return pool.removeFirst();
			} else {
				return DriverManager.getConnection(url, user, pswd);
			}
		}
	}
 
	/**
	 * 连接归池，这里的实现思想是使用过的线程入池以备下次使用
	 */
	public static void freeConnection(Connection conn) {
		pool.addLast(conn);
	}
 
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
 
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
 
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
 
	}
 
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
 
	}
 
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
 
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
 
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
 
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}