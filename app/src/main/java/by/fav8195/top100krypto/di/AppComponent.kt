package by.fav8195.top100krypto.di

import by.fav8195.top100krypto.activities.MainActivity
import by.fav8195.top100krypto.fragments.CurrenciesListFragment
import by.fav8195.top100krypto.mvp.presenter.CurrenciesPresenter
import by.fav8195.top100krypto.mvp.presenter.LatestChartPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)

    fun inject(fragment: CurrenciesListFragment)
}

