package t4;
import t3.SortCanvas;
import t3.SortFrame;
public class HeapSortVisualizer extends SortVisualizer{

	public HeapSortVisualizer(SortCanvas sortCanvas, SortFrame sortFrame, int[] array) {
		// TODO Auto-generated constructor stub
		super(sortCanvas, sortFrame, array);
	}

	@Override
	public void sort() {
		pause();
        g = bs.getDrawGraphics();
		// TODO Auto-generated method stub
        tsort(array);
        g.dispose();
	}
	public void tsort(int arr[]) {
        int n = arr.length;

        // Xây dựng Heap (sắp xếp lại mảng)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Trích xuất từng phần tử từ Heap
        for (int i = n - 1; i > 0; i--) {
            // Di chuyển root hiện tại đến end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // gọi max - heapify trên Heap đã sắp xếp
            heapify(arr, i, 0);
        }
    }
	/* ------------------- */
	void heapify(int arr[], int n, int i) {
        int largest = i; // Khởi tạo largest như root
        int l = 2 * i; // left = 2*i
        int r = 2 * i + 1; // right = 2*i + 1

        // Nếu nút con bên trái lớn hơn nút con của gốc
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Nếu nút con bên phải lớn hơn largest
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Nếu largest không phải là root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Vun đống lại các cây con bị ảnh hưởng
            heapify(arr, n, largest);
        }
    }

	@Override
	public void renderInstructionSet() {
		// TODO Auto-generated method stub
		
	}

}
