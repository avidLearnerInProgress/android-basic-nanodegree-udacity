package com.example.android.footballquiz;

import java.util.ArrayList;

/**
 * Created by admin on 20-10-2017.
 */

public class listItem {

    private String questionId;
    private String question;
    private ArrayList<String> options;
    private String solution;


    public listItem(String questionId, String question,ArrayList<String> options, String solution) {
        this.questionId = questionId;
        this.question = question;
        this.options = options;
        this.solution = solution;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
