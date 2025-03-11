package logaggregatortool;
import java.io.File;
public class LogAggregatorTool {
    public static void main(String[] args) {
        String Path_Folder = args[0];
        File User_input_path = new File(Path_Folder);
        Validator validator = new Validator();
        validator.validatorFolder(User_input_path);
    }
}


