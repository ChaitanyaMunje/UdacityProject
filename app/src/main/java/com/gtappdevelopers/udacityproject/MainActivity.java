package com.gtappdevelopers.udacityproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_name,edt_answer;
    CheckBox python_check,java_check,html_check,xm_check;
    RadioGroup radioGroup,radioGroup2,radioGroup3;
    RadioButton radioButton,radioButton2,radioButton3;
    String q1ans,q2ans,q3ans,q4ans,q5ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name=findViewById(R.id.edt_name);
        edt_answer=findViewById(R.id.edt_answer);
        radioGroup=findViewById(R.id.radio_group);
        radioGroup2=findViewById(R.id.radio_group_2);
        radioGroup3=findViewById(R.id.radio_group_3);
        python_check=findViewById(R.id.check_quest_1);
        java_check=findViewById(R.id.check_quest_2);
        xm_check=findViewById(R.id.check_quest_3);
        html_check=findViewById(R.id.check_quest_4);

        Person person=new Person();

        Log.e("DARA","data = "+person.localcount+"\n"+ Person.count);

        Calculator.add(10,90);
        Calculator.sub(50,25);


    }

    public void submit(View view) {
        if (edt_name.getText().toString().isEmpty()){
            Toast.makeText(this, "Please Enter your Name", Toast.LENGTH_SHORT).show();
        }
        else {
            if (java_check.isChecked() && xm_check.isChecked() && !html_check.isChecked() && !python_check.isChecked()){
                q1ans="Correct Answer";
            }
            else {
                q1ans="Wrong Answer";
            }

            // for 2nd question

            int radioId = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(radioId);
            if (radioId == -1){
                Toast.makeText(this, "Please Answer this question", Toast.LENGTH_SHORT).show();
                q2ans="Please Answer this question";
            }
            else if (radioButton.getText().toString().equals("Bill Gates")){
                q2ans="Correct Answer";
            }
            else {
                q2ans="Wrong Answer";
            }

            // for question 3

            int radio2id=radioGroup2.getCheckedRadioButtonId();
            radioButton2=findViewById(radio2id);

            if (radio2id == -1){
                q3ans="Please Answer this question";
            }
            else if (radioButton2.getText().toString().equals("sp")){
                q3ans="Correct Answer";
            }
            else {
                q3ans="Wrong Answer";
            }

            // for question 4
            int radio3id=radioGroup3.getCheckedRadioButtonId();
            radioButton3=findViewById(radio3id);

            if (radio3id == -1){
                q4ans="Please Answer this question";
            }
            else if (radioButton3.getText().toString().equals("int")){
                q4ans="Correct Answer";
            }
            else {
                q4ans="Wrong Answer";
            }

            // for question 5
            if (edt_answer.getText().toString().equals("boolean")){
                q5ans="Correct Answer";

            }
            else if (edt_answer.getText().toString().isEmpty()){
                q5ans="Please answer this question";

            }
            else {
                q5ans="Wrong Answer";
            }

            String correct="Correct Answer";
            if (q1ans.equals(correct) && q2ans.equals(correct) && q3ans.equals(correct) && q4ans.equals(correct) && q5ans.equals(correct)){
                Toast.makeText(this, "Congratulations "+edt_name.getText().toString()+"\n"+"Your all answers are correct.", Toast.LENGTH_SHORT).show();
            }
            else {
                String ans =q1ans + "\n" + q2ans + "\n" + q3ans + "\n" + q4ans + "\n" + q5ans;
                Toast.makeText(this, ans, Toast.LENGTH_SHORT).show();

            }
        }
    }
}
