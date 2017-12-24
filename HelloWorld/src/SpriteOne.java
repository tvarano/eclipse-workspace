import java.awt.Rectangle;

//Thomas Varano
//Sprite Class
//Dec 9, 2016



//MAKE HITBOX RECTANGLE getbounds
public class SpriteOne {
	private int x, y, width, height, ground;
	double dx, dy;
	private double jumpForce, gravity, inertia, maxSpeed;
	private boolean falling, right, left, down, jumping;
	
   public int getGround(){
		return ground;
	}
	public void setGround(int g){
		ground = g;
	}
	public double getMaxSpeed(){
		return maxSpeed;
	}
	public void setMaxSpeed(double s){
		maxSpeed = s;
	}
	public double getInertia(){
		return inertia;
	}
	public void setInertia(double i){
		this.inertia = i;
	}
	public double getDx()
	{
		return dx;
	}
	public void setDx(double dx)
	   {
	      this.dx = dx;
	   }
	public double getDy()
	   {
	      return dy;
	   }
	public void setDy(double dy)
	   {
	      this.dy = dy;
	   }
	public int getX()
	   {
	      return x;
	   }
	public void setX(int x)
	   {
	      this.x = x;
	   }
	public int getY()
	   {
	      return y;
	   }
	public void setY(int y)
	   {
	      this.y = y;
	   }
	public int getWidth()
	   {
	      return width;
	   }
	public void setWidth(int width)
	   {
	      this.width = width;
	   }
	public int getHeight()
	   {
	      return height;
	   }
	public void setHeight(int height)
	   {
	      this.height = height;
	   }
	public double getJumpForce()
	   {
	      return jumpForce;
	   }
	public void setJumpForce(double jumpForce)
	   {
	      this.jumpForce = jumpForce;
	   }
	public double getGravity()
	   {
	      return gravity;
	   }
	public void setGravity(double gravity)
	   {
	      this.gravity = gravity;
	   }
	public boolean isFalling()
	   {
	      return falling;
	   }
	public void setFalling(boolean falling)
	   {
	      this.falling = falling;
	   }
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isJumping() {
		return jumping;
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	public SpriteOne(int x, int y, int width, int height){
		   this.x = x;
		   this.y = y;
		   this.width = width;
		   this.height = height;
		   dx = 0;
		   dy = 0;
		   jumping = false;
		   falling = false;
		   left = false;
		   right = false;
		   down = false;
		   jumpForce = 1;
		   gravity = 0.25;
		   maxSpeed = 10;
		   inertia = 1;
		   ground = 10000;
	   }
	   
	   public SpriteOne(){
	      this(0,0,0,0);
	   }
	   
	   public void update(){
//COLLISION
		   Rectangle bounds = getBounds();
//MOVEMENT Y
		   if (jumping){
			   dy = 0-jumpForce;
			   setY(y+=dy);
			   setFalling(true);
			   setJumping(false);
		   }
		   
		   else if (falling){
			   dy += gravity;
			   y+=dy;
		   }

		   if (y >= ground){
			   dy = 0;
			   setFalling(false);
			   y = ground;
		   }
//MOVEMENT X
		   //probably the wrong thing to do
		   if (right && left){
			   if(dx > 0)
			   {
				   dx -= inertia;
				   if(dx < 0)
					   dx = 0;
			   }
			   else if(dx < 0)
			   {
				   dx += inertia;
				   if(dx > 0)
					   dx = 0;
			   }
		   }
		   else if (right){
			   dx+=inertia;
			   if (dx > maxSpeed){
				   dx = maxSpeed;
			   }
		   }

		   else if (left){
			   dx-= inertia;
			   if (dx < -maxSpeed){
				   dx = -maxSpeed;
			   }
		   }
		   else {
			   if(dx > 0)
			   {
				   dx -= inertia;
				   if(dx < 0)
					   dx = 0;
			   }
			   else if(dx < 0)
			   {
				   dx += inertia;
				   if(dx > 0)
					   dx = 0;
			   }
		   }	
		   x += dx; 
	   }   
	   
	   public Rectangle getBounds(){
		   return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	   }
	   
	   public boolean checkCollision(Rectangle r){
		   return (getBounds().intersects(r));
	   }

}
