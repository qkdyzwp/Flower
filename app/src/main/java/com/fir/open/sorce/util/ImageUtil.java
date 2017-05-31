package com.fir.open.sorce.util;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.fir.open.sorce.R;

/**
 * Created by modata_fir on 2017/5/31.
 */

public class ImageUtil {
    public static void displayForGlide(Context context, String url, ImageView load) {
        Glide
                .with(context)
                .load(url)
                .override(350, 350)
                .error(R.mipmap.error)
                .centerCrop()
                .into(load);
    }

    public static void initImg(Context context, String url, ImageView img){
        Glide.with(context)
                .load(url)
                .asBitmap().centerCrop()
                .placeholder(R.mipmap.error)
                .dontAnimate()
                .into(img);
    }
    public static void initImg(Context context, int resorce, ImageView img){
        Glide.with(context)
                .load(resorce)
                .asBitmap().centerCrop()
                .placeholder(R.mipmap.error)
                .dontAnimate()
                .into(img);
    }
        /**
         * 自适应宽度加载图片。保持图片的长宽比例不变，通过修改imageView的高度来完全显示图片。
         */
        public static void loadIntoUseFitWidth(Context context, final String imageUrl, final ImageView imageView) {
            Glide.with(context)
                    .load(imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            if (imageView == null) {
                                return false;
                            }
                            if (imageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            }
                            ViewGroup.LayoutParams params = imageView.getLayoutParams();
                            int vw = imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
                            float scale = (float) vw / (float) resource.getIntrinsicWidth();
                            int vh = Math.round(resource.getIntrinsicHeight() * scale);
                            params.height = vh + imageView.getPaddingTop() + imageView.getPaddingBottom();
                            imageView.setLayoutParams(params);
                            return false;
                        }
                    })
                    .placeholder(R.mipmap.error)
                    .error(R.mipmap.error)
                    .into(imageView);
        }

}
