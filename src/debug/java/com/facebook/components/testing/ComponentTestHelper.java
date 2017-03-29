/**
 * Copyright (c) 2014-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.litho.testing;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Rect;
import android.view.View;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLifecycle;
import com.facebook.litho.ComponentTree;
import com.facebook.litho.ComponentView;
import com.facebook.litho.ComponentsPools;
import com.facebook.litho.EventHandler;
import com.facebook.litho.TestComponentTree;
import com.facebook.litho.TreeProps;

import org.powermock.reflect.Whitebox;

import static android.view.View.MeasureSpec.EXACTLY;
import static android.view.View.MeasureSpec.UNSPECIFIED;
import static android.view.View.MeasureSpec.makeMeasureSpec;

/**
 * Helper class to simplify testing of components.
 *
 * Allows simple and short creation of views that are created and mounted in a similar way to how
 * they are in real apps.
 */
public final class ComponentTestHelper {

  /**
   * Mount a component into a component view.
   *
   * @param component The component builder to mount
   * @return A ComponentView with the component mounted in it.
   */
  public static ComponentView mountComponent(Component.Builder component) {
    return mountComponent(getContext(component), component.build());
