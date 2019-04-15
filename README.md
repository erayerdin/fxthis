# FXThis

 > This repository is archived due to the lack of development time and
 > better options. I really encourage you to use [TornadoFX][tornadofx_url]
 > which utilizes Kotlin.

[tornadofx_url]: https://tornadofx.io

FXThis is a Guice-powered JavaFX library, which utilizes the approach of
dependency injection.

This project is in development for now. You can grab the project from
[Jitpack](https://jitpack.io/#erayerdin/fxthis). Since it is in continuous
development, continuous reporting is not provided. Use it at your own risk.

## Works Done

 - A `GenericApplication` containing `GenericModule`
 - A `GenericModule` containing many components
 - **Meta Component:** Helps standardizing meta data
 of your software; its name and versions. While it
 is meant to be used by you, it will be also used
 for application data IO.
 - **Versioning Component:** Helps defining version
 programmatically. It is also used by meta component.
 - **System Component:** Helps getting information
 that your software runs on.
 - **Application Data Components:** Can access global/local application
 data/config.

## Works to be Done

 - **Documentation:** via mkdocs
 - Docstrings
 - Better way to separate view/controller
 
## How to Contribute?

Open the project and look for `todo`s. There are many aspects that you can
contribute.
