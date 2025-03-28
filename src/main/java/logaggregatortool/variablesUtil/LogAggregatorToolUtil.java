package logaggregatortool.variablesUtil;

import logaggregatortool.dao.AuditDao;
public class LogAggregatorToolUtil {
    public AuditDao buildAuditDao(String userInputFolderPath, int logFileCount, String logFileNames, String Result, String sortedFilePath, String ErrorMessage) {
        AuditDao auditDao = new AuditDao();
        auditDao.setFolderPath(userInputFolderPath);
        auditDao.setNumFiles(logFileCount);
        auditDao.setFilesNames(logFileNames);
        auditDao.setResult(Result);
        auditDao.setSortedFilePath(sortedFilePath);
        auditDao.setErrorMessage(ErrorMessage);
        return auditDao;
    }
}
