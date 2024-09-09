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

    public static Integer V1 = 99;
    public static Integer V2 = 99;
    public static Integer V3 = 99;
    public static Integer V4 = 99;
    public static Integer V5 = 99;

    //Внутри звезды
    public static Integer q1 = 91;
    public static Integer q2 = 92;
    public static Integer q3 = 93;
    public static Integer q4 = 94;
    public static Integer q5 = 95;

    public static Integer U1 = 99;
    public static Integer U2 = 99;
    public static Integer U3 = 99;
    public static Integer U4 = 99;
    public static Integer U5 = 99;
    public static Integer U6 = 99;
    public static Integer U7 = 99;
    public static Integer U8 = 99;
    public static Integer U9 = 99;
    public static Integer U10 = 99;


    public static int[] calculate_success_code() {
        int[] cods = {10, 20, 30, 40};


        return cods;
    }

    public static Calendar StringToCalendar(String date_b) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = sdf.parse(date_b);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            // System.out.println(cal);
//            System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//            System.out.println(cal.get(Calendar.MONTH) + 1);
//            System.out.println(cal.get(Calendar.YEAR));
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

    static public int reduce_number_to_single_digit(int in, int to) {
        if (in < to) return in;
        if (in == to) return 1;
        int temp = 0;
        while (in > to) {

            while (in > 0) {
                long l = in % 10;
                temp += l;
                in /= 10;
            }
        }
        if (temp > to) temp = reduce_number_to_single_digit(temp);
        if (temp == to) temp = 1;
        return temp;
    }

    static public HashMap<Integer, Integer> calck_number(String birthday) {
        HashMap<Integer, Integer> nomera = new HashMap<>();

        Calendar calendar = Service.StringToCalendar(birthday);

        int lig = Service.reduce_number_to_single_digit(calendar.get(Calendar.DAY_OF_MONTH));
        int duh = Service.reduce_number_to_single_digit(calendar.get(Calendar.MONTH) + 1);
        int finans = Service.reduce_number_to_single_digit(calendar.get(Calendar.YEAR));

        int otnoh = Service.reduce_number_to_single_digit(lig + duh + finans);
        int zdor = Service.reduce_number_to_single_digit(lig + duh + finans + otnoh);
        int missia_duh = Service.reduce_number_to_single_digit(lig + duh + finans + otnoh + zdor);

        nomera.put(LICHNOST, lig);
        nomera.put(DUCHOVNOST, duh);
        nomera.put(FINANS, finans);

        nomera.put(OTNOSHENIE, otnoh);
        nomera.put(ZDOROVIE, zdor);
        nomera.put(MISSION_DUSHI, missia_duh);

        Service.V1 = Service.reduce_number_to_single_digit(lig + duh);
        Service.V2 = Service.reduce_number_to_single_digit(duh + finans);
        Service.V4 = Service.reduce_number_to_single_digit(finans + otnoh);
        Service.V5 = Service.reduce_number_to_single_digit(otnoh + zdor);
        Service.V3 = Service.reduce_number_to_single_digit(zdor + lig);

        Service.U1 = Service.reduce_number_to_single_digit(lig + Service.V1);
        Service.U2 = Service.reduce_number_to_single_digit(duh + Service.V1);

        Service.U3 = Service.reduce_number_to_single_digit(duh + Service.V2);
        Service.U4 = Service.reduce_number_to_single_digit(finans + Service.V2);

        Service.U5 = Service.reduce_number_to_single_digit(lig + Service.V5);
        Service.U6 = Service.reduce_number_to_single_digit(zdor + Service.V5);
        Service.U7 = Service.reduce_number_to_single_digit(zdor + Service.V3);

        Service.U8 = Service.reduce_number_to_single_digit(otnoh + Service.V5);
        Service.U9 = Service.reduce_number_to_single_digit(otnoh + Service.V4);
        Service.U10 = Service.reduce_number_to_single_digit(finans + Service.V4);

        Service.q1 = Service.reduce_number_to_single_digit(Service.V1 + Service.V2);
        Service.q2 = Service.reduce_number_to_single_digit(Service.V2 + Service.V3);

        Service.q3 = Service.reduce_number_to_single_digit(Service.V2 + Service.V4);
        Service.q4 = Service.reduce_number_to_single_digit(Service.V3 + Service.V5);
//
        Service.q5 = Service.reduce_number_to_single_digit(Service.V5 + Service.V4);

//
//        System.out.println("----VV");
//        System.out.println("V1= " + V1);
//        System.out.println(V2);
//        System.out.println("V3= " + V3);
//        System.out.println(V4);
//        System.out.println("V5= " + V5);
//
//        System.out.println("----");
//
//        System.out.println("----UU");
//        System.out.println("U1= " + U1);
//        System.out.println("U2= " + U2);
//        System.out.println(U3);
//        System.out.println(U4);
//        System.out.println("U5= " + U5);
//        System.out.println("U6= " + U6);
//        System.out.println(U7);
//        System.out.println("U8= " + U8);
//        System.out.println(U9);
//        System.out.println("U10= " + U10);
//        System.out.println("----");


        return nomera;
    }


}
