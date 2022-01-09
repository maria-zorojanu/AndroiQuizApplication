package com.example.quiz;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quiz.QuestionDB.*;

import java.util.ArrayList;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Go_quiz";
    private static   final int DATABASE_VERSION  = 1;

    private  SQLiteDatabase dataBase;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.dataBase = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NUMBER + " INTEGER" +
                ")";

        dataBase.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dataBase.execSQL("DROP TABLE IF EXISTS "+ QuestionTable.TABLE_NAME);
        onCreate(dataBase);
    }

    private void addQuestion(Question questions){
        ContentValues cv = new ContentValues();

        cv.put(QuestionTable.COLUMN_QUESTION, questions.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, questions.getAns1());
        cv.put(QuestionTable.COLUMN_OPTION2, questions.getAns2());
        cv.put(QuestionTable.COLUMN_OPTION3, questions.getAns3());
        cv.put(QuestionTable.COLUMN_OPTION4, questions.getAns4());
        cv.put(QuestionTable.COLUMN_ANSWER_NUMBER, questions.getAnswerNr());

        dataBase.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    private void fillQuestionTable(){
        Question c1 = new Question("Emiratele Arabe Unite", "Kiew", "Budapesta", "Abu Dhabi", "Amman", 3);
        addQuestion(c1);

        Question c2 = new Question("Nigeria", "Abuja", "Budapesta", "Abu Dhabi", "Amman", 1);
        addQuestion(c2);

        Question c3 = new Question("Ghana", "Kiew", "Accra", "Roma", "Lodra", 2);
        addQuestion(c3);

        Question c4 = new Question("Etiopia", "Addis Abeba", "Bucuresti", "Chisinau", "Lisabona", 1);
        addQuestion(c4);

        Question c5 = new Question("Algeria", "Ankara", "New York", "Madrid", "Alger", 4);
        addQuestion(c5);

        Question c6 = new Question("Iordania", "Moscova", "Australia", "Abu Dhabi", "Amman", 4);
        addQuestion(c6);

        Question c7 = new Question("Paraguai", "Kiew", "Atena", "Asgabat", "Asuncion", 4);
        addQuestion(c7);

        Question c8 = new Question("Olanda", "Amsterdam", "Haga", "Copenhaga", "Sofia", 1);
        addQuestion(c8);

        Question c9 = new Question("Algeria", "Ankara", "New York", "Madrid", "Alger", 4);
        addQuestion(c9);

        Question c10 = new Question("Andorra", "Andorra", "Andorra la Vella", "Andorra alla Vella", "Rusia", 2);
        addQuestion(c10);

        Question c11 = new Question("Turcia", "Istambul", "Constantinopol", "Ankara", "Beijing", 3);
        addQuestion(c11);

        Question c12 = new Question("Madagascar", "Antananariro", "Madagascar", "Pretoria", "Antananarivo", 4);
        addQuestion(c12);

        Question c13 = new Question("Samoa", "Amsterdam", "Apia", "Bamako", "Kosovo", 2);
        addQuestion(c13);

        Question c14 = new Question("Eritreea", "Eritreea City", "Asmara", "Bankok", "Wuhan", 2);
        addQuestion(c14);

        Question c15 = new Question("Turkmenistan", "Avarua", "Bangui", "Asgabat", "Berlin", 3);
        addQuestion(c15);

        Question c16 = new Question("Grecia", "Atena", "Sparta", "Thassos", "Persia", 1);
        addQuestion(c16);

        Question c17 = new Question("Irak", "Bangui", "Bagdad", "Bamako", "Banjul", 2);
        addQuestion(c17);

        Question c18 = new Question("Azerbaidjan", "Amsterdam", "Belmopan", "Bamako", "Baku", 4);
        addQuestion(c18);

        Question c19 = new Question("Brunei", "Bandar Seri Begawan", "Bandar Begawan Seri ", "Begawan", "Anglia", 1);
        addQuestion(c19);

        Question c20 = new Question("China", "Hong Kong", "Tokio", "Beijing", "Wuhan", 3);
        addQuestion(c20);

        Question c21 = new Question("Republica Centrafricană", "Bangui", "Beirut", "Johannis Burg", "Pretoria", 1);
        addQuestion(c21);

        Question c22 = new Question("Gambia", "Bangui", "Banjul", "Bamako", "Berlin", 2);
        addQuestion(c22);

        Question c23 = new Question("Liban", "Liban City", "Ankara", "Asgabat", "Beirut", 4);
        addQuestion(c23);

        Question c24 = new Question("Serbia", "Berna", "Bratislava", "Belgrad", "Ljubliana", 3);
        addQuestion(c24);

        Question c25 = new Question("Belize", "Biskek", "New York", "Bridgetown", "Belmopan", 4);
        addQuestion(c25);

        Question c26 = new Question("Germania", "Paris", "Austria", "Berlin", "Heidelberg", 3);
        addQuestion(c26);

        Question c27 = new Question("Elvetia", "Viena", "China", "Berna", "Beijing", 3);
        addQuestion(c27);

        Question c28 = new Question("Kirghizstan", "Antananariro", "Madagascar", "Basseterre", "Biskek", 4);
        addQuestion(c28);

        Question c29 = new Question("Columbia", "Bogota", "Apia", "Bamako", "Brazilia", 1);
        addQuestion(c29);

        Question c30 = new Question("Brazilia", "Peru", "Buenos Aires", "Bankok", "Brasília", 4);
        addQuestion(c30);

        Question c31 = new Question(" Slovacia", "Riga", "Tellin", "Bratislava", "Berlin", 3);
        addQuestion(c31);

        Question c32 = new Question("Belgia", "Bruxelles", "Paris", "Marsalia", "Danemarca", 1);
        addQuestion(c32);

        Question c33 = new Question("Irak", "Bangui", "Bagdad", "Bamako", "Banjul", 2);
        addQuestion(c33);

        Question c34 = new Question("Romania", "Budapesta", "Chisinau", "Moldova", "Bucuresti", 4);
        addQuestion(c34);

        Question c35 = new Question("Ungaria", "Budapesta", "Bucuresti ", "Szeged", "Covasna", 1);
        addQuestion(c35);

        Question c36 = new Question("Argentina", "Monte  Video", "Tokio", "Buenos Aires", "Peru", 3);
        addQuestion(c36);

        Question c37 = new Question(" Egipt", "Cairo", "Tutankamon city", "Iordaania", "Pretoria", 1);
        addQuestion(c37);

        Question c38 = new Question("Australia", "Sidney", "Canberra", "Londra", "Noua Zeelanda", 2);
        addQuestion(c38);

        Question c39 = new Question("Venezuela", "Madrid", "Bosfor", "Caracas", "Venezuella City", 3);
        addQuestion(c39);

        Question c40 = new Question("Republica Moldova", "Chisinau", "Botosani", "Vaslui", "Tecuci", 1);
        addQuestion(c40);

        Question c41 = new Question("Guatemala", "Guatamella", "Ciudad de Guatemala", "Roma", "Dakar", 2);
        addQuestion(c41);

        Question c42 = new Question("Mexic", "Ciudad de México", "Puerto Rico", "Mexico City", "Texas", 1);
        addQuestion(c42);

        Question c43 = new Question("Guineea", "Ankara", "Guineea Bissau", "Madrid", "Conakry", 4);
        addQuestion(c43);

        Question c44 = new Question("Danemarca", "Amsterdam", "Australia", "Copenhaga", "Olanda", 3);
        addQuestion(c44);

        Question c45 = new Question("Senegal", "Kiew", "Atena", "Asgabat", "Dakar", 4);
        addQuestion(c45);

        Question c46 = new Question("Siria", "Amsterdam", "Haga", "Damasc", "Sofia", 3);
        addQuestion(c46);

        Question c47 = new Question("Djibouti", "Dili", "City of Djibouti", "Panama", "Djibouti", 4);
        addQuestion(c47);

        Question c48 = new Question("Bangladesh", "Andorra", "Dili", "Dhaka", "Rusia", 3);
        addQuestion(c48);

        Question c49 = new Question(" Armenia", "Japonia", "Gaborone", "Erevan", "Everest", 3);
        addQuestion(c49);

        Question c50 = new Question("Sierra Leone", "Gitega", "Gibraltar", "Georgetown", "Freetown", 4);
        addQuestion(c50);

        Question c51 = new Question("Botswana", "Gaborone", "Apia", "Bamako", "Pretoria", 1);
        addQuestion(c51);

        Question c52 = new Question("Eritreea", "Eritreea City", "Asmara", "Bankok", "Wuhan", 2);
        addQuestion(c52);

        Question c53 = new Question("Burundi", "Avarua", "Bangui", "Gitega", "Narnia", 3);
        addQuestion(c53);

        Question c54 = new Question("Vietnam", "Hanoi", "Liban", "Harare", "Persia", 1);
        addQuestion(c54);

        Question c55 = new Question("Zimbabwe", "Honiara", "Harare", "Bamako", "Laponia", 2);
        addQuestion(c55);

        Question c56 = new Question("Cuba", "Dunarea", "Belmopan", "Caraibe", "Havana", 4);
        addQuestion(c56);

        Question c57 = new Question("Finlanda", "Helsenki", "Ikea ", "Oslo", "Lituania", 1);
        addQuestion(c57);

        Question c58 = new Question("Israel", "Turkmenistan", "Tel Aviv", "Ierusalim", "Iordania", 3);
        addQuestion(c58);

        Question c59 = new Question(" Pakistan", "Islamabad", "Pakistan", "Astana", "Turkmenistan", 1);
        addQuestion(c59);

        Question c60 = new Question("Indonezia", "Bangui", "Jakarta", "Bamako", "Singaore", 2);
        addQuestion(c60);

        Question c61 = new Question("Afganistan", "Astana", "Ankara", "Asgabat", "Kabul", 4);
        addQuestion(c61);

        Question c62 = new Question("Uganda", "Kigali", "Rowanda", "Kampala", "Uganda", 3);
        addQuestion(c62);

        Question c63 = new Question("Nepal", "Biskek", "New York", "Bridgetown", "Kathmandu", 4);
        addQuestion(c63);

        Question c64 = new Question("Ucraina", "Crimeea", "Austria", "Kiew", "Rusia", 3);
        addQuestion(c64);

        Question c65 = new Question("Kuweit", "Lima", "Al Kuweit", "Kuweit", "Beijing", 3);
        addQuestion(c65);

        Question c66 = new Question("Peru", "Quatar", "Brazilia", "Luna", "Lima", 4);
        addQuestion(c66);

        Question c67 = new Question("Portugalia", "Lisabona", "Spania", "Barcelona", "Telega", 1);
        addQuestion(c67);

        Question c68 = new Question("Regatul Unit", "Alabama", "America", "Irlanda", "Londra", 4);
        addQuestion(c68);

        Question c69 = new Question(" Spania", "Canare", "Otopeni", "Madrid", "Barcelona", 3);
        addQuestion(c31);

        Question c70 = new Question("Maldive", "Male", "Madrid", "Islanda", "Australia", 1);
        addQuestion(c69);

        Question c71 = new Question("Nicaragua", "Bangui", "Managua", "Bamako", "Maputo", 2);
        addQuestion(c71);

        Question c72 = new Question("Filipne", "Mongolia", "Sri Lanka", "Filipine", "Manila", 4);
        addQuestion(c72);

        Question c73 = new Question("Belarus", "Minks", "Bucuresti ", "Lituania", "Varsovia", 1);
        addQuestion(c73);

        Question c74 = new Question("Liberia", "Monte  Video", "Kyoto", "Liber", "Liberia", 3);
        addQuestion(c74);

        Question c75 = new Question(" Uruguay", "Montevideo", "Cairo", "Paraguai", "Pretoria", 1);
        addQuestion(c75);

        Question c76 = new Question("Rusia", "Sidney", "Moscova", "Londra", "Anglia", 2);
        addQuestion(c76);

        Question c77 = new Question("Oman", "Muscat", "Mascat", "Oman", "Italia", 1);
        addQuestion(c77);

        Question c78 = new Question("Brazilia", "Peru", "Buenos Aires", "Bankok", "Brasília", 4);
        addQuestion(c78);

        Question c79 = new Question(" Bahamas", "Naypyidaw", "Nairobi", "Nassau", "Berlin", 3);
        addQuestion(c79);

        Question c80 = new Question("Kenya", "Nairobi", "Tokio", "Helsenki", "Denver", 1);
        addQuestion(c80);

        Question c81 = new Question("Cipru", "Grecia", "Nicosia", "Atena", "Constantinopol", 2);
        addQuestion(c81);

        Question c82 = new Question("Norvgia", "Laponia", "Helsenki", "Olso", "Oslo", 4);
        addQuestion(c82);

        Question c83 = new Question("Canada", "Ottawa", "SUA ", "Toronto", "Chile", 1);
        addQuestion(c83);

        Question c84 = new Question("Burkina Faso", "Papeete", "Palikir", "Ouagadougou", "Pago Pago", 3);
        addQuestion(c84);

        Question c85 = new Question(" Franta", "Paris", "Belgia", "Cannes", "Nisa", 1);
        addQuestion(c85);

        Question c86 = new Question("Coreea de Nord", "Beijign", "Phenian", "China", "Phnom Penh", 2);
        addQuestion(c86);

        Question c87 = new Question("Cehia", "Praga", "Viena", "Varsovia", "Germania", 1);
        addQuestion(c87);

        Question c88 = new Question("Maroc", "Peru", "Riad", "Bankok", "Rabat", 4);
        addQuestion(c88);

        Question c89 = new Question(" Palestina", "Quito", "Nairobi", "Ramallah", "Bloemfontein", 3);
        addQuestion(c89);

        Question c90 = new Question("Letonia", "Riga", "Talin", "Helsenki", "Oslo", 1);
        addQuestion(c90);

        Question c91 = new Question("Italia", "Sicilia", "Roma", "Venetia", "Toronto", 2);
        addQuestion(c91);

        Question c92 = new Question("Bosnia si Hertegovina", "Narnia", "Kosovo", "Pristina", "Sarajevo", 4);
        addQuestion(c92);

        Question c93 = new Question("Coreea de Sud", "Seul", "Phenian ", "Tokyo", "Oceanul Pacific", 1);
        addQuestion(c93);

        Question c94 = new Question("Bulgaria", "Groenlanda", "Palikir", "Sofia", "Varna", 3);
        addQuestion(c94);

        Question c95 = new Question("Suedia", "Stokholm", "Oslo", "Singapore", "Craiova", 1);
        addQuestion(c95);

        Question c96 = new Question(" Mongolia", "Ulanbatar", "Ulaanbaatar", "Vaduz", "Phnom Penh", 2);
        addQuestion(c96);
    }

    public ArrayList<Question> getAllQuestions(){
        ArrayList<Question> questionList = new ArrayList<>();

        dataBase = getReadableDatabase();

        String Projection [] = {
                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NUMBER
        };

        Cursor c = dataBase.query(QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null
        );

        if(c.moveToFirst()){
            do{
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setAns1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setAns2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setAns3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setAns4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NUMBER)));

                questionList.add(question);
            }while(c.moveToNext());
        }
        c.close();
        return questionList;
    }

}
