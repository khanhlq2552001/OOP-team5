package t4;

import t1.Instruction;
import t3.SortCanvas;
import t3.SortFrame;

public class BubbleSortVisualizer extends SortVisualizer{

	public BubbleSortVisualizer(SortCanvas sortCanvas, SortFrame sortFrame, int[] array) {
		super(sortCanvas, sortFrame, array);
	}
	
	/* BUBBLE SORT */
	@Override
	public void sort()
	{
		pause();
		// get graphics
        g = bs.getDrawGraphics();
		int count = 0;
		for (int i = array.length - 1; i >= 0; i--)
		{
			pause();
			count = 0;
			for (int j = 0; j < i; j++)
			{
				renderI(0,"So sánh array["+j+"]= "+array[j]+" và array["+(j+1)+"]= "+array[j+1]);
				colorPair(j, j+1, ColorManager.BAR_GREEN);
				pause();
				instructions[0].clear(g);
				bs.show();
				if (array[j] > array[j+1])
				{
					renderI(0,"Đổi chỗ array["+j+"]= "+array[j]+" và array["+(j+1)+"]= "+array[j+1]);
					colorPair(j, j+1, ColorManager.BAR_RED);
					swap(j, j+1);
					instructions[0].clear(g);
					bs.show();
					count++;
				}
			}
			bars[i].setColor(ColorManager.BAR_ORANGE); //bar in correct position
			bars[i].draw(g);
			bs.show();
			if (count == 0)  // the array is sorted
				break;
		}
		
		finishAnimation();
		bs.show();
		renderI(1,"Thuật toán kết thúc !!!");
		pause();
		instructions[1].clear(g);
		bs.show();
		g.dispose();
	}
	@Override
	public void renderInstructionSet() {
		int x = PADDING;
		int y = canvasHeight - 250 - PADDING;
		int instruction_width = 500;
		instructions = new Instruction[3];
		instructions[0] = new Instruction(x+200, y, instruction_width, 0);
		instructions[1] = new Instruction(x+250, y +5, instruction_width, 1);
		
	}
	public void renderNote() {
		g = bs.getDrawGraphics();
		int x = PADDING;
		int y = canvasHeight - 250 - PADDING;
		instructions1 = new Instruction[6];
		instructions1[0] = new Instruction(x, y+200, 34, 0);
		instructions1[1] = new Instruction(x, y+160, 34, 0);
		instructions1[2] = new Instruction(x, y+120, 34, 0);
		instructions1[0].setColor(ColorManager.BAR_GREEN);
		instructions1[1].setColor(ColorManager.BAR_RED);
		instructions1[2].setColor(ColorManager.BAR_ORANGE);
		instructions1[0].drawN(g);
		instructions1[1].drawN(g);
		instructions1[2].drawN(g);
		instructions1[3]= new Instruction(x+50, y+206, 34, 0);
		instructions1[4]= new Instruction(x+50, y+166, 34, 0);
		instructions1[5]= new Instruction(x+50, y+126, 34, 0);
		instructions1[3].setInstruction("   So sánh hai phần tử");
		instructions1[4].setInstruction("   Đổi chỗ hai phần tử");
		instructions1[5].setInstruction("   Phần tử đã được xắp xếp");
		instructions1[3].drawM(g);
		instructions1[4].drawM(g);
		instructions1[5].drawM(g);
		bs.show();
		g.dispose();
	}

}

