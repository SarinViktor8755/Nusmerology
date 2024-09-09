package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.SendResponse;
import org.example.users.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;

import static org.example.Service.calck_number;


public class Main {
    static String BOT_TOKKEN_test = "7128894901:AAF1nknzuvHd_tSX__ZqeIE6azK854BgxkU";

    public static void main(String[] args) {


        TelegramBot bot = new TelegramBot(BOT_TOKKEN_test);

        Save_to_disk.load_to_disk_points_for_users();
        bot.setUpdatesListener(updates -> {
            Update mes;

            for (int i = 0; i < updates.size(); i++) {
                mes = updates.get(i);
//                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
////                for (int j = 0; j < 100_000_000; j++) {
////                    calck_number("01.03.87");
////                }
//
//                System.out.println("01.03.87");
            //    System.out.println(mes);

                try {

                    //   Payment.Pay(bot,mes.message().from().id());
                    if (mes.callbackQuery() != null) _callbackQuery(mes, bot);
                    if (mes.message() != null) _massege(mes, bot);
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

    private static String process_message(String mes, Long user_id, TelegramBot bot) {
        StringBuilder sb = new StringBuilder();
        User user = Users.fine_user(user_id);
        //System.out.println(user.getDate_birth());
        String bd = Accept_date_birth.get_date(mes);
        if (bd.length() > 1) user.setDate_birth(bd);

        // if (bd.length() > 1)   StringToDate(bd);
        if (user.getDate_birth() == null) sb.append(Text_puttern.date_of_birth);
        else sb.append(user.getDate_birth());
        Save_to_disk.save_to_disk_users();
        return sb.toString();

    }

    private static String get_text_to_mesege_from_update(Update update) {
        //   System.out.println(update);
        String result = update.message().text();
        // if (result == null) update.;
        return result;
    }

    private static void _callbackQuery(Update mes, TelegramBot bot) throws NullPointerException {

        bot.execute(new AnswerCallbackQuery(mes.callbackQuery().id()));
        bot.execute(new AnswerInlineQuery("callbackQuery"));

        // System.out.println(mes.callbackQuery().data());
        //  System.out.println(mes.callbackQuery());
        long chatId = mes.callbackQuery().from().id();
        // System.out.println(Users.fine_user(chatId).getDate_birth().equals("null"));
        try {
            if (Users.fine_user(chatId).getDate_birth().equals("null"))
                Users.fine_user(chatId).setEtap(0); // если дата рождения null
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        if (Users.fine_user(chatId).getEtap() != 1) {
            bot.execute(new SendMessage(chatId, Text_puttern.date_of_birth).parseMode(ParseMode.HTML));
        } else {


            //////////
           // HashMap<Integer, Integer> nomera = Service.calck_number(Users.fine_user(chatId).getDate_birth());

            if (mes.callbackQuery().data().equals("callback_data1"))
                bot.execute(new SendMessage(chatId, Array_TEXT.getTextFromArkan(Service.LICHNOST, Service.LICHNOST)).parseMode(ParseMode.HTML));
            if (mes.callbackQuery().data().equals("callback_data2"))
                bot.execute(new SendMessage(chatId, "Сфера духовности").parseMode(ParseMode.HTML));
            if (mes.callbackQuery().data().equals("callback_data3"))
                bot.execute(new SendMessage(chatId, "сфера денег").parseMode(ParseMode.HTML));
            if (mes.callbackQuery().data().equals("callback_data4"))
                bot.execute(new SendMessage(chatId, "сфера отношений").parseMode(ParseMode.HTML));
            if (mes.callbackQuery().data().equals("callback_data5"))
                bot.execute(new SendMessage(chatId, "сфера здоровья").parseMode(ParseMode.HTML));
            if (mes.callbackQuery().data().equals("callback_data6"))
                bot.execute(new SendMessage(chatId, "высшая миссия души").parseMode(ParseMode.HTML));


            if (mes.callbackQuery().data().equals("restart")) {
                bot.execute(new SendMessage(chatId, "Напиши дату рождения в формате <u>дд.мм.гггг</u>").parseMode(ParseMode.HTML));
                Users.fine_user(chatId).restart_etap();

            }

            if (mes.callbackQuery().data().equals("star")) {
                try {
                    DrawingStar.get_star(Users.fine_user(chatId).getDate_birth());
                    Path imagePath = Paths.get("yourImageName.PNG");
                    byte[] c = Files.readAllBytes(imagePath);


                    SendResponse a = bot.execute(new SendPhoto(chatId, c));
                   // System.out.println(a);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Users.fine_user(chatId).getEtap() == 1)
                bot.execute(new SendMessage(chatId, "Дата рождения <b>" + Users.getUsers().get(chatId).getDate_birth() + "</b> Выберети сферу :").protectContent(true).replyMarkup(Keyboar.getKeyBord()).parseMode(ParseMode.HTML));
        }
    }

    private static void _massege(Update mes, TelegramBot bot) throws NullPointerException {
        Long id_user = mes.message().from().id();
        long chatId = mes.message().chat().id();
        String text_messege = get_text_to_mesege_from_update(mes);
        String answer = process_message(text_messege, id_user, bot);

        if (Users.fine_user(id_user).getEtap() == 0)
            bot.execute(new SendMessage(chatId, answer).replyToMessageId(mes.message().messageId()));
        if (Users.fine_user(id_user).getEtap() == 1) {

            SendMessage call = new SendMessage(chatId, "Дата рождения <b>" + Users.getUsers().get(chatId).getDate_birth() + "</b>. Выберети сферу :").protectContent(true).parseMode(ParseMode.HTML).replyMarkup(Keyboar.getKeyBord());
            bot.execute(call);
        }
    }


}



