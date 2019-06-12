package rxJava;

import io.reactivex.Observable;

public class HelloRxJava {
    public static void main(String[] args) {

        //Hello world
        Observable.create(subscriber -> {
            subscriber.onNext("Hello World");
            subscriber.onComplete();
        }).subscribe(System.out::println);

        //shorten by using helper method
        Observable.just("Hello", "world")
                .subscribe(System.out::println);

        //add onError and onComplete listeners
        Observable.just("Hello World!")
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done"));

    }

}
