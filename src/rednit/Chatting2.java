package rednit;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Chatting2 {
 private static String sentence;
    private static String after;
    private static String before;
    private static String concate = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Chatting2.getAnto("i really love you");
    }

    /**
     *
     * @param input
     * @return
     */
    public static String getAnto(String input) {
        before = input;
        Chatting2.request(before);
        return after;
    }

    public static void request(String before) {
        String fromUser = before;
        String splitSentence[] = fromUser.split(" ");
        for (String check : splitSentence) {
            sentence = check;
            if ((check.equalsIgnoreCase("i")) || (check.equalsIgnoreCase("you")) || (check.equalsIgnoreCase("we")) || (check.equalsIgnoreCase("she")) || (check.equalsIgnoreCase("he")) || (check.equalsIgnoreCase("they")) || (check.equalsIgnoreCase("the")) || (check.equalsIgnoreCase("a")) || (check.equalsIgnoreCase("an")) || (check.equalsIgnoreCase("me"))) {
                Chatting2.receive(check);
            } else {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.abbreviations.com/services/v2/syno.php?uid=7822&tokenid=hUHI8x48FZnOEO54&format=json&word=" + check)).build();
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        //.thenAccept(System.out::println)
                        .thenApply(Chatting2::parse)
                        .join();
            }
        }

    }

    public static String parse(String responseBody) {
        JSONObject passValue = new JSONObject(responseBody);
        JSONArray arr = passValue.getJSONArray("result");
        JSONObject value = arr.getJSONObject(0);
        try {
            String getAntonym = value.getString("antonyms");
            String[] split = getAntonym.split(",");
            String a = split[0];
            Chatting2.receive(a);
        } catch (JSONException e) {
            Chatting2.receive(sentence);
        }
        return null;
    }

    public static void receive(String words) {
        concate += words + " ";
        after = concate;
    }

}
// TODO code application logic here

