package org.bbt.ciss.ciss.view;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.bbt.ciss.ciss.BaseView;
import org.bbt.ciss.ciss.R;
import org.bbt.ciss.ciss.model.pojo.SemesterSchedule;
import org.bbt.ciss.ciss.presenter.SemesterSchedulePresenter;

import java.lang.reflect.Method;

/**
 * @author Yukino Yukinoshita
 */

public class SemesterScheduleView extends AppCompatActivity implements BaseView {

    private SemesterSchedulePresenter semesterSchedulePresenter;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                default:
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_schedule);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        semesterSchedulePresenter = new SemesterSchedulePresenter(this, new SemesterSchedule());
        addButton();
    }

    public void onClickAddCourse(View view) {
        String courseName = getCourseName();
        semesterSchedulePresenter.addCourse(courseName);
    }

    public void onClickShowCourse(View view) {
        semesterSchedulePresenter.getCourse();
    }

    public void showCourse(String courseName) {
        TextView textView = findViewById(R.id.message);
        textView.setText(courseName);
    }

    private String getCourseName() {
        TextView textView = findViewById(R.id.editText);
        return textView.getText().toString();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void addButton() {
        LinearLayout linearLayout = findViewById(R.id.horizontalTitle);
        Button button = new Button(this);
        int wid = (int)(((double)getRealWidth())/15);
        //Month Button
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(wid,90);
        button.setLayoutParams(layoutParams);
        linearLayout.addView(button);
        //Day Button
        layoutParams = new ViewGroup.LayoutParams(wid*2,90);
        for(int i=0;i<7;++i){
            button = new Button(this);
            button.setLayoutParams(layoutParams);
            linearLayout.addView(button);
        }

        //Time Button
        linearLayout = findViewById(R.id.verticalTitle);
        layoutParams.width = wid;
        layoutParams.height = getContainerHeight()/12;
        for(int i=0;i<12;++i){
            button = new Button(this);
            button.setLayoutParams(layoutParams);
            button.setText(String.valueOf(i+1));
            button.setTextSize(button.getTextSize()/3);
            linearLayout.addView(button);
        }
        
    }

    private int getRealHeight() {
        int dpi = 0;
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            dpi = dm.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dpi;
    }

    private int getRealWidth() {
        int dpi = 0;
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            dpi = dm.widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dpi;
    }

    private int getContainerHeight()
    {
        LinearLayout HorizontalTitle = findViewById(R.id.horizontalTitle);
        android.support.design.widget.BottomNavigationView Navigation = findViewById(R.id.navigation);
        Navigation.measure(0, 0);
        HorizontalTitle.measure(0, 0);
        return getRealHeight() - getStatusBarHeight() - 90 - Navigation.getMeasuredHeight() - getBottomStatusHeight();
    }


    private int getContainerWidth()
    {
        android.support.constraint.ConstraintLayout Container = findViewById(R.id.container);
        return Container.getMeasuredWidth();
    }

    private int getStatusBarHeight() {
        Resources resources = getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen","android");
        int statusBarHeight = resources.getDimensionPixelSize(resourceId);
        return statusBarHeight;
    }

    private int getBottomStatusHeight()
    {
        WindowManager wm1 = this.getWindowManager();
        int height = wm1.getDefaultDisplay().getHeight();
        return getRealHeight()-height;
    }
}
