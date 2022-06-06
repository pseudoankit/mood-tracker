package lostankit7.droid.moodtracker.user_entries.presentation.user_entries.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import lostankit7.android.entry_domain.entities.UserEntry
import lostankit7.droid.moodtracker.core.presentation.utils.DateTimeUtils
import lostankit7.droid.moodtracker.core_ui.compose.values.PrimaryTextColor
import lostankit7.droid.moodtracker.core_ui.utils.spacing
import lostankit7.droid.moodtracker.user_entries.presentation.user_entries.viewmodel.UserEntriesViewModel

@Composable
fun DrawUserEntryScreen(viewModel: UserEntriesViewModel) {
    val state = viewModel.state
    val entries = viewModel.userEntries().observeAsState(emptyList()).value

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(entries.size) { index ->

            val prevItem = entries.getOrNull(index - 1)

            when (val currItem = entries[index]) {
                is UserEntry.Date -> {
                    DrawMonthHeader(currItem, prevItem)
                    Spacer(modifier = Modifier.size(spacing.dp_10))
                    DrawDateHeader(currItem.date)
                }
                is UserEntry.Entry -> {
                    DrawUserEntryItem(
                        currItem = currItem, prevItem = prevItem
                    )
                    CloseBoxIfLastEntryOfSameDate(entries, index)
                }
            }

            if (index == entries.size - 1) Spacer(modifier = Modifier.size(spacing.dp_10))
        }
    }
}

@Composable
private fun DrawMonthHeader(currItem: UserEntry.Date, prevItem: UserEntry?) {
    val currItemDate = currItem.date
    val prevItemDate = (prevItem as? UserEntry.Entry)?.date

    val month =
        DateTimeUtils.getMonthIfDatesNotFallInSameMonth(prevItemDate, currItemDate) ?: return

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = spacing.dp_6)
    ) {
        Text(
            text = month,
            modifier = Modifier.align(Alignment.Center),
            color = PrimaryTextColor,
            fontSize = spacing.text.lvl8,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun CloseBoxIfLastEntryOfSameDate(list: List<UserEntry>, index: Int) {
    val nextItem = list.getOrNull(index + 1)
    if (nextItem != null && nextItem !is UserEntry.Date) return

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(spacing.dp_1),
        shape = RoundedCornerShape(
            bottomEnd = spacing.cornerRadius,
            bottomStart = spacing.cornerRadius
        ),
        elevation = spacing.elevationLow
    ) {}
}

@Composable
private fun DrawDateHeader(date: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(
            topStart = spacing.cornerRadius,
            topEnd = spacing.cornerRadius
        ),
        elevation = spacing.elevation
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = spacing.dp_4)
        ) {
            Text(text = date, modifier = Modifier.align(Alignment.Center))
        }
    }
}