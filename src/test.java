import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = {10,10,20,30,50,5,7};


        System.out.println(Arrays.toString(solution(arr)));
    }
    public static int[] solution(int[] numbers) {
        int[] answer = {};

        int[] temp = new int[numbers.length * numbers.length];
        int index = 0;
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                temp[index] = numbers[i] + numbers[j];
                index++;
            }
        }

        int[] new_temp = Arrays.copyOfRange(temp, 0, index);

        Arrays.sort(temp);
        index = 0;
        for(int i=0; i<temp.length;i++){
            if(i == temp.length-1){
                new_temp[index] = temp[temp.length-1];
                index++;
            }
            else if(temp[i] != temp[i+1]) {
                new_temp[index] = temp[i];
                index++;
            }
        }

        answer = Arrays.copyOfRange(new_temp,0,index);
        return answer;
    }
}
