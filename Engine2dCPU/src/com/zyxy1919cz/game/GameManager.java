package com.zyxy1919cz.game;

import com.zyxy1919cz.engine.AbstractGame;
import com.zyxy1919cz.engine.GameContainer;
import com.zyxy1919cz.engine.Renderer;
import com.zyxy1919cz.engine.gfx.Image;
import com.zyxy1919cz.engine.gfx.ImageTile;
import com.zyxy1919cz.engine.gfx.Light;

public class GameManager extends AbstractGame
{
	/* Init private Constructors 
	 * 
	 * private Image cat;
	 * private ImageTile fire;
	 * private ImageTile alpha;
	 * private SoundClip clip;
	 * private Light light;
	 */
	
	private Image background;
	private ImageTile fire;
	private Light light;
	private Image obstacle;
	
	
	public GameManager()
	{
		/* loads assets from res folder
		 * 
		 * cat = new Image("/icon/cat.png");
		 * fire = new ImageTile("/props/fire2.png",20, 30);
		 * alpha =  new ImageTile("/props/firealpha.png",20,30);
		 * Sets alpha rendering.
		 * 	alpha.setAlpha(true);
		 * clip = new SoundClip("/sound/arrowm.wav");
		 * Sets - dB volume
		 * 	clip.setVolume(0);
		 * light = new Light(50, 0xff00ffff);
		 * 
		 */
		
		background = new Image("/props/Background.png");
		fire = new ImageTile("/props/fire2.png", 20, 30);
		fire.setAlpha(true);
		light = new Light(100, 0xff00ffff);
		obstacle = new Image("/props/test.png");
		obstacle.setLightBlock(Light.FULL);
	}
	
	public void reset()
	{
		
	}
	
	@Override
	public void update(GameContainer gc, float dt)
	{
		/*Sets input A
		 * 
		 * if(gc.getInput().isKeyDown(KeyEvent.VK_A))
		 * {
			clip.play();
			System.out.println("A");
			}
		 */
		
		
		temp += dt * 10;
		
		if(temp > 5)
		{
			temp = 0;
		}
	}

	float temp = 0;
	
	
	@Override
	public void render(GameContainer gc, Renderer r)
	{	
		/*
		 * r.drawImage(cat, 0, 0);
		 * r.drawImageTile(fire, 54, 100, (int)temp, 0);
		 * r.drawImageTile(alpha, 10, 25, (int)temp, 0);
		 * r.drawRectangle(10, 10, 32, 60, 0xffffccff);
		 * r.drawFillRectangle(90, 90, 30, 20, 0xffccffff);
		 * r.drawImage(image, gc.getInput().getMouseX(), gc.getInput().getMouseY());
		 */
		
		r.drawLight(light, gc.getInput().getMouseX(), gc.getInput().getMouseY());
		r.setzDepth(0);
		r.drawImageTile(fire, 70, 70, (int)temp, 0);
		r.drawImage(background, 0, 0);
		r.drawImage(obstacle, 80, 110);
	}
	
	public static void main(String args[])
	{
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}
	
}
