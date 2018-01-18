package tm.nsfantom.infinity;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by user on 1/18/18.
 */

public class InfinityApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
