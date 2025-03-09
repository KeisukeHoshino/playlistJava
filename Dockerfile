FROM openjdk:17-jdk-alpine

# Mavenをインストール
RUN apk add --no-cache maven

# 作業ディレクトリを設定
WORKDIR /app

# pom.xml をコピー
COPY pom.xml ./

# Maven 依存関係を解決
RUN mvn dependency:go-offline -B

# ソースコードをコピー
COPY . ./
EXPOSE 8080 5005

# Java のデバッグ設定
# ENV MAVEN_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"

# ホットリロードを有効にする環境変数を設定
ENV JAVA_OPTS="-Dspring.devtools.restart.enabled=true -Dspring.devtools.livereload.enabled=true"

# アプリケーションをビルド
RUN mvn clean package -DskipTests

# Spring Boot アプリケーションを起動
CMD ["java", "-jar","/app/target/demo-0.0.1-SNAPSHOT.jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"]
