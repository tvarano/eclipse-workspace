import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//Thomas Varano
//[Program Descripion]
//Mar 1, 2017

public class Platform
{
   public static final int SECTION_W = 50;
   protected int x,y,width,height, centerX, centerY, edgeL, edgeR;
   protected boolean rotated, paint, conveying;
   public Color color;
   public double degreeRotation;
   public BufferedImage skin;
   protected ArrayList<Platform> sections = new ArrayList<Platform>();
   
   public Platform(int x, int y, int width, int height){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.degreeRotation = 0;
      rotated = false;
      centerX = x+width/2;
      centerY = y+height/2;
      color = Color.WHITE;
      edgeL = x; edgeR = x+width;
      try {
         skin = ImageIO.read(ClassLoader.getSystemResource("platformImage.png"));
         paint = true;
      } catch(IOException e){
         e.printStackTrace();
         paint = false;
      }
      sections.add(this);
   }
   public Platform(){
      this(0,0,0,0); 
   }
   
   public Shape rotate(int dilationCenterX, int dilationCenterY){
      rotated = true;
      AffineTransform transform = new AffineTransform();
      transform.rotate(Math.toRadians(degreeRotation), dilationCenterX, dilationCenterY + height/2);
       return transform.createTransformedShape(getBounds());
   }
   
   public void rotateAndBreakWithDegree(int stepBetween){
      if (degreeRotation>90 || degreeRotation<-90)
         throw new Error("degree rotation out of range");
      rotated = true;
      sections.removeAll(sections);
      int difY = (int)Math.round((Math.tan(Math.toRadians(degreeRotation))*width));
      if (Math.abs(stepBetween)>Math.abs(difY))
         throw new Error("stepBetween larger than difference in y");
      int amountSection = Math.round(Math.abs(difY/stepBetween));
      for (int i = 0; i<amountSection; i++){
         int platformInitX = x+(width/amountSection)*(i);
         int platformInitY = y+(difY/amountSection)*i;
         sections.add(new Platform(platformInitX, platformInitY,
               width/amountSection, height));
         sections.get(i).setColor(color);
      }
      System.out.println(difY);
   }
   
   public void rotateAndBreakWithStep(int stepBetween, int sectionWidth){
      sections.removeAll(sections);
      int amountSection = width/sectionWidth;
      int platformInitX;
      int platformInitY;
      for (int i = 0; i < amountSection; i++){
         platformInitX = x+(width/amountSection)*(i);
         if (degreeRotation>0)
            platformInitY = y+stepBetween*i;
         else
            platformInitY = y-stepBetween*i;
         sections.add(new Platform(platformInitX, platformInitY, width/amountSection, height));
         sections.get(i).setColor(color);
         sections.get(i).setDegreeRotation(degreeRotation);
         sections.get(i).setEdgeL(edgeL);
         sections.get(i).setEdgeR(edgeR);
      }
   }
   
   public void drawBounds(Graphics2D g2){
      for (Platform p : sections){
         g2.setColor(p.color);
         g2.fill(p.getBounds());
      }
   }
   
   public void draw(Graphics2D g2){
      if (paint){
         for (Platform p : sections){
            for (int i = 0; i< (int)(p.width/SECTION_W); i++){
               g2.drawImage(skin, p.x+SECTION_W*i, p.y, SECTION_W, p.height, null);
            }
         }
      }
      else {
         drawBounds(g2);
      }
   }
   
   public boolean intersects(Rectangle r){
      for (Platform currentSection : sections){
         if (currentSection.getBounds().intersects(r))
            return true;
      }
      return false;
         
   }
   
   public int getAmountSections(){
      return sections.size();
   }
   
   public Platform getSection(int index){
      return sections.get(index);
   }
   
   public CollidedPlatform getIntersection(Rectangle r){
      for (Platform currentSection : sections){
         if (currentSection.getBounds().intersects(r)){
            return new CollidedPlatform(true, currentSection);
         }
      }
      return new CollidedPlatform(false);
   }
   
   public String toString(){
      return this.getClass().getName()+"[("+x+","+y+") w="+width+", h="+height+"]";
   }
   public ArrayList<Platform> getSections() {
      return sections;
   }
   
   public void update(){}
   
   public Shape getBounds(){
//      if (rotated)
//         return bounds;
//      else
         return new Rectangle(x,y,width,height);
   }
   
   public boolean equals(Platform p){
      return (p.getX() == x && p.getY() == y && p.getWidth() == width && p.getHeight() == height);
   }
   
   public boolean equals(ConveyorBelt c){
      return (c.getX() == x && c.getY() == y && c.getWidth() == width && c.getHeight() == height);
   }

   public double getMaxX(){
      return getBounds().getBounds2D().getMaxX();
   }
   
   public double getMaxY(){
      return getBounds().getBounds2D().getMaxY();
   }
   
   public int getX() {
      return x;
   }
   public void setX(int x) {
      this.x = x;
   }
   public int getY() {
      return y;
   }
   public void setY(int y) {
      this.y = y;
   }
   public int getWidth() {
      return width;
   }
   public void setWidth(int width) {
      this.width = width;
   }
   public int getHeight() {
      return height;
   }
   public void setHeight(int height) {
      this.height = height;
   }
   public boolean isRotated() {
      return rotated;
   }
   public void setRotated(boolean rotated) {
      this.rotated = rotated;
   }

   public int getCenterX() {
      return centerX;
   }

   public void setCenterX(int centerX) {
      this.centerX = centerX;
   }

   public int getCenterY() {
      return centerY;
   }

   public void setCenterY(int centerY) {
      this.centerY = centerY;
   }

   public double getDegreeRotation() {
      return degreeRotation;
   }

   public void setDegreeRotation(double
         degreeRotation) {
      this.degreeRotation = degreeRotation;
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }
   
   public void setSkin(BufferedImage skin){
      this.skin = skin;
   }
   public boolean isConveying() {
      return conveying;
   }
   public double getDx(){
      return 0;
   }
   public void setSprites(ArrayList<Sprite> sp){}
   public void setItems(ArrayList<Item> items){}
   public int getEdgeL() {
      return edgeL;
   }
   public void setEdgeL(int edgeL) {
      this.edgeL = edgeL;
   }
   public int getEdgeR() {
      return edgeR;
   }
   public void setEdgeR(int edgeR) {
      this.edgeR = edgeR;
   }
   public BufferedImage getSkin() {
      return skin;
   }
}
