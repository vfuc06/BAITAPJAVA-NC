package TH130325;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class B1_IOStream {
    public static void main(String[] args) {
        String sourceFile= "source.txt";
        String destinationFile= "dest.txt";
        try{
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile);
            byte[] buffer = new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("Sucessfully written "+sourceFile+" to "+destinationFile);
        }
        catch(IOException e){
            System.out.println("Error: "+e.getMessage() );
        }

    }
}
