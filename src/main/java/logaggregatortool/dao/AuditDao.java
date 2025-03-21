package logaggregatortool.dao;

import lombok.Getter;
import lombok.Setter;
/**
 *This class defines getters and setters.
 */
@Getter
@Setter
public class AuditDao {
    private String folderPath;
    private int numFiles;
    private String filesNames;
    private String result;
    private String operationDatetime;
    private String sortedFilePath;
    private String errorMessage;
}
