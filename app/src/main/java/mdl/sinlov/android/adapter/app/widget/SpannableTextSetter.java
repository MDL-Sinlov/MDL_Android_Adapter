package mdl.sinlov.android.adapter.app.widget;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * for Spannable Text at views
 */
public class SpannableTextSetter {

    private static ForegroundColorSpan foregroundColorSpan;
    private static int colorOld;

    /**
     * draw spannable TextView at Inclusive
     *
     * @param tv    {@link TextView}
     * @param text  {@link String}
     * @param start int
     * @param end   int
     * @param flags {@link Spannable#SPAN_EXCLUSIVE_INCLUSIVE} or other
     * @param color {@link android.graphics.Color#RED} or other
     */
    public static void drawSpannableTextView(TextView tv, String text, int start, int end, int flags, int color) {
        SpannableStringBuilder spannableString = new SpannableStringBuilder(text);
        if (null == foregroundColorSpan || colorOld != color) {
            foregroundColorSpan = new ForegroundColorSpan(color);
            SpannableTextSetter.colorOld = color;
        }
        spannableString.setSpan(foregroundColorSpan, start, end, flags);
        tv.setText(spannableString);
    }

    /**
     * draw spannable TextView at Inclusive color is red
     * @param tv    {@link TextView}
     * @param text  {@link String}
     * @param start int
     * @param end   int
     * @param flags {@link Spannable#SPAN_EXCLUSIVE_INCLUSIVE} or other
     */
    public static void drawSpannableTextViewInRedColor(TextView tv, String text, int start, int end, int flags) {
        drawSpannableTextView(tv, text, start, end, flags, Color.RED);
    }

    /**
     * draw spannable TextView, with color red and {@link Spannable#SPAN_EXCLUSIVE_INCLUSIVE}
     * @param tv    {@link TextView}
     * @param text  {@link String}
     * @param start int
     * @param end   int
     */
    public static void drawSpannableTextViewInclusiveTextRedColor(TextView tv, String text, int start, int end) {
        drawSpannableTextViewInRedColor(tv, text, start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
    }

    private SpannableTextSetter() {
    }
}
