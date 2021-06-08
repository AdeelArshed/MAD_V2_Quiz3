package com.example.mad_v2_quiz3;

import android.app.Application;

import java.util.LinkedList;

public class AppData extends Application {
    public static LinkedList<StdInfo> students;

    @Override
    public void onCreate() {
        super.onCreate();
        students=new LinkedList<>();
     //  StdDB db=new StdDB(this);

      //  db.open();
      //  db.getData();
    //    db.close();

    }
}
