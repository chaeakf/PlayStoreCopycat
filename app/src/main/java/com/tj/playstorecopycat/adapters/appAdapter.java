package com.tj.playstorecopycat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tj.playstorecopycat.R;
import com.tj.playstorecopycat.datas.App;

import java.util.List;

public class appAdapter extends ArrayAdapter<App> {

    Context mContext;
    List<App> mList;
    LayoutInflater inf;

    public appAdapter(Context context, List<App> list){

        super(context, R.layout.app_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

       @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.app_list_item, null);
        }

//        실질적으로 상황에 맞게 머리를 써야하는 부분
//        각줄에 맞는 앱 데이트를 mList안에서 추출
        App appData = mList.get(position);

           TextView rankAndTitleTxt = row.findViewById(R.id.rankAndTitleTxt);
           TextView companyNameTxt = row.findViewById(R.id.companyNameTxt);
           TextView priceOrInstallTxt = row.findViewById(R.id.priceOrInstallTxt);

//            등수와 제목을 세팅.
            rankAndTitleTxt.setText(String.format("%d. %s",appData.rank, appData.title) );
//            회사 이름은 가진 그대로 대입.
            companyNameTxt.setText(appData.companyName);

//            만약 설치가 되었다면? 설치된 항목
//            안되었다면? 가격을 띄워줌. 3,000원 의양식.
           if (appData.isMine){
//               내가 설치한 항목일 경우에는 반드시 설치된 항목이라고 명띄우도록 명령
//               재사용성 때문에 원하지 않는 데이터가 나올 수 있음;
               priceOrInstallTxt.setText("설치된 항목");

//               실제 코딩은 하지 않음.
           } else {
//               설치하지 않은 경우.
//               String.format의 %,d를 이용해서 세자리마다 컴마 찍음.
               priceOrInstallTxt.setText(String.format("%,d원",appData.price));
           }



        return row;
    }
}


























