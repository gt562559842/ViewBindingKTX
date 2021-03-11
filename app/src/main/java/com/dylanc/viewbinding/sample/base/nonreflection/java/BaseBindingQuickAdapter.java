/*
 * Copyright (c) 2020. Dylan Cai
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dylanc.viewbinding.sample.base.nonreflection.java;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dylanc.viewbinding.base.ViewBindingUtil;

import org.jetbrains.annotations.NotNull;

public abstract class BaseBindingQuickAdapter<T, VB extends ViewBinding>
    extends BaseQuickAdapter<T, BaseBindingQuickAdapter.BaseBindingHolder<VB>> {

  public BaseBindingQuickAdapter() {
    this(-1);
  }

  public BaseBindingQuickAdapter(@LayoutRes int layoutResId) {
    super(-layoutResId);
  }

  @NotNull
  @Override
  protected BaseBindingHolder<VB> onCreateDefViewHolder(@NotNull ViewGroup parent, int viewType) {
    return new BaseBindingHolder<>(onCreateViewBinding(LayoutInflater.from(parent.getContext()), parent));
  }

  protected abstract VB onCreateViewBinding(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);

  public static class BaseBindingHolder<B extends ViewBinding> extends BaseViewHolder {

    private final B binding;

    public BaseBindingHolder(@NotNull B binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    @NonNull
    public B getViewBinding() {
      return binding;
    }
  }
}