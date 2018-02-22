package co.com.currencyexchange.core.use_cases.currency

import android.content.Context
import co.com.currencyexchange.core.use_cases.base.CompletableUseCase
import co.com.currencyexchange.core.use_cases.base.SingleUseCase
import co.com.currencyexchange.data.local.models.Currency
import co.com.currencyexchange.data.repository.ICurrencyRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by oscarg798 on 2/21/18.
 */
class GetCurrenciesUsecase(mSubscribeOnScheduler: Scheduler,
                           mObserverOnScheduler: Scheduler) :
        SingleUseCase<List<Currency>, Context>(mObserverOnScheduler, mSubscribeOnScheduler) {

    @Inject
    lateinit var mCurrencyRepository: ICurrencyRepository

    override fun buildUseCase(params: Context): Single<List<Currency>> {
        return mCurrencyRepository.getCurrencies(params)
    }
}