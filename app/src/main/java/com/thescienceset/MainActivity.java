package com.thescienceset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager sliderPage;
    private LinearLayout sliderDots;
    private SliderAdapter sliderAdapter;
    private Button btnNext;
    private Button btnBack;

    private  TextView[] mDots;
    private int currentPage = 0 ; // To handle current page

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderPage = findViewById(R.id.slider_page);
        sliderDots = findViewById(R.id.slider_dots);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);

        sliderAdapter = new SliderAdapter(this);
        sliderPage.setAdapter(sliderAdapter);
        addDotsIndicators(0);

        //When page is changed, swiping
        sliderPage.addOnPageChangeListener(viewPageListener);

        //Back and next click listners
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliderPage.setCurrentItem(currentPage + 1);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sliderPage.setCurrentItem(currentPage - 1);
            }
        });
    }

    public void addDotsIndicators(int position){
        mDots = new TextView[3];
        sliderDots.removeAllViews();
        for (int i=0;i<mDots.length;i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            sliderDots.addView(mDots[i]);
        }

        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorGreen));
        }
    }

    ViewPager.OnPageChangeListener viewPageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicators(position);
            currentPage = position;
            if(position == 0){
                btnBack.setEnabled(false);
                btnNext.setEnabled(true);
                btnBack.setVisibility(View.INVISIBLE);

                btnNext.setText("Next");
                btnBack.setText("");
            }else if(position == mDots.length -1 ){
                btnBack.setEnabled(true);
                btnNext.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);

                btnNext.setText("Finish");
                btnBack.setText("Back");
            }else{
                btnBack.setEnabled(true);
                btnNext.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);

                btnNext.setText("Next");
                btnBack.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
