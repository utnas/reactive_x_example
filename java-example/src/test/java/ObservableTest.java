import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static java.util.Collections.singletonList;

public class ObservableTest {

    @Test
    public void emptyObservable() {
        //Given
        final Observable<String> empty = Observable.empty();
        final TestSubscriber<String> testSubscriber = new TestSubscriber<>();

        //When
        empty.subscribe(testSubscriber);

        //Then
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(EMPTY_LIST);
        testSubscriber.assertCompleted();
    }

    @Test
    public void justObservableWithValue() {
        // Given
        final Observable<String> stringValue = Observable.just("String value");
        final TestSubscriber<String> testSubscriber = new TestSubscriber<>();

        //When
        stringValue.subscribe(testSubscriber);

        //Then
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(singletonList("String value"));
        testSubscriber.assertCompleted();
    }

    @Test
    public void fromObservable() {
        //Given
        final Observable<String> values = Observable.from(asList("one", "two", "three"));
        final TestSubscriber<String> testSubscriber = new TestSubscriber<>();

        //When
        values.subscribe(testSubscriber);

        //Then
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(asList("one", "two", "three"));
        testSubscriber.assertCompleted();
    }

}
