package org.example;

import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.ArrayList;
import java.util.List;

public class Keyboar {


        public static InlineKeyboardMarkup getKeyBord(){
            InlineKeyboardMarkup inlineKeyboard5 = new InlineKeyboardMarkup(
                    new InlineKeyboardButton[]{

                    });



            InlineKeyboardButton b1 = new InlineKeyboardButton("\uD83E\uDDCDСфера личности").callbackData("callback_data1");
            InlineKeyboardButton b2 = new InlineKeyboardButton("\uD83D\uDC7BСфера духовности").callbackData("callback_data2");
            InlineKeyboardButton b3 = new InlineKeyboardButton("\uD83D\uDCB0Сфера денег").callbackData("callback_data3");
            InlineKeyboardButton b4 = new InlineKeyboardButton("\uD83D\uDC6BСфера отношений").callbackData("callback_data4");
            InlineKeyboardButton b5 = new InlineKeyboardButton("❤\uFE0FСфера здоровья").callbackData("callback_data5");
            InlineKeyboardButton b6 = new InlineKeyboardButton("\uD83D\uDE36\u200D\uD83C\uDF2B\uFE0FВысшая миссия души").callbackData("callback_data6");

            InlineKeyboardButton restart = new InlineKeyboardButton("Начать сначала").callbackData("restart");
            InlineKeyboardButton[] l1 = new InlineKeyboardButton[]{b1, b2};
            InlineKeyboardButton[] l2 = new InlineKeyboardButton[]{b3, b4};
            InlineKeyboardButton[] l3 = new InlineKeyboardButton[]{b5, b6};
            InlineKeyboardButton[] l4 = new InlineKeyboardButton[]{restart};


            InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
            inlineKeyboard.addRow(l1);
            inlineKeyboard.addRow(l2);
            inlineKeyboard.addRow(l3);
            inlineKeyboard.addRow(l4);
            return inlineKeyboard;
        }


}
