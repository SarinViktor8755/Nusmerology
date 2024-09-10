package org.example.users;

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
            put(101, "Лидеры, новаторы, стремящиеся быть номером 1 во всем.Оптимисты, позитивные люди.Генераторы идей.Решительные и волевые, легко адаптирующиеся к новым условиям.Успешные лидеры, занимающие высокие должности, опытные управленцы, умеющие властвовать за собой и другими.");
            put(102, "Интеллигентные, глубокое чувство окружающего мира.Дипломаты, умеющие сглаживать острые углы, находить общий язык с любым человеком.Сдержанные, спокойные, загадочные.Обладающие целительскими и экзотерическими способностями.Сильная связь с природой.Хорошие ораторы.");
            put(103, "Артистичные и творческие, имеют богатую фантазию, чувство вкуса и стиля.Хорошие управленцы, руководители.Ощущают себя королевами по жизни.Проявляют заботу, нежность к друзьям.Для них важна семья, любят детей.");
            put(104, "Мужественность, внутренняя сила, стержень.Ответственность, систематичность, порядок во всём.Стабильность, самодостаточность.Умеют принимать взвешенные решения даже в самых трудных ситуациях.Отличные руководители на работе, главы семьи.Не боятся любого труда.");
            put(105, "Чувствуют традиции, формы и структуры, при этом привнося в них новое.Имеют аналитическое мышление, способность рассчитывать и прогнозировать.Любят свободу, разнообразие во всём.Постоянно стремятся к новой информации, любознательны и разносторонни.Любят учиться и имеют дар учительства.Хорошие ораторы.");
            put(106, "Ценят гармонию, комфорт и красоту во всём.Имеют особое чувство вкуса и стиля, тяготеют к искусству.Милые, приятные, доброжелательные, склонные к конфликтам.Имеют дар в речи.");
            put(107, "Энергия воина, победителя.Активные, смелые, самостоятеленые, целеустремлённые люди.Любят путешествия, активный образ жизни, стремятся к постоянному развитию и движению.Интуитивные, проницательные, чувствуют ложь.Имеют поддержку высших сил (ангелов).Любят докапываться до сути вещей.");
            put(108, "Соблюдают закон, ценят нравственность и мораль.Честные и порядочные.Имеют чувство долга и ответственности.Понимают причинно-следственные связи.Трудолюбивые, много работают ради статуса и денег.Защищают слабых.Богатые, успешные, строят свой крупный бизнес, системы, оперируют большими деньгами.");
            put(109, "Продвинутая мудрость, знания, философский взгляд на мир.Сочувствие и сопереживание, отзывчивость, восприимчивость к чужой боли.Эзотерический потенциал, способность видеть все сны, считывать знаки.Талантливые, увлекаются во все, что изучают, поэтому отлично проявляют себя в любой сфере.Самодостаточные, наполняются энергией в одиночестве.");
        }
    };


    public static String getTextFromArkan(int key) {
        return text.get(key);
    }

    public static String getTextFromArkan(int znach, int arkan) {
        return text.get((arkan * 100) + znach);
    }


}
