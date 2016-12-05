import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by vkostylev on 05/12/16.
 */
public class DailyAdviceClient {

    public void go() {

        try {

            Socket socket = new Socket("http://127.0.0.1", 4242);

            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String advice = bufferedReader.readLine();

            System.out.println("Today you should: " + advice);

            bufferedReader.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }


    public static void main(String[] args) {

    }
}
