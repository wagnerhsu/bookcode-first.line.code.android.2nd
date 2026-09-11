# README

## Version Information

| Name   | Version | Memo                      |
| ------ | ------- | ------------------------- |
| JDK    | 17      |                           |
| Gradle | 7.3.3   | gradle-wrapper.properties |
| AGP    | 7.2.0   | build.gradle(根目录)      |

- AGP 的版本信息在项目根目录的 build.gradle 里，不在 app/build.gradle 里。这个工程里，根目录的 build.gradle 写的是：
  - id 'com.android.application' version '7.2.0' apply false
  - id 'com.android.library' version '7.2.0' apply false

- 也就是 AGP 版本是 7.2.0。    app/build.gradle 里只是应用了这个插件，但没有声明版本号。
