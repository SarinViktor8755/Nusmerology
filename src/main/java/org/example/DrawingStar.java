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
            ImageIO.write(ImageIO.read(new File("imageStar.jpg")), "jpg", baos);
            start_Image = baos.toByteArray();

            baos = new ByteArrayOutputStream();
            ImageIO.write(ImageIO.read(new File("imageVertax.jpg")), "jpg", baos);
            vertax_Image = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static BufferedImage get_star(String birthday, int raz) throws IOException {

        HashMap<Integer, Integer> nomera = Service.calck_number_(birthday, raz);


        InputStream is = new ByteArrayInputStream(start_Image);
        BufferedImage newBi = ImageIO.read(is);
        Graphics2D g2d = (Graphics2D) newBi.getGraphics();

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
        g2d.drawString(birthday, 10, 25);

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
        g2d.drawString(String.valueOf(nomera.get(78)), 270, 370);

        g2d.drawString(String.valueOf(nomera.get(11)), 180, 185);
        g2d.drawString(String.valueOf(nomera.get(12)), 300, 185);
        g2d.drawString(String.valueOf(nomera.get(13)), 150, 290);
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
        g2d.drawString(String.valueOf(nomera.get(95)), 260, 300);


        return newBi;
    }


    public static BufferedImage draw_vertex(String birthday, String tile, int raz, int l1, int l2, int l3, int l4, int l5, int l6) throws IOException {
        Service.calck_number_(birthday, raz);


        InputStream is = new ByteArrayInputStream(vertax_Image);
        BufferedImage newBi = ImageIO.read(is);
        Graphics2D g2d = (Graphics2D) newBi.getGraphics();

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
