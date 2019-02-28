package aboubakr.beastmainbroject.inmemory;

import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;

public class Module {

    public static void Register(BeastApplication application) {
        new InMemoryBrotherService(application);
        new InMemoryCardsService(application);
        new InMemoryPictureService(application);
        new InMemoryRushEventService(application);
    }
}
