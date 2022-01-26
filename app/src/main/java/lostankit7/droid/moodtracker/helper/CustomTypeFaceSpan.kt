package lostankit7.droid.moodtracker.helper

import android.graphics.Paint
import android.graphics.Typeface

import android.text.TextPaint

import android.text.style.TypefaceSpan

/*
* TextView txt = (TextView) findViewById(R.id.custom_fonts);
        txt.setTextSize(30);
        Typeface font = Typeface.createFromAsset(getAssets(), "Akshar.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "bangla.ttf");
        SpannableStringBuilder SS = new SpannableStringBuilder("আমারநல்வரவு");
        SS.setSpan (new CustomTypefaceSpan("", font2), 0, 4,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        SS.setSpan (new CustomTypefaceSpan("", font), 4, 11,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        txt.setText(SS);
*/
class CustomTypefaceSpan(family: String?, private val newType: Typeface) : TypefaceSpan(family) {
    override fun updateDrawState(ds: TextPaint) {
        applyCustomTypeFace(ds, newType)
    }

    override fun updateMeasureState(paint: TextPaint) {
        applyCustomTypeFace(paint, newType)
    }

    companion object {
        private fun applyCustomTypeFace(paint: Paint, tf: Typeface) {
            val oldStyle = paint.typeface.style ?: 0
            val fake = oldStyle and tf.style.inv()
            if (fake and Typeface.BOLD != 0) {
                paint.isFakeBoldText = true
            }
            if (fake and Typeface.ITALIC != 0) {
                paint.textSkewX = -0.25f
            }
            paint.typeface = tf
        }
    }
}