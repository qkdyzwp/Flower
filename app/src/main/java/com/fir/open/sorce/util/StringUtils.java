package com.fir.open.sorce.util;

import android.widget.TextView;

/**
 * Created by wp on 2016/1/14.
 * about
 */
public class StringUtils {
    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.equals("");
    }

    public static boolean isEmptyForText(TextView textView) {
        CharSequence charSequence = textView.getText().toString();
        return charSequence == null || charSequence.equals("");
    }
}
