package com.optedoblivion.SimpleCalendarWidget.provider;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.optedoblivion.SimpleCalendarWidget.R;

public class SimpleCalendarWidgetProvider extends AppWidgetProvider{

    private Context mContext = null;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, 
                                                          int[] appWidgetIds){
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        mContext = context;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
        RemoteViews views = new RemoteViews(context.getPackageName(),
                R.layout.calendar_widget);
        Intent calendarIntent = new Intent();
        calendarIntent.setClassName("com.android.calendar",
                                        "com.android.calendar.LaunchActivity");
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0,
                                                            calendarIntent, 0);
        views.setOnClickPendingIntent(R.id.main_view, pendingIntent);
        sdf = new SimpleDateFormat("MMM");
        String month = sdf.format(d);
        views.setTextViewText(R.id.month_title, month);
        sdf = new SimpleDateFormat("d");
        String day = sdf.format(d);
        views.setTextViewText(R.id.day_title, day);
        sdf = new SimpleDateFormat("EEE");
        String weekday = sdf.format(d);
        views.setTextViewText(R.id.weekday_title, weekday);
        appWidgetManager.updateAppWidget(appWidgetIds, views);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        if(appWidgetIds.length > 0){
            int appWidgetId = appWidgetIds[0];
            String key = String.valueOf(appWidgetId);
        }
    }
}