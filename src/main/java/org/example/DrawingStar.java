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
//    public static void main(String[] args) throws IOException {
//        String imagePath = "image.jpg";
//        BufferedImage myPicture = ImageIO.read(new File(imagePath));
//        Graphics2D g = (Graphics2D) myPicture.getGraphics();
//        g.setStroke(new BasicStroke(3));
//        g.setColor(Color.BLUE);
//        g.drawRect(10, 10, myPicture.getWidth() - 20, myPicture.getHeight() - 20);
//        ImageIO.write(myPicture, "PNG", new File("yourImageName.PNG"));
//        ImageIO.write(myPicture, "JPEG", new File("yourImageName.JPG"));
//        ImageIO.write(myPicture, "gif", new File("yourImageName.GIF"));
//        ImageIO.write(myPicture, "BMP", new File("yourImageName.BMP"));
//
//
//
//    }

    public static BufferedImage get_star(String birthday) throws IOException {

        HashMap<Integer, Integer> nomera = Service.calck_number(birthday);

        String imagePath = "image.jpg";
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

//        g2d.setFont(new Font("Purisa", Font.BOLD, 10));
//        for (int i = 0; i < 50; i++) {
//            int x = (int) (250 +230*Math.cos(Math.toDegrees(i)));
//            int y = (int) (250 +230*Math.sin(Math.toDegrees(i)));
//            g2d.drawString(String.valueOf(i), x, y);
//        }

        //////////////////////////////////////////
        g2d.setFont(new Font("Purisa", Font.BOLD, 20));
        g2d.drawString(String.valueOf(Service.U2), 190, 150);
        g2d.drawString(String.valueOf(Service.U3), 280, 150);


        g2d.drawString(String.valueOf(Service.U1), 140, 190);
        g2d.drawString(String.valueOf(Service.U4), 330, 190);
/////////////
        g2d.drawString(String.valueOf(Service.U5), 125, 270);
        g2d.drawString(String.valueOf(Service.U10), 350, 270);


        g2d.drawString(String.valueOf(Service.U7), 140, 320);
        g2d.drawString(String.valueOf(Service.U9), 330, 320);

        g2d.drawString(String.valueOf(Service.U6), 210, 370);
        g2d.drawString(String.valueOf(Service.U8), 270, 370);
///////////////
//        int v1 = Service.reduce_number_to_single_digit(Service.LICHNOST + Service.DUCHOVNOST);
//        int v2 = Service.reduce_number_to_single_digit(Service.DUCHOVNOST + Service.FINANS);
//        int v3 = Service.reduce_number_to_single_digit(Service.FINANS + Service.OTNOSHENIE);
//        int v4 = Service.reduce_number_to_single_digit(Service.OTNOSHENIE + Service.ZDOROVIE);
//        int v5 = Service.reduce_number_to_single_digit(Service.ZDOROVIE + Service.LICHNOST);
///////////////////

     //      System.out.println("--!!!!!!!!!!!");

        g2d.drawString(String.valueOf(Service.V1), 180,185);
     //   System.out.println(Service.V1);
        g2d.drawString(String.valueOf(Service.V2), 300, 185);
    //    System.out.println(Service.V2);
        g2d.drawString(String.valueOf(Service.V3), 150, 290);
   //     System.out.println(Service.V3);
        g2d.drawString(String.valueOf(Service.V4), 330, 290);
    //    System.out.println(Service.V4);
        g2d.drawString(String.valueOf(Service.V5), 240, 360);
    //    System.out.println(Service.V5);
        ///////////////////

        g2d.drawString(String.valueOf(Service.q1), 240, 220);

        g2d.drawString(String.valueOf(Service.q2), 200, 253);
        g2d.drawString(String.valueOf(Service.q3), 285, 253);

        g2d.drawString(String.valueOf(Service.q4), 217, 300);
        g2d.drawString(String.valueOf(Service.q5), 260, 300);


        ImageIO.write(myPicture, "PNG", new File("yourImageName.PNG"));

        return myPicture;
    }


}
