//Thomas Varano
//[Program Descripion]
//Mar 3, 2017

public class CollidedPlatform
{
   private boolean collided;
   private Platform platformCollided;
   
   public CollidedPlatform(boolean collided, Platform platformCollided){
      this.collided = collided;
      this.platformCollided = platformCollided;
   }
   
   public CollidedPlatform(boolean collided){
      this(collided, null);
   }

   public boolean isCollided() {
      return collided;
   }

   public void setCollided(boolean collided) {
      this.collided = collided;
   }

   public Platform getPlatformCollided() {
      return platformCollided;
   }

   public void setPlatformCollided(Platform platformCollided) {
      this.platformCollided = platformCollided;
   }
}
