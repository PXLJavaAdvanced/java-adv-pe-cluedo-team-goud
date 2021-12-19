package be.pxl.ja;

public class CrackTheCode extends Riddle{
    public String index;
    public String questionOne;
    public String questionTwo;
    public String questionThree;
    public String questionFour;
    public String questionFive;
    public String answer;

    public CrackTheCode(String index, String questionOne, String questionTwo,
                        String questionThree, String questionFour, String questionFive, String answer) {
        this.index = index;
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
        this.questionFour = questionFour;
        this.questionFive = questionFive;
        this.answer = answer;
    }

    public String getIndex() {
        return index;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public String getQuestionThree() {
        return questionThree;
    }

    public String getQuestionFour() {
        return questionFour;
    }

    public String getQuestionFive() {
        return questionFive;
    }

    public String getAnswer() {
        return answer;
    }
}
