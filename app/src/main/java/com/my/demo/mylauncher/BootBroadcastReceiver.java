package com.my.demo.mylauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
//            Log.i("selftoactive", intent.getAction());
//            Toast.makeText(context, "开机自启动！！！", Toast.LENGTH_SHORT).show();
//            Intent intent1 = new Intent(context, MainActivity.class);
//            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//这个是重点，没有设置这个，app不会启                                                              动，而且开机后有延迟几秒才会收到，开                                                              机发送过来的信号
//            context.startActivity(intent1);
//        }

        switch (intent.getAction()) {
            case Intent.ACTION_CLOSE_SYSTEM_DIALOGS:
                Log.i("boot-test", intent.getAction());
                break;
            case Intent.ACTION_BOOT_COMPLETED: {
                Log.i("boot-test", intent.getAction());
                Toast.makeText(context, "开机自启动！！！", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(context, MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//这个是重点，没有设置这个，app不会启                                                              动，而且开机后有延迟几秒才会收到，开                                                              机发送过来的信号
                context.startActivity(intent1);
            }
            break;
        }
    }

}
