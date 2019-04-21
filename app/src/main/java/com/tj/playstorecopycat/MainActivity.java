package com.tj.playstorecopycat;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tj.playstorecopycat.adapters.appAdapter;
import com.tj.playstorecopycat.databinding.ActivityMainBinding;
import com.tj.playstorecopycat.datas.App;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    appAdapter mAppAdapter;

    List<App> appList = new ArrayList<>();

    ActivityMainBinding act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        act = DataBindingUtil.setContentView(this,R.layout.activity_main);

        fillApss();

        mAppAdapter = new appAdapter(MainActivity.this, appList);
        act.appLankListView.setAdapter(mAppAdapter);
        //act.tilteTxt.setText("제목 화면");

//        Q1. 확인버튼이 눌리면 "확인버튼을 눌렀습니다". 라는 토스트를 띄어봅시다.
        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "확인버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void fillApss(){
        appList.add(new App(1,"아스팔트 8:에어본","GameLoft",5,6000, true));
        appList.add(new App(2,"MineCraft - Pocket Edition","Mojang",4,5000, true));
        appList.add(new App(3,"아스팔트 7:하트","GameLoft",2,1000, false));
        appList.add(new App(4,"팔라독(Paladog)","FazeCat",3,1087, false));
        appList.add(new App(5,"Plasnts Vs. Zomboes","EA Swiss Sarl",1,2000, false));
        appList.add(new App(6,"스왐피(Swampy)","Disney",4,3000, false));
    }

}
