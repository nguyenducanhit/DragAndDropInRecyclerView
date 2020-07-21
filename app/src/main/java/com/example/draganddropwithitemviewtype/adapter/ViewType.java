package com.example.draganddropwithitemviewtype.adapter;

import androidx.annotation.IntDef;

@IntDef({ViewType.VIEW_TYPE_TITLE, ViewType.VIEW_TYPE_DATA})
public @interface ViewType {
    int VIEW_TYPE_TITLE = 0;
    int VIEW_TYPE_DATA = 1;
}
