import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Operators {
    public static void main(String[] args) {

        //map 함수
        String[] balls = {"1","2","3","5"};
        Observable<String> source1 = Observable.fromArray(balls)
                .map(ball -> ball + "A");
        source1.subscribe(System.out::println);

        //Function 인터페이스 적용한 map 함수
        Function<String,String> getA = ball1 -> ball1 + "A";
        Observable<String> source2 = Observable.fromArray(balls)
                .map(getA);
        source2.subscribe(System.out::println);

        //데이터 타입 추론
        Function<String,Integer> ballToindex = ball2 -> {
            switch (ball2){
                case "RED" : return 1;
                case "YELLOW" : return 2;
                case "GREEN" : return 3;
                case "BLUE" : return 4;
                default: return -1;
            }
        };

        String[] balls2 = {"RED","YELLOW","GREEN","BLUE"};
        Observable<Integer> source3 = Observable.fromArray(balls2)
                .map(ballToindex);
        source3.subscribe(System.out::println);
    }
}
