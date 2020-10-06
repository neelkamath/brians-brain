plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.10")
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

application {
    mainClassName = "com.neelkamath.briansbrain.AppKt"
}

kotlin.sourceSets {
    getByName("main").kotlin.srcDirs("src/main")
}

