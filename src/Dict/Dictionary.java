package Dict;

import java.util.*;
import manageData.Datatype.Word;
import manageData.TrieTree.Trie;
public class Dictionary {
    private ArrayList<Word> Dict;

    private Trie TrieOfTargetWord;
    // Constructors
    public Dictionary() {
        this.Dict = new ArrayList<>();
        this.TrieOfTargetWord = new Trie();

        for (int i = 0; i < this.Dict.size(); i++) {
            this.TrieOfTargetWord.insert(this.Dict.get(i).getWord_target(), i);
        }
    }

    // getter
    public ArrayList<Word> getDict() {
        return this.Dict;
    }

    public Trie getTrieOfTargetWord() {
        return this.TrieOfTargetWord;
    }
}