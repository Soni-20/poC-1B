package logaggregatortool.DAO;

import lombok.Data;
@Data
public class AuditDao {
    private String folderPath;
    private int numFiles;
    private String filesNames;
    private String Result;
    private String operationDatetime;
    private String sortedFilePath;
    private String ErrorMessage;
}
