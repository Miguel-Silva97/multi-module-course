package example.tracker_domain.repository

import example.tracker_domain.model.TrackableFood
import example.tracker_domain.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: TrackedFood)

    suspend fun deleteTrackedFood(food: TrackedFood)

    suspend fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}