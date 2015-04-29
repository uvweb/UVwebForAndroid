package fr.utc.assos.uvweb.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.utc.assos.uvweb.R;
import fr.utc.assos.uvweb.api.UvwebProvider;
import fr.utc.assos.uvweb.model.Newsfeed;
import fr.utc.assos.uvweb.model.NewsfeedItem;
import fr.utc.assos.uvweb.ui.activity.CommentActivity;
import fr.utc.assos.uvweb.ui.adapter.NewsfeedAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class NewsfeedFragment extends Fragment implements Callback<Newsfeed>, NewsfeedAdapter.ItemClickListener {
    private static final String TAG = NewsfeedFragment.class.getSimpleName();
    private static final String STATE_NEWSFEED_ITEMS = "state_newsfeed_items";

    private static final int LOADING_STATE_IN_PROGRESS = 0;
    private static final int LOADING_STATE_COMPLETE = 1;

    private RecyclerView recyclerView;

    private NewsfeedAdapter adapter;
    private List<NewsfeedItem> items;
    private ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_newsfeed, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.recycler);
        progressBar = (ProgressBar) root.findViewById(R.id.progressbar);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsfeedAdapter(this);
        recyclerView.setAdapter(adapter);

        return root;
    }

    private void setLoadingState(int loadingState) {
        if (loadingState == LOADING_STATE_IN_PROGRESS) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {
            setLoadingState(LOADING_STATE_IN_PROGRESS);
            UvwebProvider.getNewsfeed(this);
        } else {
            items = savedInstanceState.getParcelableArrayList(STATE_NEWSFEED_ITEMS);
            updateViews();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (items != null) {
            outState.putParcelableArrayList(STATE_NEWSFEED_ITEMS, new ArrayList<Parcelable>(items));
        }
    }

    @Override
    public void success(Newsfeed newsfeed, Response response) {
        items = newsfeed.getItems();
        updateViews();
    }

    private void updateViews() {
        adapter.setItems(items);
        setLoadingState(LOADING_STATE_COMPLETE);
    }

    @Override
    public void failure(RetrofitError error) {
        Log.e(TAG, "Failed loading newsfeed", error);
        Toast.makeText(getActivity(), getString(R.string.loading_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(NewsfeedItem item) {
        startActivity(new Intent(getActivity(), CommentActivity.class));
    }
}