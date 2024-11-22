plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.raul"
version = ""

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// web
	implementation("org.springframework.boot:spring-boot-starter-web")
	//Actuator
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	// SQLITE + DIALECTS + JPA
	implementation("org.xerial:sqlite-jdbc:3.41.2.2")
	implementation("org.hibernate.orm:hibernate-community-dialects")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	// Ojo, data-rest nos pone application/json+hal por defecto en swagger!
//	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	// OPEN API
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

	//
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
