# BackEnd_introduction
API와 controler들을 만들어서 model, view,에 대해 알아 보았다. 또한 RESI API를 왜 설치해야하는 지 어떻게 사용하는 지에 대해 알아보았다.

## JAVA
### Controller , Repository , Entity , DTO
> Controller : 사용자의 명령에 따라 수행 후, 지정한 뷰에 모델 객체를 넘겨준다.
> Repository : 서버의 명령에 따라 DB에서 SQL을 수행하거나 접근할 때 사용한다. (interface로 구현)
> Entity : DB에서 데이터를 저장하는 형태
> DTO(Dtat Transfer Object) : MVC 패턴에서는 주로 Client 와 Controller 사이에서 DTO 가 사용된다.
> Service
> ApiController

## resource
> 뷰 페이지 : .mustache로 구현, 자바스크립, HTML , CSS 형태도 볼 수 있다.

## 최종 기능
=> 사용자가 회원가입을 한다. 그 후 MyPage에서 사용자의 정보를 볼 수 있다.
MyPage에서는 자신이 작성한 댓글을 볼 수 있다.
게시글 작성, 사진, 제목 , 본문 으로 CRUD(작성 검색 수정 삭제) 할 수 있다.
다른 게시글에 댓글 또한 남길 수 있다.

## 현 기능
사용자 회원가입, 게시글 CRUD, 댓글 CRUD
 -2024.02.04 : MyPage에서 비밀번호 변경 기능, 게시글로 넘어가는 기능 구현
 -2024.02.20 : MEMBER의 PK를 ARTICLE의 FK로 연결

## 구현해야하는 기능
비밀번호 암호화, MyPage 꾸미기, 사용자 테이블과 게시글 테이블 댓글 테이블 연결(아직 MYPAGE에 나의 articles 출력 X),
게시글 사진 첨부 가능하게 꾸미기, 회원가입 추가 기능(중복, 이름 등등)
