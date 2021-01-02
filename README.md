# 디자인 패턴

### 디자인 패턴이란

소프트웨어 분야에서 디자인 패턴이란 특정 문맥에서 공통적으로 발생하는 문제에 대한 재사용 가능한 해결책이다. (출처 [위키 백과][https://ko.wikipedia.org/wiki/소프트웨어_디자인_패턴])

---

### 왜 사용할까

데이터와 뷰를 분리시켜 의존성을 낮추며 유지 보수를 편하게 한다.

---

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

**P**resenter : Controller와 유사한 역할을 하지만 인터페이스로 연결되어 종속성을 줄임 (View와 1:1로 연결)

Model과 View의 의존성이 낮아져 유지보수와 테스트에 장점이 있지만 View와 Presenter사이의 의존성이 강하다.

[공부한 사이트][https://thdev.tech/androiddev/2016/10/23/Android-MVC-Architecture/]
---
### - MVVM
**M**odel :
**V**iew**M**odel :
**M**odel :







