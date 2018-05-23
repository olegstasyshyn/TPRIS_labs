import java.io.*;

public class FileWorker {


    public void write(String filename , String text){
        File file = new File(filename);

        try{
            if(!file.exists()){
                file.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            byte[] outputSring = text.getBytes();
            fileOutputStream.write(outputSring);
            fileOutputStream.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public String read(String fileName) throws  IOException {

        File file = new File(fileName);

        FileInputStream fileInputStream = new FileInputStream(file);


            byte[] byteSting = new byte[fileInputStream.available()];

            fileInputStream.read(byteSting);
            String newStr = new String(byteSting);
            fileInputStream.close();
        return newStr;
    }


    public void numCut(String fileName , String newfileName) throws IOException{
        String str = read(fileName);
        System.out.println("Text:");
        System.out.println(str);

        char [] strArray = str.toCharArray();
        String newStr = "";
        for (int i = 0; i < strArray.length; i++) {
            if(!Character.isDigit(strArray[i])){
                newStr += strArray[i];
            }
        }
        System.out.println("New text:");
        System.out.println(newStr);
        write(newfileName , newStr);

    }

}

class Tets{
    public static void main(String[] args) {
        try {
            FileWorker fileWorker = new FileWorker();
            fileWorker.numCut("D://TPRIS_lab2.txt" , "D://TPRIS_lab.txt");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
