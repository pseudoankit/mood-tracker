package lostankit7.droid.moodtracker.helper

import androidx.navigation.NavOptions

private const val NO_ANIMATION = -1
fun animate(
    enter: Int,
    exit: Int,
    samePopAnim: Boolean = false
) = NavOptions.Builder().setEnterAnim(enter).setExitAnim(exit).also {
    if (samePopAnim) it.setPopEnterAnim(exit).setPopExitAnim(enter)
}.build()

fun animate(
    enter: Int = NO_ANIMATION,
    exit: Int = NO_ANIMATION,
    popEnter: Int = NO_ANIMATION,
    popExit: Int = NO_ANIMATION
) = NavOptions.Builder().also {
    if (enter != NO_ANIMATION) it.setEnterAnim(enter)
    if (exit != NO_ANIMATION) it.setExitAnim(exit)
    if (popEnter != NO_ANIMATION) it.setPopEnterAnim(popEnter)
    if (popExit != NO_ANIMATION) it.setPopExitAnim(popExit)
}.build()
