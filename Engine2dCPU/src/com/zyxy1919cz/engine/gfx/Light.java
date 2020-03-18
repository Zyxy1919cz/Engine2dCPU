package com.zyxy1919cz.engine.gfx;

public class Light {
	
	public static final int NONE = 0;
	public static final int FULL = 1;
	
	private int radius, diametr, color;
	private int[] lm;
	public Light(int radius, int color)
	{
		this.radius = radius;
		this.diametr = radius * 2;
		this.color = color;
		lm = new int [diametr * diametr];
		
		for (int y = 0; y < diametr; y++)
		{
			for (int x = 0; x < diametr; x++)
			{
				double distance = Math.sqrt((x - radius) * (x - radius) + (y - radius) * (y - radius));
				
				if(distance < radius)
				{
					double power = 1 - (distance / radius);
					lm[x + y * diametr] = ((int)(((color >> 16) & 0xff) * power) << 16| ((int)(((color >> 8) & 0xff) * power) << 8 | (int)((color & 0xff) * power)));
				}
				else
				{
					lm[x + y * diametr] = 0;
				}
			}		
		}
	}
	
	public int getLightValue(int x, int y)
	{
		if(x < 0 || x >= diametr || y < 0 || y >= diametr)
			return 0;
		
		return lm[x + y * diametr];
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getDiametr() {
		return diametr;
	}
	public void setDiametr(int diametr) {
		this.diametr = diametr;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int[] getLm() {
		return lm;
	}
	public void setLm(int[] lm) {
		this.lm = lm;
	}

}
