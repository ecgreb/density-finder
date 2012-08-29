package com.howaboutwe.android.densityfinder;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class DensityActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView manufacturer = (TextView) findViewById(R.id.manufacturer);
        manufacturer.setText(Build.MANUFACTURER);

        TextView model = (TextView) findViewById(R.id.model);
        model.setText(Build.MODEL);

        TextView release = (TextView) findViewById(R.id.release);
        release.setText(Build.VERSION.RELEASE);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        TextView resolution = (TextView) findViewById(R.id.resolution);
        resolution.setText(metrics.widthPixels + " x " + metrics.heightPixels);

        TextView density = (TextView) findViewById(R.id.density);
        density.setText(dpiToDensity(metrics.densityDpi));
    }

    private String dpiToDensity(int dpi) {
        switch (dpi) {
            case DisplayMetrics.DENSITY_XHIGH:
                return "xhdpi";
            case DisplayMetrics.DENSITY_HIGH:
                return "hdpi";
            case DisplayMetrics.DENSITY_MEDIUM:
                return "mdpi";
            case DisplayMetrics.DENSITY_LOW:
                return "ldpi";
            default:
                return "unknown";
        }
    }
}
