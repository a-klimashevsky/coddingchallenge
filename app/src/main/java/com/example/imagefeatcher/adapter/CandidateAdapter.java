package com.example.imagefeatcher.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imagefeatcher.LargePortraintActivity;
import com.example.imagefeatcher.R;
import com.example.imagefeatcher.web.Candidate;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Alex Klimashevsky on 16.07.2015.
 */
public class CandidateAdapter extends RecyclerView.Adapter<CandidateAdapter.CandidateViewHolder> {

    private List<Candidate> mCandidates;

    @Override
    public CandidateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_candidate, parent, false);
        return new CandidateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CandidateViewHolder holder, int position) {
        Candidate candidate = mCandidates.get(position);
        holder.mPositionView.setText(candidate.getPosition());
        holder.mNameView.setText(candidate.getName());
        holder.mUrl = candidate.getLargeImage();
        Picasso
                .with(holder.mNameView.getContext())
                .load(candidate.getSmallImage())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mCandidates == null ? 0 : mCandidates.size();
    }

    public void setData(List<Candidate> candidates) {
        mCandidates = candidates;
        notifyDataSetChanged();
    }

    static class CandidateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageView;

        private TextView mNameView;

        private TextView mPositionView;

        private String mUrl;

        public CandidateViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mNameView = (TextView) itemView.findViewById(R.id.name);
            mPositionView = (TextView) itemView.findViewById(R.id.position);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = LargePortraintActivity.newIntent(view.getContext(), mUrl);
            view.getContext().startActivity(intent);
        }
    }
}
