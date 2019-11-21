import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    public String hamletReplacer(String data) {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(data);

        data = matcher.replaceAll("Leon");
        return data;
    }

    public String horatioReplacer(String data) {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(data);

        data = matcher.replaceAll("Tariq");
        return data;
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String parseHamlet() {
        return horatioReplacer(hamletReplacer(this.hamletData));
    }

}
