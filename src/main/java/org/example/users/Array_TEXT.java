package org.example.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class Array_TEXT {

    public static Integer LICHNOST_COD = 1;
    public static Integer DUCHOVNOST_COD = 2;
    public static Integer FINANS_COD = 3;
    public static Integer ZDOROVIE_COD = 4;
    public static Integer OTNOSHENIE_COD = 5;
    public static Integer MISSION_DUSHI_COD = 6;
    public static HashMap<Integer, String> text = new HashMap<Integer, String>() {
        {
            put(101, "\uD83D\uDC49Лидеры, новаторы, стремятся" +
                    "быть номером 1 во всем" +
                    "Оптимисты, позитивные люди" +
                    "Генераторы идей" +
                    "Решительные и волевые, легко" +
                    "адаптируются к новым условиям\n" +
                    "\uD83D\uDC49Успешные люди, занимают" +
                    "высокие должности, отличные" +
                    "управленцы, умеют вести" +
                    "за собой других");

            put(102, "Интуиция, глубокое чувствование\n" +
                    "окружающих\n" +
                    "* Дипломаты, умеют сглаживать\n" +
                    "острые углы,находить подход\n" +
                    "к любому человеку\n" +
                    "• Сдержанные, спокойные,\n" +
                    "загадочные\n" +
                    "* Обладают целительскими\n" +
                    "и эзотерическими способностями\n" +
                    "* Сильная связь с природой\n" +
                    "• Хорошие ораторы\n");
            put(103, "Яркие, тёплые, позитивные," +
                    "эмоциональные люди\n");
            put(104, "Чтят традиции, нормы и устои,\n" +
                    "при этом привносят в них что-то\n" +
                    "новое\n" +
                    "• Имеют аналитическое мышление,\n" +
                    "способность рассчитывать\n" +
                    "и прогнозировать\n" +
                    "• Любят свободу, разнообразие\n" +
                    "во всем\n" +
                    "* Постоянно нуждаются в новой\n" +
                    "информации, любознательные\n" +
                    "и разносторонние\n" +
                    "* Любят учиться и имеют\n" +
                    "дар учителя\n" +
                    "• Хорошие ораторы\n");
            put(105, "* Чтят традиции, нормы и устои,\n" +
                    "при этом привносят в них что-то\n" +
                    "новое\n" +
                    "• Имеют аналитическое мышление,\n" +
                    "способность рассчитывать\n" +
                    "и прогнозировать\n" +
                    "• Любят свободу, разнообразие\n" +
                    "во всем\n" +
                    "* Постоянно нуждаются в новой\n" +
                    "информации, любознательные\n" +
                    "и разносторонние\n" +
                    "* Любят учиться и имеют\n" +
                    "дар учителя\n" +
                    "• Хорошие ораторы\n");
            put(106, "• Ценят гармонию, комфорт\n" +
                    "и красоту во всем\n" +
                    "* Имеют отличное чувство вкуса\n" +
                    "и стиля, тяготеют к искусству\n" +
                    "* Милые, приятные,\n" +
                    "доброжелательные,\n" +
                    "неконфликтные\n" +
                    "* Имеют дар в руках\n");

            put(107, "* Понимают причинно-\n" +
                    "следственные связи\n" +
                    "* Трудолюбивые, много работают\n" +
                    "ради статуса и денег\n" +
                    "• Защищают слабых\n" +
                    "* Богатые, успешные, строят свой\n" +
                    "крупный бизнес, системы.\n" +
                    "оперируют большими деньгами\n");
            put(108, "* Понимают причинно-\n" +
                    "следственные связи\n" +
                    "* Трудолюбивые, много работают\n" +
                    "ради статуса и денег\n" +
                    "• Защищают слабых\n" +
                    "* Богатые, успешные, строят свой\n" +
                    "крупный бизнес, системы.\n" +
                    "оперируют большими деньгами\n");
            put(109, " • Природная мудрость, знания.\n" +
                    "философский взгляд на мир\n" +
                    "• Сочувствие и сопереживание,\n" +
                    "отзывчивость, восприимчивость\n" +
                    "к чужой боли\n" +
                    "* Эзотерический потенциал,\n" +
                    "способность видеть вещие сны,\n" +
                    "считывать знаки\n" +
                    "* Талантливые, углубляются во все.\n" +
                    "что изучают, поэтому отлично\n" +
                    "проявляют себя в любой сфере\n" +
                    "* Самодостаточные, наполняются\n" +
                    "энергией в одиночестве\n");


            put(110, " • Природная мудрость, знания.\n" +
                    "философский взгляд на мир\n" +
                    "• Сочувствие и сопереживание,\n" +
                    "отзывчивость, восприимчивость\n" +
                    "к чужой боли\n" +
                    "* Эзотерический потенциал,\n" +
                    "способность видеть вещие сны,\n" +
                    "считывать знаки\n" +
                    "* Талантливые, углубляются во все.\n" +
                    "что изучают, поэтому отлично\n" +
                    "проявляют себя в любой сфере\n" +
                    "* Самодостаточные, наполняются\n" +
                    "энергией в одиночестве\n");


            put(111, " • Природная мудрость, знания.\n" +
                    "философский взгляд на мир\n" +
                    "• Сочувствие и сопереживание,\n" +
                    "отзывчивость, восприимчивость\n" +
                    "к чужой боли\n" +
                    "* Эзотерический потенциал,\n" +
                    "способность видеть вещие сны,\n" +
                    "считывать знаки\n" +
                    "* Талантливые, углубляются во все.\n" +
                    "что изучают, поэтому отлично\n" +
                    "проявляют себя в любой сфере\n" +
                    "* Самодостаточные, наполняются\n" +
                    "энергией в одиночестве\n");

            put(112, " • Природная мудрость, знания.\n" +
                    "философский взгляд на мир\n" +
                    "• Сочувствие и сопереживание,\n" +
                    "отзывчивость, восприимчивость\n" +
                    "к чужой боли\n" +
                    "* Эзотерический потенциал,\n" +
                    "способность видеть вещие сны,\n" +
                    "считывать знаки\n" +
                    "* Талантливые, углубляются во все.\n" +
                    "что изучают, поэтому отлично\n" +
                    "проявляют себя в любой сфере\n" +
                    "* Самодостаточные, наполняются\n" +
                    "энергией в одиночестве\n");
            put(113, "* Бесстрашные, рисковые,\n" +
                    "дерзкие, непредсказуемые\n" +
                    "* Способны создавать вокруг\n" +
                    "себя перемены\n" +
                    "* Не боятся трансформаций,\n" +
                    "легко отпускают старое\n" +
                    "* Способствуют прогрессу\n" +
                    "и модернизации, где бы они\n" +
                    "ни находились\n" +
                    "* Любят экстрим\n" +
                    "* Помогают меняться другим\n" +
                    "людям\n");


            put(114, "* Тонко чувствуют и воспринимают\n" +
                    "мир и окружающих, имеют\n" +
                    "хорошую интуицию\n" +
                    "• Ценят гармонию и баланс\n" +
                    "во всем\n" +
                    "* Имеют богатый внутренний мир\n" +
                    "* Люди творчества, искусства.\n" +
                    "восприимчивы ко всему\n" +
                    "прекрасному\n" +
                    "* Любознательные,\n" +
                    "интеллектуальные,\n" +
                    "разносторонние\n" +
                    "* Развита способность\n" +
                    "к целительству\n" +
                    "* Дар обучать\n");

            put(115, " • Природная мудрость, знания.\n" +
                    "философский взгляд на мир\n" +
                    "• Сочувствие и сопереживание,\n" +
                    "отзывчивость, восприимчивость\n" +
                    "к чужой боли\n" +
                    "* Эзотерический потенциал,\n" +
                    "способность видеть вещие сны,\n" +
                    "считывать знаки\n" +
                    "* Талантливые, углубляются во все.\n" +
                    "что изучают, поэтому отлично\n" +
                    "проявляют себя в любой сфере\n" +
                    "* Самодостаточные, наполняются\n" +
                    "энергией в одиночестве\n");

            put(116, " • Природная мудрость, знания.\n" +
                    "философский взгляд на мир\n" +
                    "• Сочувствие и сопереживание,\n" +
                    "отзывчивость, восприимчивость\n" +
                    "к чужой боли\n" +
                    "* Эзотерический потенциал,\n" +
                    "способность видеть вещие сны,\n" +
                    "считывать знаки\n" +
                    "* Талантливые, углубляются во все.\n" +
                    "что изучают, поэтому отлично\n" +
                    "проявляют себя в любой сфере\n" +
                    "* Самодостаточные, наполняются\n" +
                    "энергией в одиночестве\n");

            put(117, " • Природная мудрость, знания.\n" +
                    "философский взгляд на мир\n" +
                    "• Сочувствие и сопереживание,\n" +
                    "отзывчивость, восприимчивость\n" +
                    "к чужой боли\n" +
                    "* Эзотерический потенциал,\n" +
                    "способность видеть вещие сны,\n" +
                    "считывать знаки\n" +
                    "* Талантливые, углубляются во все.\n" +
                    "что изучают, поэтому отлично\n" +
                    "проявляют себя в любой сфере\n" +
                    "* Самодостаточные, наполняются\n" +
                    "энергией в одиночестве\n");

            put(118, "* Глубокие, чувствительные,\n" +
                    "интуитивные, духовно развитые\n" +
                    "люди\n" +
                    "* Имеют эзотерические\n" +
                    "способности\n" +
                    "* Богатый внутренний мир.\n" +
                    "хорошее воображение, тяга\n" +
                    "к прекрасному\n" +
                    "* Тяготеют ко всему необычному,\n" +
                    "мистическому\n" +
                    "•\tСильная материализация мыслей\n" +
                    "*\tЛюбят природу, заряжаются\n" +
                    "от воды, зависят от лунных\n" +
                    "циклов\n");

            put(119, " • Природная мудрость, знания.\n" +
                    "философский взгляд на мир\n" +
                    "• Сочувствие и сопереживание,\n" +
                    "отзывчивость, восприимчивость\n" +
                    "к чужой боли\n" +
                    "* Эзотерический потенциал,\n" +
                    "способность видеть вещие сны,\n" +
                    "считывать знаки\n" +
                    "* Талантливые, углубляются во все.\n" +
                    "что изучают, поэтому отлично\n" +
                    "проявляют себя в любой сфере\n" +
                    "* Самодостаточные, наполняются\n" +
                    "энергией в одиночестве\n");


            put(120, " • Природная мудрость, знания.\n" +
                    "философский взгляд на мир\n" +
                    "• Сочувствие и сопереживание,\n" +
                    "отзывчивость, восприимчивость\n" +
                    "к чужой боли\n" +
                    "* Эзотерический потенциал,\n" +
                    "способность видеть вещие сны,\n" +
                    "считывать знаки\n" +
                    "* Талантливые, углубляются во все.\n" +
                    "что изучают, поэтому отлично\n" +
                    "проявляют себя в любой сфере\n" +
                    "* Самодостаточные, наполняются\n" +
                    "энергией в одиночестве\n");

            put(121, " • Природная мудрость, знания.\n" +
                    "философский взгляд на мир\n" +
                    "• Сочувствие и сопереживание,\n" +
                    "отзывчивость, восприимчивость\n" +
                    "к чужой боли\n" +
                    "* Эзотерический потенциал,\n" +
                    "способность видеть вещие сны,\n" +
                    "считывать знаки\n" +
                    "* Талантливые, углубляются во все.\n" +
                    "что изучают, поэтому отлично\n" +
                    "проявляют себя в любой сфере\n" +
                    "* Самодостаточные, наполняются\n" +
                    "энергией в одиночестве\n");


            put(122, "•\tВечные дети, в которых таится огромная мудрость\n" +
                    "•\tОткрытые миру, лёгкие на подъем, авантюрные\n" +
                    "•\tПозитивные, артистичные и талантливые люди\n" +
                    "•\tИмеют дар в голосе, должны стоять на сцене\n" +
                    "•\tСвободные от ограничений, рамок и запретов\n" +
                    "•\tВоспринимают жизнь\n" +
                    "как приключение, не боятся идти в новое и неизведанное\n");


        }





    };


    public static String getTextFromArkan(int key) {
        return text.get(key);
    }

    public static String getTextFromArkan(int sfera, int arkan) throws IOException {
        System.out.println("znach" + sfera);
        System.out.println("arkan" + arkan);


       // System.out.println((arkan * 100) + znach);
        //String result = text.get((arkan * 100) + znach);
        String result = Array_of_responses.read_file((sfera * 100) + arkan);

        try {
            result.length();
        }catch (NullPointerException e){
            result = new String("NOT_INFA");
        }

        return result;
    }


}
