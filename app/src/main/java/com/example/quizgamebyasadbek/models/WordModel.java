package com.example.quizgamebyasadbek.models;

public class WordModel {
    private int img;
    private String word;
    private String hint;

    public WordModel(int img, String word, String hint) {
        this.img = img;
        this.word = word;
        this.hint = hint;
    }

    public String getHint() {
        return this.hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getImg() {
        return this.img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
