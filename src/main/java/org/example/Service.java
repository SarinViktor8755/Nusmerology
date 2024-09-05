package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Service {
    public static Integer LICHNOST = 1;
    public static Integer DUCHOVNOST = 2;
    public static Integer FINANS = 3;
    public static Integer ZDOROVIE = 4;
    public static Integer OTNOSHENIE = 5;
    public static Integer MISSION_DUSHI = 6;
    public static int[]  calculate_success_code(){
        int[] cods = {10, 20, 30, 40};



        return cods;
    }

    public static Calendar StringToCalendar(String date_b){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = sdf.parse(date_b);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
           // System.out.println(cal);
            System.out.println(cal.get(Calendar.DAY_OF_MONTH));
            System.out.println(cal.get(Calendar.MONTH) + 1);
            System.out.println(cal.get(Calendar.YEAR));
            return cal;
        } catch (ParseException e) {
            return null;
        }

    }

    static public int reduce_number_to_single_digit(int in) {
        if (in < 10) return in;
        if (in == 10) return 1;
        int temp = 0;
        while (in > 10) {

            while (in > 0) {
                long l = in % 10;
                temp += l;
                in /= 10;
            }
        }
        if (temp > 10) temp = reduce_number_to_single_digit(temp);
        if (temp == 10) temp = 1;
        return temp;
    }
    static public HashMap<Integer,Integer> calck_number(String birthday){
        HashMap<Integer,Integer> nomera = new HashMap<>();
        Calendar calendar = Service.StringToCalendar(birthday);

        int lig = Service.reduce_number_to_single_digit(calendar.get(Calendar.DAY_OF_MONTH));
        int duh = Service.reduce_number_to_single_digit(calendar.get(Calendar.MONTH) + 1);
        int finans = Service.reduce_number_to_single_digit(calendar.get(Calendar.YEAR));

        int otnoh = Service.reduce_number_to_single_digit(lig + duh + finans);
        int zdor = Service.reduce_number_to_single_digit(lig + duh + finans + otnoh);
        int missia_duh = Service.reduce_number_to_single_digit(lig + duh + finans + otnoh + zdor);

        nomera.put(LICHNOST,lig);
        nomera.put(DUCHOVNOST,duh);
        nomera.put(FINANS,finans);

        nomera.put(OTNOSHENIE,otnoh);
        nomera.put(ZDOROVIE,zdor);
        nomera.put(MISSION_DUSHI,missia_duh);

        return nomera;
    }


}
