import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C12_7RecurCombiPermu {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        // 조합 찾기
/*        List<List<Integer>> combinations = new ArrayList<>();
        for(int i=0; i<list.size();i++)
        {
            for(int j=i+1; j<list.size(); j++){
                List<Integer> list1 = new ArrayList<>();
                list1.add(list.get(i));
                list1.add(list.get(j));
                combinations.add(list1);
            }
        }
        System.out.println(Arrays.toString(combinations.toArray()));*/

        List<List<Integer>> combination_list = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
/*        for(int i=0; i<list.size(); i++){
            temp.add(list.get(i));
            for(int j=i+1; j<list.size(); j++){
                temp.add(list.get(j));
                combination_list.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            temp.remove(temp.size()-1);
        }*/
        C12_7RecurCombiPermu c12 = new C12_7RecurCombiPermu();
        c12.combination(combination_list, temp, list, 3, 0);
        System.out.println(combination_list);
    }

    void combination(List<List<Integer>> combination_list, List<Integer> temp,List<Integer> list, int n, int a){
        if(temp.size() == n){
            combination_list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=a; i<list.size(); i++){
            temp.add(list.get(i));
            combination(combination_list, temp, list, n, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
