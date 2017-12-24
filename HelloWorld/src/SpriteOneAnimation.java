import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//Thomas Varano
//arrays
//Dec 11, 2016

public class SpriteOneAnimation {
	private ArrayList<Image> rightSheet;
	private ArrayList<Image> leftSheet;
	private ArrayList<Image> upSheet;
	private ArrayList<Image> downSheet;
	private SpriteOne s;
	private BufferedImage buf = new BufferedImage(10,10, BufferedImage.TYPE_INT_RGB);
	
	public SpriteOneAnimation(SpriteOne s){
		rightSheet = new ArrayList<Image>();
		leftSheet = new ArrayList<Image>();
		upSheet = new ArrayList<Image>();
		downSheet = new ArrayList<Image>();
		this.s = s;
	}
	
	public void addRight(Image i){
	   rightSheet.add(i);
	}
	public void addLeft(Image i){
		leftSheet.add(i);
	}
	public void addUp(Image i){
		upSheet.add(i);
	}
	public void addDown(Image i){
		downSheet.add(i);
	}

	public Image getCostume(){
		Image costume = null;
		if (s.isRight()){
			for (int i = 0; i < rightSheet.size(); i++){
			   costume = rightSheet.get(i);
			}
		}
		else if (s.isLeft()){
		   for (int i = 0; i < leftSheet.size(); i++){
		      costume = leftSheet.get(i);
		   }
		}
		else if (s.getDy()>0){
		   for (int i = 0; i < upSheet.size(); i++){
	             costume = upSheet.get(i);;
		   }
		}
		else if (s.getDy()<0){
		   for (int i = 0; i < downSheet.size(); i++){
	             costume = downSheet.get(i);
		   }
		}
		
		return costume;
	}
}
