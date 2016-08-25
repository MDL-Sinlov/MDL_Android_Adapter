[TOC]

# MDL Android Adapter

- this is fast adapter for develop


Project Runtime:
- Android Studio 2.1.2
- appcompat-v7:23.4.0
- Gradle 2.10
- com.android.tools.build:gradle:2.1.2

## BaseAdapter

Less Runtime :
- minSdkVersion 9
- gradle or maven

## SupportAdapter

Less Runtime :
- minSdkVersion 14
- gradle or maven
- support recyclerview-v7 23.1.1

# Dependency

at root project `build.gradle`

```gradle
repositories {
    maven {
        url 'https://raw.githubusercontent.com/MDL-Sinlov/MDL-Android-Repo/master/mvn-repo/'
    }
    jcenter()
    ...
}
```
