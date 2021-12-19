package be.pxl.ja;

public class Anagram extends Riddle{
    public String word;
    public String description;
    public String answer;

    public Anagram(String word, String description, String answer) {
        this.word = word;
        this.description = description;
        this.answer = answer;
    }

    public String getWord() {
        return word;
    }


    public String getDescription() {
        return description;
    }


    public String getAnswer() {
        return answer;
    }
}
