package co.com.currencyexchange.core.use_cases.preferences

import co.com.currencyexchange.core.use_cases.base.CompletableUseCase
import co.com.currencyexchange.data.HAS_WATCHED_FAVORITE_CURRENCIES_DIALOG
import co.com.currencyexchange.data.repository.IPreferencesRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by oscarg798 on 2/22/18.
 */
class SaveHasWatchedFavoriteDialog(mSubscribeOnScheduler: Scheduler,
                                   mObserverOnScheduler: Scheduler) :
        CompletableUseCase<Boolean>(mSubscribeOnScheduler, mObserverOnScheduler) {


    @Inject
    lateinit var mPreferenceRepository: IPreferencesRepository

    override fun buildUseCase(params: Boolean): Completable {
        return Completable.create { emitter ->
            mPreferenceRepository.storeData(HAS_WATCHED_FAVORITE_CURRENCIES_DIALOG, if (params) "1" else "0")
            emitter.onComplete()
        }
    }
}