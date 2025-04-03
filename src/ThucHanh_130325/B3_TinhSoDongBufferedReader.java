package TH130325;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class B3_TinhSoDongBufferedReader {
    public static void main(String[] args) {
        String srcFile="source.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(srcFile))){
            int lcount=0;
            while (br.readLine()!=null){
                lcount++;
            }
            System.out.println("Total lines read in: "+srcFile+" : "+lcount);
        }
        catch (IOException e){
            System.out.println("Error: "+e.getMessage());

        }
    }
}
