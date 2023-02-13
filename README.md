# 스마트웹 모바일 서비스를 위한 클라우드 기반의 MSA 풀스택 자바 개발 과정

## 스프링 부트 게시판 실습

### 데이터베이스 연동 설정
- application.properties
- DatabaseConfiguration.java 

### 게시판 목록 조회 기능
- BoardController.openBoardList()
- BoardService.selectBoardList()
- BoardServiceImpl.selectBoardList()
- BoardMapper.selectBoardList()
- sql-board.xml > selectBoardList
- boardList.html

### 게시판 등록 기능 구현
- BoardController.openBoardWrite()
- BoardController.insertBoard(BoardDto boardDto)
- BoardService.insertBoard(BoardDto boardDto)
- BoardServiceImpl.insertBoard(BoardDto boardDto)
- BoardMapper.insertBoard(BoardDto boardDto)
- sql-board.xml > insertBoard
- boardWrite.html

### 게시판 수정 기능 구현

### 게시판 삭제 기능 구현

### 로깅 기능 구현

### 인터셉터를 이용한 요청 시작과 끝 로그 출력

### AOP를 이용한 Contrller, ServiceImpl, Mapper 로그 출력

### @Transactional 어노테이션을 이용한 트랜잭션 설정

### AOP를 이용한 트랜잭션 설정


## 블로그 & 뉴스 스타일 페이지 연동 실습

### t_topic 테이블 / 특집 기사 연동

### 특집 기사 클릭 시 메인 화면에 내용 출력 

### 기사 등록 with 파일 업로드

### 기사 카테고리 등록 (checkbox 데이터 저장)

### 관련 기사, 추천 기사, 인기 기사 테이블 생성 및 조회

