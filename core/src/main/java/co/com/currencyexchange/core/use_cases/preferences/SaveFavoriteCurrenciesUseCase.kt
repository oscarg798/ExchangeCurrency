package co.com.currencyexchange.core.use_cases.preferences

import co.com.currencyexchange.core.use_cases.base.CompletableUseCase
import co.com.currencyexchange.data.FAVORITE_CURRENCIES
import co.com.currencyexchange.data.repository.IPreferencesRepository
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by oscarg798 on 2/22/18.
 */
class SaveFavoriteCurrenciesUseCase(mSubcribeOnScheduler: Scheduler,
                                    mObserverOnScheduler: Scheduler) :
        CompletableUseCase<List<String>>(mSubcribeOnScheduler, mObserverOnScheduler) {

    @Inject
    lateinit var mPreferenceRepository: IPreferencesRepository

    override fun buildUseCase(params: List<String>): Completable {
        return Completable.create { emitter ->
            mPreferenceRepository.storeData(FAVORITE_CURRENCIES, Gson().toJson(params))
            emitter.onComplete()
        }
    }
}