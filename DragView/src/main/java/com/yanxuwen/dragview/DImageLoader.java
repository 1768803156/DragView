package com.yanxuwen.dragview;

public class DImageLoader {

    private volatile IDImageLoader loader;

    public static DImageLoader getInstance() {
        return Holder.holder;
    }

    private DImageLoader() {

    }

    private static class Holder {
        static DImageLoader holder = new DImageLoader();
    }

    /****
     * 初始化加载图片类
     * @param  loader 自定义
     * **/
    public void init(IDImageLoader loader) {
        this.loader = loader;
    }

    public IDImageLoader getLoader() {
        if (loader == null) {
            throw new NullPointerException("DImageLoader loader  no init");
        }
        return loader;
    }
}
