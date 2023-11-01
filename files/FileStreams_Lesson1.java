package files;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileStreams_Lesson1 {
    public static void main(String[] args) throws Exception{
        FileStreams_Lesson1 fileStreams = new FileStreams_Lesson1();
        File file = fileStreams.createNewFile();
        fileStreams.writeToFile(file);
        fileStreams.readFromFile(file);
        fileStreams.cleanup(file);
        System.out.println("Do you see the problem of default IO Streams ? Goto lesson 2");
    }

    private void readFromFile(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] arr = fis.readAllBytes();
            System.out.println("File length:  " + arr.length);

            String s = new String(arr, StandardCharsets.UTF_8);
            System.out.println("Read from file : " + s);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(File file) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] byteArr = "Sample Text".getBytes(StandardCharsets.UTF_8);
            System.out.println("Before Write: " + file.length());
            fos.write(byteArr);
            System.out.println("After write: " + file.length());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File createNewFile() throws IOException {

        String fileName = "file1";
        File file = new File("./" + fileName);
        System.out.println("Before file creation: " + file.exists());
        init(file);
        System.out.println("After file creation: " + file.exists());
        return file;

    }

    private void cleanup(File file) {
        if(file.delete())
            System.out.println("Cleanup Successful");
    }

    /*
    * Creates a new File with the file object
    * */
    private static void init(File file) throws IOException {
        file.createNewFile();
    }
}
