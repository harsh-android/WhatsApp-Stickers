package com.avinfo.stickermaker.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter;
import com.sangcomz.fishbun.define.Define;
import com.avinfo.stickermaker.R;
import com.avinfo.stickermaker.TextSticker.TextActivity;
import com.avinfo.stickermaker.backRemover.CutOut;
import com.avinfo.stickermaker.constants.ConstantsData;
import com.avinfo.stickermaker.utils.FileUtils;
import com.avinfo.stickermaker.utils.StickerPacksManager;

import java.io.File;
import java.util.ArrayList;

public class CreateStickerFragment extends Fragment {
    ImagesGridAdapter imagesGridAdapter;
    View view;
    private InterstitialAd mInterstitialAd;

    public CreateStickerFragment() {
        // Required empty public constructor
    }

    private ArrayList<Uri> loadStickersCreated() {
        String directoryPath = ConstantsData.STICKERS_CREATED_DIRECTORY_PATH;
        File directory = new File(directoryPath);
        ArrayList<Uri> images = new ArrayList<>();
        if (directory.exists()) {
            File[] stickersImages = directory.listFiles();
            for (File f : stickersImages) {
                if (f.isFile() && (f.getName().contains(".png") || f.getName().contains(".PNG"))) {
                    images.add(Uri.fromFile((f)));
                }
            }
        } else {
            directory.mkdir();
        }
        verifyStickersCount();
        return images;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_create, container, false);
        view.findViewById(R.id.create_sticker).setOnClickListener(v -> FishBun.with(getActivity())
                .setImageAdapter(new GlideAdapter())
                .setMaxCount(1)
                .exceptGif(true)
                .setMinCount(1)
                .setActionBarColor(Color.parseColor("#128c7e"), Color.parseColor("#128c7e"), false)
                .setActionBarTitleColor(Color.parseColor("#ffffff"))
                .startAlbum());

        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getString(R.string.instretial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        AdView adView = new AdView(getContext());
        adView.setAdSize(AdSize.BANNER);
        adView.setMinimumWidth(AdSize.FULL_WIDTH);
        adView.setAdUnitId(getString(R.string.banner1));
        adView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        FloatingActionButton textsticker = view.findViewById(R.id.textsticker);
        textsticker.setOnClickListener(view -> {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
                Intent intent = new Intent(getActivity(), TextActivity.class);
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
                Intent intent = new Intent(getActivity(), TextActivity.class);
                startActivity(intent);
                // Code to be executed when the interstitial ad is closed.
            }
        });

        RecyclerView gridview = view.findViewById(R.id.stickers_created_grid);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 3);
        gridview.setLayoutManager(gridLayoutManager);
        imagesGridAdapter = new ImagesGridAdapter(view.getContext(), loadStickersCreated());
        gridview.setAdapter(imagesGridAdapter);
        verifyStickersCount();
        return view;
    }

    public void verifyStickersCount() {
        View linearLayout = view.findViewById(R.id.no_stickers_icon);
        if (imagesGridAdapter == null || imagesGridAdapter.getItemCount() == 0) {
            linearLayout.setVisibility(View.VISIBLE);
        } else {
            linearLayout.setVisibility(View.GONE);
        }
    }

    public static void addImageToGallery(final String filePath, final Context context) {

        ContentValues values = new ContentValues();

        values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.MediaColumns.DATA, filePath);

        context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CutOut.CUTOUT_ACTIVITY_REQUEST_CODE) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    Uri imageUri = CutOut.getUri(data);
                    String stickerName = FileUtils.generateRandomIdentifier();
                    Uri imagePath = Uri.parse(ConstantsData.STICKERS_CREATED_DIRECTORY_PATH + stickerName + ".PNG");
                    StickerPacksManager.createStickerImageFile(imageUri, imagePath, getActivity(), Bitmap.CompressFormat.PNG);
                    addImageToGallery(imagePath.getPath(), getActivity());
                    imagesGridAdapter.uries = loadStickersCreated();
                    imagesGridAdapter.notifyDataSetChanged();
                    Toast.makeText(getActivity(), "Sticker created", Toast.LENGTH_LONG).show();
                    verifyStickersCount();
                    break;
                case CutOut.CUTOUT_ACTIVITY_RESULT_ERROR_CODE:
                    Exception ex = CutOut.getError(data);
                    break;
                default:
                    System.out.print("User cancelled the CutOut screen");
            }
        } else if (requestCode == Define.ALBUM_REQUEST_CODE) {
            ArrayList<Uri> uries;
            if (resultCode == Activity.RESULT_OK) {
                uries = data.getParcelableArrayListExtra(Define.INTENT_PATH);
                CutOut.activity().src(uries.get(0)).intro().start(getActivity());
            }
        }
    }

    class ImagesGridAdapter extends RecyclerView.Adapter<ImageViewHolder> {
        ArrayList<Uri> uries = new ArrayList<>();
        Context context;

        public ImagesGridAdapter(Context context, ArrayList<Uri> uries) {
            this.uries = uries;
            this.context = context;
        }

        @NonNull
        @Override
        public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            final Context context = viewGroup.getContext();
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            final View view = layoutInflater.inflate(R.layout.sticker_created_item, viewGroup, false);
            return new ImageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ImageViewHolder imageAdapter, int index) {
            imageAdapter.imageView.setImageURI(uries.get(index));
            imageAdapter.imageView.setPadding(8, 8, 8, 8);
            imageAdapter.imageView.setOnLongClickListener(v -> {
                PopupMenu popupMenu = new PopupMenu(context, imageAdapter.imageView);
                popupMenu.inflate(R.menu.sticker_menu);
                popupMenu.setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.add_to_exist_stickerpack:
                            addToStickerPack(index);
                            break;
                        case R.id.delete_sticker:
                            this.deleteSticker(index);
                            break;
                        default:
                            break;
                    }
                    return false;
                });
                popupMenu.show();
                return false;
            });
        }

        void deleteSticker(int index) {
            new AlertDialog.Builder(context)
                    .setTitle("Deleting")
                    .setMessage("Are you sure you want to delete this sticker?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        Uri uri = uries.get(index);
                        FileUtils.deleteFile(uri.getPath(),context);
                        uries.remove(index);
                        notifyItemRemoved(index);
                        notifyDataSetChanged();
                        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                        verifyStickersCount();
                    })
                    .setNegativeButton("No", null)
                    .show();
        }

        void addToStickerPack(int index) {
            Intent intent = new Intent(context, AddStickerPackActivity.class);
            intent.setData(uries.get(index));
            startActivity(intent);
        }

        @Override
        public int getItemCount() {
            return uries.size();
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.sticker_created_image);
        }

    }
}
