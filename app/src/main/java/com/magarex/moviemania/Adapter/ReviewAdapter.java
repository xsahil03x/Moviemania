package com.magarex.moviemania.Adapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magarex.moviemania.Interface.ItemClickListener;
import com.magarex.moviemania.Models.Review;
import com.magarex.moviemania.R;
import com.magarex.moviemania.databinding.ReviewItemBinding;

import java.util.List;

class ReviewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    ReviewItemBinding mBinding;
    private ItemClickListener itemClickListener;

    ReviewViewHolder(ReviewItemBinding itemBinding) {
        super(itemBinding.getRoot());
        this.mBinding = itemBinding;
        mBinding.getRoot().setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }
}

public class ReviewAdapter extends RecyclerView.Adapter<ReviewViewHolder> {

    private Activity mActivity;
    private List<Review> mReviews;

    public ReviewAdapter(Activity activity) {
        this.mActivity = activity;
    }

    public void addReviewToList(List<Review> reviewList) {
        this.mReviews = reviewList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReviewItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.review_item, parent, false);
        return new ReviewViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ReviewViewHolder holder, int position) {
        holder.mBinding.setReview(mReviews.get(position));
    }

    @Override
    public int getItemCount() {
        if (mReviews == null) {
            return 0;
        } else {
            return mReviews.size();
        }
    }

}
