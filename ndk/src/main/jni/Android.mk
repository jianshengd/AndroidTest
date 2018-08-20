LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

#so项目名称
LOCAL_MODULE    := hi-ndk

#资源文件名称，对应的c/c++代码文件
LOCAL_SRC_FILES := hi-ndk.cpp


include $(BUILD_SHARED_LIBRARY)


#写完c文件后，在jni上级目录，通过cmd执行 ndk-build .生成so库