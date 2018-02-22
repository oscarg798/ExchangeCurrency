package co.com.currencyexchange.core.use_cases.exchange

import co.com.currencyexchange.core.use_cases.base.CompletableUseCase
import co.com.currencyexchange.data.repository.IExchangeRatesRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by oscarg798 on 2/21/18.
 */
class GetExchangeRatesUseCase(mSubscribeOnScheduler: Scheduler,
                              mObserverOnScheduler: Scheduler) :
        CompletableUseCase<Pair<String, String>>(mSubscribeOnScheduler, mObserverOnScheduler) {

    @Inject
    lateinit var mExchangeRatesRepository: IExchangeRatesRepository

    override fun buildUseCase(params: Pair<String, String>): Completable {
        return Completable.fromObservable(mExchangeRatesRepository.getExchangeRates(params.first,
                params.second))
    }
}