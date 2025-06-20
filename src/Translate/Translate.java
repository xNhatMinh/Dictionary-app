package Translate;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.json.JSONException;

public class Translate {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static final String API_URL = "https://translate.googleapis.com/translate_a/single?client=gtx&dt=t";
    private static final String textToSpeech_API = "https://translate.google.com/translate_tts?ie=UTF-8&tl=";

    private final List<String> languages = new ArrayList<>();

    public Translate() {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Spanish");
        languages.add("French");
        languages.add("Japanese");
        languages.add("Chinese");
    }

    public List<String> getLanguages() {
        return languages;
    }

    public String getLanguageCode(String language) {
        switch (language) {
            case "English":
                return "en";
            case "Vietnamese":
                return "vi";
            case "Spanish":
                return "es";
            case "French":
                return "fr";
            case "Japanese":
                return "ja";
            case "Chinese":
                return "zh";
            default:
                return "en";
        }
    }

    // translate a word from sourceLanguage to targetLanguage
    public static String translateWord(String textToTranslate, String sourceLanguage, String targetLanguage) throws IOException {
        String encodedText = URLEncoder.encode(textToTranslate, StandardCharsets.UTF_8);
        String apiUrl = String.format("%s&sl=%s&tl=%s&text=%s", API_URL, sourceLanguage, targetLanguage, encodedText);


        HttpGet httpGet = new HttpGet(apiUrl);
        String jsonResponse = EntityUtils.toString(httpClient.execute(httpGet).getEntity());

        return parseTranslationResponse(jsonResponse);
    }

    // parse the json response from the API
    public static String parseTranslationResponse(String jsonResponse) {
        try {
            JSONArray jsonArray = new JSONArray(jsonResponse);
            JSONArray jsonArray2 = jsonArray.getJSONArray(0);
            StringBuilder translatedText = new StringBuilder();
            for (int i = 0; i < jsonArray2.length(); i++) {
                translatedText.append(jsonArray2.getJSONArray(i).get(0).toString());
            }
            return translatedText.toString();
        } catch (JSONException ex) {
            Logger.getLogger(Translate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void translateFile(String sourceLanguage, String targetLanguage, String sourceFile, String targetFile) throws IOException {
        String sourceLanguageCode = getLanguageCode(sourceLanguage);
        String targetLanguageCode = getLanguageCode(targetLanguage);

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String translatedLine = translateWord(line, sourceLanguageCode, targetLanguageCode);
                bw.write(translatedLine);
                bw.newLine();
            }
        }
    }
    
    public static void playSound(String text, String language) throws IOException, JavaLayerException {
        String to_conconnect = textToSpeech_API + language + "&client=tw-ob&q=" + URLEncoder.encode(text, "UTF-8");
        URL url = new URL(to_conconnect);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        InputStream audio = con.getInputStream();
        new Player(audio).play();
        con.disconnect();
    }
    

    public static void main(String[] args) throws IOException {
        // test translateFile function
        Translate translate = new Translate();
//        String sourceFile = "src/data/EnglishWordsOnly.txt";
//        String targetFile = "src/data/WordsTranslatedToVietnamese.txt";

//        translate.translateFile("English", "Vietnamese", sourceFile, targetFile);

        //test translateWord function

        String textToTranslate = "Hello, Friend";
        System.out.println(translateWord(textToTranslate, "en", "vi"));
        System.out.println(translateWord(textToTranslate, "en", "es"));
        System.out.println(translateWord(textToTranslate, "en", "fr"));
        System.out.println(translateWord(textToTranslate, "en", "ja"));
        System.out.println(translateWord(textToTranslate, "en", "zh"));

    }
}

