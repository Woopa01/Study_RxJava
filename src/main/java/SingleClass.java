
import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleClass {
    public static void main(String[] args) {

       //기존 Observable 에서 Single 객체로 변환
        Observable<String> source = Observable.just("Hello Single");
        Single.fromObservable(source)
                .subscribe(System.out::println);

        // single() 함수를 호출해 Single 객체 생성하기
        Observable.just("Hello Single")
                .single("default item")
                .subscribe(System.out::println);

        // first() 함수를 호출해 Single 객체 생성하기
        String[] colors = {"Red","Blue","Green"};
        Observable.fromArray(colors)
                .first("default item")
                .subscribe(System.out::println);

        // empty Observable에서 Single 객체 생성하기
        Observable.empty()
                .single("default value")
                .subscribe(System.out::println);

        // take() 함수에서 Single 객체 생성하기
        Observable.just(new String("ORD-1"), new String("ORD-2"))
                .take(1)
                .single(new String("default string"))
                .subscribe(System.out::println);
    }
}
