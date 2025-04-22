# Java Sandbox

Java Starter Kit for Experimentation

Included:

| Tool                                             | Type               |
|--------------------------------------------------|--------------------|
| [Maven](https://maven.apache.org)                | Build Tool         |
| [Junit 5](https://junit.org/junit5/)             | Testing Library    |
| [AssertJ](https://assertj.github.io/doc/)        | Assertion Library  |
| [Mockito](https://site.mockito.org)              | Mocking Library    |
| [Spotless](https://github.com/diffplug/spotless) | Code Formatter     |
| [Lombok](https://projectlombok.org)              | Compiler Extension |
| [ErrorProne](https://errorprone.info)            | Compiler Extension |
| [NullAway](https://github.com/uber/NullAway)     | Compiler Extension |

## Installation

This project requires some tooling on your machine, as described in the `.sdkmanrc`. If you use
sdkman `cd` into the root of this project and run:

```shell
sdk env install
```

to install the required sdks. You can also install them yourself.
Alternatively you can use the included Maven wrappers to build without installing anything.

## Automatic Formatting

Install the included git hooks:

```shell
./hooks/install.sh
```

## Compile

```shell
mvnd compile
```

## Tests

Run unit tests:

```shell
mvnd test
```

Run integration tests:

```shell
mvnd verify
```

