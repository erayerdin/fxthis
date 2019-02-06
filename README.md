# FXThis

FXThis is a Guice-powered JavaFX library, which utilizes the approach of
dependency injection.

This project is in development for now.

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

## Works to be Done

 - **Application Data Components:** Will contain
 helpers for IO on application data.