package co.com.currencyexchange.preferences

import android.app.DialogFragment
import android.os.Bundle
import android.preference.PreferenceFragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.com.currencyexchange.R
import co.com.currencyexchange.data.local.models.Currency
import kotlinx.android.synthetic.main.fragment_preference.*


class PreferenceDialogFragment : DialogFragment(), IPreferenceFragmentDialogView {


    private val mPresenter: IPreferenceFragmentDialogPresenter = PreferenceFragmentDialogPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as? AppCompatActivity)?.lifecycle?.addObserver(mPresenter)
        mPresenter.bind(this)
        isCancelable = false

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preference, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }


    override fun initComponents() {
        mRVFavoriteCurrency?.setHasFixedSize(true)
        activity?.let {
            mRVFavoriteCurrency?.layoutManager = LinearLayoutManager(it)
        }

        mTVDone?.setOnClickListener {
            mPresenter.onDonePressed()
        }

        mTVCancel?.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }

    override fun showProgressBar() {
        mPBPreferences?.visibility = View.VISIBLE
        mRVFavoriteCurrency?.visibility = View.GONE
        mLLButtonsContainer?.visibility = View.INVISIBLE
    }

    override fun hideProgressBar() {
        mPBPreferences?.visibility = View.GONE
        mRVFavoriteCurrency?.visibility = View.VISIBLE
        mLLButtonsContainer?.visibility = View.VISIBLE
    }

    override fun showFavoritesCurrencies(currencies: List<Currency>, favoriteCurrencies: ArrayList<String>) {
        mRVFavoriteCurrency?.adapter = PreferenceAdapter(ArrayList(currencies), favoriteCurrencies)
    }

    override fun getFavoriteCurrencies(): List<String>? {
        return (mRVFavoriteCurrency?.adapter as? PreferenceAdapter)?.getFavoritecurrencies()
    }

    override fun updateDone() {
        dismissAllowingStateLoss()
    }
    companion object {
        fun newInstance(): PreferenceDialogFragment {
            return PreferenceDialogFragment()
        }
    }
}