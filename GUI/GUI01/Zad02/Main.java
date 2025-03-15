import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> tab = new ArrayList<>();

        String path = "tab.txt";

    try{
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        String[] split;
        while ((line = br.readLine())!=null){
            split = line.split(" ");
           for (String s : split) {
               tab.add(Integer.parseInt(s));
           }

        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

        for (int i = 0; i < tab.size(); i++) {
            System.out.print(tab.get(i)+ " ");
        }

        System.out.println();
        int max = Collections.max(tab);
        System.out.println(max);


        int index = 0;
        for (int i = 0; i < tab.size()-1; i++) {
            index++;
            if(tab.get(index) == max){
                System.out.print(index + " ");
            }
        }

    }
}
 