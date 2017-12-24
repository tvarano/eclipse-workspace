//Thomas Varano
//[Program Descripion]
//Nov 16, 2016
public class Point
{
   private int x;
   private int y;
   private int radius;
   private String label;
   
   public Point(int x, int y)
   {
      this.x = x;
      this.y = y;
      radius = 5;
      this.label = null;
   }
   
   public Point(int x, int y, int radius){
      this.x = x;
      this.y = y;
      this.radius = radius;
      this.label = null;
   }
   
   public Point(int x, int y, int radius, String label){
      this.x = x;
      this.y = y;
      this.radius = radius;
      this.label = label;
   }
   
   public Point(int x, int y, String label)
   {
      this.x = x;
      this.y = y;
      this.radius = 5; 
      this.label = label;
   }
   
   public Point(){
      this.x = 0;
      this.y = 0;
   }
   
   public int getRadius(){
      return this.radius;
   }
   
   public void setRadius(int radius){
      this.radius = radius;
   }
   
   public int getX()
   {
      return this.x;
   }
   
   public int getY()
   {
      return this.y;
   }
   
   public void setX(int x)
   {
      this.x = x;
   }
   public void setY(int y)
   {
      this.y = y;
   }
   public String getLabel()
   {
      return label;
   }

   public void setLabel(String label)
   {
      this.label = label;
   }

   public double getSlopeTo(int x, int y){
      return ((double)(this.y - y)) / ((double)(this.x - x));      
   }
   
   public double getSlopeTo(Point p){
      return (this.y - p.getY()) / (this.x - p.getX());      
   }
   
   public double distanceToOrigin(){
      return Math.sqrt(Math.pow(x-0, 2)+Math.pow(y-0, 2));
   }
   
   public double distanceTo(int x, int y){
      return Math.sqrt(Math.pow(this.x-x, 2)+Math.pow(this.y-y, 2));
   }

   public double distanceTo(Point p){
      return Math.sqrt(Math.pow(this.x-p.getX(), 2)+Math.pow(this.y-p.getY(), 2));
   }
   
   public String getMidpointWith(int x, int y){
      return (x+this.x)/2+","+(y+this.y)/2;
   }
   
   public void translate(int dx, int dy){
      x += dx;
      y += dy;
   }
   
   public Point getCenter(){
      return new Point(x+radius,y+radius);
   }
   
   public double distanceToCenter(Point p){
      return this.getCenter().distanceTo(p.getCenter());
   }
   
   public boolean intersectsWith(Point p){
      return this.distanceToCenter(p) < radius + p.getRadius();
   }
}