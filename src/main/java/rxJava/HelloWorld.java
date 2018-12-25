package rxJava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

import java.util.concurrent.TimeUnit;

public class HelloWorld {
    public static void main(String[] args) {

        //Hello world
        Observable.create(subscriber -> {
            subscriber.onNext("Hello World");
            subscriber.onComplete();
        }).subscribe(System.out::println);

        //shorten by using helper method
        Observable.just("Hello","world")
                .subscribe(System.out::println);

        //add onError and onComplete listeners
        Observable.just("Hello World!")
                .subscribe(System.out::println, Throwable::printStackTrace, ()-> System.out.println("Done"));

        Disposable disposable = Observable.just("Hello World")
                .delay(1, TimeUnit.SECONDS)
                .subscribeWith(new DisposableObserver<String>() {

                    @Override
                    protected void onStart() {
                        System.out.println("Start!");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                });

        disposable.dispose();
    }

}
