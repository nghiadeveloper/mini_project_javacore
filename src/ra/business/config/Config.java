package ra.business.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    public static Scanner scanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    public static final String PATH_CATEGORY = "C:\\Project\\project_javacore_md3\\src\\ra\\business\\database\\category.txt";
    public static final String PATH_PRODUCT = "C:\\Project\\project_javacore_md3\\src\\ra\\business\\database\\product.txt";

    //Phương thức đọc file
    public  List<T> readFromFile(String pathFile)  {
        List<T> tList = new ArrayList<>();

        try {
            File file=new File(pathFile);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(pathFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                tList = (List<T>) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            }
        } catch (FileNotFoundException f) {
            System.err.println("File not found!");
        }catch (EOFException eof){

        } catch (IOException i){
            System.err.println("IOE exception!");
        } catch (ClassNotFoundException c){
            System.err.println("Class Not Found");
        }
        return tList;
    }
    //Phương thức ghi file
    public void writeToFile(String pathFile, List<T> tList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException f){
            System.err.println("File Not Found!");
        } catch (IOException i){
            System.err.println("IOE Exception!");
        }
    }
}
