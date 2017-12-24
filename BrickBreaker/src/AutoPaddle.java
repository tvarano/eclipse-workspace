//Thomas Varano
//[Program Descripion]
//May 9, 2017

public class AutoPaddle extends Paddle
{
   public AutoPaddle(int x, int y, int width, int height){
      super(x,y,width,height);
   }
   
   public void update(PongBall ball){
      if (ball.getTrajectory().getY2()>getY()+getHeight()/2){
         setUp(false);
         setDown(true);
      }
      else if (ball.getTrajectory().getY2()<getY()+getHeight()/2){
         setDown(false);
         setUp(true);
      }
      else {
         setDown(false);
         setUp(false);
      }
      System.out.println(ball.getTrajectory().getY2()+","+(getY()+getHeight()/2));
      super.update();
   }
}
