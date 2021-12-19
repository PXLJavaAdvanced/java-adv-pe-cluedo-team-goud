package be.pxl.ja;

public class CrackTheCode extends Riddle{
    public String[] questions;
    public String answer;

    public CrackTheCode(String[] questions, String answer) {
        this.questions = questions;
        this.answer = answer;
    }

    public String[] getQuestions() {
        return questions;
    }

    public String getAnswer() {
        return answer;
    }
}
