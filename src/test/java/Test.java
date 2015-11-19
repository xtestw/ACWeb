/**
 * Created by admin on 2015/11/19.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Test {
    static String getString(URL realUrl) {
        BufferedReader reader = null;
        String out = "";
        try {
            URLConnection connection = realUrl.openConnection();

            connection.connect();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                out += line;
            }
        } catch(Exception e) {
            System.out.println("Error...." + e);
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return out;
    }

    static String RegexString(String targetString, String expression) {
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(targetString);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
            //return matcher.group(1);
        }
        return "Nothing";
    }

    public static void main(String[] args) {
        String address = "http://www.baidu.com";
        String out = "";
        String print = "";
        try {
            URL realUrl = new URL(address);
            out = getString(realUrl);
            System.out.println(out);
            String expression = "src=\"(.+?)\"";
            print = RegexString(out, expression);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //System.out.println(out);
            System.out.println(print);
        }
    }
}