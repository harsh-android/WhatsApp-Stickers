package com.avinfo.stickermaker.constants;

import android.os.Environment;

public class ConstantsData {

    public final static String STICKERS_DIRECTORY_PATH = Environment.getExternalStorageDirectory() + "/stickerPacks/";
    public final static String STICKERS_CREATED_DIRECTORY_PATH = Environment.getExternalStorageDirectory() + "/stickersCreated/";
    public final static int STICKER_PACK_IDENTIFIER_LENGHT = 20;
}
