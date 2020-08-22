# 도서 관리 프로그램

<img src="https://img.shields.io/badge/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EC%8B%9C%EC%9E%91-2020.07.29-green"> <img src="https://img.shields.io/badge/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EC%A2%85%EB%A3%8C-2020.09.04-orange">

<p align="center">
화이팅!!!!!!!!

------------------------------------------
### 패키지 구성 설명
###### 작성자 : 대현 20/08/22

<p>project_library</p> 
- 최상위 메인 + 트랜잭션 기능수행

<p>project_library.conn</p>
- JdbcUtil (계정연결 & 환경설정)

<p>project_library.dao</p>
- 패키지.impl의 인터페이스
- 말그대로 인터페이스...껍데기일뿐임...메서드 정의만 여기서 함
- 패키지.impl의 데이터는 패키지.service와 연결됨

<p>project_library.dao.impl</p>
- DB와 데이터 주고받는 실제 구현부

<p>project_library.dto</p>
- 데이터 정의

<p>project_library.exception</p>
- 예외처리

<p>project_library.service</p>
- 패키지.impl와 사용자단 (패키지.ui.frame) 을 연결하는 통로역할

<p>project_library.ui.component</p>
- 패키지.ui.frame안에 들어가는 모든 구성 요소

<p>project_library.ui.frame</p>
- 실제 사용자단 프레임
- 각 main 들어있음 
- 패키지.dto, 패키지.service, 패키지.ui.component와 연결되어 있음
------------------------------------------

