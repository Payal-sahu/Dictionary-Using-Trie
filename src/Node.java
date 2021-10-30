import java.util.HashMap;

public class Node {
    HashMap<Character, Node> children = new HashMap<>();

    private boolean end_of_word;
    String meaning = "Invalid Word";

    //constructor
    public Node(){

    }

    public Node(char c){
        children.put(c,new Node());
    }

    //util
    public boolean isEnd_of_word() {
        return end_of_word;
    }

    public void setEndOfWord(boolean end_of_word) {
        this.end_of_word = end_of_word;
    }

    public Node getChildren(char c) {
        return children.get(c);
    }


    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }
}