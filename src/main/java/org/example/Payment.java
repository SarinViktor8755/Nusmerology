package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.LabeledPrice;
import com.pengrad.telegrambot.request.CreateInvoiceLink;
import com.pengrad.telegrambot.request.CreateNewStickerSet;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.StringResponse;

public class Payment {

    public static void Pay(TelegramBot bot, Long chat_id){
        //bot.execute(new SendMessage(chat_id, "Премиум"));
        CreateInvoiceLink invoiceLink = new CreateInvoiceLink("tile","Описание",
                "SOME-PAYLOAD"," 401643678:TEST:c500c96d-e515-4a56-a80c-14a6c47f5527",
                "RUB",
                new LabeledPrice("Цена ",100*100));

        StringResponse response = bot.execute(invoiceLink);

        bot.execute(new SendMessage(chat_id, "Премиум").replyMarkup(new InlineKeyboardMarkup(
                new InlineKeyboardButton("Оплатить").url(response.result())
        )));

//        bot.execute(SendInvoice.builder()
//                .chatId(123)
//                .currency("RUB")
//                .providerToken("401643678:TEST:3947e67a-cf1f-4db4-967c-1beae96df73d")
//                .title("Тест")
//                .description("Тест")
//                .payload("Тест")
//                .price(new LabeledPrice("Тест",1000000))
//                .build());


        System.out.println(response);

    }


}
