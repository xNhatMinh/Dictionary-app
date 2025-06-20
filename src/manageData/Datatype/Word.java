package manageData.Datatype;

import java.util.*;

public class Word {
    private String word_target;
    private String pronounce;
    private ArrayList<WordExplain> word_explain;

    //constructors
    public Word() {
        word_target = "";
        word_explain = new ArrayList<>();
        pronounce = "";
    }

    // setters
    public void copy(Word other) {
        if (other == null) {
            return;
        }
        this.word_explain = new ArrayList<>(other.word_explain);
        this.word_target = new String(other.word_target);
        this.pronounce = new String(other.pronounce);
    }
    
    public void setWordTarget(String word_target) {
        this.word_target = new String(word_target);
    }

    public void setWordExplain(ArrayList<WordExplain> word_explain) {
        this.word_explain = new ArrayList<>(word_explain);
    }

    public void addExplain(WordExplain newExplain) {
        this.word_explain.add(newExplain);
    }

    // getters
    public String getWord_target() {
        return new String(this.word_target);
    }

    public ArrayList<WordExplain> getWord_explain() {
        return this.word_explain;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }
    
}