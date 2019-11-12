package com.thescienceset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] images = {
        R.drawable.slide_one_img,
            R.drawable.slide_two_img,
            R.drawable.slide_three_img
    };

    public String[] headings = {
            "Welcome",
            "Learn",
            "Be a scientist"
    };

    public String[] descriptions = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean feugiat vestibulum vulputate. Ut in lacinia dui. Sed a semper libero. Morbi convallis suscipit eleifend. Sed dictum efficitur ligula, non pharetra massa. Aliquam facilisis vehicula lectus, id venenatis quam laoreet in. Duis luctus dolor in sagittis sodales. Etiam vel viverra tellus, ac molestie nisl. Ut vel commodo diam. Donec euismod sem.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean feugiat vestibulum vulputate. Ut in lacinia dui. Sed a semper libero. Morbi convallis suscipit eleifend. Sed dictum efficitur ligula, non pharetra massa. Aliquam facilisis vehicula lectus, id venenatis quam laoreet in. Duis luctus dolor in sagittis sodales. Etiam vel viverra tellus, ac molestie nisl. Ut vel commodo diam. Donec euismod sem.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean feugiat vestibulum vulputate. Ut in lacinia dui. Sed a semper libero. Morbi convallis suscipit eleifend. Sed dictum efficitur ligula, non pharetra massa. Aliquam facilisis vehicula lectus, id venenatis quam laoreet in. Duis luctus dolor in sagittis sodales. Etiam vel viverra tellus, ac molestie nisl. Ut vel commodo diam. Donec euismod sem."
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView sliderImage =  view.findViewById(R.id.slider_img);
        TextView sliderHeading = view.findViewById(R.id.slider_heading);
        TextView sliderDescription = view.findViewById(R.id.slider_description);

        sliderImage.setImageResource(images[position]);
        sliderHeading.setText(headings[position]);
        sliderDescription.setText(descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((LinearLayout)object);
    }
}
