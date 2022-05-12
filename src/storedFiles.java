import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;

public class storedFiles {
    private String stored_File;

    public storedFiles(String stored_File){
        this.stored_File = stored_File;
    }
    List<Account> memory = new ArrayList<>();
    List<Account> list = new ArrayList<>(memory);
 
    public void write(){
        Gson gson =new Gson();
        try(Writer writer = Files.newBufferedWriter(Paths.get("acc_data.json"));){
                    gson.toJson(list, writer);
                    writer.flush(); //flush data to file   <---
                    writer.close(); //close write  
                } catch(IOException ex){
                    ex.printStackTrace();
                    System.out.println (ex.toString());
                    System.out.println("Could not find file " + "acc_data.json");
                }
    }

    public void read(){
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File("acc_data.json");
            FileReader fr = new FileReader(f);
            //Bước 2: Đọc dữ liệu
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
              System.out.println(line);
            }
            //Bước 3: Đóng luồng
            fr.close();
            br.close(); 
           } catch (Exception ex) {
             System.out.println("Loi doc file: "+ex);
         }
    }

    /* sử dụng phương thức dir.list() của lớp File trong Java. */
    public void search() throws Exception{
        File dir = new File("directoryName");
      String[] children = dir.list();
      if (children == null) {
         System.out.println("does not exist or is not a directory");
      }
      else {
          
         for (int i = 0; i < children.length; i++) {
            String filename = children[i];
            System.out.println(filename);
         }
      }
    }

    public void update(){

    }

    public void get_All(){
        
    }
}
