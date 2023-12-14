import java.util.*;

class test2 {
    public static void main(String[] args) {
        String str = "(())()";
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution4(str));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville)
            if (i < K) queue.offer(i);
        int size = queue.size();

        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (queue.isEmpty()) {
                answer = -1;
                break;
            }
            int b = queue.poll();

            answer++;
            int newK = a + (b * 2);
            if (newK < K) {
                queue.offer(newK);
                if (queue.size() == 1 && size < scoville.length) queue.offer(scoville[size]);
            }
        }
        return answer;
    }

    public static int solution2(int[] scoville, int K) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : scoville)
            list.add(i);

        while (!list.isEmpty()) {
            if (list.size() == 1 && list.get(0) < K) {
                answer = -1;
                break;
            } else if (list.get(0) >= K) break;

            int sum = list.get(0) + list.get(1) * 2;
            list.remove(0);
            list.remove(0);

            answer++;

            for (int i = 0; i < list.size(); i++) {
                if (sum < K && sum > list.get(i) && sum < list.get(i + 1)) list.add(i, sum);
            }
        }
        return answer;
    }

    static boolean solution3(String s) {
        // 프로그래머스 : 올바른 괄호 Lv2
        // Queue
        Queue<Character> queue = new LinkedList<>();

        if(s.charAt(0) == ')' || s.charAt(s.length()-1) == '(')
            return false;
        else {
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '(')
                    queue.offer(s.charAt(i));
                else {
                    if(queue.isEmpty()) return false;
                    queue.poll();
                }
                if(i == s.length()-1 && !queue.isEmpty()) return false;
            }
        }
        return true;

/*        // for문 -> string만 가지고 푼 것.
        int open = 0;
        int close = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                close++;
            }
            if (open < close) {
                return false;
            }
        }
        if (open == close) {
            return true;
        }
        return true;*/
    }
    static boolean solution4(String s) {
        int count_a = 0;
        int count_b = 0;
        Deque<Character> clause = new ArrayDeque<>();
        for(int a=0; a<s.length(); a++){
            clause.addLast(s.charAt(a));
        }
        if (clause.size() % 2 != 0)
            return false;

        if (clause.peekFirst() == ')' || clause.peekLast() == '(')
            return false;

        if(clause.peekFirst() == '(' && clause.peekLast() == ')'){
            for (int i = 0; i < clause.size(); i++) {
                if (clause.pollFirst() == '(') count_a++;
                else count_b++;
            }
            if (count_a == count_b) return true;
        }
        return true;
    }
}
