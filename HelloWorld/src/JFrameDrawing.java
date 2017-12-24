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
//Drawing using JFrame
//Oct 26, 2016
public class JFrameDrawing extends JPanel implements MouseListener,MouseMotionListener
{
  /**
    * 
    */
   private static final long serialVersionUID = 1L;
private int mousex,mousey;
   public JFrameDrawing()
   {
      mousex = 0;
      mousey = 0;
      
      this.setBackground(Color.WHITE);
      this.addMouseListener(this); 
      this.addMouseMotionListener(this);
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setStroke(new BasicStroke(5));
//top section layer l to r
      g2.setColor(new Color(45, 87, 231));
         g2.fillRect(0, 0, 200, 120);
         g2.fillRect(400, 0, 200, 120);
         g2.fillRect(800, 0, 200, 120);
         g2.setColor(new Color(127, 188, 249));
         g2.fillRect(200, 0, 200, 120);
         g2.fillRect(600, 0, 200, 120);
      //lines
      g2.setColor(Color.BLACK);
         g2.drawRect(0, 0, 200, 120);
         g2.drawRect(200, 0, 200, 120);
         g2.drawRect(400, 0, 200, 120);
         g2.drawRect(600, 0, 200, 120);
         g2.drawRect(800, 0, 200, 120);
      
      
//background ROW ONE
         g2.setColor(new Color(100, 36, 26));
         g2.fillRect(-50, 120, 200, 120);
         g2.fillRect(150, 120, 200, 120);
         g2.fillRect(350, 120, 200, 120);
         g2.fillRect(550, 120, 200, 120);
         g2.fillRect(750, 120, 200, 120);
         g2.fillRect(950, 120, 200, 120);
         //lines
         g2.setColor(Color.BLACK);
         g2.drawRect(-50, 120, 200, 120);
         g2.drawRect(150, 120, 200, 120);
         g2.drawRect(350, 120, 200, 120);
         g2.drawRect(550, 120, 200, 120);
         g2.drawRect(750, 120, 200, 120);
         g2.drawRect(950, 120, 200, 120);
//background ROW TWO
         g2.setColor(new Color(100, 36, 26));
         g2.fillRect(-100, 240, 200, 120);
         g2.fillRect(100, 240, 200, 120);
         g2.fillRect(300, 240, 200, 120);
         g2.fillRect(500, 240, 200, 120);
         g2.fillRect(700, 240, 200, 120);
         g2.fillRect(900, 240, 200, 120);
         //lines
         g2.setColor(Color.BLACK);
         g2.drawRect(-100, 240, 200, 120);
         g2.drawRect(100, 240, 200, 120);
         g2.drawRect(300, 240, 200, 120);
         g2.drawRect(500, 240, 200, 120);
         g2.drawRect(700, 240, 200, 120);
         g2.drawRect(900, 240, 200, 120);
//background ROW THREE
         g2.setColor(new Color(100, 36, 26));
         g2.fillRect(-75, 360, 200, 120);
         g2.fillRect(125, 360, 200, 120);
         g2.fillRect(325, 360, 200, 120);
         g2.fillRect(525, 360, 200, 120);
         g2.fillRect(725, 360, 200, 120);
         g2.fillRect(925, 360, 200, 120);
         //lines
         g2.setColor(Color.BLACK);
         g2.drawRect(-75, 360, 200, 120);
         g2.drawRect(125, 360, 200, 120);
         g2.drawRect(325, 360, 200, 120);
         g2.drawRect(525, 360, 200, 120);
         g2.drawRect(725, 360, 200, 120);
         g2.drawRect(925, 360, 200, 120);
//background ROW FOUR
         g2.setColor(new Color(100, 36, 26));
         g2.fillRect(-50, 480, 200, 120);
         g2.fillRect(150, 480, 200, 120);
         g2.fillRect(350, 480, 200, 120);
         g2.fillRect(550, 480, 200, 120);
         g2.fillRect(750, 480, 200, 120);
         g2.fillRect(950, 480, 200, 120);
         //lines
         g2.setColor(Color.BLACK);
         g2.drawRect(-50, 480, 200, 120);
         g2.drawRect(150, 480, 200, 120);
         g2.drawRect(350, 480, 200, 120);
         g2.drawRect(550, 480, 200, 120);
         g2.drawRect(750, 480, 200, 120);
         g2.drawRect(950, 480, 200, 120);
//background ROW FIVE
         g2.setColor(new Color(100, 36, 26));
         g2.fillRect(-100, 600, 200, 120);
         g2.fillRect(100, 600, 200, 120);
         g2.fillRect(300, 600, 200, 120);
         g2.fillRect(500, 600, 200, 120);
         g2.fillRect(700, 600, 200, 120);
         g2.fillRect(900, 600, 200, 120);
         //lines
         g2.setColor(Color.BLACK);
         g2.drawRect(-100, 600, 200, 120);
         g2.drawRect(100, 600, 200, 120);
         g2.drawRect(300, 600, 200, 120);
         g2.drawRect(500, 600, 200, 120);
         g2.drawRect(700, 600, 200, 120);
         g2.drawRect(900, 600, 200, 120);
         
//Bottom layer l to r
         
    g2.setColor(new Color(45, 87, 231));
      g2.fillRect(0, 700, 200, 120);
      g2.fillRect(400, 700, 200, 120);
      g2.fillRect(800, 700, 200, 120);
      g2.setColor(new Color(127, 188, 249));
      g2.fillRect(200, 700, 200, 120);
      g2.fillRect(600, 700, 200, 120);
      //lines
      g2.setColor(Color.BLACK);
      g2.drawRect(0, 700, 200, 120);
      g2.drawRect(200, 700, 200, 120);
      g2.drawRect(400, 700, 200, 120);
      g2.drawRect(600, 700, 200, 120);
      g2.drawRect(800, 700, 200, 120);
      
//MEGAMAN
      Color thegrey = new Color(120,120,120);
      Color darkblu = new Color(66,110,181);
      Color babyblu = new Color(134,186,229);
      Color skin = new Color(246,225,150);
      g2.setStroke(new BasicStroke(2));
      int yvalue = 680;
      //legs / feet
         //bottom row
            g2.setColor(Color.BLACK);
            g2.fillRect(110, yvalue, 180, 20);
            g2.fillRect(350, yvalue, 180, 20);
      
            g2.setColor(thegrey);
            g2.drawRect(110, yvalue, 20, 20);
            g2.drawRect(130, yvalue, 20, 20);
            g2.drawRect(150, yvalue, 20, 20);
            g2.drawRect(170, yvalue, 20, 20);
            g2.drawRect(190, yvalue, 20, 20);
            g2.drawRect(210, yvalue, 20, 20);
            g2.drawRect(230, yvalue, 20, 20);
            g2.drawRect(250, yvalue, 20, 20);
            g2.drawRect(270, yvalue, 20, 20);
      
            g2.drawRect(350, yvalue, 20, 20);
            g2.drawRect(370, yvalue, 20, 20);
            g2.drawRect(390, yvalue, 20, 20);
            g2.drawRect(410, yvalue, 20, 20);
            g2.drawRect(430, yvalue, 20, 20);
            g2.drawRect(450, yvalue, 20, 20);
            g2.drawRect(470, yvalue, 20, 20);
            g2.drawRect(490, yvalue, 20, 20);
            g2.drawRect(510, yvalue, 20, 20);
            
         //row2
            yvalue = 660;
            g2.setColor(Color.BLACK);
            g2.fillRect(110, yvalue, 20, 20);
            g2.fillRect(270, yvalue, 20, 20);
            g2.fillRect(350, yvalue, 20, 20);
            g2.fillRect(510, yvalue, 20, 20);
            g2.setColor(darkblu);
            g2.fillRect(130, yvalue, 140, 20);
            g2.fillRect(370, yvalue, 140, 20);
            
            g2.setColor(thegrey);
            g2.drawRect(110, yvalue, 20, 20);
            g2.drawRect(130, yvalue, 20, 20);
            g2.drawRect(150, yvalue, 20, 20);
            g2.drawRect(170, yvalue, 20, 20);
            g2.drawRect(190, yvalue, 20, 20);
            g2.drawRect(210, yvalue, 20, 20);
            g2.drawRect(230, yvalue, 20, 20);
            g2.drawRect(250, yvalue, 20, 20);
            g2.drawRect(270, yvalue, 20, 20);
      
            g2.drawRect(350, yvalue, 20, 20);
            g2.drawRect(370, yvalue, 20, 20);
            g2.drawRect(390, yvalue, 20, 20);
            g2.drawRect(410, yvalue, 20, 20);
            g2.drawRect(430, yvalue, 20, 20);
            g2.drawRect(450, yvalue, 20, 20);
            g2.drawRect(470, yvalue, 20, 20);
            g2.drawRect(490, yvalue, 20, 20);
            g2.drawRect(510, yvalue, 20, 20);
        //row3
            yvalue = 640;
            g2.setColor(Color.BLACK);
            g2.fillRect(130, yvalue, 40, 20);
            g2.fillRect(290, yvalue, 20, 20);
            g2.fillRect(370, yvalue, 20, 20);
            g2.fillRect(450, yvalue, 60, 20);
            g2.setColor(darkblu);
            g2.fillRect(170, yvalue, 120, 20);
            g2.fillRect(390, yvalue, 60, 20);
            
            g2.setColor(thegrey);
            g2.drawRect(130, yvalue, 20, 20);
            g2.drawRect(150, yvalue, 20, 20);
            g2.drawRect(170, yvalue, 20, 20);
            g2.drawRect(190, yvalue, 20, 20);
            g2.drawRect(210, yvalue, 20, 20);
            g2.drawRect(230, yvalue, 20, 20);
            g2.drawRect(250, yvalue, 20, 20);
            g2.drawRect(270, yvalue, 20, 20);
            g2.drawRect(290, yvalue, 20, 20);            
      
            g2.drawRect(370, yvalue, 20, 20);
            g2.drawRect(390, yvalue, 20, 20);
            g2.drawRect(410, yvalue, 20, 20);
            g2.drawRect(430, yvalue, 20, 20);
            g2.drawRect(450, yvalue, 20, 20);
            g2.drawRect(470, yvalue, 20, 20);
            g2.drawRect(490, yvalue, 20, 20);
            
          //row4
            yvalue = 620;
            g2.setColor(Color.BLACK);
            g2.fillRect(170, yvalue, 60, 20);
            g2.fillRect(310, yvalue, 20, 20);
            g2.fillRect(370, yvalue, 20, 20);
            g2.fillRect(470, yvalue, 20, 20);
            g2.setColor(darkblu);
            g2.fillRect(210, yvalue, 100, 20);
            g2.fillRect(390, yvalue, 80, 20);
            
            g2.setColor(thegrey);
            g2.drawRect(170, yvalue, 20, 20);
            g2.drawRect(190, yvalue, 20, 20);
            g2.drawRect(210, yvalue, 20, 20);
            g2.drawRect(230, yvalue, 20, 20);
            g2.drawRect(250, yvalue, 20, 20);
            g2.drawRect(270, yvalue, 20, 20);
            g2.drawRect(290, yvalue, 20, 20);
            g2.drawRect(310, yvalue, 20, 20);
      
            g2.drawRect(370, yvalue, 20, 20);
            g2.drawRect(390, yvalue, 20, 20);
            g2.drawRect(410, yvalue, 20, 20);
            g2.drawRect(430, yvalue, 20, 20);
            g2.drawRect(450, yvalue, 20, 20);
            g2.drawRect(470, yvalue, 20, 20);
            
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
            g2.setStroke(new BasicStroke(3));
            g2.setColor(darkblu);
            g2.drawOval(801, 398, 100, 100);
            g2.drawString(mousex+","+mousey,mousex,mousey);
            g2.setColor(Color.BLACK);
            g2.drawString(JFrameDrawing.time(), 100, 100);
   }
   public Dimension getPreferredSize(){
      return new Dimension(1000, 820);
   }
   
   
   public static void main(String[] args) throws InterruptedException
   {
      JFrameDrawing panel = new JFrameDrawing();
      JFrame frame = new JFrame("Thomas Varano Drawing");
      frame.getContentPane().add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
   
   public static String time(){
//      Calendar c = Calendar.getInstance(); 
//      return c.getTime();
      //Time
      while(true){
      long dayssince = (long) ((System.currentTimeMillis() - 14400000)/8.64e+7);

      long millis = (long)(System.currentTimeMillis());
         int overallsec = (int) (millis/1000%864600);
         long overall = ((millis/1000)%(dayssince*86400)%86400);
         int hours = (int) (overall/3600%3600-4)-1;
         int min =  (int) (overall%3600/60);
         int sec = (overallsec%3600%60);
       
         hours = hours%12;
         System.out.println(overall);
         String outputSec =
      null;
         if (sec < 10)
           outputSec = "0"+sec;
         else 
            outputSec = ""+sec;
         String outputMin=
               null;
         if (min < 10)
            outputMin = "0"+min;
         else 
            outputMin = ""+min;
     return hours+":"+outputMin+":"+outputSec;
      }
      }
                  
   
   

//mouse location
   @Override
   public void mouseClicked(MouseEvent e)
   {
   }

   @Override
   public void mousePressed(MouseEvent e)
   {
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
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
   }

   @Override
   public void mouseMoved(MouseEvent e)
   {
      System.out.println("MouseAt:"+e.getX()+","+e.getY());
      mousex = e.getX();
      mousey = e.getY();
      repaint();

   
   }}
