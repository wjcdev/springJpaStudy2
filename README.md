# JPA Shop

## 프로젝트 소개
# 🛠 Spring JPA Study 2 (API 중심 학습)

이 저장소는 **김영한님의 "스프링 JPA 2" 강의**를 기반으로 **API 중심 학습**을 진행하는 프로젝트입니다.  
주요 목표는 JPA와 Spring Boot를 활용하여 **RESTful API를 구축하고, 실무에서 활용 가능한 코드 패턴을 익히는 것**입니다.

---

## 📌 학습 목표
- JPA 기본 개념 및 활용
- Spring Data JPA 활용
- API 개발을 위한 DTO & 엔티티 설계
- 쿼리 최적화 및 성능 개선 (fetch join, N+1 문제 해결)
- API 트랜잭션 관리 및 서비스 계층 구조
- 테스트 코드 작성 및 Best Practice 적용


---

## 개발 환경

### 시스템 요구 사항
- **Java**: OpenJDK 21 (LTS)
- **Gradle**: 8.10.2
- **IDE**: IntelliJ IDEA 또는 기타 Java IDE
- **Database**: H2 (in-memory database)
- **OS**: Mac OS X 15.1.1 (aarch64) 또는 이에 상응하는 환경

### 주요 라이브러리 및 프레임워크
- Spring Boot 3.2.11
- Spring Data JPA
- Hibernate 6.4.10.Final
- H2 Database
- JUnit 5

---

## 프로젝트 구조

```
## 📂 프로젝트 구조
jpashop/
├── .gradle/                # Gradle 관련 파일
├── .idea/                  # 인텔리제이 프로젝트 설정 파일
├── build/                  # Gradle 빌드 결과 폴더
├── gradle/                 # Gradle Wrapper 관련 파일
├── src/
│   ├── main/
│   │   ├── java/jpabook/jpashop/
│   │   │   ├── controller/    # API 및 MVC 컨트롤러
│   │   │   ├── domain/        # JPA 엔티티 (DB 모델)
│   │   │   ├── exception/     # 예외 처리 관련 클래스
│   │   │   ├── repository/    # JPA Repository (데이터 액세스)
│   │   │   ├── service/       # 비즈니스 로직
│   │   │   ├── Hello.java     # 테스트용 클래스
│   │   │   ├── HelloController.java  # 간단한 컨트롤러
│   │   │   ├── JpashopApplication.java  # 메인 실행 클래스
│   │   ├── resources/
│   │   │   ├── static/        # 정적 리소스 (CSS, JS, 이미지)
│   │   │   ├── templates/     # Thymeleaf HTML 템플릿
│   │   │   ├── application.yml  # Spring Boot 설정 파일
│   │   │   ├── spy.properties  # 추가적인 설정 파일
│   ├── test/
│   │   ├── java/               # 테스트 코드 (JUnit 등)
│   │   ├── resources/
│   │   │   ├── application.yml  # 테스트 환경 설정
├── build.gradle (또는 pom.xml)  # Gradle/Maven 빌드 파일
├── README.md                   # 프로젝트 설명 파일
├── .gitignore                   # Git Ignore 설정

```

---

## 실행 방법

### 1. 프로젝트 클론
```bash
git clone <레포지토리 주소>
cd jpaShop
```

### 2. Gradle 빌드
```bash
./gradlew build
```

### 3. 애플리케이션 실행
```bash
./gradlew bootRun
```

### 4. H2 콘솔 접속
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- 사용자 이름: `sa`
- 비밀번호: (없음)

---

## 테스트

### 테스트 실행
```bash
./gradlew test
```

### 주요 테스트 항목
1. 회원 가입 테스트
2. 중복 회원 예외 테스트
3. 상품 관리 및 주문 테스트


