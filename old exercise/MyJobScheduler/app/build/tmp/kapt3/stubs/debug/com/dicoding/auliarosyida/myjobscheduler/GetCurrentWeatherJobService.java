package com.dicoding.auliarosyida.myjobscheduler;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/dicoding/auliarosyida/myjobscheduler/GetCurrentWeatherJobService;", "Landroid/app/job/JobService;", "()V", "getCurrentWeather", "", "job", "Landroid/app/job/JobParameters;", "onStartJob", "", "params", "onStopJob", "showNotification", "context", "Landroid/content/Context;", "title", "", "message", "notifId", "", "Companion", "app_debug"})
public final class GetCurrentWeatherJobService extends android.app.job.JobService {
    private static final java.lang.String TAG = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CITY = "Jakarta";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String APP_ID = "7326f85b9609d6fd3a227be3e6f6fb8e";
    @org.jetbrains.annotations.NotNull()
    public static final com.dicoding.auliarosyida.myjobscheduler.GetCurrentWeatherJobService.Companion Companion = null;
    
    @java.lang.Override()
    public boolean onStartJob(@org.jetbrains.annotations.NotNull()
    android.app.job.JobParameters params) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onStopJob(@org.jetbrains.annotations.NotNull()
    android.app.job.JobParameters params) {
        return false;
    }
    
    private final void getCurrentWeather(android.app.job.JobParameters job) {
    }
    
    private final void showNotification(android.content.Context context, java.lang.String title, java.lang.String message, int notifId) {
    }
    
    public GetCurrentWeatherJobService() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/dicoding/auliarosyida/myjobscheduler/GetCurrentWeatherJobService$Companion;", "", "()V", "APP_ID", "", "CITY", "TAG", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}