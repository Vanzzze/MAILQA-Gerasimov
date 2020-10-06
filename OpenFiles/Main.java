import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        JFileChooser fileopen = new JFileChooser();
        fileopen.setDialogTitle("Выбор файла/папки");
        File file = null;
        fileopen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int returnVal = fileopen.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileopen.getSelectedFile();
        }

        File filterFile = null;
        List<String> filter = new ArrayList<>();
        fileopen.setDialogTitle("Выбор файла фильтра");

        int returnFilter = fileopen.showOpenDialog(null);
        if (returnFilter == JFileChooser.APPROVE_OPTION) {
            filterFile = fileopen.getSelectedFile();
        }

        if (filterFile.isFile()) {
            FileReader fr = new FileReader(filterFile);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            filter.add(line);
            while (line != null){
                line = reader.readLine();
                if (line != null)
                    filter.add(line);
            }
        }

        for (int i = 0; i < filter.size(); i++)
            System.out.println(filter.get(i));

        if (file.isFile()) {
            readLogFromFile rlff = new readLogFromFile();
            rlff.readLog(file, filter);
        }
        else {
            readlogFromDirectory rlfd = new readlogFromDirectory();
            rlfd.readLog(file, filter);
        }
        System.out.println();
        System.out.println("Всего строк - " + globalVariables.allLines);
        System.out.println("Строк попадает под заданный фильтр - " + globalVariables.filteredLines);
        System.out.println();
    }
}