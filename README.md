# Simple Community

안드로이드의 기초와 지금까지 공부했던 내용 정리 + 부족한 부분 추가 삭제용 프로젝트

## Getting Started / 어떻게 시작하나요?

https://developer.android.com/studio

### Prerequisites / 선행 조건

아래 사항들이 설치가 되어있어야합니다.

```
Android Studio 4.2.2          
```

### Installing / 설치

아래 사항들로 현 프로젝트에 관한 모듈들을 설치할 수 있습니다.

```
gradle : 4.2.2
kotlin_version : 1.5.10
----------------------------
retrofit2 : 2.9.0
okhttp3 : 3.9.1
rxjava3 : 3.0.0
* [richEditor : 2.0.0](https://github.com/wasabeef/richeditor-android)
```

## Built With / 누구랑 만들었나요?

* [gongul](https://github.com/gongul) - 백엔드,api 서버 제공
* [Cheese Allergy Hamster](https://github.com/shlifedev) - 개발관련 지식 제공

## 개발 기능 체크

- 로그인
  
| 기능 | 내용 |
| --- | --- |
| `자동로그인` | 스플래시 화면에서 유저 정보를 불러오며 토큰의 유효함 검사. |
| `이메일인증` | 이메일 인증을 한 유저들만 로그인 가능하도록 수정 |

- 게시판
  
| 기능 | 내용 |
| --- | --- |
| `게시글 작성` | 아래 별도의 공부내용으로 정리 |
| `` |  |  

## 개발 개선, 수정해야하는 목록

- 게시판
  
| 기능 | 내용 | 수정완료 |
| --- | --- | --- |
| `response code 핸들러 만들기` | 요청시마다 리스폰스 코드를 적어야해서 분리 처리 | |
| `파이어베이스` | 푸쉬알림, 액션 로그 찍어보기, 구글 로그인 추가 | |
| `플레이스토어 배포` | 구글 플레이스토어로 앱 배포 해보기 | |


## 공부한 내용 정리

```
Rich Editor를 이용한 게시판 제작
게시판을 만들기 위한 조건
    - html로 파싱해줄 수 있고 간단한 에디터 기능을 제공하는 라이브러리 찾기

Rich Editor에서 다양한 함수로 기능 제공
    - 라이브러리 내부에서 html로 text 제공해주는 코드를 가지고 있음

고민거리
    - 서버에서 제공해주는 editor로 작성한 text는 어떻게 보여줄것인가 알아보기.
```


