package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.SendResponse;
import org.example.users.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Main {
    static String BOT_TOKKEN_test = "7128894901:AAF1nknzuvHd_tSX__ZqeIE6azK854BgxkU";

    public static void main(String[] args) {

        DrawingStar.load_assets();
        TelegramBot bot = new TelegramBot(BOT_TOKKEN_test);

        Save_to_disk.load_to_disk_points_for_users();
        //Save_to_disk.load_to_disk_points_for_users1();
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
                //   System.out.println(updates.size() + "!!!!!!");


                try {

                    //   Payment.Pay(bot,mes.message().from().id());
                    //Clear_chats.clear_chat(bot,mes.message().chat().id());
                    System.out.println(Clear_chats.getText());
                    if (mes.callbackQuery() != null) _callbackQuery(mes, bot);
                    else if (mes.message().text() != null) _massege(mes, bot);
                    else {
                        send_messege_from_status(mes, bot);

                    }
                } catch (Exception e) {
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


    ////////////
    private static void check_users(Update message, TelegramBot bot) {

        try {

            ///
            if (message.message().text().indexOf("/users") == 0) {
                if (Users.isAdmin(message.message().from().id()))
                    bot.execute(new SendMessage(message.message().chat().id(), get_users()));
            }

            if (message.message().text().indexOf("/all_text") == 0) {
                if (Users.isAdmin(message.message().from().id()))
                    for (Integer key : Array_TEXT.text.keySet()) {
                        String value = Array_TEXT.text.get(key);
                        //System.out.println("Key: " + key + ", Value: " + value);
                        bot.execute(new SendMessage(message.message().chat().id(), key + " ::\n " + value));
                    }
            }

            String nik = message.message().from().firstName();

//            System.out.println(message);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static String get_users() {
        StringBuilder sb = new StringBuilder();


        Iterator<Map.Entry<Long, User>> itr = Users.getUsers().entrySet().iterator();
        while (itr.hasNext()) {
            // System.out.println(itr.next());
            sb.append(itr.next());
            sb.append("\n");

        }
        return sb.toString();
    }

    private static String process_message(String mes, Long user_id, TelegramBot bot) {
        StringBuilder sb = new StringBuilder();
        User user = Users.fine_user(user_id);
        //System.out.println(user.getDate_birth());
        String bd = Accept_date_birth.get_date(mes);
        if (bd.length() > 1) {
            user.setDate_birth(bd);
        }

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

            if (mes.callbackQuery().data().equals("callback_data1")) {
                //  new  (chatId,int[1,2,3]a);
                _massege_arkan(chatId, bot, "Личность", 22, 13, 11, 1, 92, 75, 71,Service.LICHNOST);
                _massege_arkan(chatId, bot, "Личность", 9, 13, 11, 1, 92, 75, 71,Service.LICHNOST);
            }
            if (mes.callbackQuery().data().equals("callback_data2"))
            // bot.execute(new SendMessage(chatId, "Сфера духовности").parseMode(ParseMode.HTML));
            {
                _massege_arkan(chatId, bot, "Духовность", 22, 11, 12, 2, 91, 72, 73,Service.DUCHOVNOST);
                _massege_arkan(chatId, bot, "Духовность", 9, 11, 12, 2, 91, 72, 73,Service.DUCHOVNOST);
            }
            //   _massege_arkan(chatId,bot,10,11,12,2,91,72,73);
            if (mes.callbackQuery().data().equals("callback_data3")) {
                _massege_arkan(chatId, bot, "Деньги", 22, 12, 14, 3, 93, 74, 80,Service.FINANS);
                _massege_arkan(chatId, bot, "Деньги", 9, 12, 14, 3, 93, 74, 80,Service.FINANS);
            }
            //_massege_arkan(chatId,bot,10,12,14,3,93,74,80);
            if (mes.callbackQuery().data().equals("callback_data4")) {
                bot.execute(new SendMessage(chatId, "сфера отношений").parseMode(ParseMode.HTML));
                _massege_arkan(chatId, bot, "Отошения", 22, 15, 13, 5, 94, 76, 77,Service.OTNOSHENIE);
                _massege_arkan(chatId, bot, "Отошения", 9, 15, 13, 5, 94, 76, 77,Service.OTNOSHENIE);

            }
            if (mes.callbackQuery().data().equals("callback_data5")) {
                _massege_arkan(chatId, bot, "Здоровье", 22, 14, 15, 4, 95, 79, 78,Service.ZDOROVIE);
                _massege_arkan(chatId, bot, "Здоровье", 9, 14, 15, 4, 95, 79, 78,Service.ZDOROVIE);
            }
            //   bot.execute(new SendMessage(chatId, "сфера здоровья").parseMode(ParseMode.HTML));
            if (mes.callbackQuery().data().equals("callback_data6")) {
                bot.execute(new SendMessage(chatId, "высшая миссия души").parseMode(ParseMode.HTML));
            }


            if (mes.callbackQuery().data().equals("restart")) {
                bot.execute(new SendMessage(chatId, "Напиши дату рождения в формате <u>дд.мм.гггг</u>").parseMode(ParseMode.HTML));
                Users.fine_user(chatId).restart_etap();

            }

            if (mes.callbackQuery().data().equals("star")) {
                try {
                    BufferedImage bi = DrawingStar.get_star(Users.fine_user(chatId).getDate_birth(), 22);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(bi, "jpg", baos);
                    byte[] bytes = baos.toByteArray();
                    bot.execute(new SendPhoto(chatId, bytes));

                    bi = DrawingStar.get_star(Users.fine_user(chatId).getDate_birth(), 9);
                    baos = new ByteArrayOutputStream();
                    ImageIO.write(bi, "jpg", baos);
                    bytes = baos.toByteArray();
                    bot.execute(new SendPhoto(chatId, bytes));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Users.fine_user(chatId).getEtap() == 1)
                bot.execute(new SendMessage(chatId, "Дата рождения <b>" + Users.getUsers().get(chatId).getDate_birth() + "</b> Выберети сферу :").protectContent(true).replyMarkup(Keyboar.getKeyBord()).parseMode(ParseMode.HTML));
        }
    }

    private static void _massege(Update mes, TelegramBot bot) throws NullPointerException {
        check_users(mes, bot);
        send_messege_from_status(mes, bot);
        //  Clear_chats.add_id_mess(mes.message().messageId());
    }

    private static void send_messege_from_status(Update mes, TelegramBot bot) {
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

    private synchronized static void _massege_arkan(Long chatId, TelegramBot bot, String tile, int raz, int l1, int l2, int l3, int l4, int l5, int l6,Integer sfera) { // отапрвляет сообщения о предсказании
        try {

            HashMap<Integer, Integer> nomera = Service.calck_number_(Users.fine_user(chatId).getDate_birth(), raz);

            BufferedImage bi = DrawingStar.draw_vertex(Users.fine_user(chatId).getDate_birth(), tile, raz, nomera.get(l1), nomera.get(l2), nomera.get(l3), nomera.get(l4), nomera.get(l5), nomera.get(l6));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();

//            System.out.println(raz);
//            System.out.println(nomera.get(l1));

            System.out.println("-------------------------");

            bot.execute(new SendPhoto(chatId, bytes).caption(nomera.get(1) + " : " + Array_TEXT.getTextFromArkan(sfera, nomera.get(1))));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



