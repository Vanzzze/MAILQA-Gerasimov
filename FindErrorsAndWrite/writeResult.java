import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class writeResult {
    private int count = 0;

    public void writeResultToFile (readLogFromFile rlff, List<String> filter){
        for (int i = 0; i < filter.size(); i++) {
            if (rlff.getLine().contains(filter.get(i))) {
                count += 1;
                System.out.println(rlff.getLineNumber() + ". " + filter.get(i) + " " + rlff.getLine());
                if (count < 2)
                    globalVariables.filteredLines += 1;
                try (FileWriter writer = new FileWriter("logLines.txt", true)) {
                    String text = rlff.getLineNumber() + ". " + filter.get(i) + " " + rlff.getLine();
                    writer.write(text);
                    writer.append('\n');
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        count = 0;
    }
}
