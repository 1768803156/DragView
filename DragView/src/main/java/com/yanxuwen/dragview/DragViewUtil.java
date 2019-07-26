package com.yanxuwen.dragview;

import android.app.Activity;
import android.support.annotation.FloatRange;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DragViewUtil {

    public static void showImgs(final Activity context, int currentIndex, final ArrayList<View> views, final ArrayList<Object> imgDatas) {
        final ArrayList<Class> listfragemnt = new ArrayList<>();
        for (int i = 0; i < imgDatas.size(); i++) {
            listfragemnt.add(ImgFragment.class);
        }

        DragViewActivity.startActivity(context, currentIndex, new DragViewActivity.OnDataListener() {
            private TextView tv_index = null;
            private ImageView tb_backiv = null;
            private View view_preview = null;

            @Override
            public ArrayList<View> getListView() {
                return views;
            }

            @Override
            public ArrayList<Object> getListData() {
                return imgDatas;
            }

            @Override
            public ArrayList<Class> getListFragmentClass() {
                return listfragemnt;
            }

            @Override
            public void onPageSelected(int position) {
                if (tv_index != null) {
                    tv_index.setText((position + 1) + "/" + imgDatas.size());
                }

            }

            @Override
            public boolean onBackPressed() {
                return true;
            }

            @Override
            public void init() {
                if (view_preview == null) {
                    view_preview = context.getLayoutInflater().inflate(R.layout.view_preview, null);
                    DragViewActivity.getInstance(context).getDragViewLayout().addView(view_preview);
                    tv_index = view_preview.findViewById(R.id.tv_index);
                    tb_backiv = view_preview.findViewById(R.id.tb_backiv);
                    tb_backiv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DragViewActivity.getInstance(context).onBackPressed();
                        }
                    });
                    DragViewActivity.getInstance(context).setOnDrawerOffsetListener(new DragViewActivity.OnDrawerOffsetListener() {
                        @Override
                        public void onDrawerOffset(@FloatRange(from = 0, to = 1) float offset) {
                            tv_index.setAlpha(offset);
                            tb_backiv.setAlpha(offset);
                            if (offset == 0) {
                                view_preview = null;
                            }
                        }
                    });
                }
            }
        });
    }
}
