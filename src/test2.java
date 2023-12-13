import java.util.*;

class test2 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution2(scoville, k));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville)
            if(i < K) queue.offer(i);
        int size = queue.size();

        while(!queue.isEmpty()){
            int a = queue.poll();
            if(queue.isEmpty()) {
                answer = -1;
                break;
            }
            int b = queue.poll();

            answer++;
            int newK = a+(b*2);
            if(newK < K) {
                queue.offer(newK);
                if(queue.size() == 1 && size < scoville.length) queue.offer(scoville[size]);
            }
        }
        return answer;
    }

    public static int solution2(int[] scoville, int K) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i : scoville)
            list.add(i);

        while(!list.isEmpty()){
            if(list.size() == 1 && list.get(0) < K){
                answer = -1;
                break;
            }
            else if(list.get(0) >= K) break;

            int sum = list.get(0) + list.get(1)*2;
            list.remove(0);
            list.remove(0);

            answer++;

            for(int i=0; i<list.size(); i++){
                if(sum < K && sum > list.get(i) && sum < list.get(i+1)) list.add(i,sum);
            }
        }
        return answer;
    }
}