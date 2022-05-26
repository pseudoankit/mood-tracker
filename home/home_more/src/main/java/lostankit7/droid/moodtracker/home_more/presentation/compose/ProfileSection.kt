package lostankit7.droid.moodtracker.home_more.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import lostankit7.droid.moodtracker.core_ui.compose.values.Dimensions
import lostankit7.droid.moodtracker.core_ui.compose.values.LocalSpacing
import lostankit7.droid.moodtracker.core_ui.compose.values.StrokeColor
import lostankit7.droid.moodtracker.core_ui.compose.view.CustomTextField
import lostankit7.droid.moodtracker.home_more.R
import lostankit7.droid.moodtracker.home_more.presentation.viewmodel.MoreViewModel

private const val PROFILE_BOX = "profile_box"
private const val PROFILE_EDIT_BTN = "profile_edt_btn"

val spacing @Composable get() = LocalSpacing.current

@Composable
fun ProfileSection(
    viewModel: MoreViewModel,
) {
    val spacing = LocalSpacing.current

    ConstraintLayout(
        createConstraints(spacing),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .layoutId(PROFILE_BOX)
                .border(
                    width = spacing.strokeLvl2,
                    color = StrokeColor,
                    shape = RoundedCornerShape(spacing.cornerRadius)
                )
                .padding(horizontal = spacing.dp_10, vertical = spacing.dp_7),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DrawProfileImage()
            Spacer(modifier = Modifier.width(spacing.dp_15))
            DrawProfileNameEdt(viewModel = viewModel)
            Spacer(modifier = Modifier.width(spacing.dp_10))
        }
        Image(
            painter = painterResource(id = R.drawable.ic_me),
            contentDescription = "Edit Profile",
            modifier = Modifier
                .size(spacing.dp_35)
                .layoutId(PROFILE_EDIT_BTN)
                .offset(x = spacing.dp_4, y = -spacing.dp_15)
                .clip(CircleShape)
                .border(
                    width = spacing.strokeLvl1,
                    color = StrokeColor,
                    shape = CircleShape
                )
                .clickable {
                    viewModel.state.profileEditEnabled.value =
                        !viewModel.state.profileEditEnabled.value
                },
        )
    }
}

@Composable
private fun createConstraints(spacing: Dimensions): ConstraintSet = ConstraintSet {
    val profileBox = createRefFor(PROFILE_BOX)
    val editButton = createRefFor(PROFILE_EDIT_BTN)

    constrain(profileBox) {
        top.linkTo(parent.top, margin = spacing.dp_15)
    }

    constrain(editButton) {
        top.linkTo(profileBox.top)
        end.linkTo(profileBox.end)
    }
}

@Composable
fun DrawProfileNameEdt(viewModel: MoreViewModel) {
    val spacing = LocalSpacing.current

    CustomTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(spacing.stdHeight),
        text = viewModel.state.profileName,
        readOnly = !viewModel.state.profileEditEnabled.value
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
                width = spacing.strokeLvl1,
                color = StrokeColor,
                shape = CircleShape
            ),
        painter = painterResource(id = R.drawable.ic_me),
        contentDescription = "Profile Image",
    )
}