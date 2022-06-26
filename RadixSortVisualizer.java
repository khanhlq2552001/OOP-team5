package t4;
import t1.Bar;
import t1.Instruction;
import t3.SortCanvas;
import t3.SortFrame;
import t4.SortVisualizer.ColorManager;

public class RadixSortVisualizer extends SortVisualizer{
	public RadixSortVisualizer(SortCanvas sortCanvas, SortFrame sortFrame, int[] array) {
		super(sortCanvas, sortFrame, array);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		pause();
		g = bs.getDrawGraphics();
		sort_radix(array.length);
		finishAnimation();
		renderI(6,"Thuật toán kết thúc!!!");
        bs.show();
        g.dispose();
	}
	int get_max_element(int n) {
		  int max = array[0];
		  renderI(0,"Duyệt tìm phần tử lớn nhất trong mảng");
		  pause();
		  instructions[0].clear(g);
		  for (int i = 1; i < n; i++) {
			  colorPair(i,ColorManager.BAR_ORANGE);
		    if (array[i] > max) {
		      max = array[i];
		      }}
		  renderI(0,"Phần tử lớn nhất trong mảng là "+max);
		  pause();
		  instructions[0].clear(g);
		  return max;
		}

	void sort_counting(int size, int place,String only) {
		
		pause();
		int []output = new int[size+1];

		  int max = array[0];

		  for (int i = 1; i < size; i++) {
		    if (array[i] > max) {
		      max = array[i];
		      }
		  }
		  renderI(4,"Khởi tạo mảng output[] chứa mảng đã sắp xếp theo chữ số "+only);
		  renderI(3,"Khởi tạo mảng count[] với chỉ số i trong count[i] là chữ số hàng "+only);
		  int []count = new int[max+1];
		  pause();
		  instructions[3].clear(g);
		  instructions[4].clear(g);
		  bs.show();
		  for (int i = 0; i < max; ++i) {
		    count[i] = 0;}
		  
		  for (int i = 0; i < size; i++) {
			count[(array[i] / place) % 10]++;
			renderI(2,"Chữ số hàng "+only+" của array["+i+"]= "+((array[i] / place) % 10) +" ,Count["+((array[i] / place) % 10)+"]= "+count[(array[i] / place) % 10]);
			colorPair(i,ColorManager.BAR_ORANGE);
			instructions[2].clear(g);
			bs.show();
		  }
		  for (int i = 1; i < max+1; i++) {
		    count[i] += count[i - 1];}
		  renderI(3,"Count[i] chứa số lượng phần tử có chữ số hàng "+only+" nhỏ hơn hoặc bằng i");
		  pause();
		  instructions[3].clear(g);
		  bs.show();
		  for (int i = size - 1; i >= 0; i--) {
		    output[count[(array[i] / place) % 10] - 1] = array[i];
		    renderI(5,"count["+((array[i] / place) % 10)+"] ="+count[(array[i] / place) % 10]);
		    renderI(1,"output[count["+((array[i] / place) % 10)+"] -1] = array["+i+"]= "+array[i]);
		    count[(array[i] / place) % 10]--;
		    renderI(2,"count["+((array[i] / place) % 10)+"] giảm đi 1 ="+count[(array[i] / place) % 10]);
			colorPair(i,ColorManager.BAR_ORANGE);
			instructions[1].clear(g);
			instructions[2].clear(g);
			instructions[5].clear(g);
			bs.show();
		  }

		  for (int i = 0; i < size; i++) {
			renderI(0,"array["+i+"]= output["+i+"]= "+output[i]);
		    array[i] = output[i];
		    setBars(bars[i],array[i]);
		    colorPair(i,ColorManager.BAR_GREEN);
		    instructions[0].clear(g);
		    bs.show();
		    }
		  bs.show();
		}

	void sort_radix(int size) {
		  int max = get_max_element(size);
		  for (int place = 1; max / place > 0; place *= 10) {
			if(place==1) {
				renderI(0,"Sắp xếp mảng theo chữ số hàng đơn vị");
				pause();
				instructions[0].clear(g);
				sort_counting(size, place,"đơn vị");
			}
			else if(place==10) {
				renderI(0,"Sắp xếp mảng theo chữ số hàng chục");
				pause();
				instructions[0].clear(g);
				sort_counting(size, place,"chục");
			}
			else if(place==100) {
				renderI(0,"Sắp xếp mảng theo chữ số hàng trăm");
				pause();
				instructions[0].clear(g);
				sort_counting(size, place,"trăm");
			}
			else if(place==1000) {
				renderI(0,"Sắp xếp mảng theo chữ số hàng nghìn");
				pause();
				instructions[0].clear(g);
				sort_counting(size, place,"nghìn");
			}
		    }
		}
	@Override
	public void renderInstructionSet() {
		int x = PADDING;
		int y = canvasHeight - 250 - PADDING;
		int instruction_width = 600;
		instructions = new Instruction[7];
		instructions[0] = new Instruction(x+200, y, instruction_width, 0);
		instructions[1] = new Instruction(x+170, y , instruction_width, 1);
		instructions[2] = new Instruction(x+170, y + 34, instruction_width, 2);
		instructions[3] = new Instruction(x+50, y , instruction_width, 3);
		instructions[4] = new Instruction(x+50, y+34 , instruction_width, 4);
		instructions[5] = new Instruction(x+170, y - 34, instruction_width, 5);
		instructions[6] = new Instruction(x+250, y , instruction_width, 6);
	}
	public void renderNote() {
		g = bs.getDrawGraphics();
		int x = PADDING;
		int y = canvasHeight - 250 - PADDING;
		instructions1 = new Instruction[6];
		instructions1[0] = new Instruction(x, y+200, 34, 0);
		instructions1[2] = new Instruction(x, y+160, 34, 0);
		instructions1[0].setColor(ColorManager.BAR_GREEN);
		instructions1[2].setColor(ColorManager.BAR_ORANGE);
		instructions1[0].drawN(g);
		instructions1[2].drawN(g);
		instructions1[3]= new Instruction(x+50, y+206, 34, 0);
		instructions1[5]= new Instruction(x+50, y+166, 34, 0);
		instructions1[3].setInstruction("   Phần tử được xắp xếp lại");
		instructions1[5].setInstruction("   Phần tử đang xét duyệt");
		instructions1[3].drawM(g);
		instructions1[5].drawM(g);
		bs.show();
		g.dispose();
	}

}
