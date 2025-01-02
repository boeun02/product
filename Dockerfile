# Step 1: 베이스 이미지로 Ubuntu를 사용
FROM ubuntu:latest

# Step 2: 작성자 정보
LABEL authors="82108"

# Step 3: 필요한 패키지 설치 (Java JDK 설치)
RUN apt-get update && apt-get install -y openjdk-21-jdk

# Step 4: 서버 애플리케이션 JAR 파일을 컨테이너에 복사
# 로컬의 target 폴더에서 빌드된 JAR 파일을 컨테이너로 복사
COPY ./build/libs/webservice-client-0.0.1-SNAPSHOT-plain.jar /app/server-application.jar

# Step 5: 컨테이너 시작 시 실행할 명령 (JAR 파일 실행)
ENTRYPOINT ["java", "-jar", "/app/server-application.jar"]

# Step 6: (옵션) 컨테이너가 실행될 때 포트를 열기
EXPOSE 8080