package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class PlaceholderFragment extends Fragment {

    private ArrayAdapter<String> adapterItems;
    private ListView lvItems;
    private LottieAnimationView loadView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create arraylist from item fixtures
        ArrayList<String> items = new ArrayList<String>();
        items.add("1");
        items.add("2");
        items.add("3");
        items.add("4");
        items.add("5");
        items.add("6");
        items.add("7");
        adapterItems = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1, items);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        lvItems = (ListView)view.findViewById(R.id.lvItems);

//        ArrayList<Item> items = Item.getItems();
//        adapterItems = new ArrayAdapter<Item>(getActivity(),
//                android.R.layout.simple_list_item_activated_1, items);
        lvItems.setAdapter(adapterItems);

        loadView = (LottieAnimationView)view.findViewById(R.id.loading_view);
        loadView.playAnimation();

        lvItems.setVisibility(View.INVISIBLE);
        loadView.setVisibility(View.VISIBLE);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                lvItems.setVisibility(View.VISIBLE);
                loadView.setVisibility(View.INVISIBLE);
//                ObjectAnimator fadeout = ObjectAnimator.ofFloat(loadView,"alpha",1f,0f);
//                ObjectAnimator fadein = ObjectAnimator.ofFloat(loadView,"alpha",0f,1f);
//
//                AnimatorSet animset = new AnimatorSet();
//                animset.playTogether(fadein,fadeout);
            }
        }, 5000);
    }
}
