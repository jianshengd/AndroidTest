#如果是普通arm处理器的Android手机，使用APP_ABI := armeabi;
#如果是x86处理器的，使用APP_ABI := x86，等等。
#如果APP_ABI := all，会编译所有指令的so
#APP_ABI：= armeabi armeabi-v7a x86 mips mips-r2 mips-r2-sf
APP_ABI := all

#NDK中C++标准库、STL的配置
#如未配置可能出现错误： fatal error: iostream: No such file or directory
APP_STL := stlport_static



