.PHONY: run-dist
.PHONY: run-pinci
.PHONY: build

run-dist:
	build/install/app/bin/app

run-pinci:
	./build/install/app/bin/app -h
build:
	./gradlew build
	./gradlew test
	./gradlew check