package com.shamanland.fonticon;

import android.content.Context;
import android.widget.TextView;

public class Icons {

    private static String sStartDelimeter = "{";
    private static String sEndDelimeter   = "}";

    public static void setParseDelimiters(String start, String end) {
        sStartDelimeter = start;
        sEndDelimeter = end;
    }

    /**
     * Transform the given TextViews replacing {icon_xxx} texts with icons.
     */
    public static void iconify(TextView... textViews) {
        for (TextView textView : textViews) {
            textView.setTypeface(FontIconTypefaceHolder.getTypeface());
            textView.setText(compute(textView.getContext(), textView.getText()));
        }
    }

    private static CharSequence compute(Context context, CharSequence charSequence) {
        String text = charSequence.toString();
        return replaceIcons(context, new StringBuilder(text));
    }

    private static StringBuilder replaceIcons(Context context, StringBuilder text) {
        int startIndex = text.indexOf(sStartDelimeter);
        if (startIndex == -1) {
            return text;
        }
        int endIndex = text.substring(startIndex).indexOf(sEndDelimeter) + startIndex + sStartDelimeter.length();

        String iconString = text.substring(startIndex + sStartDelimeter.length(), endIndex - sEndDelimeter.length());
        int strId = context.getResources().getIdentifier(iconString, "string", context.getPackageName());
        if (strId != 0) {
            String iconValue = context.getString(strId);
            text = text.replace(startIndex, endIndex, iconValue);
        }
        return replaceIcons(context, text);
    }
}
