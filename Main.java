import java.io.*;
import java.net.URL;


public class Main {

    private static void Download(String from, String to) throws IOException {
        URL url = new URL(from);
        BufferedInputStream Input = new BufferedInputStream(url.openStream());
        FileOutputStream Output = new FileOutputStream(to);
        byte[] buffer = new byte[1024];
        int count;
        while ((count = Input.read(buffer)) != -1)
            Output.write(buffer, 0, count);
        Input.close();
        Output.close();
    }

    private static void SearchingEquals(String str) {
        String color[] = new String[]{"red", "orange", "yellow", "green", "blue", "violet", "white", "black", "brown", "pink", };
        for (String colors : color) if (str.equals(colors)) System.out.println(str);

    }

    public static void main(String[] args) throws IOException {
        Download(args[0], args[1]);
        BufferedReader Input = new BufferedReader(new FileReader(args[1]));
        String s;
        StringBuilder ss = new StringBuilder();
        while ((s = Input.readLine()) != null) {
            s = s.replaceAll("[^A-Za-z]", " ").toLowerCase();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    if (ss.length() > 0) SearchingEquals(ss.toString());
                    ss = new StringBuilder();
                } else {
                    ss.append(s.charAt(i));
                }
            }
        }
        Input.close();
    }
}
