package manageData.TrieTree;

import java.util.ArrayList;

public class Trie {
    static final int ALPHABET_SIZE = 26;
    static class TrieNode {
        private TrieNode[] children;
        private int idArray;

        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            idArray = -1;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }

        //getter, setter of idArray
        public int getIdArray() {
            return this.idArray;
        }

        public void setIdArray(int i) {
            this.idArray = i;
        }

    }

    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String key, int indexArray) {
        String l_key = key.toLowerCase().trim();
        TrieNode tmpNode = this.root;
        for (int i = 0; i < l_key.length(); i++) {
            int index = l_key.charAt(i) - 'a';
            if (tmpNode.children[index] == null) {
                tmpNode.children[index] = new TrieNode();
            }
            tmpNode = tmpNode.children[index];
        }
        tmpNode.setIdArray(indexArray);
    }

    public int search(String key) {
        String l_key = key.toLowerCase().trim();
        TrieNode tmpNode = this.root;
        for (int i = 0; i < l_key.length(); i++) {
            int index = l_key.charAt(i) - 'a';
            if (tmpNode.children[index] != null) {
                tmpNode = tmpNode.children[index];
            } else {
                return -1;
            }
        }
        if (tmpNode != null && tmpNode.getIdArray() >= 0) {
            return tmpNode.getIdArray();
        } else {
            return -1; // Can't find
        }
    }

    public void suggest(TrieNode root, ArrayList<String> list, StringBuffer curr) {
        if (root == null) return;

        if (root.getIdArray() >= 0) {
            list.add(curr.toString());
        }

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            char c = (char)(i + 'a');
            curr.append(c);
            suggest(root.children[i], list, curr);
            curr.setLength(curr.length() - 1);
        }
    }

    public ArrayList<String> findWordsWithPrefix(String prefix) {
        String l_prefix = prefix.toLowerCase().trim();
        ArrayList<String> list = new ArrayList<>();
        TrieNode lastNode = this.root;
        StringBuffer curr = new StringBuffer(l_prefix);
        for (int i = 0; i < l_prefix.length(); i++) {
            int index = l_prefix.charAt(i) - 'a';
            if (lastNode.children[index] != null) {
                lastNode = lastNode.children[index];
            } else {
                return list;
            }
        }
        suggest(lastNode, list, curr);
        return list;
    }

    // remove word
    public boolean remove(String key)
    {
        String l_key = key.toLowerCase().trim();
        TrieNode tmpNode = this.root;
        for (int i = 0; i < l_key.length(); i++) {
            int index = l_key.charAt(i) - 'a';
            if (tmpNode.children[index] != null) {
                tmpNode = tmpNode.children[index];
            } else {
                return false;
            }
        }
        if (tmpNode != null && tmpNode.getIdArray() >= 0) {
            tmpNode.setIdArray(-1);
            return true;
        } else {
            return false; // Can't find
        }
    }
}
