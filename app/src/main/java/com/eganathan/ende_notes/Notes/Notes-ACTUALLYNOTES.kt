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

    /*
    * DI -
    * 48.01 TIME STAMP: https://youtu.be/8YPXv7xKh2w
    *
    * */
}
