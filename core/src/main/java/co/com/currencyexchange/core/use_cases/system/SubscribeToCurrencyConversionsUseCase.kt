package co.com.currencyexchange.core.use_cases.system

import co.com.currencyexchange.core.use_cases.base.ObservableUseCase
import co.com.currencyexchange.data.local.models.ExchangeConversion
import co.com.currencyexchange.data.repository.IExchangeRatesRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by oscarg798 on 2/21/18.
 */
class SubscribeToCurrencyConversionsUseCase(mSubcribeOnScheduler: Scheduler,
                                            mObserverOnScheduler: Scheduler) :
        ObservableUseCase<List<ExchangeConversion>, Any?>(mSubcribeOnScheduler, mObserverOnScheduler) {

    @Inject
    lateinit var mExchangeRatesRepository: IExchangeRatesRepository

    override fun buildUseCase(params: Any?): Observable<List<ExchangeConversion>> {
        return mExchangeRatesRepository.mExchangePublisher
                .map {
                    val resultList = ArrayList<ExchangeConversion>()
                    for ((entry, value) in it) {
                        resultList.add(ExchangeConversion(entry, value))
                    }
                    resultList
                }
    }
}