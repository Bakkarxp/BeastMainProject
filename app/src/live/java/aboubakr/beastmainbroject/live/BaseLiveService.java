package aboubakr.beastmainbroject.live;

import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.otto.Bus;

public class BaseLiveService {
    protected final BeastApplication application;
    protected final Bus bus;
    protected final DatabaseReference databaseReference ;
    public static final String FIREBASE_REFERENCE="https://beastmainproject-231722.firebaseio.com/";

    public BaseLiveService(BeastApplication application) {
        this.application = application;
        bus = application.getBus();
        bus.register(this);
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }
}
