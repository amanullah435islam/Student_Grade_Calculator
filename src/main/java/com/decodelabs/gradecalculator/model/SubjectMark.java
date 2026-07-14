package com.decodelabs.gradecalculator.model;


public class SubjectMark {

    private String subjectName;

    private int mark;

    public SubjectMark() {
    }

    public SubjectMark(String subjectName, int mark) {
        this.subjectName = subjectName;
        this.mark = mark;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

}