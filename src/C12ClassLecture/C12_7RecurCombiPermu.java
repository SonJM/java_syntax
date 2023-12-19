package C12ClassLecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C12_7RecurCombiPermu {
    static boolean[] visited;
    static int count =0;
    static int answer = 0;
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
        visited = new boolean[list.size()];
        permutation(combination_list, list, 0,0);
        System.out.println(answer);
//        System.out.println(combination_list);
//
//        System.out.println(max_count(combination_list));
    }

    static void combination(List<List<Integer>> combination_list, List<Integer> temp,List<Integer> list, int n, int a){
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
    static void permutation(List<List<Integer>> combination_list, List<Integer> temp,List<Integer> list, int n){
        if(temp.size() == n){
            int sum = 0;
            for (Integer integer : temp) sum += integer;
            if(sum >= 6) combination_list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<list.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(list.get(i));
                permutation(combination_list, temp, list, n);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }

    static void permutation(List<List<Integer>> combination_list, List<Integer> temp,List<Integer> list){
        int sum = 0;
        for (Integer integer : temp) {
            sum += integer;
        }
        if(sum >= 6) combination_list.add(new ArrayList<>(temp));
        for(int i=0; i<list.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(list.get(i));
                permutation(combination_list, temp, list);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }
    }

    static void permutation(List<List<Integer>> combination_list, List<Integer> list, int temp, int count){
        if(count == 3){
            if(temp > answer){
                answer = temp;
                return;
            }
        }

        for(int i=0; i<list.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(combination_list, list, temp + list.get(i), count+1);
                visited[i] = false;
            }
        }
    }

    private static int max_count(List<List<Integer>> combination_list) {
        int sum, max = 0;
        for (List<Integer> integers : combination_list) {
            sum = 0;
            for (Integer integer : integers)
                sum += integer;
            max = Math.max(max, sum);
        }
        return max;
    }
}
