package com.avinfo.stickermaker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avinfo.stickermaker.R;
import com.avinfo.stickermaker.utils.StickerPacksManager;
import com.avinfo.stickermaker.whatsapp_api.StickerPack;
import com.avinfo.stickermaker.whatsapp_api.StickerPackListAdapter;
import com.avinfo.stickermaker.whatsapp_api.StickerPackListItemViewHolder;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.List;

public class MyStickersFragment extends Fragment {

    private static final int STICKER_PREVIEW_DISPLAY_LIMIT = 5;
    private LinearLayoutManager layoutManager;
    private RecyclerView stickersRecyclerView;
    private final StickerPackListAdapter.OnAddButtonClickedListener onAddButtonClickedListener = pack -> {
        ((HomeActivity) getActivity()).addStickerPackToWhatsApp(pack.identifier, pack.name);
    };
    private StickerPackListAdapter stickerListAdapter;

    public MyStickersFragment() {

    }
    private InterstitialAd mInterstitialAd;

    @Override
    public void onResume() {
        super.onResume();
        stickerListAdapter.setStickerPackList(StickerPacksManager.getStickerPacks(getActivity()));
        stickerListAdapter.notifyDataSetChanged();
        verifyStickersCount();
    }

    private View view;

    private void initRecyclerView() {
        List<StickerPack> stickersPacks = StickerPacksManager.stickerPacksContainer.getStickerPacks();
        layoutManager = new GridLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL);
        stickersRecyclerView = view.findViewById(R.id.stickers_recycler_list);
        stickersRecyclerView.setLayoutManager(layoutManager);
        stickerListAdapter = new StickerPackListAdapter(stickersPacks, onAddButtonClickedListener, this);

        stickersRecyclerView.setAdapter(stickerListAdapter);
        stickersRecyclerView.setItemViewCacheSize(20);
        stickersRecyclerView.setDrawingCacheEnabled(true);
        stickersRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        stickersRecyclerView.setNestedScrollingEnabled(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(stickersRecyclerView.getContext(), layoutManager.getOrientation());
        stickersRecyclerView.addItemDecoration(dividerItemDecoration);
        stickersRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this::recalculateColumnCount);
    }

    private void initSwipeRefresh() {
        SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.refresh_my_stickers_swiper);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            List<StickerPack> stickersPacks = StickerPacksManager.getStickerPacks(getActivity());
            stickerListAdapter.setStickerPackList(stickersPacks);
            swipeRefreshLayout.setRefreshing(false);
            verifyStickersCount();
        });
    }

    private void recalculateColumnCount() {
        final int previewSize = getActivity().getResources().getDimensionPixelSize(R.dimen.sticker_pack_list_item_preview_image_size);
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        StickerPackListItemViewHolder viewHolder = (StickerPackListItemViewHolder) stickersRecyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
        if (viewHolder != null) {
            final int max = Math.max(viewHolder.imageRowView.getMeasuredWidth() / previewSize, 1);
            int numColumns = Math.min(STICKER_PREVIEW_DISPLAY_LIMIT, max);
            stickerListAdapter.setMaxNumberOfStickersInARow(numColumns);
        }
    }

    public void initButtons() {
        FloatingActionButton floatingActionButtonAdd = view.findViewById(R.id.floating_button_add_sticker_pack);
        floatingActionButtonAdd.setOnClickListener(view -> {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
                Intent intent = new Intent(getActivity(), NewStickerPackActivity.class);
                startActivity(intent);
            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                Intent intent = new Intent(getActivity(), NewStickerPackActivity.class);
                startActivity(intent);
                // Code to be executed when the interstitial ad is closed.
            }
        });

    }

    public void ads(){
        AdView adView = new AdView(getContext());
        adView.setAdSize(AdSize.FULL_BANNER);
        adView.setAdUnitId(getString(R.string.banner1));
        adView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getString(R.string.instretial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

    }

    public void verifyStickersCount() {
        View linearLayout = view.findViewById(R.id.no_stickerspacks_icon);
        if (stickerListAdapter.getItemCount() == 0) {
            linearLayout.setVisibility(View.VISIBLE);
        } else {
            linearLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_stickers, container, false);
        ads();
        this.initRecyclerView();
        this.initButtons();
        this.initSwipeRefresh();
        this.verifyStickersCount();
        return view;
    }
}
