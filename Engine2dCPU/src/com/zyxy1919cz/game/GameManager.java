package com.zyxy1919cz.game;

import java.awt.event.KeyEvent;

import com.zyxy1919cz.engine.AbstractGame;
import com.zyxy1919cz.engine.GameContainer;
import com.zyxy1919cz.engine.Renderer;
import com.zyxy1919cz.engine.gfx.Image;
import com.zyxy1919cz.engine.gfx.ImageTile;

public class GameManager extends AbstractGame
{
	private ImageTile fire;
	private Image cat;
	
	public GameManager()
	{
		fire = new ImageTile("/props/fire2.png",20, 30);
		cat = new Image("/icon/cat.png");
	}
	
	@Override
	public void update(GameContainer gc, float dt)
	{
		if(gc.getInput().isKeyDown(KeyEvent.VK_A))
		{
			System.out.println("A was pressed.");
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
		r.drawImage(cat, 0, 0);
		r.drawImageTile(fire, gc.getInput().getMouseX() - 10, gc.getInput().getMouseY() - 10, (int)temp, 0);
	}
	
	public static void main(String args[])
	{
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}
	
}
