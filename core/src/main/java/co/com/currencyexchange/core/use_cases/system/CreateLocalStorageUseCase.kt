package co.com.currencyexchange.core.use_cases.system

import android.content.Context
import co.com.currencyexchange.core.use_cases.base.CompletableUseCase
import co.com.currencyexchange.data.repository.IPreferencesRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by oscarg798 on 2/22/18.
 */
class CreateLocalStorageUseCase(mSubscribeOnScheduler: Scheduler,
                                mObserverOnScheduler: Scheduler) :
        CompletableUseCase<Context>(mSubscribeOnScheduler, mObserverOnScheduler) {

    @Inject
    lateinit var mPreferenceRepository: IPreferencesRepository

    override fun buildUseCase(params: Context): Completable {
        return Completable.create { emitter ->
            mPreferenceRepository.createLocalStorage(params)
            emitter.onComplete()
        }
    }
}