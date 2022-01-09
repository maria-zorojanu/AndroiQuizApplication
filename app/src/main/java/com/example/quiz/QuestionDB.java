package com.example.quiz;
import android.provider.BaseColumns;

public class QuestionDB {
    public QuestionDB(){}

    public static class QuestionTable implements BaseColumns{
        public static  final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "questions";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NUMBER = "answer_nr";
    }
}
