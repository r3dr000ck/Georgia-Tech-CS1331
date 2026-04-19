public class Main {
    public static void main(String[] args) {
        String[] arr = {"z", "y", "a", "d", "e", "c"};

        pr(bubble(arr));
        pr(select(arr));
        pr(insert(arr));
        pr(merge(arr, 0, arr.length - 1));
    }

    public static void pr(String[] a) {
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static String[] bubble(String[] a) {
        String[] arr = a;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j].compareTo(arr[j + 1]) > 0) {
                    String tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return a;
    }

    public static String[] select(String[] a){
        String[] arr = a;
        
        for(int i = 0; i < arr.length; i++) {
            int curMin = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j].compareTo(arr[curMin]) < 0) {
                    curMin = j;
                }
            }
            String tmp = arr[curMin];
            arr[i] = arr[curMin];
            arr[curMin] = tmp;
        }

        return arr;
    }

    public static String[] insert(String[] a){
        String[] arr = a;

        for(int i = 1; i < arr.length; i++) {
            int j = i;
            String tmp = arr[j];
            while (j > 0 && arr[i].compareTo(tmp) > 0) {
                arr[j + 1] = arr[j];
            }
            arr[j] = tmp;
        }

        return arr;
    }

    public static String[] merge(String[] a, int low, int high) {
        if (low >= high) {
            return a;
        } 

        int mid = (low + high) / 2;

        merge(a, low, mid);

        merge(a, mid + 1, high);

        m(a, low, mid, high);

        return a;
    }

    public static void m(String[] a, int low, int mid, int high) {
        String[] arr = new String[high - low + 1];
        int left = low;
        int right = mid + 1;
        int i = 0;

        while(left <= mid && right <= high) {
            if(a[left].compareTo(a[right]) <= 0) {
                arr[i] = a[left];
                left++;
            } else {
                arr[i] = a[right];
                right++;
            }
            i++;
        }

        while(left <= mid) {
            arr[i] = a[left];
            left++;
            i++;
        }

        while(right <= high) {
            arr[i] = a[right];
            right++;
            i++;
        }

        for(int j = 0; j < arr.length; j++) {
            a[low + j] = arr[j];
        }
    }
}