plugins {
    id("java")
    id("com.google.protobuf") version "0.9.4"
}

group = "net.unnamed"
version = "1.0-SNAPSHOT"

dependencies {
    api("io.nats:jnats:2.20.5")

    api("com.google.protobuf:protobuf-javalite:4.28.2")
    implementation("com.google.protobuf:protobuf-java-util:4.28.2")

    implementation("com.google.protobuf:protoc:4.28.2")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:4.28.2"
    }
    generateProtoTasks {
        all().configureEach {
            builtins {
                named("java") {
                    option("lite")
                }
            }
        }
    }
}

sourceSets {
    main {
        proto {
            srcDir("../proto")
        }
    }
}