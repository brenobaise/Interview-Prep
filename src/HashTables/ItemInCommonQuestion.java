package HashTables;

import java.util.HashMap;

public class ItemInCommonQuestion {
    int[] array1;
    int[] array2;

    public ItemInCommonQuestion(int[] array1, int[] array2) {
        this.array1 = array1;
        this.array2 = array2;
    }

    public boolean itemInCommon(){
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i : array1){
            hm.put(i, true);

        }
        for(int j : array2){
            if(hm.get(j) != null) return true;
        }
        return false;
    }
}
