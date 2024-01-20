// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}

buildscript {
    repositories {
        mavenCentral()
        google()
//        maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
    }

    dependencies {
//        classpath 'com.android.tools.build:gradle:7.1.0'
    }

}

