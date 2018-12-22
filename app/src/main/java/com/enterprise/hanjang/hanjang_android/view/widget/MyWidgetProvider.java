//package com.enterprise.hanjang.hanjang_android.view.widget;
//
//import android.app.PendingIntent;
//import android.appwidget.AppWidgetManager;
//import android.appwidget.AppWidgetProvider;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.widget.RemoteViews;
//import android.widget.Toast;
//
//import com.enterprise.hanjang.hanjang_android.R;
//
///**
// * Created by shineeseo on 2018. 10. 27..
// */
//
//public class MyWidgetProvider extends AppWidgetProvider {
//
//    //onReceive에서 위젯이 존재하는 경우 onUpdate를 호출하게 됩니다.
////    onReceive 함수에서 Click1을 감지하는 경우
////    Toast를 출력하게 된다.
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        super.onReceive(context, intent);
//
//        String action = intent.getAction();
//        if(AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action))
//        {
//            Bundle extras = intent.getExtras();
//            //Bundle 은 Key-Value 쌍으로 이루어진 일종의 해쉬맵 자료구조
//            //한 Activity에서 Intent 에 putExtras로 Bundle 데이터를 넘겨주고,
//            //다른 Activity에서 getExtras로 데이터를 참조하는 방식입니다.
//            if(extras!=null)
//            {
//                int [] appWidgetIds = extras.getIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS);
//                if(appWidgetIds!=null && appWidgetIds.length>0)
//                    this.onUpdate(context,AppWidgetManager.getInstance(context),appWidgetIds);
//            }
//        }//업데이트인 경우
//        else if(action.equals("Click1"))
//        {
//            Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    //onUpdate 내부에서 각 appWidgetId에 대하여 즉, 각각의 위젯에 대하여 RemoteView를 할당하게 됩니다.
//    @Override
//    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//        super.onUpdate(context, appWidgetManager, appWidgetIds);
//        final int N = appWidgetIds.length;
//        for(int i=0;i<N;i++)
//        {
//            int appWidgetId = appWidgetIds[i];
//            RemoteViews views = buildViews(context);
//            appWidgetManager.updateAppWidget(appWidgetId,views);
//        }
//    }
//
//    private PendingIntent buildURIIntent(Context context)
//    {
//        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://puzzleleaf.tistory.com"));
//        PendingIntent pi = PendingIntent.getActivity(context,0,intent,0);
//        return pi;
//    }
//
//    //Click1 이라는 Action을 onReceive로 보낸다.
//    private PendingIntent buildToastIntent(Context context)
//    {
//        //        //buildToastIntent 함수는 자세히 보면
////        new Intent("Click1") 이 쓰여있는데
////        PendingIntent에서 getBroadCast()를 통해
////        Click1 이라는 Action을 발생시킨다.
//        Intent in = new Intent("Click1");
//        PendingIntent pi = PendingIntent.getBroadcast(context,0,in,PendingIntent.FLAG_UPDATE_CURRENT);
//        return pi;
//    }
//
//    //RemoteView는 buildView 함수를 통해서 할당이 되는데 이것은 buildURIIntent 함수와 buildToastIntent 함수에 의해서
//    //PendingIntent가 onClick 이벤트로 추가가 됩니다.
//    //위젯에 멀티 버튼 추가하기
////    private RemoteViews buildViews(Context context)
////    {
//////        RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.hanjang_widget);
//////        views.setOnClickPendingIntent(R.id.simple_btn,buildURIIntent(context));
//////        views.setOnClickPendingIntent(R.id.simple_btn2,buildToastIntent(context));
////
////
//////        return views;
////    }
//
//
//}
