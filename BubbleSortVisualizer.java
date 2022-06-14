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
				pause();
				bars[j].setColor(originalColor);
				colorPair(j, j+1, ColorManager.BAR_GREEN);
				
				if (array[j] > array[j+1])
				{
					swap(j, j+1);
					colorPair(j, j+1, ColorManager.BAR_GREEN);
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
		g.dispose();
	}
	@Override
	public void renderInstructionSet() {
		
	}

}

