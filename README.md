FontIcon2 Library
====

FontIcon2 is based on FontIcon and adds best features of [Iconify][8] library
Generally usages are the same. Differences are at 8

====

Android FontIcon is simple library which use font-based icons in Android.

Permament link to [project's page][1].

![Example Image][2]

Gradle dependency
----

```groovy
repositories {
    maven {
        url 'http://repo.shamanland.com'
    }
}

dependencies {
    compile 'com.shamanland:fonticon:0.1.+'
}
```

Usage
----

**1. Create your font with icons**

Do it yourself. Check tutorial on [fontastic.me][4] service or find other service.

**2. Prepare your font to be used in Android.**

Read this [manual][5] for details. In case of fontastic use [this util][3].

**3. Declare your FontIconDrawable in xml**

[**res/xml/ic_android.xml**][6]

```xml
<?xml version="1.0" encoding="utf-8"?>
<font-icon
    xmlns:android="http://schemas.android.com/apk/res-auto"
    android:text="@string/ic_android"
    android:textSize="@dimen/big_icon_size"
    android:textColor="@color/green_170"
    />
```

**4. Inflate your FontIconDrawable in Java**

```java
Drawable icon = FontIconDrawable.inflate(getResources(), R.xml.ic_android);
```

**5. Use your FontIconDrawable as compound for TextView or Button (in res/layout with custom class)**

```xml
<com.shamanland.fonticon.FontIconTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Dummy text"
    app:iconLeft="@xml/ic_android"
    />

<com.shamanland.fonticon.FontIconButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Dummy text"
    app:iconLeft="@xml/ic_button_yes"
    />
```

**6. Use your FontIconDrawable as compound for TextView (in Java-code with platform class)**

```java
Drawable icon = FontIconDrawable.inflate(getResources(), R.xml.ic_android);
TextView tv = (TextView) result.findViewById(R.id.my_textview_or_button);
tv.setCompoundDrawables(icon, null, null, null);
```

**7. Use FontIconView as single icon in your layout**

```xml
<com.shamanland.fonticon.FontIconView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/ic_android"
    android:textSize="@dimen/icon_size"
    android:textColor="@color/icon_color"
    />
```

**8. Using symbol aliases**

If you need icons on a `TextView`, use the `{ }` syntax. You can put any text around it and have more than one icon in the text. Note that the shadows apply to the icons as well. (Inspired by Iconify)

```xml
<com.shamanland.fonticon.FontIconView
    android:text="{android}"
    android:shadowColor="#22000000"
    android:textSize="90dp"
    android:textColor="#FF33B5E5"
    ... />
```

> You can either use ```IconTextView``` / ```ButtonTextView``` or use any ```TextView``` and then programmatically call ```Iconify.addIcons(myTextView);```.

> If you need another template separators instead of `{ }`, you can set them at the start of your application with `Icons.setParseDelimiters("[", "]")`

**9. Add glowing effect on touch for your FontIconView**

[**res/layout/f_glowing.xml**][7]

```xml
<com.shamanland.fonticon.FontIconView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="@dimen/icon_glow_radius"
        android:text="@string/ic_googleplus"
        android:textSize="@dimen/big_icon_size"
        android:textColor="@color/pressed_googleplus"
        android:clickable="true"
        app:overridePressed="true"
        app:pressedGlowColor="@color/googleplus"
        app:pressedGlowRadius="@dimen/icon_glow_radius"
        />
```
Branches
----

`master` - example of usage via gradle dependency

`dev` - sources of library

Tools
----

[FontIcon-Prepare][3] - prepares web fonts to be used with this library


[1]: http://shomeser.blogspot.com/p/android-fonticon-library.html
[2]: http://1.bp.blogspot.com/-1m5lo0aOxh0/UvoDZwDgRoI/AAAAAAAAJoU/Ua1QGEIdxzg/s1600/fonticon.gif
[3]: http://github.com/shamanland/fonticon-prepare/
[4]: http://fontastic.me/howto/
[5]: http://blog.shamanland.com/2013/11/how-to-use-icon-fonts-in-android.html
[6]: http://github.com/shamanland/fonticon/blob/dev/app/src/main/res/xml/ic_android.xml
[7]: http://github.com/shamanland/fonticon/blob/dev/app/src/main/res/layout/f_glowing.xml
[8]: http://github.com/JoanZapata/android-iconify/
