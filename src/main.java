public class main {


    public static void main(String[] args){
        System.out.println("this is main class");
        int[][] arr = new int[3][4];
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[0][2] = 0;
        arr[0][3] = 1;
        arr[1][0] = 0;
        arr[1][1] = 1;
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[2][0] = 1;
        arr[2][1] = 0;
        arr[2][2] = 0;
        arr[2][3] = 1;

        System.out.println(count(arr,3,4));
    }




    public static int count(int[][] a, int m, int n) {

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (a[i][j] == 1) {
                    if (i - 1 >= 0 && j - 1 >= 0 && a[i - 1][j - 1] == 1) {
                        count = count + 1;

                    }
                    if (i - 1 >= 0 && a[i - 1][j] == 1) {
                        count = count + 1;
                    }
                    if (i - 1 >= 0 && j + 1 < n && a[i - 1][j + 1] == 1) {
                        count = count + 1;
                    }
                    if (j + 1 < n && a[i][j + 1] == 1) {
                        count = count + 1;
                    }
                }
            }
        }


        return count;
    }
}
