import java.io.*;
import java.util.List;

public class readLogFromFile {
    private int lineNumber = 0;
    private String line;


    public void readLog(File file, List<String> filter) throws Exception {
        if (file.isFile()) {
            try {
                writeResult wr = new writeResult();
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                line = reader.readLine();
                System.out.println("File - " + file.getName());
                while (line != null) {
                    wr.writeResultToFile(this, filter);
                    lineNumber += 1;
                    line = reader.readLine();
                }
                globalVariables.allLines += lineNumber;
                lineNumber = 0;
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else {
            readlogFromDirectory rlfd = new readlogFromDirectory();
            rlfd.readLog(file, filter);
        }
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

}