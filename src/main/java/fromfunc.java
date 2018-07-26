import io.reactivex.Observable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class fromfunc {
    public static void main(String[] args){
        Integer[] array = {1,2,3,4,5};

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        Callable<String> callable = () -> {
          int result = 1+1;
          return "Hello Callable";
        };

        Future<String> future = Executors.newSingleThreadExecutor().submit(() ->{
                int result = 1+1;
                return "Hello future";
                });

        Publisher<String> publisher = (Subscriber<? super String> s) -> {
            s.onNext("Hello Observable,fromPublisher()");
            s.onComplete();
        };

        Observable<Integer> source = Observable.fromArray(array);
        source.subscribe(System.out::println);

        Observable<String> source2 = Observable.fromIterable(arrayList);
        source2.subscribe(System.out::println);

        Observable<String> source3 = Observable.fromCallable(callable);
        source3.subscribe(System.out::println);

        Observable<String> source4 = Observable.fromFuture(future);
        source4.subscribe(System.out::println);

        Observable<String> source5 = Observable.fromPublisher(publisher);
        source5.subscribe(System.out::println);


    }
}
