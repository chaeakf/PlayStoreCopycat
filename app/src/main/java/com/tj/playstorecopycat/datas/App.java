package com.tj.playstorecopycat.datas;


import java.io.Serializable;

public class App implements Serializable {
    public int rank;    //순위
    public String title;    //제목
    public  String companyName; //제조사명
    public  int userRating; //평균 평점 (별 몇개?)
    public  int price;  //구매가격
    public boolean isMine;  // 내가 구매했는지? True: 설치된 항목, Flase: 가격표시

    //Alt + insert -> Constructor
    public App(int rank, String title, String companyName, int userRating, int price, boolean isMine) {
        this.rank = rank;
        this.title = title;
        this.companyName = companyName;
        this.userRating = userRating;
        this.price = price;
        this.isMine = isMine;
    }
}
