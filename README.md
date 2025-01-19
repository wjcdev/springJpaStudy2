# JPA Shop

## 프로젝트 소개
JPA Shop은 Spring Boot와 JPA를 사용하여 구현된 간단한 쇼핑몰 백엔드 애플리케이션입니다. 
이 프로젝트는 JPA 학습을 위해 설계되었으며, 주요 기능은 다음과 같습니다:

- 회원 관리 (등록, 조회, 중복 검증 등)
- 상품 관리
- 주문 기능
- 데이터베이스 연동 및 테스트 자동화

본 프로젝트는 **인프런 김영한님의 강좌**를 바탕으로 개발되었습니다.

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
├── src
│   ├── main
│   │   ├── java
│   │   │   └── jpabook
│   │   │       ├── jpashop
│   │   │       │   ├── domain
│   │   │       │   ├── repository
│   │   │       │   ├── service
│   │   │       │   └── controller
│   │   └── resources
│   │       ├── application.yml
│   │       └── static
│   └── test
│       ├── java
│       │   └── jpabook
│       │       └── jpashop
│       │           └── service
│       └── resources
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
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


