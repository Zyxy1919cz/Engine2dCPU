package com.zyxy1919cz.game;

import java.awt.event.KeyEvent;

import com.zyxy1919cz.engine.AbstractGame;
import com.zyxy1919cz.engine.GameContainer;
import com.zyxy1919cz.engine.Renderer;
import com.zyxy1919cz.engine.audio.SoundClip;
import com.zyxy1919cz.engine.gfx.Image;
import com.zyxy1919cz.engine.gfx.ImageTile;

public class GameManager extends AbstractGame
{
	private ImageTile fire;
	private ImageTile alpha;
	private Image cat;
	private SoundClip clip;
	
	
	public GameManager()
	{
		fire = new ImageTile("/props/fire2.png",20, 30);
		alpha =  new ImageTile("/props/firealpha.png",20,30);
		alpha.setAlpha(true);
		cat = new Image("/icon/cat.png");
		clip = new SoundClip("/sound/arrowm.wav");
		clip.setVolume(0);
	}
	
	public void reset()
	{
		
	}
	
	@Override
	public void update(GameContainer gc, float dt)
	{
		if(gc.getInput().isKeyDown(KeyEvent.VK_A))
		{
			clip.play();
			System.out.println("A");
		}
		
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
		/*for (int x = 0; x < image.getW(); x++)
		{
			for (int y = 0; y < image.getH(); y++)
			{
				r.setLightMap(x, y, image.getP(x + y * pW));
			}
		}
		*/
		r.drawImageTile(alpha, gc.getInput().getMouseX() - 10, gc.getInput().getMouseY() -25, (int)temp, 0);
		r.drawImage(cat, 0, 0);
		r.drawImageTile(fire, 54, 100, (int)temp, 0);
		r.drawRectangle(10, 10, 32, 60, 0xffffccff);
		r.drawFillRectangle(90, 90, 30, 20, 0xffccffff);
	}
	
	public static void main(String args[])
	{
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}
	
}
