import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//Thomas Varano
//[Program Descripion]
//May 3, 2017

public abstract class Item
{
   protected double x,y,width,height,dx,dy;
   protected Color color;
   protected ArrayList<Platform> platforms = new ArrayList<Platform>();
   protected boolean paint, hitWithHammer;
   protected BufferedImage skin = LevelOne.DEFAULT_SKIN;
   
   public Item(double x, double y, double width, double height){
      this.x = x; this.y = y; this.width = width; this.height = height;
      this.color = Color.WHITE;
   }
   
   public Rectangle getBounds(){
      return new Rectangle((int)x, (int)y, (int)width, (int)height);
   }
   
   public void draw(Graphics2D g2){
      paint = (skin!=null);
      if (paint)
         g2.drawImage(skin, (int)x, (int)y, (int)width, (int)height, null);
      else
         drawBounds(g2);
   }
   
   public void drawBounds(Graphics2D g2){
      Color prev = g2.getColor();
      g2.setColor(color);
      g2.fill(getBounds());
      g2.setColor(prev);
   }
   
   @Override
   public String toString(){
      return getClass().getName()+"[("+x+","+y+") "+width+"x"+height+"]";
   }
   
   public boolean platformIntersection(){
      for (Platform current : platforms){
            CollidedPlatform currentPlatformIntersection = current.getIntersection(getBounds());
            if (currentPlatformIntersection.isCollided() && dy >= 0){
               return true;
            }
      }
      return false;
   }
   
   public Platform currentPlatform(){
      for (int i = 0; i<platforms.size(); i++){
         CollidedPlatform currentPlatformIntersection = platforms.get(i).getIntersection(getBounds());
         if (currentPlatformIntersection.isCollided()){
            return currentPlatformIntersection.getPlatformCollided();
         }
      }
      return null;
   }
   
   public double getCenterX(){
      return x+width/2;
   }

   public boolean intersects(Item i){
      return (i.getBounds().intersects(getBounds()));
   }
   public boolean intersects(Rectangle r){
      return (r.intersects(getBounds()));
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

   public double getDx() {
      return dx;
   }

   public void setDx(double dx) {
      this.dx = dx;
   }

   public double getDy() {
      return dy;
   }

   public void setDy(double dy) {
      this.dy = dy;
   }

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public ArrayList<Platform> getPlatforms() {
      return platforms;
   }

   public void setPlatforms(ArrayList<Platform> platforms) {
      this.platforms = platforms;
   }

   public boolean isPaint() {
      return paint;
   }

   public void setPaint(boolean paint) {
      this.paint = paint;
   }

   public BufferedImage getSkin() {
      return skin;
   }

   public void setSkin(BufferedImage skin) {
      this.skin = skin;
      paint = (skin!=null);
      if (this instanceof MiscObject && paint == true)
         ((MiscObject)(this)).animate = false;
   }

   public boolean isHitWithHammer() {
      return hitWithHammer;
   }

   public void setHitWithHammer(boolean hitWithHammer) {
      this.hitWithHammer = hitWithHammer;
   }
}
