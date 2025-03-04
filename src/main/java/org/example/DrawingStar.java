package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

public class DrawingStar {
    public static byte[] start_Image;
    public static byte[] vertax_Image;

    public static void load_assets() {
        try {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(ImageIO.read(new File("asssets/imageStar.jpg")), "jpg", baos);
            start_Image = baos.toByteArray();

            baos = new ByteArrayOutputStream();
            ImageIO.write(ImageIO.read(new File("asssets/imageVertax.jpg")), "jpg", baos);
            vertax_Image = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static BufferedImage get_star(String birthday,String birthday_1, int raz) throws IOException {


        HashMap<Integer, Integer> nomera = Service.calck_number_(birthday, raz);
        if (!birthday_1.equals("-")){
            HashMap<Integer, Integer> nomera_1 = Service.calck_number_(birthday_1, raz);
            HashMap<Integer, Integer> nomera_0 = Service.calck_number_(birthday, raz);

            nomera = Service.sumHashMaps(nomera_1,nomera_0);
            for (Integer key : nomera.keySet()) {
                int newValue = Service.reduce_number_to_single_digit(nomera.get(key),22); // Применяем функцию
                nomera.put(key, newValue); // Сохраняем новое значение
            }
        }


        BufferedImage newBi = ImageIO.read(new ByteArrayInputStream(start_Image));
        ByteArrayInputStream byteStream1 = new ByteArrayInputStream("Purisa Bold.ttf".getBytes());



        Graphics2D g2d = (Graphics2D) newBi.getGraphics();
//        BasicStroke wideStroke = new BasicStroke(12.0f);
//        g2d.setStroke(wideStroke);

//        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
//        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
//        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);

        g2d.setFont(new Font("Purisa", Font.BOLD, 35));
        g2d.drawString(String.valueOf(nomera.get(Service.DUCHOVNOST)), 237, 71);
        g2d.drawString(String.valueOf(nomera.get(Service.LICHNOST)), 48, 212);
        g2d.drawString(String.valueOf(nomera.get(Service.FINANS)), 420, 212);

        g2d.drawString(String.valueOf(nomera.get(Service.ZDOROVIE)), 122, 429);
        g2d.drawString(String.valueOf(nomera.get(Service.OTNOSHENIE)), 350, 429);

        if (nomera.get(Service.MISSION_DUSHI) >= 10) {
            g2d.setFont(new Font("Purisa", Font.BOLD, 40));
            g2d.drawString(String.valueOf(nomera.get(Service.MISSION_DUSHI)), 225, 265);
        } else {
            g2d.setFont(new Font("Purisa", Font.BOLD, 60));
            g2d.drawString(String.valueOf(nomera.get(Service.MISSION_DUSHI)), 230, 270);
        }


        g2d.setFont(new Font("Purisa", Font.BOLD, 20));

        //////////
        if (birthday_1.equals("-")) {
            g2d.drawString(birthday, 10, 25);
        }else {
            g2d.drawString(birthday +" + "+ birthday_1, 10, 25);
        }


        g2d.drawString(String.valueOf(nomera.get(72)), 190, 150);
        g2d.drawString(String.valueOf(nomera.get(73)), 280, 150);

        g2d.drawString(String.valueOf(nomera.get(71)), 140, 190);
        g2d.drawString(String.valueOf(nomera.get(74)), 330, 190);
/////////////
        g2d.drawString(String.valueOf(nomera.get(75)), 125, 270);
        g2d.drawString(String.valueOf(nomera.get(80)), 350, 270);////////

        g2d.drawString(String.valueOf(nomera.get(77)), 140, 320);
        g2d.drawString(String.valueOf(nomera.get(79)), 330, 320);

        g2d.drawString(String.valueOf(nomera.get(76)), 210, 370);

        if (nomera.get(78) >= 10) {
            g2d.drawString(String.valueOf(nomera.get(78)), 260, 370);
        } else
            g2d.drawString(String.valueOf(nomera.get(78)), 270, 370);

        g2d.drawString(String.valueOf(nomera.get(11)), 180, 185);
        g2d.drawString(String.valueOf(nomera.get(12)), 300, 185);
        g2d.drawString(String.valueOf(nomera.get(13)), 145, 290);
        g2d.drawString(String.valueOf(nomera.get(14)), 330, 290);
        g2d.drawString(String.valueOf(nomera.get(15)), 240, 360);

        g2d.drawString(String.valueOf(nomera.get(91)), 240, 220);
        g2d.drawString(String.valueOf(nomera.get(92)), 200, 253);

        if (nomera.get(Service.MISSION_DUSHI) >= 10) {
            //     g2d.setFont(new Font("Purisa", Font.BOLD, 40));
            g2d.drawString(String.valueOf(nomera.get(93)), 275, 257);
        } else {
            //    g2d.setFont(new Font("Purisa", Font.BOLD, 60));
            g2d.drawString(String.valueOf(nomera.get(93)), 285, 257);
        }
        // g2d.drawString(String.valueOf(nomera.get(93)), 285, 253);

        g2d.drawString(String.valueOf(nomera.get(94)), 217, 300);
        if (nomera.get(95) >= 10) {
            g2d.drawString(String.valueOf(nomera.get(95)), 250, 300);
        } else g2d.drawString(String.valueOf(nomera.get(95)), 260, 300);

        return newBi;
    }


    public static BufferedImage draw_vertex(String birthday, String tile, int raz, int l1, int l2, int l3, int l4, int l5, int l6) throws IOException {
        Service.calck_number_(birthday, raz);


        InputStream is = new ByteArrayInputStream(vertax_Image);
        BufferedImage newBi = ImageIO.read(is);
        Graphics2D g2d = (Graphics2D) newBi.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Purisa", Font.BOLD, 18));
        g2d.setFont(new Font("Purisa", Font.BOLD, 10));
        g2d.drawString(tile, 5, 10);

        g2d.setFont(new Font("Purisa", Font.BOLD, 18));
        g2d.drawString(String.valueOf(l1), 25, 170);
        g2d.drawString(String.valueOf(l2), 150, 170);
       g2d.drawString(String.valueOf(l3), 90, 25);
        g2d.setFont(new Font("Purisa", Font.BOLD, 15));
        g2d.drawString(String.valueOf(l4), 90, 185);

        g2d.drawString(String.valueOf(l5), 50, 110);
        g2d.drawString(String.valueOf(l6), 130, 110);
        //   ImageIO.write(myPicture, "PNG", new File("yourImageName.PNG"));
        return newBi;
    }


}
