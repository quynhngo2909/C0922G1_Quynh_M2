package ss2_Loop_Array.loop_array_excersize;

public class CombineArray {
    public static void main(String[] args) {
        int[] numbers1 = new int[6];
        int[] numbers2 = new int[9];
        int size1 = numbers1.length;
        int size2 = numbers2.length;
        int size3 = size1 + size2;
        int[] numbers3 = new int[size3];
        for (int i = 0; i < size1; i++) {
            numbers1[i] = (int) (Math.random()*100);
        }
        System.out.println("Mảng 1:");
        for (int i:numbers1) {
            System.out.print(i + " , ");
        }
        for (int i = 0; i < size2; i++) {
            numbers2[i] = (int) (Math.random()*100);
        }
        System.out.println();
        System.out.println("Mảng 2:");
        for (int i:numbers2) {
            System.out.print(i + " , ");
        }
        System.out.println();
        for (int i = 0; i < size1; i++) {
            numbers3[i] = numbers1[i];
        }
        for (int i = 0; i < size2; i++) {
            numbers3[size1 + i] = numbers2[i];
        }
        System.out.println("Mảng gộp:");
        for (int i:numbers3) {
            System.out.print(i + " , ");
        }
    }
}


