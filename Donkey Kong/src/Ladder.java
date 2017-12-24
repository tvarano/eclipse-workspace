import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;

//Thomas Varano
//[Program Descripion]
//Mar 1, 2017

public class Ladder
{
   public static final int BOUND_UP = 1;
   public static final int BOUND_DOWN = 2;
   protected static final int BOUND_NEUTRAL = 3;
   public static final double SPEED = 0.25;
   private double initialY, x,y,width,height;
   private Color color;
   private boolean up, down;
   private int position;
   private Platform upperBound;
   private Platform lowerBound;
   private boolean paint;
   private BufferedImage skin;
   
   public Ladder(double x, double width, double height, int position, Platform bound){
      if (position == BOUND_DOWN){
         lowerBound = bound;
         this.y = bound.getY()-height;
         upperBound = null;
         this.height = height+6;
      }
      else if (position == BOUND_UP){
         upperBound = bound;
         this.y = bound.getY();
         lowerBound = null;
         this.height = bound.getHeight()+height;
      }
      else
         throw new NullPointerException("unspecified Position");
      this.x = x;
      this.width = width;
      color = Color.WHITE;
      paint = false;
      this.initialY = y;
   }
   public Ladder (double maxX, double width, double height, int position, Platform bound, boolean isBoundRight){
      this(maxX-width,width,height,position,bound);
   }
   public Ladder(){
      this(0,0,0,BOUND_NEUTRAL,null);
   }
   
   public Ladder(int x, int width, Platform lowerBound, Platform upperBound){
      this.y = upperBound.getY();
      this.x = x;
      this.width = width;
      this.height = lowerBound.getY()-upperBound.getY()+5;
      this.upperBound = upperBound;
      this.lowerBound = lowerBound;
      position = BOUND_NEUTRAL;
      color = Color.WHITE;
   }
   public Ladder(int maxX, int width, Platform lowerBound, Platform upperBound, boolean isBoundRight){
      this(maxX-width,width,lowerBound,upperBound);
   }
   
   public void drawBounds(Graphics2D g2){
      Color prevColor = g2.getColor();
      g2.setColor(color);
      g2.fill(getBounds());
      g2.setColor(prevColor);
   }
   
   public void draw(Graphics2D g2) {
      if (paint) {
         for (int i = 0; i < (int) (height / 10); i++) {
            g2.drawImage(skin, (int)x, (int)y + 10 * i, (int)width, 10, null);
         }
      } else {
         drawBounds(g2);
      }
   }
   
   public void move(){
      if (up && y>initialY){
         y-=SPEED;
      }
      else if (down && y<initialY+height) {
         y+=SPEED;
      }
   }
   
   public boolean intersects(Shape shape){
      return getBounds().intersects((Rectangle)shape);
   }
   public boolean isGrabbed(Rectangle r) {
      return (this.intersects(r) && r.getCenterX()>this.getCenterX()-5 && r.getCenterX() < this.getCenterX()+5);
   }
   
   public boolean isEnveloped(Rectangle r){
      return (x>r.getX() && x+width<r.getMaxX() && getBounds().intersects(r));
   }
   
   public String toString(){
      return this.getClass().getName()+"[("+x+","+y+") w= "+width+". h= "+height+"]";
   }
   
   public boolean equals(Ladder l){
      return this.getBounds().equals(l.getBounds());
   }
   
   public Rectangle getBounds(){
      return new Rectangle((int)x,(int)y,(int)width,(int)height);
   }
   
   public double getCenterX(){
      return x+width/2;
   }
   
   public double getX() {
      return x;
   }
   public void setX(double x) {
      this.x = x;
   }
   public double getY() {
      return y;
   }
   public void setY(double y) {
      this.y = y;
   }
   public double getWidth() {
      return width;
   }
   public void setWidth(double width) {
      this.width = width;
   }
   public double getHeight() {
      return height;
   }
   public void setHeight(double height) {
      this.height = height;
   }
   public Color getColor() {
      return color;
   }
   public void setColor(Color color) {
      this.color = color;
   }
   public int getPosition() {
      return position;
   }
   public void setPosition(int position) {
      this.position = position;
   }
   public Platform getUpperBound() {
      return upperBound;
   }
   public void setUpperBound(Platform upperBound) {
      this.upperBound = upperBound;
   }
   public Platform getLowerBound() {
      return lowerBound;
   }
   public void setLowerBound(Platform lowerBound) {
      this.lowerBound = lowerBound;
   }
   public void setSkin(BufferedImage skin){
      this.skin = skin;
      paint = true;
   }
   public boolean isUp(){
      return up;
   }
   public void setUp(boolean up){
      this.up = up;
   }
   public boolean isDown(){
      return down;
   }
   public void setDown(boolean down){
      this.down = down;
   }
}
