package t1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import t4.SortVisualizer.ColorManager;
public class Instruction {

	private final int MARGIN = 35;
	private int x, y, width, height;
	private String instruction;
	private Color color;
	private int margin;

	public Instruction(int x, int y, int width, int margin)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = 34;
		this.margin = margin;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public void draw(Graphics g)
	{
		g.setColor(ColorManager.BAR_WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.blue);
		g.setFont(new Font("Times New Roman", Font.BOLD, 22));
		g.drawString(instruction, x , y + 20);
	}
	public void drawN(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	public void drawM(Graphics g)
	{
		g.setColor(ColorManager.BAR_WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.BOLD, 22));
		g.drawString(instruction, x , y + 20);
	}
	public void clear(Graphics g)
	{
		// clear the space
		g.setColor(ColorManager.BAR_WHITE);
		g.fillRect(x, y, width+150, height);
	}

	public void setColor(Color color) { this.color = color; }

	public Color getColor() { return color; }
	
}

