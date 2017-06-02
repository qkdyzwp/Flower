package com.fir.open.sorce.view;

/**
 * Created by modata_fir on 2017/5/31.
 */


import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.fir.open.sorce.entity.Banner;
import com.fir.open.sorce.util.ImageUtil;

/**
 * Created by Sai on 15/8/4.
 * 本地图片Holder例子
 */
public class LocalImageHolderView implements Holder<Banner> {
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
    @Override
    public void UpdateUI(Context context, int position,Banner banner) {
        ImageUtil.initImg(context,  banner.getPicUrl(),imageView);
    }
}
