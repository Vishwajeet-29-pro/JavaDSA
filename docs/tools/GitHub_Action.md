# GitHub Actions
GitHub Actions is a powerful tool for automating software workflows directly within GitHub repositories.
With Actions, you can create continuous Integration (CI) and Continuous Deployment (CD) pipelines, automates code reviews, manage issues, and much more.

## Why GitHub Actions?
GitHub Actions integrates directly into your GitHub repositories and offers several advantages:
1. Seamless Integration: No need for external CI/CD services, as it's embedded within GitHub.
2. Ease of Use: Pre-built actions from the GitHub Marketplace help in setting up CI/CD pipelines quickly.
3. Customizable: Allows users to create custom workflows that suit any kind of automation, testing, deployment, or notification requirements.
4. Concurrent Jobs: Run multiple jobs in parallel, increasing efficiency.
5. Matrix Builds: Test your application across different platforms, databases, and languages easily.
6. Cost Efficiency: Free for public repositories, with reasonable price plans for private repositories.
7. Rich Ecosystem: Supports major languages and frameworks including Java, Kotlin, Node.js, Python, and more.

[Workflows](#1-workflows) <br>
[Events](#2-events) <br>
[Jobs](#3-jobs) <br>
[Steps](#4-steps) <br>
[Actions](#5-actions) <br>
[Runners](#6-runners) <br>
[Secrets and Environment Variables](#7-secrets-and-environment-variables) <br>
[Matrix Builds](#8-matrix-builds) <br>
[Caching and Artifacts](#9-caching-and-artifacts) <br>
[Triggers](10-triggers) <br>
[Permission and Access Control](11-permissions-and-access-control) <br>
[Notification](#12-notification) <br>
[workflow Concurrency](#13-workflow-concurrency) <br>
[Reusability of Workflows](#14-reusability-of-worksflows) <br>


## Components of GitHub Actions
#### 1. Workflows
- A workflow is a configurable-automated process that can be triggered by an event in the GitHub repositories, such as code pushes, pull request, or on schedule.
- Defile in `.github/workflows/*.yml`

**Example Workflow for Kotlin/Gradle:**
```yaml
name: Build and Test

on:
  push:
    branches:
      - main
  pull_request:
    branches:
      - main

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout code
      uses: actions/checkout@v2

    - name: Set up JDK
      uses: actions/setup-java@v2
      with:
        java-version: '17'

    - name: Build with Gradle
      run: ./gradlew build

    - name: Run Tests
      run: ./gradlew test
```
**Core Concepts of Workflows**
- YAML Configuration: GitHub workflows are configured in YAML, and each workflow file is named with a `.yml` extension inside the `.github/workflows/` folder.
- Event-Driven: Workflows are triggered by events (e.g., `push`, `pull_request`, `schedule`). Events define when the workflows start. Multiple events can trigger a single workflow, and you can filter events to be more specific (e.g., only trigger on `push` to `main`).
- Jobs: Each workflow contains one or more jobs. Jobs define a sequence of steps that GitHub will execute. Jobs can run in parallel by default unless you specify dependencies.
- Steps: Inside each job, steps define individual tasks. A step can run shell commands, call an external action, or execute scripts.

**Multiple Workflows:** You can have multiple workflows in a single repository. Each workflow can be triggered by different events or conditions.

Example: 
- A workflow for building and testing code on push.
- Another workflow for deploying code on `release` or manual triggers.
```yaml
# .github/workflows/build.yml
name: Build and Test
on:
  push:
    branches:
      - main
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout repository
        uses: actions/checkout@v2
      - name: Build with Gradle
        run: ./gradlew build
```
```yaml
# .github/workflows/deploy.yml
name: Deploy to Production
on:
  release:
    types: [published]
jobs:
  deploy:
    runs-on: ubuntu-latest
    steps:
      - name: Deploy to Production
        run: ./deploy-to-prod.sh
```
