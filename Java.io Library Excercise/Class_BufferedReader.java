package IO.Library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Class_BufferedReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("D:\\FresherBuiQuangThi.txt");
        BufferedReader br = new BufferedReader(fr);
  
        int i;
        while ((i = br.read()) != -1) {
            System.out.print((char) i);
        }
        br.close();
        fr.close();


	}

}
