package aboubakr.beastmainbroject.inmemory;

import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

public class BaseInMemory {
    protected final BeastApplication application;
    protected final Bus bus;

    public BaseInMemory(BeastApplication application) {
        this.application = application;
        bus = application.getBus();
        bus.register(this);
    }
}
