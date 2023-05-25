package com.eganathan.ende_notes.Notes

interface NotesACTUALLYNOTES {
    /*UseCases:- [Business Logic]
      * [1] Advantage of Use cases is that it makes the code better readable,
      *
      * [2] UseCase is a basically a single action that the user/application performs, for example getting notes, sorting them, adding a new note or deleting note
      *
      * [3]it does not need to be linked to a API/DB but mostly it is,
      * can also be for example searching in a local list or so..
      *
      * [4]These Use-cases are named exactly as what they do : AddNoteUseCase() ->
      *
      * [5]Helps with code re-usability,
      * Because the VM will call the use-cases,
      * so if we do the api call, validation and business logic inside the view model,while having to implement the same in other place then its code duplication,use-cases are very helpful to avoid code duplication.
      * you can use the use case in different VM
      *
      *
      * */


    /* DEPENDENCY INJECTION
    *  Build a application class in the root package
    *  extend the class to Application() add a @HiltAndroidApp annotation
    *  add to the manifest file android:name=".NoteApp" within the application tag
    *  create provide modules- AppModule object and annotate it with @Module and @InstallIn(SingletonComponent::class)
    * inside that create singleton provoders
    *
    * example:
    *
    *
    *
    * */

    /* VM Classes: are directly coupled to the state snd is in the presentation layer
    *48.01 TIME STAMP: https://youtu.be/8YPXv7xKh2w
    * */

    /***
     * Planing a view model must could be done in a whay that helps us from the spegatii code
     *  [1] note down all the state we are assosiated to the screen that can be wrapped into a single data class here for example everything thats related to notes screen
     *     here for example we can create a data class with val list of notes, val ordertpye  val show orderwidget etc....
     *  [2]note down all the events the assosiated screen
     *      and wrap into a sealed class then in a function named onEvent handel it using when here we can use the use cases and or use the logic for state managemente
     *
     *
     *
     *
     * ***/
}
