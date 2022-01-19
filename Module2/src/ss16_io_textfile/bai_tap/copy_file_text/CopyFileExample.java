package ss16_io_textfile.bai_tap.copy_file_text;

import java.io.*;

public class CopyFileExample {
    public static void main(String[] args) throws IOException {
        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            inStream = new FileInputStream(new File("D:\\A0921I1-PhamBaQuocAnh\\Module2\\src\\ss16_io_textfile\\bai_tap\\copy_file_text\\fileMain.txt"));
            outStream = new FileOutputStream(new File("D:\\A0921I1-PhamBaQuocAnh\\Module2\\src\\ss16_io_textfile\\bai_tap\\copy_file_text\\fileCopy.txt"));

            int length;
            byte[] buffer = new byte[1024];

            // copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            System.out.println("File is copied successful!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inStream.close();
            outStream.close();
        }
    }
}
