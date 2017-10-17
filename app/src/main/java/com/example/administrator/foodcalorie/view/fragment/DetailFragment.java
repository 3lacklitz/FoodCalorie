package com.example.administrator.foodcalorie.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.foodcalorie.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends Fragment {
    @BindView(R.id.txt_show_cal)
    TextView showCal;
    @BindView(R.id.txt_cal)
    TextView textCal;
    private int counter, total, counter1, total1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);

//        Bundle bundle = getActivity().getIntent().getExtras();
//        double value = bundle.getDouble("Result");

        TextViewAnimationShowCal(0, "Result", showCal);
        TextViewAnimationCal(0, "1234", textCal);

        return view;
    }

    private void TextViewAnimationShowCal(int mulai, String total_laporan, final TextView showCal) {
        counter = mulai;
        total = Integer.parseInt(total_laporan);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (counter<total){
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    showCal.post(new Runnable() {
                        @Override
                        public void run() {
                            showCal.setText("" + counter);
                        }
                    });
                    counter++;
                }
            }
        }).start();
    }

    private void TextViewAnimationCal(int mulai, String total_laporan, final TextView showCal) {
        counter1 = mulai;
        total1 = Integer.parseInt(total_laporan);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (counter1<total1){
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    textCal.post(new Runnable() {
                        @Override
                        public void run() {
                            textCal.setText("" + counter1);
                        }
                    });
                    counter1++;
                }
            }
        }).start();
    }

}
