package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String dateTime(String format){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String firstDueDate(){
        Date dataVencimento = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(dataVencimento);
        c.add(Calendar.DATE, +10);

        System.out.println(c.getTime().toString());
        return c.getTime().toString();
    }
}
