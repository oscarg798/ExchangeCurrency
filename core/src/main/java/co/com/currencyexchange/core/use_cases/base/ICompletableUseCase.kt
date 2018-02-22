package co.com.currencyexchange.core.use_cases.base

import io.reactivex.Completable
import io.reactivex.observers.DisposableCompletableObserver

/**
 * Created by oscarg798 on 2/21/18.
 */
interface ICompletableUseCase<Params> {


    fun getUseCase(params: Params): Completable

    fun execute(params: Params, observer: DisposableCompletableObserver)

    fun dispose()
}