package com.example.imagefeatcher;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class LargePortraintActivity extends ActionBarActivity {

    private static final String ARG_IMAGE_URL = "arg_image_url";

    private ImageView mImageView;

    public static Intent newIntent(Context context, String url){
        Intent intent = new Intent(context, LargePortraintActivity.class);
        intent.putExtra(ARG_IMAGE_URL, url);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_portraint);
        mImageView = (ImageView) findViewById(R.id.image);

        Picasso.with(this).load(getIntent().getStringExtra(ARG_IMAGE_URL)).into(mImageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_large_portraint, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
