# Completed with Advance Android app development with MVVM framework
 + MVVM
 + Retrofit
 + Room Persistance
 + CacheData Source
 + Dagger 2 dependencies  injection
 + Pagging data source adapter
 
 View > View Model > UseCase>> Repository >> (1. Local Data Source , 2. Remote Data Source)
 
 
 View- Activity, Fragment, view model
 
 ViewModel>> Cannot interact with repository. It is interact with action or use-case and use case interact with data layer.
 
 Domain: Which has specific task..We include repository interfaces to the domain layer. Also, add entity classes if they are written in pure kotlin. If Android, specific dependencies then need to add in data layer. 
 
 UseCase: Logic executing classes they defines actions. It also called interactor
 
 Data Layer: contains abstract deification of all data sources and their implementation. Repository interfaces in domain layer but Data classes in data layer.
 
 
 Project Requirement Use Case: 
 View Movie
 Update Movie
 View TV shoes
 Update Tv Shows
 View Artists
 Update Artist

Presentation layer:
 + Activity:
 + Viewmodel
 + ViewmodelFactor

Data Layer:
 + Api/serviceInterface
 + Db/database and interface
 + Data/ model classes

Datasource
 + Datasourceimplementation
 + And then finally datarepositoryimple class 

Domain Layer:
 + Repository interface
 + UseCasse
 
 Go Bacck to the Activity to set databinding and set observer to load the data and update repository




