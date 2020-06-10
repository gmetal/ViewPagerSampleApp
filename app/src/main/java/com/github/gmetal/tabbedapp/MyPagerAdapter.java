package com.github.gmetal.tabbedapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyPagerAdapter extends PagerAdapter {

    private final Context mContext;
    private List<CatImage> mItems;

    public MyPagerAdapter(final Context context, final List<CatImage> items) {

        mContext = context;
        mItems = items;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        final View inflatedView = layoutInflater.inflate(R.layout.view_tab, null);
        final CatImage currentCatImage = mItems.get(position);
        final ImageView tabImageView = inflatedView.findViewById(R.id.tab_image);
        final TextView tabTitle = inflatedView.findViewById(R.id.tab_title);

        Picasso.with(mContext).load(currentCatImage.getImageUrl()).into(tabImageView);
        tabTitle.setText(currentCatImage.getTitle());

        container.addView(inflatedView);

        return inflatedView;
    }

    @Override
    public void destroyItem(@NonNull final ViewGroup container, final int position, @NonNull final Object object) {

        View viewToBeDestroyed = (View) object;
        container.removeView(viewToBeDestroyed);
    }

    @Override
    public int getCount() {

        return mItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull final View view, @NonNull final Object object) {

        return view == object;
    }
}
