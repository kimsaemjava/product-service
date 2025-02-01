# 🏗️ 1️⃣ 빌드 스테이지 - Gradle을 사용하여 애플리케이션 빌드
FROM gradle:8.11.1-jdk17 AS build
WORKDIR /myapp

# 🔥 Gradle 캐시 최적화: Gradle 종속성을 먼저 복사하여 캐싱 활용
COPY gradle /myapp/gradle
COPY gradlew /myapp/
COPY build.gradle settings.gradle /myapp/
RUN chmod +x gradlew

# 🔥 종속성 캐싱을 위해 먼저 Gradle 종속성 다운로드 (변경이 적음)
RUN ./gradlew dependencies --no-daemon
# 🔥 소스 코드 복사 (이전 단계보다 아래에 배치하여 변경 사항 최소화)
COPY src /myapp/src

# 🔥 빌드 실행 (테스트 제외하여 속도 개선)
RUN ./gradlew clean build --no-daemon -x test

# 🎯 2️⃣ 런타임 스테이지 - 최종 실행 환경 설정
FROM openjdk:17-alpine
WORKDIR /myapp

# 🔥 빌드한 JAR 파일을 복사
COPY --from=build /myapp/build/libs/*.jar /myapp/productservice.jar

# 🔥 컨테이너가 실행될 포트 설정
EXPOSE 9301

# 🔥 엔트리포인트 설정
CMD ["java", "-jar", "/myapp/productservice.jar"]