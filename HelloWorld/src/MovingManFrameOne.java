import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Thomas Varano
//[Program Descripion]
//Nov 4, 2016
public class MovingManFrameOne extends JPanel implements MouseListener, MouseMotionListener
   {
      /**
    * 
    */
   private static final long serialVersionUID = 1L;
      private static int mousex;
      private static int mousey;
      private static int spritex = 100;
      private static int pressx;
      private static int dragx;
      private static int distancex;
      private static boolean release;
      private static boolean press;
      

      public MovingManFrameOne()
      {   
         this.setBackground(Color.WHITE);  //sets background
         this.addMouseListener(this);
         this.addMouseMotionListener(this);
      }
      
      public void paintComponent(Graphics g)
      {

         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D) g;
         g2.setStroke(new BasicStroke(20));
//        g2.drawImage(sprite, spritex, 600, 200, 200, null);
        g2.setColor(Color.WHITE);
        g2.drawRect(0, 0, getWidth()/2, getHeight());
        g2.drawRect(getWidth()/2, 0, getWidth(), getHeight());
        g2.setColor(Color.BLACK);
        g2.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
      //MEGAMAN
        Color thegrey = new Color(120,120,120);
        Color darkblu = new Color(66,110,181);
        Color babyblu = new Color(134,186,229);
        Color skin = new Color(246,225,150);
        g2.setStroke(new BasicStroke(2));
        int yvalue = 680;
        //legs / feet
           //bottom row (spritex - 
              g2.setColor(Color.BLACK);
              g2.fillRect(spritex + 10, yvalue, 180, 20);
              g2.fillRect(spritex + 250, yvalue, 180, 20);
        
              g2.setColor(thegrey);
              g2.drawRect(spritex + 10 , yvalue, 20, 20);
              g2.drawRect(spritex + 30, yvalue, 20, 20);
              g2.drawRect(spritex + 50, yvalue, 20, 20);
              g2.drawRect(spritex + 70, yvalue, 20, 20);
              g2.drawRect(spritex + 90, yvalue, 20, 20);
              g2.drawRect(spritex + 110, yvalue, 20, 20);
              g2.drawRect(spritex + 130, yvalue, 20, 20);
              g2.drawRect(spritex + 150, yvalue, 20, 20);
              g2.drawRect(spritex + 170, yvalue, 20, 20);
        
              g2.drawRect(spritex + 250, yvalue, 20, 20);
              g2.drawRect(spritex + 270, yvalue, 20, 20);
              g2.drawRect(spritex + 290, yvalue, 20, 20);
              g2.drawRect(spritex + 310, yvalue, 20, 20);
              g2.drawRect(spritex + 330, yvalue, 20, 20);
              g2.drawRect(spritex + 350, yvalue, 20, 20);
              g2.drawRect(spritex + 370, yvalue, 20, 20);
              g2.drawRect(spritex + 390, yvalue, 20, 20);
              g2.drawRect(spritex + 410, yvalue, 20, 20);
              
           //row2
              yvalue = 660;
              g2.setColor(Color.BLACK);
              g2.fillRect(spritex + 10, yvalue, 20, 20);
              g2.fillRect(spritex + 170, yvalue, 20, 20);
              g2.fillRect(spritex + 250, yvalue, 20, 20);
              g2.fillRect(spritex + 410, yvalue, 20, 20);
              g2.setColor(darkblu);
              g2.fillRect(spritex + 30, yvalue, 140, 20);
              g2.fillRect(spritex + 270, yvalue, 140, 20);
              
              g2.setColor(thegrey);
              g2.drawRect(spritex + 10, yvalue, 20, 20);
              g2.drawRect(spritex + 30, yvalue, 20, 20);
              g2.drawRect(spritex + 50, yvalue, 20, 20);
              g2.drawRect(spritex + 70, yvalue, 20, 20);
              g2.drawRect(spritex + 90, yvalue, 20, 20);
              g2.drawRect(spritex + 110, yvalue, 20, 20);
              g2.drawRect(spritex + 130, yvalue, 20, 20);
              g2.drawRect(spritex + 150, yvalue, 20, 20);
              g2.drawRect(spritex + 170, yvalue, 20, 20);
        
              g2.drawRect(spritex + 250, yvalue, 20, 20);
              g2.drawRect(spritex + 270, yvalue, 20, 20);
              g2.drawRect(spritex + 290, yvalue, 20, 20);
              g2.drawRect(spritex + 310, yvalue, 20, 20);
              g2.drawRect(spritex + 330, yvalue, 20, 20);
              g2.drawRect(spritex + 350, yvalue, 20, 20);
              g2.drawRect(spritex + 370, yvalue, 20, 20);
              g2.drawRect(spritex + 390, yvalue, 20, 20);
              g2.drawRect(spritex + 410, yvalue, 20, 20);
          //row3
              yvalue = 640;
              g2.setColor(Color.BLACK);
              g2.fillRect(spritex + 30, yvalue, 40, 20);
              g2.fillRect(spritex + 190, yvalue, 20, 20);
              g2.fillRect(spritex + 270, yvalue, 20, 20);
              g2.fillRect(spritex + 350, yvalue, 60, 20);
              g2.setColor(darkblu);
              g2.fillRect(spritex + 70, yvalue, 120, 20);
              g2.fillRect(spritex + 290, yvalue, 60, 20);
              
              g2.setColor(thegrey);
              g2.drawRect(spritex + 30, yvalue, 20, 20);
              g2.drawRect(spritex + 50, yvalue, 20, 20);
              g2.drawRect(spritex + 70, yvalue, 20, 20);
              g2.drawRect(spritex + 90, yvalue, 20, 20);
              g2.drawRect(spritex + 110, yvalue, 20, 20);
              g2.drawRect(spritex + 130, yvalue, 20, 20);
              g2.drawRect(spritex + 150, yvalue, 20, 20);
              g2.drawRect(spritex + 170, yvalue, 20, 20);
              g2.drawRect(spritex + 190, yvalue, 20, 20);
        
              g2.drawRect(spritex + 270, yvalue, 20, 20);
              g2.drawRect(spritex + 290, yvalue, 20, 20);
              g2.drawRect(spritex + 310, yvalue, 20, 20);
              g2.drawRect(spritex + 330, yvalue, 20, 20);
              g2.drawRect(spritex + 350, yvalue, 20, 20);
              g2.drawRect(spritex + 370, yvalue, 20, 20);
              g2.drawRect(spritex + 390, yvalue, 20, 20);
              
            //row4
              yvalue = 620;
              g2.setColor(Color.BLACK);
              g2.fillRect(spritex + 70, yvalue, 60, 20);
              g2.fillRect(spritex + 210, yvalue, 20, 20);
              g2.fillRect(spritex + 270, yvalue, 20, 20);
              g2.fillRect(spritex + 370, yvalue, 20, 20);
              g2.setColor(darkblu);
              g2.fillRect(spritex + 110, yvalue, 100, 20);
              g2.fillRect(spritex + 290, yvalue, 80, 20);
              
              g2.setColor(thegrey);
              g2.drawRect(spritex + 70, yvalue, 20, 20);
              g2.drawRect(spritex + 90, yvalue, 20, 20);
              g2.drawRect(spritex + 110, yvalue, 20, 20);
              g2.drawRect(spritex + 130, yvalue, 20, 20);
              g2.drawRect(spritex + 150, yvalue, 20, 20);
              g2.drawRect(spritex + 170, yvalue, 20, 20);
              g2.drawRect(spritex + 190, yvalue, 20, 20);
              g2.drawRect(spritex + 210, yvalue, 20, 20);
        
              g2.drawRect(spritex + 270, yvalue, 20, 20);
              g2.drawRect(spritex + 290, yvalue, 20, 20);
              g2.drawRect(spritex + 310, yvalue, 20, 20);
              g2.drawRect(spritex + 330, yvalue, 20, 20);
              g2.drawRect(spritex + 350, yvalue, 20, 20);
              g2.drawRect(spritex + 370, yvalue, 20, 20);
              
           //row5
              yvalue = 600;
              g2.setColor(Color.BLACK);
              g2.fillRect(210, yvalue, 20, 20);
              g2.fillRect(330, yvalue, 40, 20);
              g2.fillRect(470, yvalue, 20, 20);
              g2.setColor(darkblu);
              g2.fillRect(230, yvalue, 100, 20);
              g2.fillRect(370, yvalue, 100, 20);

              g2.setColor(thegrey);
              g2.drawRect(210, yvalue, 20, 20);
              g2.drawRect(230, yvalue, 20, 20);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
          
           //row6
              yvalue = 580;
              g2.setColor(Color.BLACK);
              g2.fillRect(230, yvalue, 20, 20);
              g2.fillRect(450, yvalue, 20, 20);
              g2.setColor(darkblu);
              g2.fillRect(250, yvalue, 200, 20);

              g2.setColor(thegrey);
              g2.drawRect(230, yvalue, 20, 20);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
        //row7
              yvalue = 560;
              g2.setColor(Color.BLACK);
              g2.fillRect(250, yvalue, 20, 20);
              g2.fillRect(430, yvalue, 20, 20);
              g2.setColor(darkblu);
              g2.fillRect(270, yvalue, 160, 20);
              
              g2.setColor(thegrey);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);

         //row8
              yvalue = 540;
              g2.setColor(Color.BLACK);
              g2.fillRect(270, yvalue, 20, 20);
              g2.fillRect(430, yvalue, 20, 20);
              g2.setColor(darkblu);
              g2.fillRect(290, yvalue, 140, 20);

              g2.setColor(thegrey);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              
          //row9
              yvalue = 520;
              g2.setColor(Color.BLACK);
              g2.fillRect(250, yvalue, 40, 20);
              g2.fillRect(430, yvalue, 20, 20);
              g2.setColor(darkblu);
              g2.fillRect(290, yvalue, 140, 20);

              g2.setColor(thegrey);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              
           //row10
              yvalue = 500;
              g2.setColor(Color.BLACK);
              g2.fillRect(230, yvalue, 20, 20);
              g2.fillRect(290, yvalue, 20, 20);
              g2.fillRect(450, yvalue, 20, 20);
              g2.setColor(darkblu);
              g2.fillRect(250, yvalue, 40, 20);
              g2.fillRect(310, yvalue, 140, 20);

              g2.setColor(thegrey);
              g2.drawRect(230, yvalue, 20, 20);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
           //row11
              yvalue = 480;
              g2.setColor(Color.BLACK);
              g2.fillRect(210, yvalue, 20, 20);
              g2.fillRect(310, yvalue, 20, 20);
              g2.fillRect(470, yvalue, 100, 20);
              g2.fillRect(590, yvalue, 80, 20);
              g2.setColor(darkblu);
              g2.fillRect(230, yvalue, 80, 20);
              g2.fillRect(330, yvalue, 140, 20);

              g2.setColor(thegrey);
              g2.drawRect(210, yvalue, 20, 20);
              g2.drawRect(230, yvalue, 20, 20);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
              g2.drawRect(530, yvalue, 20, 20);
              g2.drawRect(550, yvalue, 20, 20);
              
              g2.drawRect(590, yvalue, 20, 20);
              g2.drawRect(610, yvalue, 20, 20);
              g2.drawRect(630, yvalue, 20, 20);
              g2.drawRect(650, yvalue, 20, 20);
           //row12
              yvalue = 460;
              g2.setColor(Color.BLACK);
              g2.fillRect(190, yvalue, 20, 20);
              g2.fillRect(250, yvalue, 20, 20);
              g2.fillRect(310, yvalue, 20, 20);
              g2.fillRect(370, yvalue, 100, 20);
              g2.fillRect(570, yvalue, 20, 20);
              g2.fillRect(630, yvalue, 60, 20);
              g2.setColor(darkblu);
              g2.fillRect(210, yvalue, 40, 20);
              g2.fillRect(270, yvalue, 40, 20);
              g2.fillRect(330, yvalue, 40, 20);
              g2.fillRect(470, yvalue, 100, 20);
              g2.fillRect(590, yvalue, 60, 20);

              g2.setColor(thegrey);
              g2.drawRect(190, yvalue, 20, 20);
              g2.drawRect(210, yvalue, 20, 20);
              g2.drawRect(230, yvalue, 20, 20);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
              g2.drawRect(530, yvalue, 20, 20);
              g2.drawRect(550, yvalue, 20, 20);            
              g2.drawRect(570, yvalue, 20, 20);
              g2.drawRect(590, yvalue, 20, 20);
              g2.drawRect(610, yvalue, 20, 20);
              g2.drawRect(630, yvalue, 20, 20);
              g2.drawRect(650, yvalue, 20, 20);
              g2.drawRect(670, yvalue, 20, 20);
           //row13
              yvalue = 440;
              g2.setColor(Color.BLACK);
              g2.fillRect(170, yvalue, 20, 20);
              g2.fillRect(250, yvalue, 20, 20);
              g2.fillRect(290, yvalue, 20, 20);
              g2.fillRect(350, yvalue, 20, 20);
              g2.fillRect(470, yvalue, 20, 20);
              g2.fillRect(570, yvalue, 20, 20);
              g2.fillRect(650, yvalue, 60, 20);
              g2.setColor(skin);
              g2.fillRect(370, yvalue, 100, 20);
              g2.setColor(darkblu);
              g2.fillRect(190, yvalue, 60, 20);
              g2.fillRect(270, yvalue, 20, 20);
              g2.fillRect(310, yvalue, 40, 20);
              g2.fillRect(490, yvalue, 80, 20);
              g2.fillRect(590, yvalue, 60, 20);
              g2.fillRect(670, yvalue, 20, 20);

              g2.setColor(thegrey);
              g2.drawRect(170, yvalue, 20, 20);
              g2.drawRect(190, yvalue, 20, 20);
              g2.drawRect(210, yvalue, 20, 20);
              g2.drawRect(230, yvalue, 20, 20);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
              g2.drawRect(530, yvalue, 20, 20);
              g2.drawRect(550, yvalue, 20, 20);            
              g2.drawRect(570, yvalue, 20, 20);
              g2.drawRect(590, yvalue, 20, 20);
              g2.drawRect(610, yvalue, 20, 20);
              g2.drawRect(630, yvalue, 20, 20);
              g2.drawRect(650, yvalue, 20, 20);
              g2.drawRect(670, yvalue, 20, 20);
              g2.drawRect(690, yvalue, 20, 20);
           //row14
              yvalue = 420;
              g2.setColor(Color.BLACK);
              g2.fillRect(170, yvalue, 20, 20);
              g2.fillRect(270, yvalue, 20, 20);
              g2.fillRect(330, yvalue, 20, 20);
              g2.fillRect(390, yvalue, 80, 20);
              g2.fillRect(490, yvalue, 40, 20);
              g2.fillRect(570, yvalue, 20, 20);
              g2.fillRect(650, yvalue, 60, 20);
              g2.setColor(skin);
              g2.fillRect(370, yvalue, 20, 20);
              g2.fillRect(470, yvalue, 20, 20);            
              g2.setColor(darkblu);
              g2.fillRect(190, yvalue, 80, 20);
              g2.fillRect(290, yvalue, 40, 20);
              g2.fillRect(350, yvalue, 20, 20);
              g2.fillRect(530, yvalue, 40, 20);
              g2.fillRect(590, yvalue, 60, 20);
              g2.fillRect(670, yvalue, 20, 20);

              g2.setColor(thegrey);
              g2.drawRect(170, yvalue, 20, 20);
              g2.drawRect(190, yvalue, 20, 20);
              g2.drawRect(210, yvalue, 20, 20);
              g2.drawRect(230, yvalue, 20, 20);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
              g2.drawRect(530, yvalue, 20, 20);
              g2.drawRect(550, yvalue, 20, 20);            
              g2.drawRect(570, yvalue, 20, 20);
              g2.drawRect(590, yvalue, 20, 20);
              g2.drawRect(610, yvalue, 20, 20);
              g2.drawRect(630, yvalue, 20, 20);
              g2.drawRect(650, yvalue, 20, 20);
              g2.drawRect(670, yvalue, 20, 20);
              g2.drawRect(690, yvalue, 20, 20);
           //row15
              yvalue = 400;
              g2.setColor(Color.BLACK);
              g2.fillRect(170, yvalue, 20, 20);
              g2.fillRect(310, yvalue, 20, 20);
              g2.fillRect(510, yvalue, 80, 20);
              g2.fillRect(650, yvalue, 40, 20);
              g2.setColor(Color.WHITE);
              g2.fillRect(390, yvalue, 60, 20);
              g2.fillRect(470, yvalue, 20, 20);
              g2.setColor(skin);
              g2.fillRect(350, yvalue, 40, 20);
              g2.fillRect(450, yvalue, 20, 20);            
              g2.fillRect(490, yvalue, 20, 20);            
              g2.setColor(darkblu);
              g2.fillRect(190, yvalue, 120, 20);
              g2.fillRect(330, yvalue, 20, 20);
              g2.fillRect(590, yvalue, 60, 20);

              g2.setColor(thegrey);
              g2.drawRect(170, yvalue, 20, 20);
              g2.drawRect(190, yvalue, 20, 20);
              g2.drawRect(210, yvalue, 20, 20);
              g2.drawRect(230, yvalue, 20, 20);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
              g2.drawRect(530, yvalue, 20, 20);
              g2.drawRect(550, yvalue, 20, 20);            
              g2.drawRect(570, yvalue, 20, 20);
              g2.drawRect(590, yvalue, 20, 20);
              g2.drawRect(610, yvalue, 20, 20);
              g2.drawRect(630, yvalue, 20, 20);
              g2.drawRect(650, yvalue, 20, 20);
              g2.drawRect(670, yvalue, 20, 20);
            
            //row16
              yvalue = 380;
              g2.setColor(Color.BLACK);
              g2.fillRect(190, yvalue, 20, 20);
              g2.fillRect(310, yvalue, 20, 20);
              g2.fillRect(410, yvalue, 40, 20);
              g2.fillRect(470, yvalue, 60, 20);
              g2.fillRect(590, yvalue, 60, 20);
              g2.setColor(Color.WHITE);
              g2.fillRect(370, yvalue, 40, 20);
              g2.fillRect(490, yvalue, 20, 20);
              g2.setColor(skin);
              g2.fillRect(350, yvalue, 20, 20);
              g2.fillRect(450, yvalue, 20, 20);            
              g2.setColor(darkblu);
              g2.fillRect(210, yvalue, 100, 20);
              g2.fillRect(330, yvalue, 20, 20);

              g2.setColor(thegrey);
              g2.drawRect(190, yvalue, 20, 20);
              g2.drawRect(210, yvalue, 20, 20);
              g2.drawRect(230, yvalue, 20, 20);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
              
              g2.drawRect(590, yvalue, 20, 20);
              g2.drawRect(610, yvalue, 20, 20);
              g2.drawRect(630, yvalue, 20, 20);
            
              //row17
              yvalue = 360;
              g2.setColor(Color.BLACK);
              g2.fillRect(210, yvalue, 40, 20);
              g2.fillRect(290, yvalue, 20, 20);
              g2.fillRect(410, yvalue, 40, 20);
              g2.fillRect(470, yvalue, 60, 20);
              g2.setColor(Color.WHITE);
              g2.fillRect(370, yvalue, 40, 20);
              g2.fillRect(490, yvalue, 20, 20);
              g2.setColor(skin);
              g2.fillRect(350, yvalue, 20, 20);
              g2.fillRect(450, yvalue, 20, 20);            
              g2.setColor(darkblu);
              g2.fillRect(250, yvalue, 40, 20);
              g2.fillRect(310, yvalue, 40, 20);

              g2.setColor(thegrey);
              g2.drawRect(210, yvalue, 20, 20);
              g2.drawRect(230, yvalue, 20, 20);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
            
              //row18
              yvalue = 340;
              g2.setColor(Color.BLACK);
              g2.fillRect(250, yvalue, 40, 20);
              g2.fillRect(290, yvalue, 20, 20);
              g2.fillRect(310, yvalue, 20, 20);
              g2.fillRect(410, yvalue, 40, 20);
              g2.fillRect(470, yvalue, 60, 20);
              g2.setColor(Color.WHITE);
              g2.fillRect(390, yvalue, 60, 20);
              g2.fillRect(470, yvalue, 40, 20);
              g2.setColor(skin);
              g2.fillRect(370, yvalue, 20, 20);
              g2.setColor(darkblu);
              g2.fillRect(310, yvalue, 60, 20);
              g2.fillRect(450, yvalue, 40, 20);            


              g2.setColor(thegrey);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
              //row19
              yvalue = 340;
              g2.setColor(Color.BLACK);
              g2.fillRect(250, yvalue, 40, 20);
              g2.fillRect(290, yvalue, 20, 20);
              g2.fillRect(310, yvalue, 20, 20);
              g2.fillRect(410, yvalue, 40, 20);
              g2.fillRect(470, yvalue, 60, 20);
              g2.setColor(Color.WHITE);
              g2.fillRect(390, yvalue, 60, 20);
              g2.fillRect(470, yvalue, 40, 20);
              g2.setColor(skin);
              g2.fillRect(370, yvalue, 20, 20);
              g2.setColor(darkblu);
              g2.fillRect(310, yvalue, 60, 20);
              g2.fillRect(450, yvalue, 40, 20);            


              g2.setColor(thegrey);
              g2.drawRect(250, yvalue, 20, 20);
              g2.drawRect(270, yvalue, 20, 20);
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
              //row20
              yvalue = 320;
              g2.setColor(Color.BLACK);
              g2.fillRect(290, yvalue, 20, 20);
              g2.fillRect(450, yvalue, 40, 20);
              g2.fillRect(510, yvalue, 20, 20);
              
              g2.setColor(darkblu);
              g2.fillRect(310, yvalue, 140, 20);
              g2.fillRect(490, yvalue, 20, 20);


              g2.setColor(thegrey);
              
              g2.drawRect(290, yvalue, 20, 20);
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
              
            //row21
              yvalue = 300;
              g2.setColor(Color.BLACK);
              g2.fillRect(310, yvalue, 20, 20);
              g2.fillRect(430, yvalue, 40, 20);
              g2.fillRect(510, yvalue, 20, 20);
              
              g2.setColor(darkblu);
              g2.fillRect(330, yvalue, 100, 20);
              g2.fillRect(450, yvalue, 60, 20);


              g2.setColor(thegrey);
              
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              g2.drawRect(510, yvalue, 20, 20);
              
              //row21
              yvalue = 280;
              g2.setColor(Color.BLACK);
              g2.fillRect(310, yvalue, 20, 20);
              g2.fillRect(430, yvalue, 80, 20);
              
              g2.setColor(darkblu);
              g2.fillRect(330, yvalue, 100, 20);


              g2.setColor(thegrey);
              
              g2.drawRect(310, yvalue, 20, 20);
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              g2.drawRect(490, yvalue, 20, 20);
              
              //row22
              yvalue = 260;
              g2.setColor(Color.BLACK);
              g2.fillRect(330, yvalue, 20, 20);
              g2.fillRect(410, yvalue, 80, 20);
              
              g2.setColor(darkblu);
              g2.fillRect(350, yvalue, 60, 20);
              g2.fillRect(430, yvalue, 40, 20);


              g2.setColor(thegrey);
              
              g2.drawRect(330, yvalue, 20, 20);
              g2.drawRect(350, yvalue, 20, 20);
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
              g2.drawRect(470, yvalue, 20, 20);
              //row23
              yvalue = 240;
              g2.setColor(Color.BLACK);
              g2.fillRect(350, yvalue, 120, 20);
              
              g2.setColor(thegrey);
              
              g2.drawRect(350, yvalue, 20, 20);
              g2.drawRect(370, yvalue, 20, 20);
              g2.drawRect(390, yvalue, 20, 20);
              g2.drawRect(410, yvalue, 20, 20);
              g2.drawRect(430, yvalue, 20, 20);
              g2.drawRect(450, yvalue, 20, 20);
  //LINES/BALL
              g2.setColor(babyblu);
              g2.setStroke(new BasicStroke(15));
              g2.drawLine(717, 440, 805, 361);
              g2.drawLine(717, 440, 805, 541);
              g2.fillOval(801, 398, 100, 100);
        g2.drawString(mousex+","+mousey, mousex, mousey);
        g2.drawString(distancex+"", mousex, mousey-20);
      }
      
      
      public Dimension getPreferredSize(){
         return new Dimension(1000, 800);
      }
      public static void main(String[] args) throws InterruptedException
      {
         
         MovingManFrameOne panel = new MovingManFrameOne();
         JFrame frame = new JFrame("Intro Frame");
         frame.getContentPane().add(panel);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(800, 600);
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);     
}

      @Override
      public void mouseClicked(MouseEvent e)
      {
      }

      @Override
      public void mousePressed(MouseEvent e)
      {
         System.out.println("press"+e.getX()+","+e.getY());
         pressx = e.getX();
         if (e.getID() == 501)
            press = true;
      System.out.println(press+""+e.getID());
      }

      @Override
      public void mouseReleased(MouseEvent e)
      {
         if (e.getID()==502);
         release = true;
         System.out.println(e.getID());
         System.out.println("release"+release);
         
               
      }

      @Override
      public void mouseEntered(MouseEvent e)
      {
      }

      @Override
      public void mouseExited(MouseEvent e)
      {
      }

      @Override
      public void mouseDragged(MouseEvent e)
      {
         dragx = e.getX();
         distancex = pressx-dragx;
         if (Math.abs(distancex) > 0)
         spritex = spritex - distancex/20;
         while (spritex == 1001)
            spritex = -199;
         while (spritex == -200)
            spritex = 1000;
         if (release = true)
            distancex = 0;
         repaint();
      }

      @Override
      public void mouseMoved(MouseEvent e)
      {
         mousex = e.getX();
         mousey = e.getY();
         System.out.println(e.getX()+","+e.getY());
         repaint();

      }
}