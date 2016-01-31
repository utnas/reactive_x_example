import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static java.util.Collections.singletonList;

public class ObservableTest {

    @Test
    public void emptyObservableTest() {
        //Given
        final Observable<String> emptyObservable = Observable.empty();
        final TestSubscriber<String> testSubscriber = new TestSubscriber<>();

        //When
        emptyObservable.subscribe(testSubscriber);

        //Then
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(EMPTY_LIST);
        testSubscriber.assertCompleted();
    }

    @Test
    public void justObservableWithValueTestT() {
        // Given
        final Observable<String> observable = Observable.just("value");
        final TestSubscriber<String> testSubscriber = new TestSubscriber<>();

        //When
        observable.subscribe(testSubscriber);

        //Then
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(singletonList("value"));
        testSubscriber.assertCompleted();
    }

    @Test
    public void fromObservableTest() {
        //Given
        final Observable<String> observable = Observable.from(asList("one", "two", "three"));
        final TestSubscriber<String> testSubscriber = new TestSubscriber<>();

        //When
        observable.subscribe(testSubscriber);

        //Then
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(asList("one", "two", "three"));
        testSubscriber.assertCompleted();
    }

}
