package aboubakr.beastmainbroject.live;

import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;

public class Module {

    public static void Register(BeastApplication application) {
        new LiveBrotherService(application);
        new LiveCardsService(application);
        new LivePictureService(application);
        new LiveRushEventService(application);
    }
}
