package Simple_Servlets;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    /**
     * Эта прога показывает,что каждый сервлет работает в отдельном потоке.
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 2; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URLConnection urlConnection = new URL("http://localhost:8080/").openConnection();
                        urlConnection.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
