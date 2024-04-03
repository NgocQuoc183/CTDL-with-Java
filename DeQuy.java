package DoAn;

public class DeQuy {
	// 1. Tính dãy số fibonacci
	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	// Khử đệ quy Fibonacci
	public static int khuFibonacci(int n) {
	    if (n <= 1) {
	        return n;
	    }
	    int a = 0, b = 1;
	    int sum = 0;
	    for (int i = 2; i <= n; i++) {
	        sum = a + b;
	        a = b;
	        b = sum;
	    }
	    return sum;
	}

	// 2. Tính giai thừa
	public static int giaiThua(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * giaiThua(n - 1);
		}
	}
	
	// Khử đệ quy giai thừa 
	public static int khuGiaiThua(int n) {
	    int result = 1;
	    for (int i = 2; i <= n; i++) {
	        result *= i;
	    }
	    return result;
	}

	// 3.Tính tổng các số từ 1 đến n
	public static int tong(int n) {
		if (n <= 1) {
			return n;
		} else {
			return n + tong(n - 1);
		}
	}
	
	// Khử đệ quy tổng từ 1 -> n 
	public static int khuTong(int n) {
	    int sum = 0;
	    for (int i = 1; i <= n; i++) {
	        sum += i;
	    }
	    return sum;
	}
	
	// 4. Tính luỹ thừa
	public static int luyThua(int a, int n) {
		if (n == 0) {
			return 1;
		} else {
			return a * luyThua(a, n - 1);
		}
	}
	
	// Khử đệ quy tính luỹ thừa 
	public static int khuLuyThua(int a, int n) {
	    int result = 1;
	    for (int i = 1; i <= n; i++) {
	        result *= a;
	    }
	    return result;
	}

	// 5. Tính tổng luỹ thừa
	public static int tongLuyThua(int a, int n) {
		if (n == 1) {
			return a;
		} else {
			return luyThua(a, n) + tongLuyThua(a, n - 1);
		}
	}
	public static int khuTongLuyThua(int a, int n) {
	    int sum = 0;
	    for (int i = 1; i <= n; i++) {
	        sum += khuLuyThua(a, i);
	    }
	    return sum;
	}

	// 6. Chuyển nhị phân
	public static String chuyenNP(int n) {
		if (n == 0) {
			return "0";
		} else if (n == 1) {
			return "1";
		} else {
			return chuyenNP(n / 2) + n % 2;
		}
	}

	// 7. Sắp xếp quickSort
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			// Chọn phần tử chốt (pivot)
			int pivot = arr[low];

			// Chia mảng thành hai phần
			int i = low + 1;
			int j = high;
			while (i <= j) {
				// Tìm phần tử bên trái pivot lớn hơn pivot
				while (i <= j && arr[i] < pivot) {
					i++;
				}

				// Tìm phần tử bên phải pivot nhỏ hơn pivot
				while (i <= j && arr[j] >= pivot) {
					j--;
				}

				// Hoán đổi hai phần tử
				if (i <= j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i++;
					j--;
				}
			}

			// Sắp xếp phần tử bên trái pivot
			quickSort(arr, low, j);

			// Sắp xếp phần tử bên phải pivot
			quickSort(arr, i, high);
		}
	}

	//8.  bubleSort ( Sắp xếp nổi bọt )
	public class BubbleSort {

		public static void bubbleSort(int[] arr2, int n) {
			if (n == 1) {
				return;
			}

			for (int i = 0; i < n - 1; i++) {
				if (arr2[i] > arr2[i + 1]) {
					// Hoán đổi hai phần tử
					int temp = arr2[i];
					arr2[i] = arr2[i + 1];
					arr2[i + 1] = temp;
				}
			}

			bubbleSort(arr2, n - 1);
		}
	}
	
	// 9. Tháp hà nội 
	public static void towerOfHanoi(int n, char from, char aux, char to) {
	    if (n == 1) {
	        System.out.println("Di chuyển đĩa 1 từ " + from + " sang " + to);
	        return;
	    }

	    towerOfHanoi(n - 1, from, to, aux);
	    System.out.println("Di chuyển đĩa " + n + " từ " + from + " sang " + to);
	    towerOfHanoi(n - 1, aux, from, to);
	}
}