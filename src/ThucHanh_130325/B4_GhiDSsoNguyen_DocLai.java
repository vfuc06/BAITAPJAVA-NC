package TH130325;
import java.io.*;
public class B4_GhiDSsoNguyen_DocLai {
    public static void main(String[] args) {
        String fileName= "numbers.dat";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int[] nums = {10, 20, 30, 40, 50};
            for (int num : nums) {
                dos.writeInt(num);
            }
            System.out.println("Number written to the file: " + fileName);
        }
        catch (IOException e){
            System.out.println("Error writing to file: " + e.getMessage());
        }
        try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName)) ){
            System.out.println("Reading numbers from the file: " + fileName+ " : ");
            while (dis.available()>0){
                System.out.println(dis.readInt());
            }
        }catch (IOException e){
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
