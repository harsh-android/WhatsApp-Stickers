package com.avinfo.stickermaker.MultiTouch;

import android.graphics.Path;

public interface OnGestureListener {
    void onDrag(float f, float f2, Path path);

    void onDrag(float f, float f2, boolean z);
}
