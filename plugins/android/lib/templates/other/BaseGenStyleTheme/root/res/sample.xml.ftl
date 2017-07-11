<resources xmlns:tools="http://schemas.android.com/tools">

    <style name="${nameMaterialTheme}.Base" parent="Theme.AppCompat.Light.DarkActionBar">
        <item name="windowNoTitle">true</item>
        <item name="windowActionBar">false</item>
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

    <style name="${nameMaterialTheme}" parent="${nameMaterialTheme}.Base">
        <item name="android:windowContentTransitions" tools:ignore="NewApi">true</item>
        <item name="android:windowAllowEnterTransitionOverlap" tools:ignore="NewApi">true</item>
        <item name="android:windowAllowReturnTransitionOverlap" tools:ignore="NewApi">true</item>
        <item name="android:windowSharedElementEnterTransition" tools:ignore="NewApi">@android:transition/move</item>
        <item name="android:windowSharedElementExitTransition" tools:ignore="NewApi">@android:transition/move</item>
    </style>

</resources>
