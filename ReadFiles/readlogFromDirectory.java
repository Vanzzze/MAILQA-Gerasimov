import java.io.File;
import java.util.List;

public class readlogFromDirectory {
    int allFiles = 0;

    public void readLog(File file, List<String> filter) throws Exception {
        if (file.isDirectory()){
            readLogFromFile rlff = new readLogFromFile();
            for (File filesInDirectory : file.listFiles()){
                allFiles += 1;
                rlff.readLog(filesInDirectory, filter);
                globalVariables.allLines += rlff.getLineNumber();
                rlff.setLineNumber(0);
            }
        }
        else {
            readLogFromFile rlff = new readLogFromFile();
            rlff.readLog(file, filter);
        }
    }
}
