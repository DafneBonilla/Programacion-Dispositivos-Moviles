// Generated by view binder compiler. Do not edit!
package com.example.curso.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.viewbinding.ViewBindings;
import android.widget.TextView;
import com.example.curso.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPrivacyBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView Copyright;

  @NonNull
  public final TextView Politics;

  @NonNull
  public final TextView Tittle;

  private ActivityPrivacyBinding(@NonNull ConstraintLayout rootView, @NonNull TextView Copyright,
      @NonNull TextView Politics, @NonNull TextView Tittle) {
    this.rootView = rootView;
    this.Copyright = Copyright;
    this.Politics = Politics;
    this.Tittle = Tittle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPrivacyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPrivacyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_privacy, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPrivacyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Copyright;
      TextView Copyright = ViewBindings.findChildViewById(rootView, id);
      if (Copyright == null) {
        break missingId;
      }

      id = R.id.Politics;
      TextView Politics = ViewBindings.findChildViewById(rootView, id);
      if (Politics == null) {
        break missingId;
      }

      id = R.id.Tittle;
      TextView Tittle = ViewBindings.findChildViewById(rootView, id);
      if (Tittle == null) {
        break missingId;
      }

      return new ActivityPrivacyBinding((ConstraintLayout) rootView, Copyright, Politics, Tittle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}