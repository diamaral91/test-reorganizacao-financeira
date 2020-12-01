package utils;

public class Utils {

    public static void sleep(){
        try {
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
