import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary d = new Dictionary();

        // String file = "dictionary.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/dictionary.txt"));
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        String curLine;
        while ((curLine = bufferedReader.readLine()) != null){
            String[] str = curLine.split("\\s+",2);
            d.insert(str[0],str[1]);
        }

        System.out.println("Welcome to Dictionary");

        do {
            System.out.println("1. Search ");
            System.out.println("2. View All Word");
            System.out.println("3. Insert new Word ");
            System.out.println("4. Exit");
            int n = Integer.parseInt(br.readLine());
            if(n==4){
                System.out.println("Thank You!");
                break;
            }
            switch(n){
                case 1 : System.out.print("Enter word : ");
                        String str = br.readLine();
                        str = str.toLowerCase();
                        System.out.println("meaning : "+ d.search(str));
                        break;
                case 2: d.display();
                        break;
                case 3:
                    System.out.print("Enter word : ");
                    String w = br.readLine();
                    System.out.print("Enter Meaning : ");
                    String m = br.readLine();
                    d.insert(w,m);
            }
        }
        while(true);

    }
}