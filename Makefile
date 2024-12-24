# Variables
GRADLE := ./gradlew
BUILD_DIR := build
JAR_FILE := $(BUILD_DIR)/libs/Java-DSA-1.0-SNAPSHOT.jar

# Targets
.PHONY: all build clean run test

all: build

# Build the project
build:
	$(GRADLE) build

# Clean build directory
clean:
	$(GRADLE) clean

# Run the main application
run: build
	java -jar $(JAR_FILE)

# Run the tests
test:
	$(GRADLE) test
	@echo "Tested the entire project."

-include .User.mk
