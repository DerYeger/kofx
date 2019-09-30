# kotlin.javafx

[![Travis](https://img.shields.io/travis/com/deryeger/kotlin.javafx?style=for-the-badge)](https://travis-ci.com/DerYeger/kotlin.javafx)
[![JitPack](https://img.shields.io/jitpack/v/github/deryeger/kotlin.javafx?style=for-the-badge)](https://jitpack.io/#eu.yeger/kotlin.javafx)
[![License](https://img.shields.io/github/license/deryeger/kotlin.javafx?style=for-the-badge)](https://www.gnu.org/licenses/gpl-3.0.en.html)
[![Coverage](https://img.shields.io/codecov/c/github/deryeger/kotlin.javafx?style=for-the-badge)](https://codecov.io/gh/DerYeger/kotlin.javafx)

A library for easier JavaFX development in combination with Kotlin.

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
    implementation 'eu.yeger:kotlin.javafx:{version}'
}
```

## Content

- Methods for defining layout programmatically in a structured way
- Cleaner bindings
- Support for JavaFX Property delegation
- Blocking and returning methods for running code on the FX-thread
- WIP Alert DSL

## Example

An example project using this library can be found [here](https://github.com/DerYeger/minesweeper).