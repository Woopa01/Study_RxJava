import com.oracle.tools.packager.Log;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Operators2 {
    public static void main(String[] args) {

        //interval 함수 활용
        Observable<Long> source1 = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(data -> (data + 1) * 100)
                .take(5);
        source1.subscribe(System.out::println);

        //range 함수
        Observable<Integer> source2 = Observable.range(1, 10)
                .filter(number -> number % 2 == 0);
        source2.subscribe(System.out::println);

        //repeat 함수
        String[] balls = {"1","3","5"};
        Observable<String> source3 = Observable.fromArray(balls)
                .repeat(3);

        source3.doOnComplete(() -> Log.debug("On Complete"))
                .subscribe(Log::info);
    }
}