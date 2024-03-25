package example.tracker_domain.di

import com.example.core.domain.preferences.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import example.tracker_domain.repository.TrackerRepository
import example.tracker_domain.use_case.CalculateMealNutrients
import example.tracker_domain.use_case.DeleteTrackedFood
import example.tracker_domain.use_case.GetFoodsForDate
import example.tracker_domain.use_case.SearchFood
import example.tracker_domain.use_case.TrackFood
import example.tracker_domain.use_case.TrackerUseCases

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}