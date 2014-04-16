package com.shamanland.fonticon;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class FontIconTextView extends TextView {

    public FontIconTextView(Context context) {
        super(context);
    }

    public FontIconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            Icons.iconify(this);
            CompoundDrawables.init(context, attrs, this);
        }
    }

    public FontIconTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) {
            Icons.iconify(this);
            CompoundDrawables.init(context, attrs, this);
        }
    }

    public void updateCompoundDrawables() {
        CompoundDrawables.update(this);
    }
}
