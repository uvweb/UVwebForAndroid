package fr.utc.assos.uvweb.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import fr.utc.assos.uvweb.R;
import fr.utc.assos.uvweb.model.UvDetailComment;

public class CommentActivity extends ToolbarActivity {

    public static final String ARG_COMMENT = "arg_comment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        UvDetailComment comment = getIntent().getParcelableExtra(ARG_COMMENT);
        setTitle(comment.getAuthor());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_comment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
