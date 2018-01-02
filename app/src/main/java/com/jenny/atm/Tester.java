package com.jenny.atm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2018/1/2.
 */

public class Tester {
    public static void main(String[] args) {
        Date now = new Date();  //儲存當下日期
        System.out.println(now);
        System.out.println(now.getTime());
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(now));
        //反過來，給字串，得Date
        String s = "1998-07-20";
        try {
            Date birthday = sdf.parse(s);
            System.out.println(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
