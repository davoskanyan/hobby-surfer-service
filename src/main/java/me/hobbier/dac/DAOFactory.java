package me.hobbier.dac;

import me.hobbier.dac.queries.SQLQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author emil.saghatelyan on 10/31/2016.
 */
public class DAOFactory {

	private final DriverManagerDataSource driverManagerDataSource;
	private final SQLQueries sqlQueries;

	@Autowired
	public DAOFactory(DriverManagerDataSource driverManagerDataSource, SQLQueries sqlQueries) {
		this.driverManagerDataSource = driverManagerDataSource;
		this.sqlQueries = sqlQueries;

	}


	/**
	 * Returns query with the specified name.
	 *
	 * @param queryName Name of the query
	 * @return query
	 */
	public final String getQuery(final String queryName) {
		return sqlQueries.getQuery(queryName);
	}

	/**
	 * Gets template for implementing data reading.
	 *
	 * @param projectId project identifier
	 * @return Template for implementing data reading.
	 */
	public final NamedParameterJdbcTemplate getReadJdbcTemplate(String projectId) {
		return new NamedParameterJdbcTemplate(driverManagerDataSource);
	}

	/**
	 * Returns JDBC template for data writing
	 *
	 * @param projectId project identifier
	 * @return jdbc template for writing/master datasource
	 */
	public final NamedParameterJdbcTemplate getWriteJdbcTemplate(String projectId) {
		return new NamedParameterJdbcTemplate(driverManagerDataSource);
	}
}
