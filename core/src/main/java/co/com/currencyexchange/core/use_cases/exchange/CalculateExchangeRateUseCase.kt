package co.com.currencyexchange.core.use_cases.exchange

import co.com.currencyexchange.core.use_cases.base.CompletableUseCase
import co.com.currencyexchange.data.repository.IExchangeRatesRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by oscarg798 on 2/21/18.
 */
class CalculateExchangeRateUseCase(mSubcribeOnScheduler: Scheduler,
                                   mObserveOnScheduler: Scheduler) :
        CompletableUseCase<Double>(mSubcribeOnScheduler, mObserveOnScheduler) {


    @Inject
    lateinit var mExchangeRatesRepository: IExchangeRatesRepository

    override fun buildUseCase(params: Double): Completable {
        return Completable.create {
            mExchangeRatesRepository.calculateExchangeRate(params)
            it.onComplete()
        }
    }
}