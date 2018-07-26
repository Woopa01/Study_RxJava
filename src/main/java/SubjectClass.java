import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class SubjectClass {
    public static void main(String[] args) {
        
        //AsyncSubject : 발행한 마지막 데이터만 얻어옴
        AsyncSubject<String> subject1 = AsyncSubject.create();
        subject1.subscribe(data -> System.out.println("Subscriber #1 -> " + data));
        subject1.onNext("1");
        subject1.onNext("3");
        subject1.subscribe(data -> System.out.println("Subsriber #2 -> " + data) );
        subject1.onNext("5");
        subject1.onComplete();
        System.out.println("");

        //BehaviorSubject : 구독시 가장 최근값 혹은 기본값
        BehaviorSubject<String> subject2 = BehaviorSubject.createDefault("6");
        subject2.subscribe(data -> System.out.println("Subscriber #1 -> " + data));
        subject2.onNext("1");
        subject2.onNext("3");
        subject2.subscribe(data -> System.out.println("Subsriber #2 -> " + data) );
        subject2.onNext("5");
        subject2.onComplete();
        System.out.println("");

        //PublishSubject : 구독시 발행 시작 - 일반적
        PublishSubject<String> subject3 = PublishSubject.create();
        subject3.subscribe(data -> System.out.println("Subscriber #1 -> " + data));
        subject3.onNext("1");
        subject3.onNext("3");
        subject3.subscribe(data -> System.out.println("Subsriber #2 -> " + data) );
        subject3.onNext("5");
        subject3.onComplete();
        System.out.println("");

        //ReplaySubject : 구독시 처음부터 끝까지 발행
        ReplaySubject<String> subject4 = ReplaySubject.create();
        subject4.subscribe(data -> System.out.println("Subscriber #1 -> " + data));
        subject4.onNext("1");
        subject4.onNext("3");
        subject4.subscribe(data -> System.out.println("Subsriber #2 -> " + data) );
        subject4.onNext("5");
        subject4.onComplete();
        System.out.println("");


    }
}
