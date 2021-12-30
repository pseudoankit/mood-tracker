package lostankit7.droid.moodtracker.helper

import androidx.navigation.NavOptions
import lostankit7.droid.moodtracker.R

const val NO_ANIMATION = -1
const val ANIMATE_TOP_BOTTOM = 1

fun navOptions(
    enter: Int,
    exit: Int,
    reverse: Boolean = true
) = NavOptions.Builder().setEnterAnim(enter).setPopExitAnim(exit).also {
    if (reverse) it.setPopEnterAnim(exit).setExitAnim(enter)
}.build()

fun navOptions(
    enter: Int = NO_ANIMATION,
    popExit: Int = NO_ANIMATION,
    exit: Int = NO_ANIMATION,
    popEnter: Int = NO_ANIMATION
) = NavOptions.Builder().also {
    if (enter != NO_ANIMATION) it.setEnterAnim(enter)
    if (popExit != NO_ANIMATION) it.setPopExitAnim(popExit)
    if (exit != NO_ANIMATION) it.setExitAnim(exit)
    if (popEnter != NO_ANIMATION) it.setPopEnterAnim(popEnter)
}.build()

fun navOptions(animation: Int, reverse: Boolean = true): NavOptions {
    val enter: Int
    val exit: Int
    when (animation) {
        ANIMATE_TOP_BOTTOM -> {
            enter = R.anim.anim_bottom_to_top
            exit = R.anim.anim_top_to_bottom
        }
        else -> {
            enter = NO_ANIMATION
            exit = NO_ANIMATION
        }
    }

    return NavOptions.Builder().also {
        it.setEnterAnim(enter)
        if (reverse) it.setExitAnim(exit)
        if (reverse) it.setPopEnterAnim(enter)
        it.setPopExitAnim(exit)
    }.build()
}
