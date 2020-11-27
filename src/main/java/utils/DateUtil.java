package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String dateTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy_hh.mm");
        return simpleDateFormat.format(date);
    }
}
