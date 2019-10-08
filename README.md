# kofx

[![License](https://img.shields.io/github/license/deryeger/kofx?color=green&style=for-the-badge)](https://www.gnu.org/licenses/gpl-3.0.en.html)
[![Travis](https://img.shields.io/travis/com/deryeger/kofx?color=green&style=for-the-badge)](https://travis-ci.com/DerYeger/kotlin.javafx)
[![JitPack](https://img.shields.io/jitpack/v/github/deryeger/kofx?color=green&style=for-the-badge)](https://jitpack.io/#eu.yeger/kotlin.javafx)

A library for easier and better JavaFX development in combination with Kotlin.

## Installation

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```
dependencies {
    implementation 'eu.yeger:kofx:{version}'
}
```

## Content

- Methods for defining structured layouts programmatically
- Extension methods for clean bindings
- Support for JavaFX Property delegation
- Blocking and returning methods for running code on the FX-thread
- WIP Alert DSL

## Example

An example project using this library can be found [here](https://github.com/DerYeger/minesweeper).
