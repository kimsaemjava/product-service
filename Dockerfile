#FROM openjdk:17-alpine
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} productservice.jar
#ENTRYPOINT ["java","-jar","/productservice.jar"]
#빌드할 이미지로 jdk17과 해당 gradle을 지정
FROM gradle:8.11.1-jdk17 AS build
#소스코드를 복사할 작업디렉토리 생성
WORKDIR /myapp
#호스트머신의 소스코드를 작업디렉토리로 복사
COPY . /myapp
#이전 빌드에서 생성된 모든 build/ 디렉토리 내용을 삭제합니다.새롭게 빌드를 시작하기 위해 필요한 명령어
#프로젝트를 빌드-compileJava, test, jar가 실행
#Gradle 데몬을 사용하지 않고 즉시 실행
RUN gradle  clean build --no-daemon

FROM openjdk:17-alpine
WORKDIR /myapp
#빌드이미지에서 생성된 jar파일을 런타임 이미지로복사
COPY --from=build /myapp/build/libs/*.jar /myapp/productservice.jar
EXPOSE 9300
CMD ["java","-jar","productservice.jar"]