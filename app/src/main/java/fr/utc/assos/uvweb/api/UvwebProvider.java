package fr.utc.assos.uvweb.api;

import java.util.List;

import fr.utc.assos.uvweb.BuildConfig;
import fr.utc.assos.uvweb.model.Newsfeed;
import fr.utc.assos.uvweb.model.UvDetail;
import fr.utc.assos.uvweb.model.UvListItem;
import retrofit.Callback;
import retrofit.RestAdapter;

public final class UvwebProvider {
    private UvwebProvider() {
        // Class should not be instantiated
    }

    private static RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("https://assos.utc.fr/uvweb")
            .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
            .build();
    private static UvwebApi uvwebApi = restAdapter.create(UvwebApi.class);

    public static void getUvs(Callback<List<UvListItem>> callback) {
        uvwebApi.getUvs(callback);
    }

    public static void getNewsfeed(Callback<Newsfeed> callback) {
        uvwebApi.getNewsfeed(callback);
    }

    public static void getUvDetail(String name, Callback<UvDetail> callback) {
        uvwebApi.getUvDetail(name, callback);
    }
}
