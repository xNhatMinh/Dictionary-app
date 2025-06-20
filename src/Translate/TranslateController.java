package Translate;

import java.io.*;
import java.util.*;
import javazoom.jl.decoder.JavaLayerException;


public class TranslateController {
    private Translate translate;

    public TranslateController() {
        this.translate = new Translate();
    }

    public List<String> getLanguages() {
        return this.translate.getLanguages();
    }

    public String getLanguageCode(String language) {
        return this.translate.getLanguageCode(language);
    }

    public String translateWord(String textToTranslate, String sourceLanguage, String targetLanguage) throws IOException {
        return this.translate.translateWord(textToTranslate, sourceLanguage, targetLanguage);
    }

    public void translateFile(String sourceLanguage, String targetLanguage, String sourceFile, String targetFile) throws IOException {
        this.translate.translateFile(sourceLanguage, targetLanguage, sourceFile, targetFile);
    }
    
    public void readMessage(String Text, String language) throws IOException, JavaLayerException {
        this.translate.playSound(Text, language);
    }
}
