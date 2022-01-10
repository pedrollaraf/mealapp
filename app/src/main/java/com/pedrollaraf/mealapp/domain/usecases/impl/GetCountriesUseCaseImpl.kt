package com.pedrollaraf.mealapp.domain.usecases.impl



import com.pedrollaraf.mealapp.domain.models.Country
import com.pedrollaraf.mealapp.domain.repository.CountriesRepository
import com.pedrollaraf.mealapp.domain.usecases.abs.GetCountriesUseCase

class GetCountriesUseCaseImpl(private val getCountriesRepository: CountriesRepository) : GetCountriesUseCase {
    override suspend fun invoke(): List<Country> {
        return getCountriesRepository.getCountries()
    }
}