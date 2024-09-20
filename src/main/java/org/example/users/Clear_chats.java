package org.example.users;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.DeleteMessage;

import java.util.ArrayList;
import java.util.HashMap;

public class Clear_chats {
    private static ArrayList<Integer> id_mess = new ArrayList<Integer>();



    public static void add_id_mess(Integer id_mess){
        getText().add(id_mess);
    }

    public static ArrayList<Integer> getText() {
        return id_mess;
    }

    public static void clear_chat(TelegramBot bot,Long chat_id){
        for(int j = id_mess.size(); j > id_mess.size() ; j--)
        {
            DeleteMessage deleteMessage = new DeleteMessage(chat_id, Math.toIntExact(id_mess.get(j)));
            bot.execute(deleteMessage);
        }
    }
}
