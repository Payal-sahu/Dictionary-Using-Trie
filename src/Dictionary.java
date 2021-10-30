

public class Dictionary {
    private Node root;
    public Dictionary() {
        root = new Node();
    }
    public void insert(String word,String meaning) {
        word = word.toLowerCase();
        Node current = root;
        for (char ch : word.toCharArray() )
        {
            Node child = current.getChildren(ch);
            if (child != null)
                current = child;
            else
            {
                current.children.put(ch, new Node(ch));
                current = current.getChildren(ch);
            }

        }

        current.setEndOfWord(true);
        current.setMeaning(meaning);
    }

    public String search(String s){
        Node current =root;
        char c='0';
        for(char l:s.toCharArray()){
            if(current.getChildren(l) == null){
                c = l;
                break;
            }
            current = current.getChildren(l);
        }
        if(current == null) return "NotFound";
        return current.getMeaning();
    }

    public void display(){
        char[] wordArray = new char[200];
        printAllWords(root, wordArray, 0);
    }

    void printAllWords(Node root, char[] wordArray, int pos)
    {
        if(root == null)
            return;
        if(root.isEnd_of_word())
        {
            printWord(wordArray, pos, root.getMeaning());
        }
        for(int i=0; i<26; i++)
        {
            if(root.children.get((char)(i+'a')) != null)
            {
                wordArray[pos] = (char)(i+'a');
                printAllWords(root.children.get((char)(i+'a')), wordArray, pos+1);
            }
        }
    }

    void printWord(char[] wordArray, int pos, String meaning){
        for(int i=0;i<pos;i++){
            System.out.print(wordArray[i]);
        }
        System.out.println(": "+ meaning);
    }

}