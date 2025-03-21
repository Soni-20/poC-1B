package logaggregatortool.databaseConnection;

import logaggregatortool.constants.DataBaseConnectionConstants;
import logaggregatortool.constants.LogAggregatorToolConstants;
import logaggregatortool.dao.AuditDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class represents DataBaseConnection
 * insert the data into audit table
 */
public class DataBaseConnection {
    /**
     * Loads database properties(dburl,dbusername,dbpassword)
     *
     * @return properties containing database configuration details.
     */
    private Properties getProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(LogAggregatorToolConstants.FILE_PATH_PROPERTIES)) {
            properties.load(fileInputStream);
            return properties;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    public void insertAudit(AuditDao auditDao) {
        String addAuditQuery = LogAggregatorToolConstants.INSERT_AUDIT_QUERY;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(addAuditQuery);
            preparedStatement.setString(1, auditDao.getFolderPath());
            preparedStatement.setInt(2, auditDao.getNumFiles());
            preparedStatement.setString(3, auditDao.getFilesNames());
            preparedStatement.setString(4, auditDao.getOperationDatetime());
            preparedStatement.setString(4, auditDao.getResult());
            preparedStatement.setString(5, auditDao.getSortedFilePath());
            preparedStatement.setString(6, auditDao.getErrorMessage());
            preparedStatement.execute();
        } catch (SQLException exception) {
            System.out.println(LogAggregatorToolConstants.AUDIT_ERROR + exception.getMessage());
        }
    }
    private Connection getConnection() {
        Connection connection;
        Properties properties = getProperties();
        String dbUrl = properties.getProperty(DataBaseConnectionConstants.DB_URL);
        String dbUsername = properties.getProperty(DataBaseConnectionConstants.DB_USERNAME);
        String dbPassword = properties.getProperty(DataBaseConnectionConstants.DB_PASSWORD);
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return connection;
    }
}
