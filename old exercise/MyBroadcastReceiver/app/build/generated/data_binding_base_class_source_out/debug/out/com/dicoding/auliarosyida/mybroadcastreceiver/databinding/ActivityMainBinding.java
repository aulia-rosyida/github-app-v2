// Generated by view binder compiler. Do not edit!
package com.dicoding.auliarosyida.mybroadcastreceiver.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.dicoding.auliarosyida.mybroadcastreceiver.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout activityMain;

  @NonNull
  public final Button btnDownload;

  @NonNull
  public final Button btnPermission;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout activityMain,
      @NonNull Button btnDownload, @NonNull Button btnPermission) {
    this.rootView = rootView;
    this.activityMain = activityMain;
    this.btnDownload = btnDownload;
    this.btnPermission = btnPermission;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayout activityMain = (LinearLayout) rootView;

      id = R.id.btn_download;
      Button btnDownload = rootView.findViewById(id);
      if (btnDownload == null) {
        break missingId;
      }

      id = R.id.btn_permission;
      Button btnPermission = rootView.findViewById(id);
      if (btnPermission == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, activityMain, btnDownload,
          btnPermission);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
