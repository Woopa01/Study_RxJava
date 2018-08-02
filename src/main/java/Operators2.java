import com.sun.java.swing.ui.CommonUI;
import com.sun.tools.javac.util.Log;
import io.reactivex.Observable;
import io.reactivex.annotations.SchedulerSupport;

import java.util.concurrent.TimeUnit;

public class Operators2 {
    public static void main(String[] args) {

        //interval 함수 활용
        Observable<Long> source1 = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(data -> (data+1) * 100)
                .take(5);
        source1.subscribe(System.out::println);
    }
}
