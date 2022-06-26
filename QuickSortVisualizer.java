package t4;

import t1.Instruction;
import t3.SortCanvas;
import t3.SortFrame;
import t4.SortVisualizer.ColorManager;

public class QuickSortVisualizer extends SortVisualizer{

	public QuickSortVisualizer(SortCanvas sortCanvas, SortFrame sortFrame, int[] array) {
		super(sortCanvas, sortFrame, array);
	}
	
	
	/* QUICK SORT */
	public void sort()
	{
		pause();
		g = bs.getDrawGraphics();
		quicksort(0, array.length - 1);
		finishAnimation();
		renderI(3,"Thuật toán kết thúc!!!");
		bs.show();
		g.dispose();
	}
	// recursive quick sort
	int partition(int low, int high) {
		renderI(1,"Trong mảng từ array["+low+"]= "+array[low]+" đến array["+high+"]= "+array[high]+" chọn array["+high+"] làm chốt");
		renderI(0,"Đặt chỉ số của phần tử nhỏ hơn ban đầu là i= "+(low-1));
        int pivot = array[high];
        colorPair(low,high,ColorManager.BAR_RED);
        instructions[1].clear(g);
        instructions[0].clear(g);
        bs.show();
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
        	renderI(2,"So sánh  array["+j+"] ="+array[j]+" và chốt = "+array[high]);
        	colorPair(j,high,ColorManager.BAR_ORANGE);
        	instructions[2].clear(g);
        	bs.show();
            // Nếu phần tử hiện tại nhỏ hơn chốt
            if (array[j] < pivot) {
                i++;
                swap(i,j);
                renderI(2,"Đổi chỗ  array["+j+"] ="+array[j]+" và array["+i+"]= "+array[i]+" , i="+i);
                colorPair(j,i,ColorManager.BAR_GREEN);
                instructions[2].clear(g);
                // swap arr[i] và arr[j]
            }

        }

        // swap arr[i+1] và arr[high] (hoặc pivot)
        swap(i+1,high);
        return i + 1;
    }
    // arr[] --> Mảng cần được sắp xếp,
    // low --> chỉ mục bắt đầu,
    // high --> chỉ mục kết thúc
    void quicksort(int low, int high) {
        if (low < high) {
            // pi là chỉ mục của chốt, arr[pi] vị trí của chốt
            int pi = partition(low, high);
            // Sắp xếp đệ quy các phần tử
            // trướcphân vùng và sau phân vùng
            quicksort(low, pi - 1);
            quicksort(pi + 1, high);
        }
    }
	@Override
		public void renderInstructionSet() {
			int x = PADDING;
			int y = canvasHeight - 250 - PADDING;
			int instruction_width = 700;
			instructions = new Instruction[4];
			instructions[0] = new Instruction(x+180, y+30, instruction_width, 0);
			instructions[1] = new Instruction(x+50, y , instruction_width, 1);
			instructions[2] = new Instruction(x+170, y , instruction_width, 2);
			instructions[3] = new Instruction(x+250, y , instruction_width, 3);
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
		instructions1[3].setInstruction("   Đổi chỗ hai phần tử");
		instructions1[4].setInstruction("   Hai phần tử đầu ,cuối của mảng đã chọn");
		instructions1[5].setInstruction("   So sánh hai phần tử");
		instructions1[3].drawM(g);
		instructions1[4].drawM(g);
		instructions1[5].drawM(g);
		bs.show();
		g.dispose();
	}
}