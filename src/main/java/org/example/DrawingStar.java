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

        HashMap<Integer,Integer> nomera = Service.calck_number(birthday);

        String imagePath = "image.jpg";
        BufferedImage myPicture = ImageIO.read(new File(imagePath));
        Graphics2D g2d = (Graphics2D) myPicture.getGraphics();

        g2d.setColor(Color.BLACK);

        g2d.setFont(new Font("Purisa", Font.BOLD, 25));
        g2d.drawString(String.valueOf(nomera.get(Service.DUCHOVNOST)), 237, 71);
        g2d.drawString(String.valueOf(nomera.get(Service.LICHNOST)), 48, 212);
        g2d.drawString(String.valueOf(nomera.get(Service.FINANS)), 420, 212);

        g2d.drawString(String.valueOf(nomera.get(Service.ZDOROVIE)), 122, 429);
        g2d.drawString(String.valueOf(nomera.get(Service.OTNOSHENIE)), 350, 429);

        g2d.drawString(String.valueOf(nomera.get(Service.MISSION_DUSHI)), 238, 255);

        ImageIO.write(myPicture, "PNG", new File("yourImageName.PNG"));

        return myPicture;
    }








}
