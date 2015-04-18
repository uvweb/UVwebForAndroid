package fr.utc.assos.uvweb.api;

import java.util.List;

import fr.utc.assos.uvweb.model.UvListItem;
import retrofit.Callback;
import retrofit.http.GET;

public interface UvwebApi {
    @GET("/uv/app/all")
    void getUvs(Callback<List<UvListItem>> callback);
}
