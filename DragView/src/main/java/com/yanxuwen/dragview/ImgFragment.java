package com.yanxuwen.dragview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by yanxuwen on 2018/6/15.
 */

public class ImgFragment extends DragFragment implements View.OnClickListener {
    private PinchImageView dragview;

    @Override
    public View getDragView() {
        return (view == null) ? null : view.findViewById(R.id.dragview);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.imgfragment);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        dragview = view.findViewById(R.id.dragview);
        dragview.setOnClickListener(this);
        DImageLoader.getInstance().getLoader().displayImage(getContext(), data, dragview);
    }

    public PinchImageView getImageView() {
        return dragview;
    }

    @Override
    public void init() {

    }

    @Override
    public void onDragStatus(int status) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.dragview) {
            try {
                if (!getActivity().isFinishing())
                    getActivity().onBackPressed();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
