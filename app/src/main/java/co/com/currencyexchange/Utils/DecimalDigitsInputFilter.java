package co.com.currencyexchange.Utils;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by oscarg798 on 2/22/18.
 */

public class DecimalDigitsInputFilter implements InputFilter {

    private Pattern mPattern;

    public DecimalDigitsInputFilter(int digitsAfterZero) {
        mPattern = Pattern.compile("^(?:\\d+(?:\\.\\d{0," + digitsAfterZero + "})?)?$");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        Matcher matcher = mPattern.matcher(dest);
        if (!matcher.matches())
            return "";
        return null;
    }

}