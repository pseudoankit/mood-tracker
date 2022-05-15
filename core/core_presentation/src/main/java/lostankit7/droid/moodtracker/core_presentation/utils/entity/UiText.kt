package lostankit7.droid.moodtracker.core_presentation.utils.entity

import android.content.Context
import androidx.annotation.StringRes

sealed class UiText {

        data class NormalString(val string: String) : UiText()

        class ResourceString(
            @StringRes val stringId: Int, vararg val arguments: Any
        ) : UiText()

        fun asString(context: Context): String {
            return when (this) {
                is NormalString -> this.string
                is ResourceString -> String.format(
                    context.resources.getString(stringId), arguments
                )
            }
        }
    }