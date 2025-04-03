package TH130325;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_BufferedReader {
    public static void main(String[] args) {
        String desFile ="output.txt";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter(desFile)){
            System.out.println("Enter text and write('exit') to stop: ");
            String line;
            while(!(line = br.readLine()).equalsIgnoreCase("exit")){
                fw.write(line+"\n");
            }
            System.out.println("Successfully wrote to the file" + desFile);
        } catch (IOException e){
            System.err.println("Error: "+e.getMessage());
        }
    }
}
