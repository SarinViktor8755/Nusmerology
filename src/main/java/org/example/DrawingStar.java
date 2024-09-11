package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class DrawingStar {


    public synchronized static BufferedImage get_star(String birthday, int raz) throws IOException {
  //      System.out.println();
  //      System.out.println("calck_STAR");
        HashMap<Integer, Integer> nomera = Service.calck_number_(birthday, raz);

//        for (int i = 0; i < 100; i++) {
//                nomera.put(i,i);
//        }
     //   System.out.println("draw_star");
        String imagePath = "imageStar.jpg";
        BufferedImage myPicture = ImageIO.read(new File(imagePath));
        Graphics2D g2d = (Graphics2D) myPicture.getGraphics();

        g2d.setColor(Color.BLACK);

        g2d.setFont(new Font("Purisa", Font.BOLD, 35));
        g2d.drawString(String.valueOf(nomera.get(Service.DUCHOVNOST)), 237, 71);
        g2d.drawString(String.valueOf(nomera.get(Service.LICHNOST)), 48, 212);
        g2d.drawString(String.valueOf(nomera.get(Service.FINANS)), 420, 212);

        g2d.drawString(String.valueOf(nomera.get(Service.ZDOROVIE)), 122, 429);
        g2d.drawString(String.valueOf(nomera.get(Service.OTNOSHENIE)), 350, 429);
        g2d.setFont(new Font("Purisa", Font.BOLD, 60));
        g2d.drawString(String.valueOf(nomera.get(Service.MISSION_DUSHI)), 230, 270);

        g2d.setFont(new Font("Purisa", Font.BOLD, 20));
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
       // System.out.println(nomera.get(11));
        g2d.drawString(String.valueOf(nomera.get(12)), 300, 185);
      //  System.out.println(nomera.get(12));
        g2d.drawString(String.valueOf(nomera.get(13)), 150, 290);
        //System.out.println(nomera.get(13));
        g2d.drawString(String.valueOf(nomera.get(14)), 330, 290);
        //System.out.println(nomera.get(14));
        g2d.drawString(String.valueOf(nomera.get(15)), 240, 360);
        //  System.out.println(nomera.get(15));
        ///////////////////

        g2d.drawString(String.valueOf(nomera.get(91)), 240, 220);
        g2d.drawString(String.valueOf(nomera.get(92)), 200, 253);
        g2d.drawString(String.valueOf(nomera.get(93)), 285, 253);
        g2d.drawString(String.valueOf(nomera.get(94)), 217, 300);
        g2d.drawString(String.valueOf(nomera.get(95)), 260, 300);

     //   System.out.println("STOPdraw_star");


         ImageIO.write(myPicture, "PNG", new File("yourImageName.PNG"));


        return myPicture;
    }


    public static BufferedImage draw_vertex(String birthday, String tile, int raz, int l1, int l2, int l3, int l4, int l5, int l6) throws IOException {
        Service.calck_number_(birthday, raz);

        String imagePath = "imageVertax.jpg";
        BufferedImage myPicture = ImageIO.read(new File(imagePath));
        Graphics2D g2d = (Graphics2D) myPicture.getGraphics();

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Purisa", Font.BOLD, 18));

        g2d.setFont(new Font("Purisa", Font.BOLD, 10));
        g2d.drawString(tile, 5, 10);

        g2d.setFont(new Font("Purisa", Font.BOLD, 18));

        g2d.drawString(String.valueOf(l1), 12, 170);
        g2d.drawString(String.valueOf(l2), 150, 170);
        g2d.drawString(String.valueOf(l3), 90, 25);
        g2d.setFont(new Font("Purisa", Font.BOLD, 15));
        g2d.drawString(String.valueOf(l4), 90, 185);

        g2d.drawString(String.valueOf(l5), 50, 110);
        g2d.drawString(String.valueOf(l6), 130, 110);
        ImageIO.write(myPicture, "PNG", new File("yourImageName.PNG"));
        return myPicture;
    }


}
