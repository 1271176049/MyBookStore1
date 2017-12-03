package edu.sdp.com.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdp.com.manager.filter.HttpFilter;
import edu.sdp.com.utils.JdbcUtils;

public class TransactionFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest reqeust, HttpServletResponse response, FilterChain chain) {
		// 从当前线程中获取链接，确保链接的唯一性
		Connection connection = JdbcUtils.getConnection();

		try {
			// 开启链接
			connection.setAutoCommit(false);
			// 放行
			chain.doFilter(reqeust, response);
			// 提交
			connection.commit();
			// 如果出现了sql异常，我们会将它转换为运行时异常并向上抛出，跑到BaseServlet，然后再将它抛到这里
		} catch (Exception e) {
			// 出现异常，事务回滚
			System.out.println("出现异常，TransactionFilter将其捕获");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 将当前线程中的链接移除
			JdbcUtils.closeConnection(connection);
		}
	}

}
