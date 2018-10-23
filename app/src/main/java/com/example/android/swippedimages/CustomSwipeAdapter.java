package com.example.android.swippedimages;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by H on 3/12/2018.
 */

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resources =new int[] {R.drawable.aa,R.drawable.bb,R.drawable.cc,R.drawable.dd};

    private Context ctx;
    private LayoutInflater layoutInflater ;

    public CustomSwipeAdapter(Context ctx){
        this.ctx=ctx;
    }
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swip_layout,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.imageView);
        imageView.setImageResource(image_resources[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
