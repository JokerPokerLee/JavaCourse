//以字符为单位拷贝文件内容
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
        	/**打开源文件*/
            inputStream = new FileReader("xanadu.txt");
            /**打开目标文件*/
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            /**从输入流中读出数据并写入到输出流中*/
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
        	/**关闭输入输出流*/
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}