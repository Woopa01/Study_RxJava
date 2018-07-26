import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class HelloWorld {
    public static void main(String[] args){
        Observable.just("Hello","World!").subscribe(System.out::print);

        Observable<String> source = Observable.create(
                (ObservableEmitter<String> emitter) -> {
                    emitter.onNext("Hello");
                    emitter.onNext(" ");
                    emitter.onNext("World!");
                    emitter.onComplete();
                }
        );

        source.subscribe(System.out::println);

        source.subscribe(System.out::print);
    }
}
