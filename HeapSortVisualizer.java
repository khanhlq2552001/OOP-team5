package t4;
import t1.Instruction;
import t3.SortCanvas;
import t3.SortFrame;
import t4.SortVisualizer.ColorManager;
public class HeapSortVisualizer extends SortVisualizer{

	public HeapSortVisualizer(SortCanvas sortCanvas, SortFrame sortFrame, int[] array) {
		super(sortCanvas, sortFrame, array);
	}
	@Override
	public void sort() {
		pause();
        g = bs.getDrawGraphics();
        tsort(array.length);
        finishAnimation();
        renderI(3,"Thuật toán kết thúc!!!");
        bs.show();
        g.dispose();
	}
	void tsort(int n) {
        // Xây dựng Heap (sắp xếp lại mảng)
		renderI(0,"Bước 1: Sắp xếp mảng thành dạng đống");
		pause();
		instructions[0].clear(g);
		bs.show();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify( n, i);}
        renderI(1,"Bước 2: Đưa nút gốc hiện tại đến vị trí cuối, ");
        renderI(2,"thực hiện lại bước 1 với mảng bỏ đi phần tử cuối.");
		pause();
		instructions[1].clear(g);
		instructions[2].clear(g);
		bs.show();
        // Trích xuất từng phần tử từ Heap
        for (int i = n - 1; i > 0; i--) {
            // Di chuyển root hiện tại đến end
        	renderI(0,"Đưa nút gốc của cây xuống vị trí cuối");
        	swap(0,i);
        	pause();
        	instructions[0].clear(g);
    		bs.show();
            // gọi max - heapify trên Heap đã sắp xếp
            heapify(i, 0);
        }
    }
	/* ------------------- */
	void heapify(int n, int i) {
        int largest = i; // Khởi tạo largest như root
        int l = 2 * i; // left = 2*i
        int r = 2 * i + 1; // right = 2*i + 1
        if(l<n) {
        	renderI(1,"So sánh nút gốc array["+i+"] ="+array[i]+" và con trái array["+l+"]= "+array[l]);
        	colorPair(l,i,ColorManager.BAR_GREEN);
        	instructions[1].clear(g);
        	bs.show();
        }
        // Nếu nút con bên trái lớn hơn nút con của gốc
        if (l < n && array[l] > array[largest])
            largest = l;
        // Nếu nút con bên phải lớn hơn largest
        if(r<n) {
        	renderI(1,"So sánh nút gốc array["+i+"] ="+array[i]+" và con phải array["+r+"]= "+array[r]);
        	colorPair(r,i,ColorManager.BAR_GREEN);
        	instructions[1].clear(g);
        	bs.show();
        }
        if (r < n && array[r] > array[largest])
            largest = r;
        // Nếu largest không phải là root
        if (largest != i) {
        	if(largest==l) {
        		renderI(1,"Đổi chỗ nút gốc array["+i+"] ="+array[i]+" và con trái array["+l+"]= "+array[l]);
        		colorPair(i,largest,ColorManager.BAR_RED);
        		instructions[1].clear(g);
            	bs.show();
        	}
        	if(largest==r) {
        		renderI(1,"Đổi chỗ nút gốc array["+i+"] ="+array[i]+" và con phải array["+r+"]= "+array[r]);
        		colorPair(i,largest,ColorManager.BAR_RED);
        		instructions[1].clear(g);
            	bs.show();
        	}
        	swap(i,largest);
        	pause();
            // Vun đống lại các cây con bị ảnh hưởng
            heapify( n,largest);
        }
    }
	@Override
	public void renderInstructionSet() {
		// TODO Auto-generated method stub
		int x = PADDING;
		int y = canvasHeight - 250 - PADDING;
		int instruction_width = 600;
		instructions = new Instruction[4];
		instructions[0] = new Instruction(x+200, y, instruction_width, 0);
		instructions[1] = new Instruction(x+170, y , instruction_width, 1);
		instructions[2] = new Instruction(x+170, y + 34, instruction_width, 2);
		instructions[3] = new Instruction(x+250, y +5, instruction_width, 3);
	}
	public void renderNote() {
		g = bs.getDrawGraphics();
		int x = PADDING;
		int y = canvasHeight - 250 - PADDING;
		instructions1 = new Instruction[6];
		instructions1[0] = new Instruction(x, y+200, 34, 0);
		instructions1[1] = new Instruction(x, y+160, 34, 0);
		instructions1[0].setColor(ColorManager.BAR_GREEN);
		instructions1[1].setColor(ColorManager.BAR_RED);
		instructions1[0].drawN(g);
		instructions1[1].drawN(g);
		instructions1[3]= new Instruction(x+50, y+206, 34, 0);
		instructions1[4]= new Instruction(x+50, y+166, 34, 0);
		instructions1[5]= new Instruction(x+50, y+126, 34, 0);
		instructions1[3].setInstruction("   So sánh hai phần tử");
		instructions1[4].setInstruction("   Đổi chỗ hai phần tử");
		instructions1[3].drawM(g);
		instructions1[4].drawM(g);
		bs.show();
		g.dispose();
	}
	}

