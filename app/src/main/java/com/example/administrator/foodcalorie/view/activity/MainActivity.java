package com.example.administrator.foodcalorie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.foodcalorie.R;
import com.example.administrator.foodcalorie.Util;
import com.example.administrator.foodcalorie.view.adapter.ViewAdapter;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.view_pager_food)
    ViewPager viewPager;
    @BindView(R.id.type_motion)
    Spinner spinnerTypeMotion;
    @BindView(R.id.txt_weight)
    EditText inputWeight;
    @BindView(R.id.txt_high)
    EditText inputHigh;
    @BindView(R.id.txt_age)
    EditText inputAge;
    @BindView(R.id.rb_male)
    RadioButton rdMale;
    @BindView(R.id.rb_female)
    RadioButton rdFemale;


    Double result, valueType;
    String type[] = {"นั่งทำงานอยู่กับที่ และไม่ได้ออกกำลังกายเลย", "ออกกำลังกายหรือเล่นกีฬาเล็กน้อย ประมาณอาทิตย์ละ 1-3 วัน", "ออกกำลังกายหรือเล่นกีฬาปานกลาง ประมาณอาทิตย์ละ 3-5 วัน", "ออกกำลังกายหรือเล่นกีฬาอย่างหนัก ประมาณอาทิตย์ละ 6-7 วัน", "ออกกำลังกายหรือเล่นกีฬาอย่างหนักทุกวันเช้าเย็น"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setAdaptor();
        setTypeMotion();

//        radioGroup = (RadioGroup) findViewById(R.id.rg_sex);
//        radioGroup.clearCheck();
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton rb = (RadioButton) group.findViewById(checkedId);
//                if (null != rb && checkedId > -1) {
//                    Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
    }

    private void setTypeMotion() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeMotion.setAdapter(adapter);
        spinnerTypeMotion.setOnItemSelectedListener(onChoose);
    }

    AdapterView.OnItemSelectedListener onChoose = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            if (type[arg2] == "นั่งทำงานอยู่กับที่ และไม่ได้ออกกำลังกายเลย") {
                valueType = 1.2;
            } else if (type[arg2] == "ออกกำลังกายหรือเล่นกีฬาเล็กน้อย ประมาณอาทิตย์ละ 1-3 วัน") {
                valueType = 1.375;
            } else if (type[arg2] == "ออกกำลังกายหรือเล่นกีฬาปานกลาง ประมาณอาทิตย์ละ 3-5 วัน") {
                valueType = 1.55;
            } else if (type[arg2] == "ออกกำลังกายหรือเล่นกีฬาอย่างหนัก ประมาณอาทิตย์ละ 6-7 วัน") {
                valueType = 1.725;
            } else if (type[arg2] == "ออกกำลังกายหรือเล่นกีฬาอย่างหนักทุกวันเช้าเย็น") {
                valueType = 1.9;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    };

    @OnClick(R.id.btn_calculator)
    void onCalculatorButtonClick() {
        String insertWeight = inputWeight.getText().toString();
        String insertHigh = inputHigh.getText().toString();
        String insertAge = inputAge.getText().toString();
        if (Util.validateData(insertWeight, insertHigh, insertAge, this)) {

        } else {
            if (rdMale.isChecked()) {
                result = valueType * (66 + (13.7 * Double.valueOf(insertWeight)) + (5 * Double.valueOf(insertHigh)) - (6.8 * Double.valueOf(insertAge)));
            } else if (rdFemale.isChecked()) {
                result = valueType * (665 + (9.6 * Double.valueOf(insertWeight)) + (1.8 * Double.valueOf(insertHigh)) - (4.7 * Double.valueOf(insertAge)));
            }
            Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getBaseContext(), CalorieActivity.class);
            intent.putExtra("Result", result);
            startActivity(intent);
        }
    }

//        RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
//        Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();

    private void setAdaptor() {
        viewPager.setAdapter(new ViewAdapter(this));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 6000);
    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    } else if (viewPager.getCurrentItem() == 3) {
                        viewPager.setCurrentItem(4);
                    } else if (viewPager.getCurrentItem() == 4) {
                        viewPager.setCurrentItem(5);
                    } else if (viewPager.getCurrentItem() == 5) {
                        viewPager.setCurrentItem(6);
                    } else if (viewPager.getCurrentItem() == 6) {
                        viewPager.setCurrentItem(7);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}


