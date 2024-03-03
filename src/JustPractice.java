import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.builder;

class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i = 3; i < brown + yellow; i++){
            int width = (brown + yellow) / i;
            if(width>=i) {
                if ((i - 2) * (width - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = i;
                    break;
                }
            }
        }
        return answer;
    }
}

class stackEX{
    public void stack(){
        Stack<Integer> stackInt = new Stack<>();
        Stack<String> stackString = new Stack<>();
        Stack<Boolean> stackBoolean = new Stack<>();

        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);

        stackInt.pop();
        stackInt.pop();
        stackInt.pop();
        // 3 -> 2 -> 1 순으로 값 제거

        /**
         마지막 요소를 반환
        */
        System.out.println(stackInt.peek());

        // 비었는지 확인
        System.out.println(stackInt.isEmpty());

        // 인자로 검색
        System.out.println(stackInt.search(2));

        // 다 삭제
        stackInt.clear();
    }
}

public class JustPractice {
    public static void main(String[] args){
        /*
        * List처럼 저장공간을 추가로 늘리는데 List처럼 저장공간을 한 칸씩 늘리지 않고 약 두배로 늘립니다.
        * 여기서 과부하가 많이 발생합니다.
        * 그렇기에 초기에 저장할 데이터 개수를 알고 있다면 Map의 초기 용량을 지정해주는 것이 좋습니다
        */
        Map<Integer,String> a = new HashMap<>();
        a.put(1,"rlarhkdwp");
        a.put(1,"sss"); // 교체되는거네
        a.put(2,"ad");
        a.put(3,"www");

        for(Integer i = 1; i < a.size() + 1; i++){
            System.out.println(a.get(i));
        }

        a.remove(1); //key값 1 제거
        a.clear(); //모든 값 제거

        HashMap<Integer,String> map = new HashMap<Integer,String>(3){{//초기값 지정
            put(1,"사과");
            put(2,"바나나");
            put(3,"포도");
        }}; // 초기값 지정 방법 및 크기 제한

        System.out.println(map); // 반복문 없이 전체 출력도 가능
    }
}

class PracticeStream{
    List<String> list = Arrays.asList("a", "b", "c");
    Stream<String> stream = list.stream();
    Stream<String> filteredStream = stream.filter(s -> s.startsWith("a"));


    String[] array = new String[]{"a", "b", "c"};
    Stream<String> stream1 = Arrays.stream(array);
}







