# 屏蔽Home, back, recent app键

## 1. 声明为桌面应用

activity添加<intent-filter>

``` xml
<category android:name="android.intent.category.HOME" />
<category android:name="android.intent.category.DEFAULT" />
```

## 2. 屏蔽back键

在activity中添加

``` java
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_MENU) {
        return true;
    }
    return super.onKeyDown(keyCode, event);
}v
```

## 3. 屏蔽“最近任务”键

### 3.1 添加权限：

``` xml
<uses-permission android:name="android.permission.REORDER_TASKS" />
```

### 3.2 在activity中添加

``` java
@Override
protected void onPause() {
    super.onPause();
    ActivityManager activityManager = (ActivityManager) getApplicationContext()
            .getSystemService(Context.ACTIVITY_SERVICE);
    activityManager.moveTaskToFront(getTaskId(), 0);
}
```
