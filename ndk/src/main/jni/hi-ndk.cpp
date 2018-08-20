//
// Created by Administrator on 2018/8/7.
//

#include "com_example_jianshengd_ndk_HelloNdk.h"

JNIEXPORT jstring JNICALL Java_com_example_jianshengd_ndk_HelloNdk_getMaxInt
  (JNIEnv *env, jobject thiz, jint first, jint second){
  return env->NewStringUTF("first");
  }