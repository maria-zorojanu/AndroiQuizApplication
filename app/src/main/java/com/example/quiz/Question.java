 package com.example.quiz;

public class Question {
    private String question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private  int answerNr;

    public Question(){}

    public Question(String question, String a1, String a2, String a3, String a4, int nr){
        this.question = question;
        this.ans1 = a1;
        this.ans2 = a2;
        this.ans3 = a3;
        this.ans4 = a4;
        this.answerNr = nr;
    }

    public String getQuestion(){
        return question;
    }

    public String getAns1(){
        return ans1;
    }
    public String getAns2(){
        return ans2;
    }
    public String getAns3(){
        return ans3;
    }
    public String getAns4(){
        return ans4;
    }

    public int getAnswerNr(){
        return answerNr;
    }

    public void setQuestion(String q){
        this.question = q;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}
