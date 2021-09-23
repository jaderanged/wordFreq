import java.io.*;
import java.nio.file.Path;
import java.util.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String line = null;
        int lineNum = 15;
        Map<String, Integer> wordFreq = new HashMap<String, Integer>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/jade.boone/Documents/Fall Semester 2021/Software Development/raven.txt"));
            StringBuilder sb = new StringBuilder();


            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                line.replaceAll("[^a-zA-Z]+", "").toLowerCase();
                lineNum++;
                if(lineNum > 15 && lineNum <60){
                    for (int i = 0; i < words.length; i++) {
                        if (wordFreq.get(words[i]) == null) {
                            wordFreq.put(words[i], 1);
                        } else {
                            int newValue = Integer.valueOf(String.valueOf(wordFreq.get(words[i])));
                            newValue++;
                            wordFreq.put(words[i], newValue);
                        }
                    }
                }
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordFreq.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        for (Map.Entry<String, Integer> key : list) {
            System.out.println("Word: " + "'" + key.getKey() + "'" + " Counts: " + key.getValue());
        }
    }
}

