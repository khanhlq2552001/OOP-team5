package t3;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
public class SortCanvas extends Canvas{

	private SortFrame sortFrame;
	public SortCanvas(SortFrame sortFrame) {
		this.sortFrame = sortFrame;
	}
	public void paint(Graphics g)
    {
        super.paint(g);
		clear(g);
		sortFrame.onDrawArray();
    }

	public void clear(Graphics g)
	{
		g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
	}

}
