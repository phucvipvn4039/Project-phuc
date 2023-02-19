package com.example.login;

public class Question {
    public int ID;
    public String Question, Image;
    public String AnswerA;
    public String AnswerB;
    public String AnswerC;
    public String AnswerD;
    public String Answer;
    public int ChoiceId=-1; //xem lai
    private String Traloi= "";// xem lai

    public Question() {
    }

    public Question(int ID, String question, String answerA, String answerB, String answerC, String answerD, String answer, String traloi, String image) {
        this.ID = ID;
        Question = question;
        Image = image;
        AnswerA = answerA;
        AnswerB = answerB;
        AnswerC = answerC;
        AnswerD = answerD;
        Answer = answer;
        Traloi = traloi;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String answerA) {
        AnswerA = answerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public void setAnswerC(String answerC) {
        AnswerC = answerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public void setAnswerD(String answerD) {
        AnswerD = answerD;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public int getChoiceId() {
        return ChoiceId;
    }

    public void setChoiceId(int choiceId) {
        ChoiceId = choiceId;
    }

    public String getTraloi() {
        return Traloi;
    }

    public void setTraloi(String traloi) {
        Traloi = traloi;
    }
}
