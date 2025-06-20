package Dict;
import java.util.*;
import java.io.*;
import manageData.Datatype.Word;
import manageData.Datatype.WordExplain;

public class VocabularyList {
    private List<List<Word>> vocabularies = new ArrayList<>();
    private List<String> topics = new ArrayList<>();

    public List<String> getTopics() {
        return topics;
    }

    public List<List<Word>> getVocabularies() {
        return vocabularies;
    }
    
    public void clear() {
        vocabularies.clear();
        topics.clear();
    }
    
    public int addNewVocabulary(String topic, Word word) {
//        saveFile = true;
        if (topics.contains(topic)) {
            vocabularies.get(topics.indexOf(topic)).add(word);
            return topics.indexOf(topic); // exist topic
        } else {
            topics.add(topic);
            List<Word> newList = new ArrayList<>();
            newList.add(word);
            vocabularies.add(newList);
            return topics.size() - 1;
        }
    }
    
    public void saveFileVocabulary() {
            try {
                String filePath = "src/data/WordsBySubject.txt";
                FileWriter fw = new FileWriter(filePath);
                BufferedWriter bw = new BufferedWriter(fw);

                for (int i = 0; i < topics.size(); ++i) {
                    bw.write("# " + topics.get(i) + "\n");
                    
                    for (Word w : vocabularies.get(i)) {
                        if (w.getWord_target() != null && !w.getWord_target().isEmpty()) {
                            for (WordExplain we : w.getWord_explain()) {
                                String type = we.getType();
                                String def = we.getDefinition();
                                String mean = we.getMeaning();
                                bw.write(w.getWord_target() + "\t" + w.getPronounce() + "\t" + type + "\t" + def + "\t" + mean + "\n");
                            }
                        }
                    }
                    bw.write("\n");
                }

                System.out.println("successful !!");
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("Export failed!!!");
                System.out.println("Sorry. An error occurred while exporting data.");
            }
    }


    public void loadVocabulary(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("# ")) {
                    String topic = line.substring(2);
                    topics.add(topic);
                    vocabularies.add(new ArrayList<>());
                } else if (!line.isEmpty()) {
                    String[] parts = line.split("\t");
                    if (parts.length >= 3) {
                        String english = parts[0];
                        String pronounce = parts[1];
                        String type = parts[2];
                        String def = parts[3];
                        String mean = parts[4];
                        WordExplain we = new WordExplain(type, def, mean);
                        boolean exist = false;
                        for (List<Word> ws : vocabularies) {
                            if (exist) {
                                break;
                            }
                            for (Word w : ws) {
                                if (w.getWord_target().equals(english)) {
                                    w.addExplain(we);
                                    exist = true;
                                }
                            }
                        }
                        if (!exist) {
                            Word word = new Word();
                            word.setWordTarget(english);
                            word.setPronounce(pronounce);
                            word.addExplain(we);
                            vocabularies.get(topics.size() - 1).add(word);
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void review(int wordCount, int topic) {
        Collections.shuffle(vocabularies.get(topic));
        int count = Math.min(wordCount, vocabularies.get(topic).size());
        for (int i = 0; i < count; i++) {
            Word vocabulary = vocabularies.get(topic).get(i);
            System.out.println("Word: " + vocabulary.getWord_target());
            System.out.print("Press Enter for the meaning.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            System.out.println("Meaning:");
            for (WordExplain we : vocabulary.getWord_explain()) {
                System.out.println(we.getType() + "\t" + we.getMeaning());
            }
            
        }
    }
}
