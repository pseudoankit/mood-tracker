package lostankit7.droid.moodtracker.home_more.di.component

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.fragment.app.FragmentActivity
import dagger.Component
import lostankit7.droid.moodtracker.core.di.component.CoreAppComponent
import lostankit7.droid.moodtracker.core.di.component.CoreAppComponent.Companion.coreAppComponent
import lostankit7.droid.moodtracker.home_more.di.module.ViewModelModule
import lostankit7.droid.moodtracker.home_more.presentation.fragment.MoreFragment

@Component(
    dependencies = [CoreAppComponent::class],
    modules = [ViewModelModule::class]
)
interface HomeMoreComponent {

    companion object {
        val FragmentActivity.createComponent: HomeMoreComponent
            get() = DaggerHomeMoreComponent.builder()
                .coreAppComponent(application.coreAppComponent)
                .build()
    }

    @ExperimentalComposeUiApi
    fun inject(fragment: MoreFragment)
}