# OTPView

Provides a widget for enter PIN/OTP/password etc on Android 4.1+ (API 16).

<p><img src="screenshots/styles.png" width="35%" />
<img src="screenshots/input.gif" width="35%" /></p>

## Dependency

### MavenCentral

``` 
repositories {
    maven {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
   implementation 'com.github.VishalMakwana20:OTPView:0.1.2'
}
```

## Usage

PinView inherits from EditText, which means you can use all the APIs from EditText.

### Step 1:

Add PinView in your layout.

#### XML

``` xml
<com.example.otpview.custom.OTPView
    android:id="@+id/firstPinView"
    style="@style/PinWidget.PinView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:cursorVisible="true"
    android:hint="Hint."
    android:inputType="text"
    android:itemBackground="@mipmap/ic_launcher"
    android:padding="@dimen/common_padding"
    android:textColor="@color/text_colors"
    android:textSize="18sp"
    android:textStyle="bold"
    app:cursorColor="@color/line_selected"
    app:cursorWidth="2dp"
    app:hideLineWhenFilled="true"
    app:itemCount="5"
    app:itemHeight="48dp"
    app:itemRadius="4dp"
    app:itemSpacing="0dp"
    app:itemWidth="48dp"
    app:lineColor="@color/line_colors"
    app:lineWidth="2dp"
    app:viewType="rectangle" />
```

#### Java

``` Java
final OTPView pinView = findViewById(R.id.secondPinView);
pinView.setTextColor(
        ResourcesCompat.getColor(getResources(), R.color.colorAccent, getTheme()));
pinView.setTextColor(
        ResourcesCompat.getColorStateList(getResources(), R.color.text_colors, getTheme()));
pinView.setLineColor(
        ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()));
pinView.setLineColor(
        ResourcesCompat.getColorStateList(getResources(), R.color.line_colors, getTheme()));
pinView.setItemCount(4);
pinView.setItemHeight(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_size));
pinView.setItemWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_size));
pinView.setItemRadius(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_radius));
pinView.setItemSpacing(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_spacing));
pinView.setLineWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_line_width));
pinView.setAnimationEnable(true);// start animation when adding text
pinView.setCursorVisible(false);
pinView.setCursorColor(
        ResourcesCompat.getColor(getResources(), R.color.line_selected, getTheme()));
pinView.setCursorWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_cursor_width));
pinView.addTextChangedListener(new TextWatcher() {...});
pinView.setItemBackgroundColor(Color.BLACK);
pinView.setItemBackground(getResources().getDrawable(R.drawable.item_background));
pinView.setItemBackgroundResources(R.drawable.item_background);
pinView.setHideLineWhenFilled(false);
pinView.setPasswordHidden(false);
pinView.setTransformationMethod(new PasswordTransformationMethod());
```

### Step 2:

Specifies `pinViewStyle` in your theme,

``` xml
<style name="AppTheme" parent="Theme.AppCompat.Light">
    ...
    <item name="pinViewStyle">@style/OTPWidget.OTPView</item>
</style>
```

or use the `PinWidget.PinView` style.

``` xml
<com.example.otpview.custom.OTPView
    android:id="@+id/pinView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    style="@style/OTPWidget.OTPView" />
```

### Step 3 (Optional):

To highlight current item, use 'selected' state, in other words,

add `android:state_selected="true"` to `app:lineColor`

``` xml
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <!-- Use for the item to be input, set the value as the default to disable it -->
    <item android:color="@color/line_selected" android:state_selected="true" />
    <item android:color="@color/line_focused" android:state_focused="true" />
    <item android:color="@color/line_default" />
</selector>
```

or add `android:cursorVisible="true"`.

## Attributes

* **itemCount**, the length of your pin code.
* **itemWidth**, the width of each item.
* **itemHeight**, the height of each item.
* **itemSpacing**, the spacing between two items.
* **lineWidth**, the line (border) width.
* **lineColor**, the line (border) colors.
* **viewType**, the view type of PinView, currently this will be one of `rectangle`, `line` or `none`.
* **cursorVisible**, show cursor or not.
* **cursorColor**, the cursor color.
* **cursorWidth**, the width of cursor.
* **itemBackground**, the item background.
* **hideLineWhenFilled**, specifies whether the line (border) should be hidden or visible when text entered.

## Thanks

 * Inspired by [Chaos PinView](https://github.com/ChaosLeung/PinView)



