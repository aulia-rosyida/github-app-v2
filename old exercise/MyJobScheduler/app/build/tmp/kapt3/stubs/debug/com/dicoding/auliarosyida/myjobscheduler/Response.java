package com.dicoding.auliarosyida.myjobscheduler;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\nH\u00c6\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/dicoding/auliarosyida/myjobscheduler/Response;", "", "id", "", "name", "", "weatherList", "", "Lcom/dicoding/auliarosyida/myjobscheduler/Weather;", "main", "Lcom/dicoding/auliarosyida/myjobscheduler/Main;", "(ILjava/lang/String;Ljava/util/List;Lcom/dicoding/auliarosyida/myjobscheduler/Main;)V", "getId", "()I", "getMain", "()Lcom/dicoding/auliarosyida/myjobscheduler/Main;", "getName", "()Ljava/lang/String;", "getWeatherList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Response {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.dicoding.auliarosyida.myjobscheduler.Weather> weatherList = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dicoding.auliarosyida.myjobscheduler.Main main = null;
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.dicoding.auliarosyida.myjobscheduler.Weather> getWeatherList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dicoding.auliarosyida.myjobscheduler.Main getMain() {
        return null;
    }
    
    public Response(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "weather")
    java.util.List<com.dicoding.auliarosyida.myjobscheduler.Weather> weatherList, @org.jetbrains.annotations.NotNull()
    com.dicoding.auliarosyida.myjobscheduler.Main main) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.dicoding.auliarosyida.myjobscheduler.Weather> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dicoding.auliarosyida.myjobscheduler.Main component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dicoding.auliarosyida.myjobscheduler.Response copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "weather")
    java.util.List<com.dicoding.auliarosyida.myjobscheduler.Weather> weatherList, @org.jetbrains.annotations.NotNull()
    com.dicoding.auliarosyida.myjobscheduler.Main main) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}