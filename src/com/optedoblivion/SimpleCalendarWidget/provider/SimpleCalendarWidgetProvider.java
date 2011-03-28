package com.optedoblivion.SimpleCalendarWidget.provider;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import com.optedoblivion.SimpleCalendarWidget.R;

public class SimpleCalendarWidgetProvider extends AppWidgetProvider{

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, 
                                                          int[] appWidgetIds){
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
        RemoteViews views = new RemoteViews(context.getPackageName(),
                R.layout.calendar_widget);
        views.setTextViewText(R.id.TextView01, sdf.format(d));
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