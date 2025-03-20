package logaggregatortool.databaseConnection;

import logaggregatortool.DAO.AuditDao;
import logaggregatortool.constants.LogAggregatorToolConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
public class DataBaseConnection {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(LogAggregatorToolConstants.DB_URL, LogAggregatorToolConstants.DB_USERNAME, LogAggregatorToolConstants.DB_PASSWORD);
    }
    private Properties loadProperties() throws SQLException {
        Properties properties = loadProperties();
        try (FileInputStream fileInputStream = new FileInputStream("\\src\\main\\resources")) {
            properties.load(fileInputStream);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return properties;
    }
    public void insertAudit(AuditDao auditDao) {
        String addAuditQuery = LogAggregatorToolConstants.INSERT_AUDIT_QUERY;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addAuditQuery);
            preparedStatement.setString(1, auditDao.getFolderPath());
            preparedStatement.setInt(2, auditDao.getNumFiles());
            preparedStatement.setString(3, auditDao.getFilesNames());
            preparedStatement.setString(4, auditDao.getOperationDatetime());
            preparedStatement.setString(4, auditDao.getResult());
            preparedStatement.setString(5, auditDao.getSortedFilePath());
            preparedStatement.setString(6, auditDao.getErrorMessage());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(LogAggregatorToolConstants.AUDIT_ERROR + e.getMessage());
        }
    }
}
