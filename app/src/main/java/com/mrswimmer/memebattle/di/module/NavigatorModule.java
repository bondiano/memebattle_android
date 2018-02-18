package com.mrswimmer.memebattle.di.module;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class NavigatorModule {
    private Cicerone<Router> cicerone;

    public NavigatorModule() {
        cicerone = Cicerone.create();
    }

    @Provides
    public Router provideRouter() {
        return cicerone.getRouter();
    }

    @Provides
    public NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }
}
