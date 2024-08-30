package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    public static Graphics2D get_star() throws IOException {

        Random rand = new Random();

// Obtain a number between [0 - 49].
        int n = rand.nextInt(50);

        String imagePath = "image.jpg";
        BufferedImage myPicture = ImageIO.read(new File(imagePath));
        Graphics2D g2d = (Graphics2D) myPicture.getGraphics();
        g2d.setStroke(new BasicStroke(n));
        g2d.setColor(Color.RED);
//        g2d.drawLine(120, 50, 360, 50);
//
//        g2d.draw(new Line2D.Double(59.2d, 99.8d, 419.1d, 99.8d));
//
//        g2d.draw(new Line2D.Float(21.50f, 132.50f, 459.50f, 132.50f));

        g2d.setFont(new Font("Purisa", Font.BOLD, 25));

        g2d.drawString(String.valueOf(n), 50, 30);
        g2d.drawString(String.valueOf(n), 50, 60);
        g2d.drawString(String.valueOf(n), 50, 90);
        g2d.drawString(String.valueOf(n), 50, 120);
        g2d.drawString(String.valueOf(n), 50, 150);
        g2d.drawString("If there's a soulmate for everyone", 50, 180);

        g2d.drawRect(n, n, myPicture.getWidth() - n, myPicture.getHeight() - n);
        ImageIO.write(myPicture, "PNG", new File("yourImageName.PNG"));

        return g2d;
    }


    public static BufferedImage get_star1() throws IOException {

        Random rand = new Random();

// Obtain a number between [0 - 49].
        int n = rand.nextInt(50);

        String imagePath = "image.jpg";
        BufferedImage myPicture = ImageIO.read(new File(imagePath));
        Graphics2D g2d = (Graphics2D) myPicture.getGraphics();
        g2d.setStroke(new BasicStroke(n));
        g2d.setColor(Color.RED);
//        g2d.drawLine(120, 50, 360, 50);
//
//        g2d.draw(new Line2D.Double(59.2d, 99.8d, 419.1d, 99.8d));
//
//        g2d.draw(new Line2D.Float(21.50f, 132.50f, 459.50f, 132.50f));

        g2d.setFont(new Font("Purisa", Font.BOLD, 25));

        g2d.drawString(String.valueOf(n), 50, 30);
        g2d.drawString(String.valueOf(n), 50, 60);
        g2d.drawString(String.valueOf(n), 50, 90);
        g2d.drawString(String.valueOf(n), 50, 120);
        g2d.drawString(String.valueOf(n), 50, 150);
        g2d.drawString("If there's a soulmate for everyone", 50, 180);

        g2d.drawRect(n, n, myPicture.getWidth() - n, myPicture.getHeight() - n);
        ImageIO.write(myPicture, "PNG", new File("yourImageName.PNG"));
        g2d.dispose();




        return myPicture;
    }

}
