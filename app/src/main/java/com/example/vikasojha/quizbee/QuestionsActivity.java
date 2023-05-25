package com.example.vikasojha.quizbee;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    //    String questions[] = {
//                            "Which method can be defined only once in a program?",
//                            "Which of these is not a bitwise operator?",
//                            "Which keyword is used by method to refer to the object that invoked it?",
//                            "Which of these keywords is used to define interfaces in Java?",
//                            "Which of these access specifiers can be used for an interface?",
//                            "Which of the following is correct way of importing an entire package ‘pkg’?",
//                            "What is the return type of Constructors?",
//                            "Which of the following package stores all the standard java classes?",
//                            "Which of these method of class String is used to compare two String objects for their equality?",
//                            "An expression involving byte, int, & literal numbers is promoted to which of these?"
//                         };
//    String answers[] = {"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};
//    String opt[] = {
//                    "finalize method","main method","static method","private method",
//                    "&","&=","|=","<=",
//                    "import","this","catch","abstract",
//                    "Interface","interface","intf","Intf",
//                    "public","protected","private","All of the mentioned",
//                    "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
//                    "int","float","void","None of the mentioned",
//                    "lang","java","util","java.packages",
//                    "equals()","Equals()","isequal()","Isequal()",
//                     "int","long","byte","float"
//                   };
    String questions[] = {
            "You should wear _____ to keep your hands warm. It's very cold outside.",
            "Nam's family has been living _____ Ha Noi for twenty years.",
            "Don't worry too much. We all _____ mistakes sometimes.",
            "Jane has been trying to solve this problem all week, but she still hasn't been able to _____ it.",
            "My sister and I share the housework. We take turns to _____ the dishes and clean the house.",
            "_____ the book again and again, I finally understood what the author meant.",
            "_____ you love English, the better you can learn it.",
            "The prize _____ to Xuan yesterday.",
            "The student _____ the topic when the bell rang.",
            "Life here is so good, _____ ?"
    };
    String answers[] = {"gloves", "in", "make", "crack", "wash up", "Having read", "The more", "was awarded", "were discussing", "isn't it"};
    String opt[] = {
            "hats", "gloves", "shoes", "boots",
            "over", "in", "on", "at",
            "give", "make", "put", "take",
            "crash", "break", "crack", "shatter",
            "wash through", "wash up", "wash away", "wash over",
            "Having read", "Have read", "Have been read", "Have been reading",
            "Most", "More", "The more", "Most of",
            "awards", "was awarding", "was awarded", "has awarded",
            "discuss", "have discussed", "were discussing", "are discussing",
            "isn't it", "has it", "wasn't it", "was it"
    };

    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView) findViewById(R.id.textView4);
        TextView textView = (TextView) findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText("" + correct);

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                } else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}