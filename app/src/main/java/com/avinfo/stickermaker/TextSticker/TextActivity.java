package com.avinfo.stickermaker.TextSticker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.avinfo.stickermaker.MultiTouch.MultiTouchListener;
import com.avinfo.stickermaker.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TextActivity extends AppCompatActivity {

    String[] color1 = new String[]{"#5D8AA8","#F0F8FF","#E32636","#E52B50","#FFBF00","#A4C639","#8DB600","#FBCEB1","#7FFFD4","#4B5320",
                "#3B444B","#E9D66B","#B2BEB5","#87A96B","#FF9966","#6D351A","#007FFF","#89CFF0","#A1CAF1","#F4C2C2",
                "#FFD12A","#848482","#98777B","#F5F5DC","#3D2B1F","#000000","#318CE7","#FAF0BE","#0000FF","#DE5D83",
                "#79443B","#CC0000","#B5A642","#66FF00","#BF94E4","#C32148","#FF007F","#08E8DE","#D19FE8","#004225",
                "#CD7F32","#964B00","#FFC1CC","#E7FEFF","#F0DC82","#800020","#DEB887","#CC5500","#E97451","#8A3324",
                "#BD33A4","#702963","#536878","#006B3C","#ED872D","#E30022","#A3C1AD","#78866B","#FFEF00","#FF0800",
                "#C41E3A","#00CC99","#960018","#99BADD","#ED9121","#92A1CF","#ACE1AF","#007BA7","#2A52BE","#A0785A",
                "#F7E7CE","#36454F","#DFFF00","#DE3163","#FFB7C5","#CD5C5C","#7B3F00","#FFA700","#98817B","#E34234",
                "#D2691E","#E4D00A","#FBCCE7","#00FF6F","#0047AB","#9BDDFF","#002E63","#8C92AC","#B87333","#FF3800",
                "#FF7F50","#893F45","#FBEC5D","#B31B1B","#6495ED","#FFF8DC","#FFFDD0","#DC143C","#00FFFF","#FFFF31",
                "#F0E130","#00008B","#654321","#5D3954","#A40000","#08457E","#986960","#CD5B45","#008B8B","#B8860B",
                "#013220","#1A2421","#BDB76B","#483C32","#734F96","#8B008B","#003366","#556B2F","#FF8C00","#779ECB",
                "#03C03C","#966FD6","#C23B22","#E75480","#003399","#872657","#E9967A","#560319","#3C1414","#2F4F4F",
                "#177245","#918151","#FFA812","#CC4E5C","#9400D3","#555555","#1560BD","#C19A6B","#EDC9AF","#696969",
                "#85BB65","#00009C","#E1A95F","#614051","#50C878","#E5AA70","#FF1C00","#CE1620","#B22222","#E25822",
                "#FC8EAC","#F7E98E","#014421","#E49B0F","#F8F8FF","#6082B6","#996515","#FFDF00","#DAA520","#808080",
                "#008000","#71A6D2","#FCF75E","#B2EC5D","#138808","#FF5C5C","#E3A857","#002FA7","#FFFFF0","#00A86B",
                "#D73B3E","#C3B091","#B57EDC","#CCCCFF","#FFF0F5","#C4C3D0","#7CFC00","#FFF700","#BFFF00","#FF00FF",
                "#C04000","#800000","#191970","#3EB489","#FFDB58","#000080","#CC7722","#808000","#FF7F00","#002147",
                "#AEC6CF","#836953","#CFCFC4","#77DD77","#F49AC2","#FFB347","#FFD1DC","#B39EB5","#FF6961","#CB99C9",
                "#FDFD96","#FFE5B4","#D1E231","#F0EAD6","#E6E200","#01796F","#FFC0CB","#93C572","#E5E4E2","#8E4585",
                "#FF5A36","#701C1C","#FF7518","#69359C","#E30B5D","#826644","#FF0000","#414833","#65000B","#002366",
                "#E0115F","#B7410E","#FF6700","#F4C430","#FF8C69","#C2B280","#967117","#ECD540","#082567","#321414",
                "#FFF5EE","#704214","#8A795D","#C0C0C0","#CB410B","#87CEEB","#CF71AF","#FFFAFA","#A7FC00","#4682B4",
                "#E4D96F","#FAD6A5","#F28500","#008080","#E2725B","#EEE600","#00755E","#30D5C8","#120A8F","#5B92E5",
                "#F3E5AB","#8F00FF","#F5DEB3","#FFFFFF","#0F4D92","#FFFF00"};

//    public static StickerView mCurrentView;

    int[] smoke = new int[] {R.drawable.thumb1, R.drawable.thumb2, R.drawable.thumb3, R.drawable.thumb4, R.drawable.thumb5, R.drawable.thumb6, R.drawable.thumb7, R.drawable.thumb8, R.drawable.thumb9, R.drawable.thumb10};

//    SeekBar seekBar;

    int flag;

    private static Bitmap b;
    private static Canvas c;
    public static Bitmap framebitmap;
    FrameLayout frameLayout1;
    ImageView sm1,sm2,sm3,save_text;
    TextView text;
    TextView editText;
    LinearLayout colorlayout,fontlayout,smokelayout;
    ImageView keyboard,font,text_smoke,color,done;

    List<ColorData> dataList1 = new ArrayList<>();
    List<TextData> dataList = new ArrayList<>();
    List<SmokeData>dataList2 = new ArrayList<>();

    GridView fontgrid,colorgrid,smokegrid;

    public static Bitmap finalEditedText;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

//        seekBar = (SeekBar)findViewById(R.id.textsize);
        frameLayout1 = (FrameLayout)findViewById(R.id.framelayout1);
        save_text = (ImageView)findViewById(R.id.save_text);
        sm1 = (ImageView)findViewById(R.id.sm1);
        sm2 = (ImageView)findViewById(R.id.sm2);
        sm3 = (ImageView)findViewById(R.id.sm3);
        smokelayout = (LinearLayout)findViewById(R.id.smokelayout);
        smokegrid = (GridView)findViewById(R.id.smokegrid);
        text_smoke = (ImageView)findViewById(R.id.text_smoke);
        color = (ImageView)findViewById(R.id.color);
        colorgrid = (GridView)findViewById(R.id.colorgrid);
        editText = (TextView) findViewById(R.id.edittext);
        fontgrid = (GridView)findViewById(R.id.fontgrid);
        colorlayout = (LinearLayout)findViewById(R.id.colorlayout);
        fontlayout = (LinearLayout)findViewById(R.id.fontlayout);
        keyboard = (ImageView)findViewById(R.id.keyboard);
        font =(ImageView)findViewById(R.id.font);
        done = (ImageView)findViewById(R.id.done);
        text = (TextView)findViewById(R.id.text);

        final Dialog dialog = new Dialog(TextActivity.this);
        dialog.setContentView(R.layout.text_dialog);
        dialog.setTitle("Enter Text..");
        dialog.setCancelable(false);
        final EditText textedit = (EditText)dialog.findViewById(R.id.textedit);
        showSoftKeyboard(textedit);

        Button cancel = dialog.findViewById(R.id.cancel);
        Button ok = (Button)dialog.findViewById(R.id.ok);
        Button clear = (Button)dialog.findViewById(R.id.clear);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = textedit.getText().toString();
                editText.setText(name);
                dialog.dismiss();
            }
        });

        editText.setOnTouchListener(new MultiTouchListener());
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                editText.setTextSize(i);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });

        smokegrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {

                    case 0:
                        sm1.setImageResource(R.drawable._1pre_text_1);
                        sm2.setImageResource(R.drawable._1post_text_1);
                        sm3.setImageResource(0);
                        break;

                    case 1:
                        sm1.setImageResource(R.drawable._2pre_text_1);
                        sm2.setImageResource(R.drawable._2post_text_1);
                        sm3.setImageResource(R.drawable._2post_text_2);
                        break;

                    case 2:
                        sm1.setImageResource(R.drawable._3pre_text_1);
                        sm2.setImageResource(R.drawable._3post_text_1);
                        sm3.setImageResource(R.drawable._3post_text_2);
                        break;

                    case 3:
                        sm1.setImageResource(R.drawable._4pre_text_1);
                        sm2.setImageResource(R.drawable._4post_text_1);
                        sm3.setImageResource(R.drawable._4post_text_2);
                        break;

                    case 4:
                        sm1.setImageResource(R.drawable._5pre_text_1);
                        sm2.setImageResource(R.drawable._5post_text_1);
                        sm3.setImageResource(0);
                        break;

                    case 5:
                        sm1.setImageResource(R.drawable._6pre_text_1);
                        sm2.setImageResource(R.drawable._6post_text_1);
                        sm3.setImageResource(R.drawable._6post_text_2);
                        break;

                    case 6:
                        sm1.setImageResource(R.drawable._7pre_text_1);
                        sm2.setImageResource(R.drawable._7post_text_1);
                        sm3.setImageResource(R.drawable._7post_text_2);
                        break;

                    case 7:
                        sm1.setImageResource(R.drawable._8pre_text_1);
                        sm2.setImageResource(R.drawable._8post_text_1);
                        sm3.setImageResource(0);
                        break;

                    case 8:
                        sm1.setImageResource(R.drawable._9pre_text_1);
                        sm2.setImageResource(R.drawable._9post_text_1);
                        sm3.setImageResource(0);
                        break;

                    case 9:
                        sm1.setImageResource(R.drawable._10pre_text_1);
                        sm2.setImageResource(R.drawable._10post_text_1);
                        sm3.setImageResource(0);
                        break;


                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textedit.setText("");
            }
        });
        dialog.show();

//        done.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                finish();
//                String aa = editText.getText().toString();
//                if (!aa.isEmpty())
//                {
//                    ImageView imageView = new ImageView(TextActivity.this);
//                    frameLayout1.buildDrawingCache();
//                    Bitmap bitmap = frameLayout1.getDrawingCache();
//                    imageView.setImageBitmap(bitmap);
//                    framebitmap = loadBitmapFromView(imageView);
//                    framebitmap = CropBitmapTransparency(framebitmap);
//
//                    final StickerView stickerView = new StickerView(TextActivity.this);
//                    stickerView.setBitmap(framebitmap);
//                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
//                    EditingActivity.frameLayout.addView(stickerView,layoutParams);
//                    setCurrentEdit(stickerView);
//                    stickerView.setOperationListener(new StickerView.OperationListener() {
//                        @Override
//                        public void onDeleteClick() {
//                            EditingActivity.frameLayout.removeView(stickerView);
//                        }
//
//                        @Override
//                        public void onEdit(StickerView stickerView) {
//
//                            mCurrentView.setInEdit(false);
//                            mCurrentView = stickerView;
//                            mCurrentView.setInEdit(true);
//
//                        }
//
//                        @Override
//                        public void onTop(StickerView stickerView) {
//
//                        }
//                    });
//
//
//                }
//
//            }
//        });

//        EditingActivity.frameLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                if (mCurrentView!=null)
//                {
//                    mCurrentView.setInEdit(false);
//                }
//
//                return false;
//            }
//        });

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorgrid.setVisibility(View.GONE);
                fontgrid.setVisibility(View.GONE);
            }
        });

        colorgrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setTextColor(Color.parseColor(color1[i]));
            }
        });

        for (int a=0 ; a<color1.length ; a++)
        {
            ColorData data1 = new ColorData();
            data1.setColor1(color1[a]);
            dataList1.add(data1);
        }

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                smokelayout.setVisibility(View.GONE);
                fontlayout.setVisibility(View.GONE);
                hideSoftKeyboard(editText);

                if (colorlayout.getVisibility()== View.GONE)
                {
                    colorlayout.setVisibility(View.VISIBLE);
                }

                ColorAdapter colorAdapter = new ColorAdapter(TextActivity.this,dataList1);
                colorgrid.setAdapter(colorAdapter);
            }
        });

        for (int s=0 ; s<smoke.length ; s++)
        {
            SmokeData data3 = new SmokeData();
            data3.setSmoke(smoke[s]);
            dataList2.add(data3);
        }

        text_smoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (flag==0)
//                {
//                    editText.setGravity(Gravity.CENTER);
//                    flag = 1;
//                }d
//                else if (flag==1)
//                {
//                    editText.setGravity(Gravity.LEFT);
//                    flag = 2;
//                }
//                else if (flag==2)
//                {
//                    editText.setGravity(Gravity.RIGHT);
//                    flag = 0;
//                }






                fontlayout.setVisibility(View.GONE);
                colorlayout.setVisibility(View.GONE);

                if (smokelayout.getVisibility()==View.GONE)
                {
                    smokelayout.setVisibility(View.VISIBLE);
                }
                else
                {
                    smokegrid.setVisibility(View.GONE);
                }

                SmokeAdapter adapter = new SmokeAdapter(TextActivity.this,dataList2);
                smokegrid.setAdapter(adapter);

            }
        });

        save_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fontlayout.getVisibility()==View.VISIBLE)
                {
                    fontlayout.setVisibility(View.GONE);
                }
                else if (colorlayout.getVisibility()==View.VISIBLE)
                {
                    colorlayout.setVisibility(View.GONE);
                }
                else if (smokelayout.getVisibility()==View.VISIBLE)
                {
                    smokelayout.setVisibility(View.GONE);
                }
                else
                {
                    create_Save_Image();
                }


            }
        });

        keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showSoftKeyboard(editText);
                dialog.show();
                fontlayout.setVisibility(View.GONE);
                colorlayout.setVisibility(View.GONE);
                smokelayout.setVisibility(View.GONE);
            }
        });

        for (int i=0 ; i<51 ; i++)
        {
            TextData data = new TextData();
            data.setFont("Abc");
            dataList.add(data);

        }

        font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                smokelayout.setVisibility(View.GONE);
                colorlayout.setVisibility(View.GONE);
                hideSoftKeyboard(editText);

                if (fontlayout.getVisibility()== View.GONE)
                {
                    fontlayout.setVisibility(View.VISIBLE);
                }

                FontAdapter adapter = new FontAdapter(TextActivity.this,dataList);
                fontgrid.setAdapter(adapter);

            }
        });

        fontgrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0:
                        Typeface typeface0 = Typeface.createFromAsset(getAssets(),"font36.TTF");
                        editText.setTypeface(typeface0);
                        break;

                    case 1:
                        Typeface typeface = Typeface.createFromAsset(getAssets(),"font1.ttf");
                        editText.setTypeface(typeface);
                        break;

                    case 2:
                        Typeface typeface2 = Typeface.createFromAsset(getAssets(),"font2.ttf");
                        editText.setTypeface(typeface2);
                        break;

                    case 3:
                        Typeface typeface3 = Typeface.createFromAsset(getAssets(),"font3.ttf");
                        editText.setTypeface(typeface3);
                        break;

                    case 4:
                        Typeface typeface4 = Typeface.createFromAsset(getAssets(),"font4.TTF");
                        editText.setTypeface(typeface4);
                        break;

                    case 5:
                        Typeface typeface5 = Typeface.createFromAsset(getAssets(),"font5.ttf");
                        editText.setTypeface(typeface5);
                        break;

                    case 6:
                        Typeface typeface6 = Typeface.createFromAsset(getAssets(),"font6.TTF");
                        editText.setTypeface(typeface6);
                        break;

                    case 7:
                        Typeface typeface7 = Typeface.createFromAsset(getAssets(),"font7.ttf");
                        editText.setTypeface(typeface7);
                        break;

                    case 8:
                        Typeface typeface8 = Typeface.createFromAsset(getAssets(),"font8.ttf");
                        editText.setTypeface(typeface8);
                        break;

                    case 9:
                        Typeface typeface9 = Typeface.createFromAsset(getAssets(),"font9.ttf");
                        editText.setTypeface(typeface9);
                        break;

                    case 10:
                        Typeface typeface10 = Typeface.createFromAsset(getAssets(),"font10.TTF");
                        editText.setTypeface(typeface10);
                        break;

                    case 11:
                        Typeface typeface11 = Typeface.createFromAsset(getAssets(),"font11.ttf");
                        editText.setTypeface(typeface11);
                        break;

                    case 12:
                        Typeface typeface12 = Typeface.createFromAsset(getAssets(),"font12.ttf");
                        editText.setTypeface(typeface12);
                        break;

                    case 13:
                        Typeface typeface13 = Typeface.createFromAsset(getAssets(),"font13.otf");
                        editText.setTypeface(typeface13);
                        break;

                    case 14:
                        Typeface typeface14 = Typeface.createFromAsset(getAssets(),"font14.TTF");
                        editText.setTypeface(typeface14);
                        break;

                    case 15:
                        Typeface typeface15 = Typeface.createFromAsset(getAssets(),"font15.ttf");
                        editText.setTypeface(typeface15);
                        break;

                    case 16:
                        Typeface typeface16 = Typeface.createFromAsset(getAssets(),"font16.TTF");
                        editText.setTypeface(typeface16);
                        break;

                    case 17:
                        Typeface typeface17 = Typeface.createFromAsset(getAssets(),"font17.ttf");
                        editText.setTypeface(typeface17);
                        break;

                    case 18:
                        Typeface typeface18 = Typeface.createFromAsset(getAssets(),"font18.ttf");
                        editText.setTypeface(typeface18);
                        break;

                    case 19:
                        Typeface typeface19 = Typeface.createFromAsset(getAssets(),"font19.ttf");
                        editText.setTypeface(typeface19);
                        break;

                    case 20:
                        Typeface typeface20 = Typeface.createFromAsset(getAssets(),"font20.ttf");
                        editText.setTypeface(typeface20);
                        break;
                    case 21:
                        Typeface typeface21 = Typeface.createFromAsset(getAssets(),"font21.ttf");
                        editText.setTypeface(typeface21);
                        break;
                    case 22:
                        Typeface typeface22 = Typeface.createFromAsset(getAssets(),"font22.ttf");
                        editText.setTypeface(typeface22);
                        break;

                    case 23:
                        Typeface typeface23 = Typeface.createFromAsset(getAssets(),"font23.ttf");
                        editText.setTypeface(typeface23);
                        break;

                    case 24:
                        Typeface typeface24 = Typeface.createFromAsset(getAssets(),"font24.ttf");
                        editText.setTypeface(typeface24);
                        break;

                    case 25:
                        Typeface typeface25 = Typeface.createFromAsset(getAssets(),"font25.ttf");
                        editText.setTypeface(typeface25);
                        break;

                    case 26:
                        Typeface typeface26 = Typeface.createFromAsset(getAssets(),"font26.ttf");
                        editText.setTypeface(typeface26);
                        break;

                    case 27:
                        Typeface typeface27 = Typeface.createFromAsset(getAssets(),"font27.ttf");
                        editText.setTypeface(typeface27);
                        break;

                    case 28:
                        Typeface typeface28 = Typeface.createFromAsset(getAssets(),"font28.TTF");
                        editText.setTypeface(typeface28);
                        break;

                    case 29:
                        Typeface typeface29 = Typeface.createFromAsset(getAssets(),"font29.ttf");
                        editText.setTypeface(typeface29);
                        break;

                    case 30:
                        Typeface typeface30 = Typeface.createFromAsset(getAssets(),"font30.ttf");
                        editText.setTypeface(typeface30);
                        break;

                    case 31:
                        Typeface typeface31 = Typeface.createFromAsset(getAssets(),"font31.otf");
                        editText.setTypeface(typeface31);
                        break;

                    case 32:
                        Typeface typeface32 = Typeface.createFromAsset(getAssets(),"font32.ttf");
                        editText.setTypeface(typeface32);
                        break;

                    case 33:
                        Typeface typeface33 = Typeface.createFromAsset(getAssets(),"font33.OTF");
                        editText.setTypeface(typeface33);
                        break;

                    case 34:
                        Typeface typeface34 = Typeface.createFromAsset(getAssets(),"font34.ttf");
                        editText.setTypeface(typeface34);
                        break;

                    case 35:
                        Typeface typeface35 = Typeface.createFromAsset(getAssets(),"font35.TTF");
                        editText.setTypeface(typeface35);
                        break;

                    case 36:
                        Typeface typeface36 = Typeface.createFromAsset(getAssets(),"font37.otf");
                        editText.setTypeface(typeface36);
                        break;

                    case 37:
                        Typeface typeface37 = Typeface.createFromAsset(getAssets(),"font38.otf");
                        editText.setTypeface(typeface37);
                        break;

                    case 38:
                        Typeface typeface38 = Typeface.createFromAsset(getAssets(),"font39.otf");
                        editText.setTypeface(typeface38);
                        break;

                    case 39:
                        Typeface typeface39 = Typeface.createFromAsset(getAssets(),"font40.otf");
                        editText.setTypeface(typeface39);
                        break;

                    case 40:
                        Typeface typeface40 = Typeface.createFromAsset(getAssets(),"font41.otf");
                        editText.setTypeface(typeface40);
                        break;

                    case 41:
                        Typeface typeface41 = Typeface.createFromAsset(getAssets(),"font42.otf");
                        editText.setTypeface(typeface41);
                        break;

                    case 42:
                        Typeface typeface42 = Typeface.createFromAsset(getAssets(),"font43.otf");
                        editText.setTypeface(typeface42);
                        break;

                    case 43:
                        Typeface typeface43 = Typeface.createFromAsset(getAssets(),"font44.otf");
                        editText.setTypeface(typeface43);
                        break;

                    case 44:
                        Typeface typeface44 = Typeface.createFromAsset(getAssets(),"font45.otf");
                        editText.setTypeface(typeface44);
                        break;

                    case 45:
                        Typeface typeface45 = Typeface.createFromAsset(getAssets(),"font46.otf");
                        editText.setTypeface(typeface45);
                        break;

                    case 46:
                        Typeface typeface46 = Typeface.createFromAsset(getAssets(),"font47.otf");
                        editText.setTypeface(typeface46);
                        break;

                    case 47:
                        Typeface typeface47 = Typeface.createFromAsset(getAssets(),"font48.otf");
                        editText.setTypeface(typeface47);
                        break;

                    case 48:
                        Typeface typeface48 = Typeface.createFromAsset(getAssets(),"font49.otf");
                        editText.setTypeface(typeface48);
                        break;

                    case 49:
                        Typeface typeface49 = Typeface.createFromAsset(getAssets(),"font50.otf");
                        editText.setTypeface(typeface49);
                        break;

                    case 50:
                        Typeface typeface50 = Typeface.createFromAsset(getAssets(),"font51.otf");
                        editText.setTypeface(typeface50);
                        break;

                    case 51:
                        Typeface typeface51 = Typeface.createFromAsset(getAssets(),"font52.otf");
                        editText.setTypeface(typeface51);
                        break;

                    case 52:
                        Typeface typeface52 = Typeface.createFromAsset(getAssets(),"font53.otf");
                        editText.setTypeface(typeface52);
                        break;

                    case 53:
                        Typeface typeface53 = Typeface.createFromAsset(getAssets(),"font54.otf");
                        editText.setTypeface(typeface53);
                        break;

                    case 54:
                        Typeface typeface54 = Typeface.createFromAsset(getAssets(),"font55.otf");
                        editText.setTypeface(typeface54);
                        break;

                    case 55:
                        Typeface typeface55 = Typeface.createFromAsset(getAssets(),"font56.otf");
                        editText.setTypeface(typeface55);
                        break;

                    case 56:
                        Typeface typeface56 = Typeface.createFromAsset(getAssets(),"font57.otf");
                        editText.setTypeface(typeface56);
                        break;

                    case 57:
                        Typeface typeface57 = Typeface.createFromAsset(getAssets(),"font58.otf");
                        editText.setTypeface(typeface57);
                        break;

                    case 58:
                        Typeface typeface58 = Typeface.createFromAsset(getAssets(),"font59.otf");
                        editText.setTypeface(typeface58);
                        break;

                    case 59:
                        Typeface typeface59 = Typeface.createFromAsset(getAssets(),"font60.otf");
                        editText.setTypeface(typeface59);
                        break;

                    case 60:
                        Typeface typeface60 = Typeface.createFromAsset(getAssets(),"font61.otf");
                        editText.setTypeface(typeface60);
                        break;

                    case 61:
                        Typeface typeface61 = Typeface.createFromAsset(getAssets(),"font62.otf");
                        editText.setTypeface(typeface61);
                        break;

                    case 62:
                        Typeface typeface62 = Typeface.createFromAsset(getAssets(),"font63.otf");
                        editText.setTypeface(typeface62);
                        break;

                    case 63:
                        Typeface typeface63 = Typeface.createFromAsset(getAssets(),"font64.otf");
                        editText.setTypeface(typeface63);
                        break;

                    case 64:
                        Typeface typeface64 = Typeface.createFromAsset(getAssets(),"font65.otf");
                        editText.setTypeface(typeface64);
                        break;

                    case 65:
                        Typeface typeface65 = Typeface.createFromAsset(getAssets(),"font66.otf");
                        editText.setTypeface(typeface65);
                        break;

                    case 66:
                        Typeface typeface66 = Typeface.createFromAsset(getAssets(),"font67.otf");
                        editText.setTypeface(typeface66);
                        break;

                    case 67:
                        Typeface typeface67 = Typeface.createFromAsset(getAssets(),"font68.otf");
                        editText.setTypeface(typeface67);
                        break;

                    case 68:
                        Typeface typeface68 = Typeface.createFromAsset(getAssets(),"font69.otf");
                        editText.setTypeface(typeface68);
                        break;

                    case 69:
                        Typeface typeface69 = Typeface.createFromAsset(getAssets(),"font70.otf");
                        editText.setTypeface(typeface69);
                        break;

                    case 70:
                        Typeface typeface70 = Typeface.createFromAsset(getAssets(),"font71.otf");
                        editText.setTypeface(typeface70);
                        break;

                    case 71:
                        Typeface typeface71 = Typeface.createFromAsset(getAssets(),"font72.otf");
                        editText.setTypeface(typeface71);
                        break;

                    case 72:
                        Typeface typeface72 = Typeface.createFromAsset(getAssets(),"font73.otf");
                        editText.setTypeface(typeface72);
                        break;

                    case 73:
                        Typeface typeface73 = Typeface.createFromAsset(getAssets(),"font74.otf");
                        editText.setTypeface(typeface73);
                        break;

                    case 74:
                        Typeface typeface74 = Typeface.createFromAsset(getAssets(),"font75.otf");
                        editText.setTypeface(typeface74);
                        break;

                    case 75:
                        Typeface typeface75 = Typeface.createFromAsset(getAssets(),"font76.otf");
                        editText.setTypeface(typeface75);
                        break;

                    case 76:
                        Typeface typeface76 = Typeface.createFromAsset(getAssets(),"font77.otf");
                        editText.setTypeface(typeface76);
                        break;

                    case 77:
                        Typeface typeface77 = Typeface.createFromAsset(getAssets(),"font78.otf");
                        editText.setTypeface(typeface77);
                        break;

                    case 78:
                        Typeface typeface78 = Typeface.createFromAsset(getAssets(),"font79.otf");
                        editText.setTypeface(typeface78);
                        break;

                    case 79:
                        Typeface typeface79 = Typeface.createFromAsset(getAssets(),"font80.otf");
                        editText.setTypeface(typeface79);
                        break;

                    case 80:
                        Typeface typeface80 = Typeface.createFromAsset(getAssets(),"font81.ttf");
                        editText.setTypeface(typeface80);
                        break;

                    case 81:
                        Typeface typeface81 = Typeface.createFromAsset(getAssets(),"font82.ttf");
                        editText.setTypeface(typeface81);
                        break;

                    case 82:
                        Typeface typeface82 = Typeface.createFromAsset(getAssets(),"font83.ttf");
                        editText.setTypeface(typeface82);
                        break;

                    case 83:
                        Typeface typeface83 = Typeface.createFromAsset(getAssets(),"font84.ttf");
                        editText.setTypeface(typeface83);
                        break;

                    case 84:
                        Typeface typeface84 = Typeface.createFromAsset(getAssets(),"font85.ttf");
                        editText.setTypeface(typeface84);
                        break;

                    case 85:
                        Typeface typeface85 = Typeface.createFromAsset(getAssets(),"font86.ttf");
                        editText.setTypeface(typeface85);
                        break;

                    case 86:
                        Typeface typeface86 = Typeface.createFromAsset(getAssets(),"font87.ttf");
                        editText.setTypeface(typeface86);
                        break;

                    case 87:
                        Typeface typeface87 = Typeface.createFromAsset(getAssets(),"font88.ttf");
                        editText.setTypeface(typeface87);
                        break;

                    case 88:
                        Typeface typeface88 = Typeface.createFromAsset(getAssets(),"font89.ttf");
                        editText.setTypeface(typeface88);
                        break;

                    case 89:
                        Typeface typeface89 = Typeface.createFromAsset(getAssets(),"font90.ttf");
                        editText.setTypeface(typeface89);
                        break;

                    case 90:
                        Typeface typeface90 = Typeface.createFromAsset(getAssets(),"font91.ttf");
                        editText.setTypeface(typeface90);
                        break;

                    case 91:
                        Typeface typeface91 = Typeface.createFromAsset(getAssets(),"font92.ttf");
                        editText.setTypeface(typeface91);
                        break;

                    case 92:
                        Typeface typeface92 = Typeface.createFromAsset(getAssets(),"font93.ttf");
                        editText.setTypeface(typeface92);
                        break;

                    case 93:
                        Typeface typeface93 = Typeface.createFromAsset(getAssets(),"font94.ttf");
                        editText.setTypeface(typeface93);
                        break;

                    case 94:
                        Typeface typeface94 = Typeface.createFromAsset(getAssets(),"font95.ttf");
                        editText.setTypeface(typeface94);
                        break;

                    case 95:
                        Typeface typeface95 = Typeface.createFromAsset(getAssets(),"font96.ttf");
                        editText.setTypeface(typeface95);
                        break;

                    case 96:
                        Typeface typeface96 = Typeface.createFromAsset(getAssets(),"font97.ttf");
                        editText.setTypeface(typeface96);
                        break;

                    case 97:
                        Typeface typeface97 = Typeface.createFromAsset(getAssets(),"font98.ttf");
                        editText.setTypeface(typeface97);
                        break;

                    case 98:
                        Typeface typeface98 = Typeface.createFromAsset(getAssets(),"font99.ttf");
                        editText.setTypeface(typeface98);
                        break;
                    







                }
                
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_sticker_pack, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.save_sticker_pack) {
            if (fontlayout.getVisibility()==View.VISIBLE)
            {
                fontlayout.setVisibility(View.GONE);
            }
            else if (colorlayout.getVisibility()==View.VISIBLE)
            {
                colorlayout.setVisibility(View.GONE);
            }
            else if (smokelayout.getVisibility()==View.VISIBLE)
            {
                smokelayout.setVisibility(View.GONE);
            }
            else
            {
                create_Save_Image();
            }


        }
        return super.onOptionsItemSelected(item);
    }


    public void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(TextActivity.this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(TextActivity.this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    Bitmap CropBitmapTransparency(Bitmap sourceBitmap) {
        int minX = sourceBitmap.getWidth();
        int minY = sourceBitmap.getHeight();
        int maxX = -1;
        int maxY = -1;
        for (int y = 0; y < sourceBitmap.getHeight(); y++) {
            for (int x = 0; x < sourceBitmap.getWidth(); x++) {
                int alpha = (sourceBitmap.getPixel(x, y) >> 24) & 255;
                if (alpha > 0)   // pixel is not 100% transparent
                {
                    if (x < minX)
                        minX = x;
                    if (x > maxX)
                        maxX = x;
                    if (y < minY)
                        minY = y;
                    if (y > maxY)
                        maxY = y;
                }
            }
        }
        if ((maxX < minX) || (maxY < minY))
            return null; // Bitmap is entirely transparent

        // crop bitmap to non-transparent area and return:
        return Bitmap.createBitmap(sourceBitmap, minX, minY, (maxX - minX) + 1, (maxY - minY) + 1);
    }

    public static Bitmap loadBitmapFromView(View v) {
        if (v.getMeasuredHeight() <= 0) {
            v.measure(-2, -2);
            b = Bitmap.createBitmap(v.getMeasuredWidth(), v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            c = new Canvas(b);
            v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
            v.draw(c);
            return b;
        }
        b = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        return b;
    }

//    private void setCurrentEdit(final StickerView stickerView) {
//        if (mCurrentView != null) {
//            mCurrentView.setInEdit(false);
//        }
//        mCurrentView = stickerView;
//        stickerView.setInEdit(true);
//
//
//    }


    @Override
    public void onBackPressed() {

        if (fontlayout.getVisibility()==View.VISIBLE)
        {
            fontlayout.setVisibility(View.GONE);
        }
        else if (colorlayout.getVisibility()==View.VISIBLE)
        {
            colorlayout.setVisibility(View.GONE);
        }
        else if (smokelayout.getVisibility()==View.VISIBLE)
        {
            smokelayout.setVisibility(View.GONE);
        }
        else
        {
            finish();
        }


    }

    public Bitmap finalEditedImage;
    private void create_Save_Image() {
        finalEditedImage = getMainFrameBitmap(frameLayout1);
        saveImage(finalEditedImage);
    }


    private Bitmap getMainFrameBitmap(View view) {

        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    private void saveImage(Bitmap bitmap2) {
        finish();
        Log.v("TAG", "saveImageInCache is called");
        Bitmap bitmap;
        OutputStream output;

        // Retrieve the image from the res folder
        bitmap = bitmap2;

        File filepath = Environment.getExternalStorageDirectory();
        // Create a new folder in SD Card
        File dir = new File(filepath.getAbsolutePath() + "/" + "stickersCreated");
        dir.mkdirs();

        // Create a name for the saved image
        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String FileName = ts + ".PNG";
        File file = new File(dir, FileName);
        file.renameTo(file);
        String _uri = "file://" + filepath.getAbsolutePath() + "/" + "stickersCreated" + "/" + FileName;
        //for share image
        String _uri2 = filepath.getAbsolutePath() + "/" + "stickersCreated" + "/" + FileName;
        String _url = _uri2;//used in share image
        Toast.makeText(this, "Save Text Done PNG", Toast.LENGTH_SHORT).show();
        Log.d("cache uri=", _uri);
        MediaScannerConnection.scanFile(this, new String[]{_url}, null, new MediaScannerConnection.OnScanCompletedListener() {
            public void onScanCompleted(String path, Uri uri) {
                Log.i("ExternalStorage", "Scanned " + path + ":");
                Log.i("ExternalStorage", "-> uri=" + uri);
            }
        });
        try {
            output = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
            output.flush();
            output.close();


        } catch (Exception e) {
//             TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

//      TODO ColorAdapter
class ColorAdapter extends BaseAdapter {

    Activity activity;
    List<ColorData> dataList;
    LayoutInflater inflater;

    public ColorAdapter(TextActivity textActivity, List<ColorData> dataList) {

        activity = textActivity;
        this.dataList = dataList;
        inflater = LayoutInflater.from(textActivity);

    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.color_grid,viewGroup,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.colorbox);
        imageView.setBackgroundColor(Color.parseColor(  dataList.get(i).getColor1()));

        return view;
    }
}

//      TODO SmokeAdapter
class SmokeAdapter extends BaseAdapter{

    Activity activity;
    List<SmokeData>dataList2;
    LayoutInflater inflater;

    public SmokeAdapter(TextActivity textActivity, List<SmokeData> dataList2) {

        activity = textActivity;
        this.dataList2 = dataList2;
        inflater = LayoutInflater.from(textActivity);

    }

    @Override
    public int getCount() {
        return dataList2.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.smoke_grid,viewGroup,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.smoke_item);
        imageView.setImageResource(dataList2.get(i).getSmoke());

        return view;
    }
}