package fr.utc.assos.uvweb.api;

import java.util.List;

import fr.utc.assos.uvweb.model.Newsfeed;
import fr.utc.assos.uvweb.model.UvListItem;
import retrofit.Callback;
import retrofit.RestAdapter;

public class UvwebProvider {
    private static RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://s370803768.onlinehome.fr/uvweb")
            .build();
    private static UvwebApi uvwebApi = restAdapter.create(UvwebApi.class);

    public static void getUvs(Callback<List<UvListItem>> callback) {
        uvwebApi.getUvs(callback);
    }

    public static void getNewsfeed(Callback<Newsfeed> callback) {
        uvwebApi.getNewsfeed(callback);
    }
}
