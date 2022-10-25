package com.example.myapplication

class AndroidArchitecture {

    /*

    Modular code -> unit testing easier
                 -> can add new features as well easily


    1. Model-view-Controller  (default arch of any android studio project)

              Model -> layer for data storing and handling communication with database (data classes, data logic (retireve from databse, perform data queries)
              View  -> UI layer. Data is presented to user here (xml)
              Controller -> logic written here (request logic, handle requests of user)(sometimes diff class is created or sometime written in main activitu only)
                             like setonclickListners

              view <-> controller <-> model

              Use - small apps

              Disadvantage -> Code layers depend on each other even if MVC is applied correctly. (view is tightly bind to controller so singularity not achieved)
                              UI logic is also handled by controller only nd not separately

    2. Model - view - presenter

              Model -> same task
              View -> UI represnts (now xml and activity both here so that binding remains and also logic is separated)
                       so here view can be changed independently of presenter
              Presenter -> sepaarate class for logics (like what to pass when user does this) other than UI logic -> more modularity achieved
                           the presenter and view interacts thru interfaces

              clear separation is achieved

    3. Model- view - ViewModel (unidirectional i.e. reference of viewmodel in activity, reference of model in viewmodel)

             Model/Repository -> data storage
             View -> UI logic
             ViewModel -> accepter of notfication of view, updates from model, write and read from model, update to UI
                          interaction with UI not thru interfaces but the View will get data thru 'Observables'
                          View will observe the observables everytime



        MVVM over MVP

        1. in MVP -> activity holds refernce to Presenter and vice versa
                     but in MVVP only one direction

        2. Testing easier

























    Anroid Jetpack - set of libraries for robust, backward compatible code and a good architecture for the code

    manifest file -> provides the data to the Android OS aboout the app that it has installed in itself so that proper integration is possible

    Anroid Architecture need :  (it comes under the androit jetpack)

    1. Your OS can stop your app at any time if there is memory issue
       And most of the time you store your data and other thinfs also in the activity only which will go away once the app is stopped
       Best practise -> only define the UI related content in the activity

       Also, when u rotate your screen your data is lost as the OnCreate method is called again so this is not good

    2. Data Model -> component that stores all the data so tjat even if the app crash this data is stored in the OS

    3. Unidirectional /flow -> from UI to database or from database to UI

    4. Modular programming, testing easier


    Activity/Fragments -> Should onlt have the UI logic and nothing else

    ViewModel -> Holding and preparing the data to display to the UI.
                 Other logics to call lower layer of the architecture to retrieve the data from them
                 It must never keep a referecne to the activity to avoid memory leaks

    Model -> Contains the data (room databse)

    dependency injection -> we do not instantiate the class in other class instead pass them as a dependency to the oher class



    Configuration change -> keyboard hide, screen density, scren rotataion
                            After every configuration change android recreates our activity

    Architecure Components :

    Room

    WorkManager

    LifeCycle

    Navigation

    Paging

    Databinding

     */


}