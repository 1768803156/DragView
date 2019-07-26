package com.yanxuwen.dragviewlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.yanxuwen.dragview.IDImageLoader;

public class ImageLoader implements IDImageLoader {

    @Override
    public void displayImage(@NonNull Context context, @NonNull Object uri, @NonNull ImageView imageView) {
        RequestOptions options3 = new RequestOptions()
                .centerCrop()
                .priority(Priority.HIGH);
        Glide.with(context).load(uri).transition(DrawableTransitionOptions.withCrossFade()).apply(options3).into(imageView);

    }

}
