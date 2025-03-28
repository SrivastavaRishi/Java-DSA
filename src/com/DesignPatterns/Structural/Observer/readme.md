One Observable
Many Observer
If state changes, notify all the observers.

Use cases:
1. Cric-buzz (ball by ball update observer)
2. Weather station
3. Amazon site (notify me feature)

Notify me : 
Observable interface : StocksObservable
    Concrete class: 
        IphoneObservable
        IpadObservable

Observer interface : NotificationAlertObserver 
    Concrete class:
        EmailAlertObserver
