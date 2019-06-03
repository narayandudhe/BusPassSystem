<?xml version="1.0" encoding="utf-8"?>
<!--
  ~ Copyright (C) 2014 The Android Open Source Project
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~      http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License
  -->

<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/status_bar_latest_event_content"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:tag="bigText"
    >
    <include layout="@layout/notification_template_header" />

    <LinearLayout
            android:id="@+id/notification_action_list_margin_target"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_gravity="top"
            android:layout_marginTop="@dimen/notification_content_margin_top"
            android:layout_marginBottom="@dimen/notification_action_list_height"
            android:clipToPadding="false"
            android:orientation="vertical">

        <LinearLayout
            android:id="@+id/notification_main_column"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="top"
            android:paddingStart="@dimen/notification_content_margin_start"
            android:paddingEnd="@dimen/notification_content_margin_end"
            android:clipToPadding="false"
            android:minHeight="@dimen/notification_min_content_height"
            android:orientation="vertical"
            >
            <include layout="@layout/notification_template_part_line1" />
            <include layout="@layout/notification_template_progress" />
            <com.android.internal.widget.ImageFloatingTextView android:id="@+id/big_text"
                android:layout_width="matc