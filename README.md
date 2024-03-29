### - MVC

**M**odel : 데이터를 저장 및 처리, 비즈니스 로직

**V**iew : UI (Activity, Fragment ...)

**C**ontroller : 사용자의 입력을 받음

주로 웹에서 사용되는 구조, 

웹에서는 View와 Controller가 분리되지만 안드로이드에서는 View와 Controller가 Activity에서 같이 공존함. 

배우기엔 쉽지만 코드가 난잡해지고 View와 Model의 의존성이 생긴다. 이로 인해 유지 보수가 어려워진다.

---

### - MVP

**M**odel : 데이터를 저장 및 처리, 비즈니스 로직

**V**iew : UI (Activity, Fragment ...)

**P**resenter : Controller와 유사한 역할을 하지만 인터페이스로 연결되어 종속성을 줄임 (View와 1:1로 결합)

Model과 View의 의존성이 낮아져 유지보수와 테스트에 장점이 있지만 View와 Presenter사이의 의존성이 강하다.

[공부한 사이트](https://thdev.tech/androiddev/2016/10/23/Android-MVC-Architecture/)

---

### - MVVM

**M**odel : 데이터를 저장 및 처리, 비즈니스 로직

**V**iew : UI, MVVM에서 View는 ViewModel의 데이터 바인딩을 통해 데이터의 변경을 주시(Observe)하고 변경이 있다면 UI에 반영한다.

**V**iew**M**odel : Model에서 제공받은 데이터를 가공하고 이벤트를 보낸다. (View와 1:n으로 결합할 수 있으며 View에 대한 내용을 참조해서는 안된다.)

MVP 패턴의 View와 Presenter 사이의 높은 의존성을 보완하기 위해 만들어진 패턴

**AAC (Android Architecture Components)** 을 사용하면 편함 Ex) Room(내부 저장소), LiveData, ViewModel(AAC) ...



