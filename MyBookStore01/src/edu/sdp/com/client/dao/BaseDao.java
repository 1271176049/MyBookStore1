package edu.sdp.com.client.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.sdp.com.utils.JdbcUtils;

/**
 * CRUD的工具类，其它dao的实现类通过继承它，来调用它的方法
 * <p>
 * 内部使用dbUtils.jar提供的QueryRunner对象执行sql语句
 * <p>
 * 实现类只需要继承它，然后调用父类响应的方法，并将sql语句和参数传入即可
 * <p>
 * 该类最终要的作用就是通过获取泛型来确定dao的实现类要得到的结果
 * 
 * @author 王大锤
 *
 */
public class BaseDao<T> {
	private QueryRunner queryRunner = new QueryRunner();
	private Class<T> type;

	// 在子类创建对象的时候，调用父类的构造器
	// 获取泛型
	@SuppressWarnings("unchecked")
	public BaseDao() {
		// 获取运行时类型，就是子类的类型
		@SuppressWarnings("rawtypes")
		Class<? extends BaseDao> class1 = this.getClass();
		// 获取父类类型
		ParameterizedType genericSuperclass = (ParameterizedType) class1.getGenericSuperclass();
		// 获取具体的泛型的类型
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		//
		this.type = (Class<T>) actualTypeArguments[0];
	}

	// 获取List集合
	public List<T> getBeanList(String sql, Object... params) {
		Connection connection = JdbcUtils.getConnection();
		List<T> query = null;
		try {
			// BeanListHandler<T> implements ResultSetHandler<List<T>>
			query = queryRunner.query(connection, sql, new BeanListHandler<>(type), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			// 关闭数据库链接
			// JdbcUtils.closeConnection(connection);
		}
		return query;
	}

	// 获取单一值
	public Object getSingleValue(String sql, Object... params) {
		Connection conn = JdbcUtils.getConnection();
		Object object = null;
		try {
			object = queryRunner.query(conn, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return object;
	}

	// 通用的增删改
	public void update(String sql, Object... params) {
		Connection connection = JdbcUtils.getConnection();
		try {
			queryRunner.update(connection, sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			// JdbcUtils.closeConnection(connection);
		}
	}

	/**
	 * 批量操作
	 * 
	 * @param sql
	 * @param params
	 */
	public void batch(String sql, Object[][] params) {
		// 获取连接
		Connection connection = JdbcUtils.getConnection();
		try {
			queryRunner.batch(connection, sql, params);
		} catch (SQLException e) {
			// 将编译时异常转换为运行时异常
			throw new RuntimeException(e);
		} finally {
			// JDBCUtils.releaseConnection(connection);
		}

	}

	// 获取一个对象
	public T getBean(String sql, Object... params) {
		Connection connection = JdbcUtils.getConnection();
		T query = null;
		try {
			query = queryRunner.query(connection, sql, new BeanHandler<>(type), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			// JdbcUtils.closeConnection(connection);
		}
		return query;
	}
}
