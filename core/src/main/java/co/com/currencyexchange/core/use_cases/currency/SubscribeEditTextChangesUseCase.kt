package co.com.currencyexchange.core.use_cases.currency

import android.widget.EditText
import co.com.currencyexchange.core.use_cases.base.ObservableUseCase
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent
import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * Created by oscarg798 on 2/21/18.
 */
class SubscribeEditTextChangesUseCase(mSubscribeonScheduler: Scheduler,
                                      mObserverOnScheduler: Scheduler) :
        ObservableUseCase<TextViewAfterTextChangeEvent, EditText>(mSubscribeonScheduler, mObserverOnScheduler) {

    override fun buildUseCase(params: EditText): Observable<TextViewAfterTextChangeEvent> {
        return RxTextView.afterTextChangeEvents(params)

    }
}