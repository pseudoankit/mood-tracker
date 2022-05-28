package lostankit7.droid.moodtracker.home_more.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import lostankit7.droid.moodtracker.core_ui.compose.values.LocalSpacing
import lostankit7.droid.moodtracker.core_ui.compose.values.StrokeColor
import lostankit7.droid.moodtracker.core_ui.compose.view.CustomTextField
import lostankit7.droid.moodtracker.home_more.R
import lostankit7.droid.moodtracker.home_more.presentation.viewmodel.MoreViewModel

@Composable
fun ProfileSection(
    viewModel: MoreViewModel,
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .offset(y = spacing.dp_20)
            .fillMaxWidth()
            .wrapContentWidth()
            .border(
                width = spacing.strokeLvl2,
                color = StrokeColor,
                shape = RoundedCornerShape(spacing.cornerRadius)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = spacing.dp_10, vertical = spacing.dp_7),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DrawProfileImage()
            Spacer(modifier = Modifier.width(spacing.dp_15))
            DrawProfileNameEdt(viewModel = viewModel)
            Spacer(modifier = Modifier.width(spacing.dp_10))
        }
    }
}

//todo generic edt
@Composable
fun DrawProfileNameEdt(viewModel: MoreViewModel) {
    val spacing = LocalSpacing.current

    CustomTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(spacing.stdHeight),
        text = viewModel.state.profileName
    )
}

@Composable
fun DrawProfileImage() {
    val spacing = LocalSpacing.current
    Image(
        modifier = Modifier
            .size(spacing.profileImage)
            .clip(CircleShape)
            .border(
                width = spacing.dp_1,
                color = StrokeColor,
                shape = CircleShape
            ),
        painter = painterResource(id = R.drawable.ic_me),
        contentDescription = "Profile Image",
    )
}