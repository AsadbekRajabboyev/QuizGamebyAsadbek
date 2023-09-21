package com.example.quizgamebyasadbek.models;

public class WordModel {
    private int img;
    private String word;
    private String hint;
    private int wordSize;

    public WordModel(int img, String word, String hint, int wordSize) {
        this.img = img;
        this.word = word;
        this.hint = hint;
        this.wordSize = wordSize;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getWordSize() {
        return wordSize;
    }

    public void setWordSize(int wordSize) {
        this.wordSize = wordSize;
    }
}
