package ss17_io_binary_file_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "milk", "vinamilk", 5000, "sữa tươi 100%"));
        products.add(new Product(2, "beer", "huda", 6000, "bia đậm đà hương vị Việt"));
        products.add(new Product(3, "tea", "olong", 7000, "trà ún vô ko mất ngủ"));
        products.add(new Product(4, "cooking oil", "tuong an", 8000, "dầu ăn ko béo"));
        writeToFile("D:\\A0921I1-PhamBaQuocAnh\\Module2\\src\\ss17_io_binary_file_serialization\\bai_tap\\quan_ly_san_pham_luu_ra_file_nhi_phan\\text.txt",products);
        products = readFromFile("D:\\A0921I1-PhamBaQuocAnh\\Module2\\src\\ss17_io_binary_file_serialization\\bai_tap\\quan_ly_san_pham_luu_ra_file_nhi_phan\\text.txt");
        for (Product product: products){
            System.out.println(product);
        }
    }

    public static void writeToFile(String path,List<Product> product) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(product);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readFromFile(String path){
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            ois.close();
            fis.close();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
