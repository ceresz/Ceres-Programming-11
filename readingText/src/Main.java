import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static String checkThisWord = "program";
    public static void main(String[] args) throws IOException {
        String file = "";
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null) {
            file += line;
        }
        br.close();
        ArrayList<String> sentences = splitIntoSentence(file);
        for (String asdf:
                sentences) {
            System.out.println(asdf);
        }
        System.out.println(findWord(sentences, checkThisWord));
    }

    public static ArrayList<String> splitIntoSentence(String lines) {
        ArrayList<String> sentences = new ArrayList<>();
        int prevPos = 0;
        int afterPos = 0;
        for (int i = 0; i < lines.length(); i++) {
            if (lines.substring(i, i + 1).equals(".")) {
                if (i < lines.length() - 1 && !lines.substring(i-1, i+3).equals("e.g.") && !lines.substring(i-3, i+1).equals("e.g.")) {
                    afterPos = i+1;
                    sentences.add(lines.substring(prevPos, afterPos));
                    prevPos = i+1;
                }
            }
        }
        sentences.add(lines.substring(prevPos, lines.length()));
        return sentences;
    }

    public static String findWord(ArrayList<String> lines, String word) {
        String out = "";
        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i).split(" ");
            if (containWord(words, word)) {
                out += "Sentence Index: " + i + ", Word in sentence: ";
                for (int j = 1; j < words.length + 1; j++) {
                    if (words[j-1].equals(word)) {
                        out += j + " ";
                    }
                }
                out += "\n";
            }
        }
        return out;
    }

    public static boolean containWord(String[] words, String word) {
        boolean yes = false;
        for (String w:
                words) {
            if (w.equals(word)) {
                yes = true;
                break;
            }
        }
        return yes;
    }
}