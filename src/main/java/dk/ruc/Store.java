package dk.ruc;

import io.reactivex.rxjava3.subjects.PublishSubject;

public final class Store {
    private static PublishSubject<Object> instance;

    private Store() {}

    public static PublishSubject<Object> getInstance() {
        if (instance == null) {
            instance = PublishSubject.create();
        }

        return instance;
    }
}
