package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.AnswerCallbackQuery;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import com.pengrad.telegrambot.request.SendInvoice;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;
import com.pengrad.telegrambot.utility.BotUtils;
import org.example.users.User;
import org.example.users.Users;

import java.security.Key;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static String BOT_TOKKEN_test = "7039553340:AAHCuowlWMQltfoQNwXOg6MUQ3srtm95N0o";

    public static void main(String[] args) {
//        for (int i = 0; i < 3500; i++) {
//            System.out.println(i);
//            System.out.println(Accept_date_birth.reduce_number_to_single_digit(i));
//            System.out.println();
//        }


        TelegramBot bot = new TelegramBot(BOT_TOKKEN_test);

//        for (int i = 1; i < 3000; i++) {
//            System.out.println("--"+i);
//            System.out.println(reduce_number_to_single_digit(i));
//        }
//
//        System.out.println(Accept_date_birth.get_date("25.03.87"));
//        System.out.println(Accept_date_birth.get_date("25.03.1987"));
//        System.out.println(Accept_date_birth.get_date("25/03/87"));
//        System.out.println(Accept_date_birth.get_date("25-03-2015"));
//        System.out.println(Accept_date_birth.get_date("25 03 86"));
//        System.out.println(Accept_date_birth.get_date("25 03 1986"));
//        System.out.println(Accept_date_birth.get_date("25_03_86"));
//        Accept_date_birth.get_date("25_03_86");
//        System.out.println("-----");
//        System.out.println("11");
//            System.out.println(Accept_date_birth.reduce_number_to_single_digit(11));
//        System.out.println("-----");
//        System.out.println("1987");


        //    System.out.println(Accept_date_birth.reduce_number_to_single_digit(1987));

//        System.out.println(Users.fine_user(13L));
//        if(Users.fine_user(13L)==null) System.out.println("--");


        bot.setUpdatesListener(updates -> {
            Update mes;
            Long id_user;

            for (int i = 0; i < updates.size(); i++) {

                try {


                    mes = updates.get(i);
                    System.out.println(mes);
                    if (mes.callbackQuery() != null) {
                        //System.out.println("callbackQuery");
                        BaseResponse response = bot.execute(new AnswerCallbackQuery(mes.callbackQuery().id()));
                        bot.execute(new AnswerInlineQuery("callbackQuery"));

                        // System.out.println(mes.callbackQuery().data());
                        System.out.println(mes.callbackQuery());
                        long chatId = mes.callbackQuery().from().id();
                        if (Users.fine_user(chatId).getEtap() != 1) {
                            bot.execute(new SendMessage(chatId, "Напиши дату рождения в формате дд.мм.гггг"));

                        }else {
                            if (mes.callbackQuery().data().equals("callback_data1"))
                                bot.execute(new SendMessage(chatId, "Сфера личности"));
                            if (mes.callbackQuery().data().equals("callback_data2"))
                                bot.execute(new SendMessage(chatId, "Сфера духовности"));
                            if (mes.callbackQuery().data().equals("callback_data3"))
                                bot.execute(new SendMessage(chatId, "сфера денег"));
                            if (mes.callbackQuery().data().equals("callback_data4"))
                                bot.execute(new SendMessage(chatId, "сфера отношений"));
                            if (mes.callbackQuery().data().equals("callback_data5"))
                                bot.execute(new SendMessage(chatId, "сфера здоровья"));
                            if (mes.callbackQuery().data().equals("callback_data6"))
                                bot.execute(new SendMessage(chatId, "высшая миссия души"));


                            if (mes.callbackQuery().data().equals("restart")){
                                bot.execute(new SendMessage(chatId, "Напиши дату рождения в формате дд.мм.гггг"));
                                Users.fine_user(chatId).restart_etap();

                            }
                            if (Users.fine_user(chatId).getEtap() == 1) bot.execute(new SendMessage(chatId, "Выберети сферу :").protectContent(true).replyMarkup(Keyboar.getKeyBord()));
                        }

                    }


                    if (mes.message() != null) {
                        id_user = mes.message().from().id();
                        long chatId = mes.message().chat().id();
                        String text_messege = get_text_to_mesege_from_update(mes);
                        String answer = process_message(text_messege, id_user);

                        if (Users.fine_user(id_user).getEtap() == 0)
                            bot.execute(new SendMessage(chatId, answer).replyToMessageId(mes.message().messageId()));
                        if (Users.fine_user(id_user).getEtap() == 1) {
                            SendMessage call = new SendMessage(chatId, "Выберети сферу :").protectContent(true).replyMarkup(Keyboar.getKeyBord());
                            bot.execute(call);
                        }
                    }

//                String data_b = Accept_date_birth.get_date(mes.message().text());
//              //  System.out.println(data_b + "!!");
//                //if (data_b.length() < 1) bot.execute(new SendMessage(chatId, "еще раз в другом формате Нпример 25.03.87").replyToMessageId(mes.message().messageId()));else
//                bot.execute(new SendMessage(chatId, answer).replyToMessageId(mes.message().messageId()));
//
//                try {
//                    int add[] = Accept_date_birth.get_10_ches(data_b);
//                    bot.execute(new SendMessage(chatId, add[0] + "   "+ add[1]  + "   "+ add[2]).replyToMessageId(mes.message().messageId()));
//
//                } catch (ParseException e) {
//                    throw new RuntimeException(e);
//                }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }


            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }, e -> {
            if (e.response() != null) {
                // got bad response from telegram
                e.response().errorCode();
                e.response().description();
            } else {
                // probably network error
                e.printStackTrace();
            }
        });


    }

    private static String process_message(String mes, Long user_id) {
        StringBuilder sb = new StringBuilder();
        User user = Users.fine_user(user_id);
        //System.out.println(user.getDate_birth());
        String bd = Accept_date_birth.get_date(mes);
        if (bd.length() > 1) user.setDate_birth(bd);

        if (user.getDate_birth() == null) sb.append("Напиши дату рождения в формате дд.мм.гггг");
        else sb.append(user.getDate_birth());

        return sb.toString();

    }

    private static String get_text_to_mesege_from_update(Update update) {
        //   System.out.println(update);
        String result = update.message().text();
        // if (result == null) update.;
        return result;
    }


}



