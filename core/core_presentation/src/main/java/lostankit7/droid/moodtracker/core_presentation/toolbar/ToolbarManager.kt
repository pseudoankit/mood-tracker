package lostankit7.droid.moodtracker.core_presentation.toolbar

import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar

class ToolbarManager constructor(
    private var builder: FragmentToolbar,
    private var container: View) {

    fun prepareToolbar() {
        if (builder.resId != FragmentToolbar.NO_TOOLBAR) {
            val fragmentToolbar = container.findViewById(builder.resId) as Toolbar

            if (builder.title != -1) {
                fragmentToolbar.setTitle(builder.title)
            }

            if (builder.menuId != -1) {
                fragmentToolbar.inflateMenu(builder.menuId)
            }

            if (builder.menuItems.isNotEmpty() && builder.menuClicks.isNotEmpty()){
                val menu = fragmentToolbar.menu
                for ((index, menuItemId) in builder.menuItems.withIndex()) {
                    (menu.findItem(menuItemId) as MenuItem).setOnMenuItemClickListener(builder.menuClicks[index])
                }
            }
        }
    }
}