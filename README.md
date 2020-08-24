# 도서 관리 프로그램
<<<<<<< HEAD
=======

<img src="https://img.shields.io/badge/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EC%8B%9C%EC%9E%91-2020.07.29-green"> <img src="https://img.shields.io/badge/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EC%A2%85%EB%A3%8C-2020.09.04-orange">

<p align="center">
화이팅!!!!!!!!
  
---
## 프로젝트 환경
> 운영체제 : Windows 10   
> 개발환경 : Eclipse,  DBeaver   
> 프로그래밍 언어 : JAVA(Swing)   

---
## 패키지 구성 설명
###### 작성 : 대현 20/08/22

project_library
> 최상위 메인 + 트랜잭션 기능수행
---
project_library.conn
> JdbcUtil (계정연결 & 환경설정)
---
project_library.dao
> 패키지.impl의 인터페이스 /
> 말그대로 인터페이스...껍데기일뿐임...메서드 정의만 여기서 함 /
> 패키지.impl의 데이터는 패키지.service와 연결됨
---
project_library.dao.impl
> DB와 데이터 주고받는 실제 구현부
---
project_library.dto
> 데이터 정의
---
project_library.exception
> 예외처리
---
project_library.service
> 패키지.impl와 사용자단 (패키지.ui.frame) 을 연결하는 통로역할
---
project_library.ui.component
> 패키지.ui.frame안에 들어가는 모든 구성 요소
---
project_library.ui.frame
> 실제 사용자단 프레임 /
> 각 main 들어있음 /
> 패키지.dto, 패키지.service, 패키지.ui.component와 연결되어 있음
>>>>>>> branch 'master' of https://github.com/DaeguIT-MinSuKim/yi_java4st_3team.git
