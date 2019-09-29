# kotlin.javafx

![License](https://img.shields.io/github/license/deryeger/kotlin.javafx?style=for-the-badge)
![Travis](https://img.shields.io/travis/com/deryeger/kotlin.javafx?style=for-the-badge)
![Coverage](https://img.shields.io/codecov/c/github/deryeger/kotlin.javafx?style=for-the-badge)


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