package com.yanxuwen.dragview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

public interface IDImageLoader {

    void displayImage(@NonNull Context context, @NonNull Object uri, @NonNull ImageView imageView);

}
