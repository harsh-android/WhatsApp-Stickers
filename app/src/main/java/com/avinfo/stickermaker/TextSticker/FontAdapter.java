package com.avinfo.stickermaker.TextSticker;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.avinfo.stickermaker.R;

import java.util.List;


public class FontAdapter extends BaseAdapter {

    Activity activity;
    List<TextData> dataList;
    LayoutInflater inflater;

    public FontAdapter(TextActivity textActivity, List<TextData> dataList) {

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

        view = inflater.inflate(R.layout.font_layout,viewGroup,false);
       TextView textView = (TextView)view.findViewById(R.id.font_item);
        textView.setText(dataList.get(i).getFont());


        switch (i)
        {
            case 0:
                Typeface typeface0 = Typeface.createFromAsset(activity.getAssets(),"font36.TTF");
                textView.setTypeface(typeface0);
                break;

            case 1:
                Typeface typeface = Typeface.createFromAsset(activity.getAssets(),"font1.ttf");
                textView.setTypeface(typeface);
                break;

            case 2:
                Typeface typeface2 = Typeface.createFromAsset(activity.getAssets(),"font2.ttf");
                textView.setTypeface(typeface2);
                break;

            case 3:
                Typeface typeface3 = Typeface.createFromAsset(activity.getAssets(),"font3.ttf");
                textView.setTypeface(typeface3);
                break;

            case 4:
                Typeface typeface4 = Typeface.createFromAsset(activity.getAssets(),"font4.TTF");
                textView.setTypeface(typeface4);
                break;

            case 5:
                Typeface typeface5 = Typeface.createFromAsset(activity.getAssets(),"font5.ttf");
                textView.setTypeface(typeface5);
                break;

            case 6:
                Typeface typeface6 = Typeface.createFromAsset(activity.getAssets(),"font6.TTF");
                textView.setTypeface(typeface6);
                break;

            case 7:
                Typeface typeface7 = Typeface.createFromAsset(activity.getAssets(),"font7.ttf");
                textView.setTypeface(typeface7);
                break;

            case 8:
                Typeface typeface8 = Typeface.createFromAsset(activity.getAssets(),"font8.ttf");
                textView.setTypeface(typeface8);
                break;

            case 9:
                Typeface typeface9 = Typeface.createFromAsset(activity.getAssets(),"font9.ttf");
                textView.setTypeface(typeface9);
                break;

            case 10:
                Typeface typeface10 = Typeface.createFromAsset(activity.getAssets(),"font10.TTF");
                textView.setTypeface(typeface10);
                break;

            case 11:
                Typeface typeface11 = Typeface.createFromAsset(activity.getAssets(),"font11.ttf");
                textView.setTypeface(typeface11);
                break;

            case 12:
                Typeface typeface12 = Typeface.createFromAsset(activity.getAssets(),"font12.ttf");
                textView.setTypeface(typeface12);
                break;

            case 13:
                Typeface typeface13 = Typeface.createFromAsset(activity.getAssets(),"font13.otf");
                textView.setTypeface(typeface13);
                break;

            case 14:
                Typeface typeface14 = Typeface.createFromAsset(activity.getAssets(),"font14.TTF");
                textView.setTypeface(typeface14);
                break;

            case 15:
                Typeface typeface15 = Typeface.createFromAsset(activity.getAssets(),"font15.ttf");
                textView.setTypeface(typeface15);
                break;

            case 16:
                Typeface typeface16 = Typeface.createFromAsset(activity.getAssets(),"font16.TTF");
                textView.setTypeface(typeface16);
                break;

            case 17:
                Typeface typeface17 = Typeface.createFromAsset(activity.getAssets(),"font17.ttf");
                textView.setTypeface(typeface17);
                break;

            case 18:
                Typeface typeface18 = Typeface.createFromAsset(activity.getAssets(),"font18.ttf");
                textView.setTypeface(typeface18);
                break;

            case 19:
                Typeface typeface19 = Typeface.createFromAsset(activity.getAssets(),"font19.ttf");
                textView.setTypeface(typeface19);
                break;

            case 20:
                Typeface typeface20 = Typeface.createFromAsset(activity.getAssets(),"font20.ttf");
                textView.setTypeface(typeface20);
                break;
            case 21:
                Typeface typeface21 = Typeface.createFromAsset(activity.getAssets(),"font21.ttf");
                textView.setTypeface(typeface21);
                break;
            case 22:
                Typeface typeface22 = Typeface.createFromAsset(activity.getAssets(),"font22.ttf");
                textView.setTypeface(typeface22);
                break;

            case 23:
                Typeface typeface23 = Typeface.createFromAsset(activity.getAssets(),"font23.ttf");
                textView.setTypeface(typeface23);
                break;

            case 24:
                Typeface typeface24 = Typeface.createFromAsset(activity.getAssets(),"font24.ttf");
                textView.setTypeface(typeface24);
                break;

            case 25:
                Typeface typeface25 = Typeface.createFromAsset(activity.getAssets(),"font25.ttf");
                textView.setTypeface(typeface25);
                break;

            case 26:
                Typeface typeface26 = Typeface.createFromAsset(activity.getAssets(),"font26.ttf");
                textView.setTypeface(typeface26);
                break;

            case 27:
                Typeface typeface27 = Typeface.createFromAsset(activity.getAssets(),"font27.ttf");
                textView.setTypeface(typeface27);
                break;

            case 28:
                Typeface typeface28 = Typeface.createFromAsset(activity.getAssets(),"font28.TTF");
                textView.setTypeface(typeface28);
                break;

            case 29:
                Typeface typeface29 = Typeface.createFromAsset(activity.getAssets(),"font29.ttf");
                textView.setTypeface(typeface29);
                break;

            case 30:
                Typeface typeface30 = Typeface.createFromAsset(activity.getAssets(),"font30.ttf");
                textView.setTypeface(typeface30);
                break;

            case 31:
                Typeface typeface31 = Typeface.createFromAsset(activity.getAssets(),"font31.otf");
                textView.setTypeface(typeface31);
                break;

            case 32:
                Typeface typeface32 = Typeface.createFromAsset(activity.getAssets(),"font32.ttf");
                textView.setTypeface(typeface32);
                break;

            case 33:
                Typeface typeface33 = Typeface.createFromAsset(activity.getAssets(),"font33.OTF");
                textView.setTypeface(typeface33);
                break;

            case 34:
                Typeface typeface34 = Typeface.createFromAsset(activity.getAssets(),"font34.ttf");
                textView.setTypeface(typeface34);
                break;

            case 35:
                Typeface typeface35 = Typeface.createFromAsset(activity.getAssets(),"font35.TTF");
                textView.setTypeface(typeface35);
                break;

            case 36:
                Typeface typeface36 = Typeface.createFromAsset(activity.getAssets(),"font37.otf");
                textView.setTypeface(typeface36);
                break;

            case 37:
                Typeface typeface37 = Typeface.createFromAsset(activity.getAssets(),"font38.otf");
                textView.setTypeface(typeface37);
                break;

            case 38:
                Typeface typeface38 = Typeface.createFromAsset(activity.getAssets(),"font39.otf");
                textView.setTypeface(typeface38);
                break;

            case 39:
                Typeface typeface39 = Typeface.createFromAsset(activity.getAssets(),"font40.otf");
                textView.setTypeface(typeface39);
                break;

            case 40:
                Typeface typeface40 = Typeface.createFromAsset(activity.getAssets(),"font41.otf");
                textView.setTypeface(typeface40);
                break;

            case 41:
                Typeface typeface41 = Typeface.createFromAsset(activity.getAssets(),"font42.otf");
                textView.setTypeface(typeface41);
                break;

            case 42:
                Typeface typeface42 = Typeface.createFromAsset(activity.getAssets(),"font43.otf");
                textView.setTypeface(typeface42);
                break;

            case 43:
                Typeface typeface43 = Typeface.createFromAsset(activity.getAssets(),"font44.otf");
                textView.setTypeface(typeface43);
                break;

            case 44:
                Typeface typeface44 = Typeface.createFromAsset(activity.getAssets(),"font45.otf");
                textView.setTypeface(typeface44);
                break;

            case 45:
                Typeface typeface45 = Typeface.createFromAsset(activity.getAssets(),"font46.otf");
                textView.setTypeface(typeface45);
                break;

            case 46:
                Typeface typeface46 = Typeface.createFromAsset(activity.getAssets(),"font47.otf");
                textView.setTypeface(typeface46);
                break;

            case 47:
                Typeface typeface47 = Typeface.createFromAsset(activity.getAssets(),"font48.otf");
                textView.setTypeface(typeface47);
                break;

            case 48:
                Typeface typeface48 = Typeface.createFromAsset(activity.getAssets(),"font49.otf");
                textView.setTypeface(typeface48);
                break;

            case 49:
                Typeface typeface49 = Typeface.createFromAsset(activity.getAssets(),"font50.otf");
                textView.setTypeface(typeface49);
                break;

            case 50:
                Typeface typeface50 = Typeface.createFromAsset(activity.getAssets(),"font51.otf");
                textView.setTypeface(typeface50);
                break;

//            case 51:
//                Typeface typeface51 = Typeface.createFromAsset(activity.getAssets(),"font52.otf");
//                textView.setTypeface(typeface51);
//                break;
//
//            case 52:
//                Typeface typeface52 = Typeface.createFromAsset(activity.getAssets(),"font53.otf");
//                textView.setTypeface(typeface52);
//                break;
//
//            case 53:
//                Typeface typeface53 = Typeface.createFromAsset(activity.getAssets(),"font54.otf");
//                textView.setTypeface(typeface53);
//                break;
//
//            case 54:
//                Typeface typeface54 = Typeface.createFromAsset(activity.getAssets(),"font55.otf");
//                textView.setTypeface(typeface54);
//                break;
//
//            case 55:
//                Typeface typeface55 = Typeface.createFromAsset(activity.getAssets(),"font56.otf");
//                textView.setTypeface(typeface55);
//                break;
//
//            case 56:
//                Typeface typeface56 = Typeface.createFromAsset(activity.getAssets(),"font57.otf");
//                textView.setTypeface(typeface56);
//                break;
//
//            case 57:
//                Typeface typeface57 = Typeface.createFromAsset(activity.getAssets(),"font58.otf");
//                textView.setTypeface(typeface57);
//                break;
//
//            case 58:
//                Typeface typeface58 = Typeface.createFromAsset(activity.getAssets(),"font59.otf");
//                textView.setTypeface(typeface58);
//                break;
//
//            case 59:
//                Typeface typeface59 = Typeface.createFromAsset(activity.getAssets(),"font60.otf");
//                textView.setTypeface(typeface59);
//                break;
//
//            case 60:
//                Typeface typeface60 = Typeface.createFromAsset(activity.getAssets(),"font61.otf");
//                textView.setTypeface(typeface60);
//                break;
//
//            case 61:
//                Typeface typeface61 = Typeface.createFromAsset(activity.getAssets(),"font62.otf");
//                textView.setTypeface(typeface61);
//                break;
//
//            case 62:
//                Typeface typeface62 = Typeface.createFromAsset(activity.getAssets(),"font63.otf");
//                textView.setTypeface(typeface62);
//                break;
//
//            case 63:
//                Typeface typeface63 = Typeface.createFromAsset(activity.getAssets(),"font64.otf");
//                textView.setTypeface(typeface63);
//                break;
//
//            case 64:
//                Typeface typeface64 = Typeface.createFromAsset(activity.getAssets(),"font65.otf");
//                textView.setTypeface(typeface64);
//                break;
//
//            case 65:
//                Typeface typeface65 = Typeface.createFromAsset(activity.getAssets(),"font66.otf");
//                textView.setTypeface(typeface65);
//                break;
//
//            case 66:
//                Typeface typeface66 = Typeface.createFromAsset(activity.getAssets(),"font67.otf");
//                textView.setTypeface(typeface66);
//                break;
//
//            case 67:
//                Typeface typeface67 = Typeface.createFromAsset(activity.getAssets(),"font68.otf");
//                textView.setTypeface(typeface67);
//                break;
//
//            case 68:
//                Typeface typeface68 = Typeface.createFromAsset(activity.getAssets(),"font69.otf");
//                textView.setTypeface(typeface68);
//                break;
//
//            case 69:
//                Typeface typeface69 = Typeface.createFromAsset(activity.getAssets(),"font70.otf");
//                textView.setTypeface(typeface69);
//                break;
//
//            case 70:
//                Typeface typeface70 = Typeface.createFromAsset(activity.getAssets(),"font71.otf");
//                textView.setTypeface(typeface70);
//                break;
//
//            case 71:
//                Typeface typeface71 = Typeface.createFromAsset(activity.getAssets(),"font72.otf");
//                textView.setTypeface(typeface71);
//                break;
//
//            case 72:
//                Typeface typeface72 = Typeface.createFromAsset(activity.getAssets(),"font73.otf");
//                textView.setTypeface(typeface72);
//                break;
//
//            case 73:
//                Typeface typeface73 = Typeface.createFromAsset(activity.getAssets(),"font74.otf");
//                textView.setTypeface(typeface73);
//                break;
//
//            case 74:
//                Typeface typeface74 = Typeface.createFromAsset(activity.getAssets(),"font75.otf");
//                textView.setTypeface(typeface74);
//                break;
//
//            case 75:
//                Typeface typeface75 = Typeface.createFromAsset(activity.getAssets(),"font76.otf");
//                textView.setTypeface(typeface75);
//                break;
//
//            case 76:
//                Typeface typeface76 = Typeface.createFromAsset(activity.getAssets(),"font77.otf");
//                textView.setTypeface(typeface76);
//                break;
//
//            case 77:
//                Typeface typeface77 = Typeface.createFromAsset(activity.getAssets(),"font78.otf");
//                textView.setTypeface(typeface77);
//                break;
//
//            case 78:
//                Typeface typeface78 = Typeface.createFromAsset(activity.getAssets(),"font79.otf");
//                textView.setTypeface(typeface78);
//                break;
//
//            case 79:
//                Typeface typeface79 = Typeface.createFromAsset(activity.getAssets(),"font80.otf");
//                textView.setTypeface(typeface79);
//                break;
//
//            case 80:
//                Typeface typeface80 = Typeface.createFromAsset(activity.getAssets(),"font81.ttf");
//                textView.setTypeface(typeface80);
//                break;
//
//            case 81:
//                Typeface typeface81 = Typeface.createFromAsset(activity.getAssets(),"font82.ttf");
//                textView.setTypeface(typeface81);
//                break;
//
//            case 82:
//                Typeface typeface82 = Typeface.createFromAsset(activity.getAssets(),"font83.ttf");
//                textView.setTypeface(typeface82);
//                break;
//
//            case 83:
//                Typeface typeface83 = Typeface.createFromAsset(activity.getAssets(),"font84.ttf");
//                textView.setTypeface(typeface83);
//                break;
//
//            case 84:
//                Typeface typeface84 = Typeface.createFromAsset(activity.getAssets(),"font85.ttf");
//                textView.setTypeface(typeface84);
//                break;
//
//            case 85:
//                Typeface typeface85 = Typeface.createFromAsset(activity.getAssets(),"font86.ttf");
//                textView.setTypeface(typeface85);
//                break;
//
//            case 86:
//                Typeface typeface86 = Typeface.createFromAsset(activity.getAssets(),"font87.ttf");
//                textView.setTypeface(typeface86);
//                break;
//
//            case 87:
//                Typeface typeface87 = Typeface.createFromAsset(activity.getAssets(),"font88.ttf");
//                textView.setTypeface(typeface87);
//                break;
//
//            case 88:
//                Typeface typeface88 = Typeface.createFromAsset(activity.getAssets(),"font89.ttf");
//                textView.setTypeface(typeface88);
//                break;
//
//            case 89:
//                Typeface typeface89 = Typeface.createFromAsset(activity.getAssets(),"font90.ttf");
//                textView.setTypeface(typeface89);
//                break;
//
//            case 90:
//                Typeface typeface90 = Typeface.createFromAsset(activity.getAssets(),"font91.ttf");
//                textView.setTypeface(typeface90);
//                break;
//
//            case 91:
//                Typeface typeface91 = Typeface.createFromAsset(activity.getAssets(),"font92.ttf");
//                textView.setTypeface(typeface91);
//                break;
//
//            case 92:
//                Typeface typeface92 = Typeface.createFromAsset(activity.getAssets(),"font93.ttf");
//                textView.setTypeface(typeface92);
//                break;
//
//            case 93:
//                Typeface typeface93 = Typeface.createFromAsset(activity.getAssets(),"font94.ttf");
//                textView.setTypeface(typeface93);
//                break;
//
//            case 94:
//                Typeface typeface94 = Typeface.createFromAsset(activity.getAssets(),"font95.ttf");
//                textView.setTypeface(typeface94);
//                break;
//
//            case 95:
//                Typeface typeface95 = Typeface.createFromAsset(activity.getAssets(),"font96.ttf");
//                textView.setTypeface(typeface95);
//                break;
//
//            case 96:
//                Typeface typeface96 = Typeface.createFromAsset(activity.getAssets(),"font97.ttf");
//                textView.setTypeface(typeface96);
//                break;
//
//            case 97:
//                Typeface typeface97 = Typeface.createFromAsset(activity.getAssets(),"font98.ttf");
//                textView.setTypeface(typeface97);
//                break;
//
//            case 98:
//                Typeface typeface98 = Typeface.createFromAsset(activity.getAssets(),"font99.ttf");
//                textView.setTypeface(typeface98);
//                break;



        }


        return view;
    }
}
