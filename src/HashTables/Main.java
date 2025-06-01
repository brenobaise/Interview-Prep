package HashTables;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1,2,3};
        int[] array2 = {2,4,5};
        ItemInCommonQuestion hm = new ItemInCommonQuestion(array1, array2);

        System.out.println(hm.itemInCommon());
    }


}
