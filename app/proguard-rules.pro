# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute SourceFile

-keepattributes *Annotation*,InnerClasses,EnclosingMethod

-dontnote retrofit2.Platform
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions

-keep public class com.google.android.gms.* { public *; }
-dontwarn com.google.android.gms.**

#-----------------------------------------------------
-keep public class * extends java.lang.Exception

-keep class com.google.firebase.messaging.** { *; }
-dontwarn com.google.firebase.messaging.**

-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

-keep class com.onesignal.** { *; }
-dontwarn com.onesignal.**

-keep class sun.misc.Unsafe { *; }
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn okio.**

-keep class com.j256.**
-keepclassmembers class com.j256.** { *; }
-keep enum com.j256.**
-keepclassmembers enum com.j256.** { *; }
-keep interface com.j256.**
-keepclassmembers interface com.j256.** { *; }
-keepclassmembers class * {
  public <init>(android.content.Context);
}

#scaner
-keepclassmembers class net.sourceforge.zbar.ImageScanner { *; }
-keepclassmembers class net.sourceforge.zbar.Image { *; }
-keepclassmembers class net.sourceforge.zbar.Symbol { *; }
-keepclassmembers class net.sourceforge.zbar.SymbolSet { *; }

-dontwarn javax.**
-dontwarn java.lang.**
-dontwarn org.apache.log4j.**
-dontwarn org.slf4j.**

-dontnote com.google.gson.**
-dontnote android.support.**
-dontnote **ILicensingService

-keep public class com.android.vending.licensing.ILicensingService
-keep class javax.** { *; }
-keep class android.support.** { *; }
-keep class com.google.gson.** { *; }
-keep class java.beans.** { *; }
-keep class org.junit.** { *; }
-keep class org.aspectj.** { *; }


-dontwarn androidx.**
-keep class androidx. { *; }
-keep interface androidx. { *; }
-dontwarn okhttp3.internal.platform.ConscryptPlatform
-dontwarn javax.**
-dontwarn lombok.**
-dontwarn org.apache.**
-dontwarn com.squareup.**
-dontwarn com.sun.**
-dontwarn retrofit
-dontwarn org.xmlpull.v1.**
-dontwarn androidx.appcompat.widget.**
-dontwarn android.**
-dontnote androidx.**
-dontwarn androidx.**

-dontwarn java.beans.**

-dontwarn org.bouncycastle.**

-dontwarn edu.emory.**
-dontwarn org.aspectj.**
-dontwarn org.junit.**
-dontwarn org.springframework.core.**

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}


-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keep public class com.adjust.sdk.** { *; }
-keep class com.google.android.gms.common.ConnectionResult {
    int SUCCESS;
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info getAdvertisingIdInfo(android.content.Context);
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
    java.lang.String getId();
    boolean isLimitAdTrackingEnabled();
}
-keep class dalvik.system.VMRuntime {
    java.lang.String getRuntime();
}
-keep class android.os.Build {
    java.lang.String[] SUPPORTED_ABIS;
    java.lang.String CPU_ABI;
}
-keep class android.content.res.Configuration {
    android.os.LocaleList getLocales();
    java.util.Locale locale;
}
-keep class android.os.LocaleList {
    java.util.Locale get(int);
}
-keep public class com.android.installreferrer.** { *; }

# For using GSON @Expose annotation
-keepattributes *Annotation*

-keep public class com.android.installreferrer.** { *; }
-keepclasseswithmembers,allowoptimization public class * {
    public <methods>;
    public <fields>;
}
-keep public class okhttp3.Request {
  public protected *;
}
-keepclassmembers class okhttp3.* {
    <fields>;
    <init>();
    <methods>;
}

-keep class io.sentry.android.core.SentryAndroidOptions
-keep class io.sentry.android.ndk.SentryNdk

