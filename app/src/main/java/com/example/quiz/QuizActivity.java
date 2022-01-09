package com.example.quiz;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {

    private RadioGroup answers;
    private RadioButton ans1;
    private RadioButton ans2;
    private RadioButton ans3;
    private RadioButton ans4;
    private Button nextButton;

    private TextView questionText;
    private TextView scoreText;
    private TextView questionCountText;
    private TextView correctText, wrongText;
    private TextView highScoreText;
    private TextView submitButtonText;

    private ArrayList<Question> questionsList;
    private  int questionCounter;
    private int questionTotalCount;
    private Question currentQuestion;
    private boolean answerd;
    private int questionsInOneGame= 10;
    private int questionInCurrentGame = 0;
    private int highScore = questionsInOneGame*-10;
    private final Handler handler= new Handler();

    private int correctCount = 0, wrongCount = 0, score;
    private  int totalSizeOfQuiz = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        setupUI();
        fetchDB();
        //buttonLabelColor = ans1.getTextColors();

    }

    private void setupUI() {
        correctText = findViewById(R.id.txtCorrect);
        wrongText = findViewById(R.id.txtWrong);
        questionCountText = findViewById(R.id.txtTotalQuestion);
        scoreText =findViewById(R.id.txtScore);
        questionText = findViewById(R.id.txtQuestion);
        highScoreText = findViewById(R.id.txtHighScore);
        submitButtonText = findViewById(R.id.submit_button);

        answers = findViewById(R.id.radio_group);
        ans1 = findViewById(R.id.radio_button1);
        ans2 = findViewById(R.id.radio_button2);
        ans3 = findViewById(R.id.radio_button3);
        ans4 = findViewById(R.id.radio_button4);
        nextButton = findViewById(R.id.submit_button);
    }

    private  void fetchDB(){
        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionsList = dbHelper.getAllQuestions();

        startQuiz();
    }

    private void startQuiz(){
        questionTotalCount = questionsList.size();
        questionTotalCount = questionsList.size();
        Collections.shuffle(questionsList);
        showQuestions();

        answers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radio_button1:
                        ans1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_selected));
                        ans2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        ans3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        ans4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        break;
                    case R.id.radio_button2:
                        ans1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        ans2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_selected));
                        ans3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        ans4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        break;
                    case R.id.radio_button3:
                        ans1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        ans2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        ans3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_selected));
                        ans4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        break;
                    case R.id.radio_button4:
                        ans1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        ans2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        ans3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
                        ans4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.when_selected));
                        break;
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!answerd){
                    if(ans1.isChecked()||ans2.isChecked()||ans3.isChecked()||ans4.isChecked()){
                        quizOperations();
                    }
                }else{
                    Toast.makeText(QuizActivity.this, "Pleanse select one option", Toast.LENGTH_SHORT);
                }
            }
        });


    }

    private void quizOperations() {
        answerd = true;
        RadioButton rbSelected = findViewById(answers.getCheckedRadioButtonId());
        int answerNr =1+ answers.indexOfChild(rbSelected);

        checkSolution(answerNr, rbSelected);
    }

    private void checkSolution(int answerNr, RadioButton rbSelected) {
        switch ((currentQuestion.getAnswerNr())){
            case 1:
                if(currentQuestion.getAnswerNr() == answerNr){
                    ans1.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_option_background));

                    correctCount++;
                    score+=20;
                    correctText.setText("Correct\n"+ String.valueOf(correctCount));

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showQuestions();
                        }
                    }, 500);

                }else{
                    changeToIncorrectColor(rbSelected);
                    wrongCount++;
                    score-=10;
                    wrongText.setText("Wrong\n"+ String.valueOf(wrongCount));
                    handler.postDelayed(() ->{showQuestions();}, 500);
                }
                scoreText.setText("Score\n" + String.valueOf(score));
                break;

            case 2:
                if(currentQuestion.getAnswerNr() == answerNr){
                    ans2.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_option_background));
                    correctCount++;
                    score+=20;
                    correctText.setText("Correct\n"+ String.valueOf(correctCount));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showQuestions();
                        }
                    }, 500);
                }else{
                    changeToIncorrectColor(rbSelected);
                    wrongCount++;
                    score-=10;
                    wrongText.setText("Wrong\n"+ String.valueOf(wrongCount));
                    handler.postDelayed(() ->{showQuestions();}, 500);
                }
                scoreText.setText("Score\n" + String.valueOf(score));
                break;

            case 3:
                if(currentQuestion.getAnswerNr() == answerNr){
                    ans3.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_option_background));
                    correctCount++;
                    score+=20;
                    correctText.setText("Correct\n"+ String.valueOf(correctCount));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showQuestions();
                        }
                    }, 500);
                }else{
                    changeToIncorrectColor(rbSelected);
                    wrongCount++;
                    score-=10;
                    wrongText.setText("Wrong\n"+ String.valueOf(wrongCount));
                    handler.postDelayed(() ->{showQuestions();}, 500);
                }
                scoreText.setText("Score\n" + String.valueOf(score));
                break;

            case 4:
                if(currentQuestion.getAnswerNr() == answerNr){
                    ans4.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_option_background));
                    correctCount++;
                    score+=20;
                    correctText.setText("Correct\n"+ String.valueOf(correctCount));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showQuestions();
                        }
                    }, 500);
                }else{
                    changeToIncorrectColor(rbSelected);
                    wrongCount++;
                    score-=10;
                    wrongText.setText("Wrong\n"+ String.valueOf(wrongCount));
                    handler.postDelayed(() ->{showQuestions();}, 500);
                }
                scoreText.setText("Score\n" + String.valueOf(score));
                break;
        } //eo switch

    }

    private void changeToIncorrectColor(RadioButton rbSelected) {
        rbSelected.setBackground(ContextCompat.getDrawable(this,R.drawable.wrong_answer_background));
    }

    public void showQuestions() {
        answers.clearCheck();
        ans1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
        ans2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
        ans3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
        ans4.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.question_container_background));
        if(questionCounter<questionTotalCount){
            currentQuestion = questionsList.get(questionCounter);
            questionText.setText(currentQuestion.getQuestion());
            ans1.setText(currentQuestion.getAns1());
            ans2.setText(currentQuestion.getAns2());
            ans3.setText(currentQuestion.getAns3());
            ans4.setText(currentQuestion.getAns4());

            if(questionInCurrentGame == questionsInOneGame){

                if(score>highScore){
                    highScore = score;
                    highScoreText.setText("HIGH SCORE: "+ String.valueOf(highScore));
                }

                score = 0;
                scoreText.setText("Score\n"+ String.valueOf(score));
                wrongCount =0;
                wrongText.setText("Wrong\n"+ String.valueOf(wrongCount));
                correctCount = 0;
                correctText.setText("Correct\n"+ String.valueOf(correctCount));
                questionInCurrentGame=0;
            }
            if(questionCounter ==totalSizeOfQuiz){
                questionCounter = 0;
            }
            answerd= false;

            questionCountText.setText(("Questions:"+ String.valueOf(1 + questionInCurrentGame) +"/"+ questionsInOneGame));
            questionCounter++;
            questionInCurrentGame++;


        }else{
            totalSizeOfQuiz = questionsList.size();
            handler.postDelayed(()-> {
            }, 1000);
        }
    }

}