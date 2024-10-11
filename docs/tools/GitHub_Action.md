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

#### 2. Events
1. What Are Events?
    In GitHub Actions, events are triggers that start the execution of workflows. Workflows are event-driven, meaning they begin when specific events occur in your GitHub repository. These events can be automatic (like pushing code) or manual (triggered by the user).
    Events define when a workflow should run, and each event can be customized or filtered to meet specific conditions.

2. Types of Events:
   1. **Push Event (push):**
      - Triggers a workflow when code is pushed to a specific branch.
      - Can be filtered to trigger only on specific branches or paths.
      
      Example: Trigger on push to the main branch only:
      ```yaml
        on:
          push:
            branches:
                -main
      ```
      Example: Trigger on push to any branch except main:
      ```yaml
        on:
          push:
            branches-ignore:
                -main
      ```
      
   2. **Pull Request Event (pull_request)**
        - Triggers when a pull request is opened, synchronized (i.e., when new commits are pushed to the PR), reopened, or closed.
        - Can be filtered to run only on specific branches.
      
        Example: Trigger workflow when a pull request targets the main branch:
      ```yaml
        on:
          pull_request:
            branches:
              - main
      ```
   3. **Schedule Event (schedule):**
      - Triggers the workflows based on a cron schedule.
      - You define a cron expression to specify the exact time or frequency for the event.
      
      - Example: Run workflow every Monday at midnight:
      ```yaml
        on:
          schedule:
            -cron: '0 0 * * 1'
      ```
      Cron expression format:
      ``` 
      ┌───────────── minute (0 - 59)
      │ ┌───────────── hour (0 - 23)
      │ │ ┌───────────── day of the month (1 - 31)
      │ │ │ ┌───────────── month (1 - 12)
      │ │ │ │ ┌───────────── day of the week (0 - 7) (Sunday to Saturday, 0 and 7 both represent Sunday)
      │ │ │ │ │
      │ │ │ │ │
      * * * * *

       ```
   4. **Manual Event (workflow_dispatch)**
      - Triggers a workflow manually from the GitHub Actions UI.
      - You can optionally define input parameters for the workflow when manually triggered.

      Example: Enable manual trigger with input parameters:
       ```yaml
        on:
          workflow_dispatch:
            inputs:
              environment:
                description: 'Choose deployment environment'
                required: true
                default: 'production'
       ```
      When you trigger the workflow manually, GitHub will prompt you to provide for inputs.
   5. **Release Event(release)**
        - Triggers workflow when a release is published, updated or created in the repository.
        - Commonly used to automate release-related tasks like deploying a new version of an application.
        
        Example: Trigger workflow when a release is published:
        ```yaml 
            on:
              release:
                types: [published]
        ```
      
   6. Issue and Pull Request Events:
      - These are multiple events that can trigger workflows for issues and pull requests, such as:
        - `issues`: Triggered when issues are opened, edited, or closed.
        - `issue_comment`: Triggered when someone comments on an issue.
        - `pull_request_review`: Triggered when a review is submitted on a pull request.

      Example: Trigger when an issue is opened:
        ```yaml
            on:
              issue:
                types: [opened] 
        ```
      
   7. Workflow Run Event(workflow_run)
        - Triggers after another workflow finishes running.
        - Useful for creating dependent workflows where the result of one workflow triggers another.
        
       Example: Trigger a workflow when another workflow completes:
      ```yaml
        on:
          workflow_run:
            workflows: ["Test Workflow"]
            types:
              - completed
      ```
   8. Custom Events
        - You can define custom events within your application using GitHub's REST API to trigger workflows.
        - This is useful for scenarios where built-in events are not sufficient.
      Example:
      ```bash
        curl -X POST \
          -H "Authorization: token $GITHUB_TOKEN" \
          -H "Accept: application/vnd.github.v3+json" \
           https://api.github.com/repos/<owner>/<repo>/dispatches \
           -d '{"event_type":"custom_event"}'
      ```
      In your workflow file:
      ```yaml
        on: 
          repository_dispatch:
            types: [custom_event]
      ```
3. **Event Filters and Conditions:**
   You can filter events to trigger workflows more precisely by specifying certain branches, tags, or paths.
    - Branches: Run workflows only when code is pushed to certain branches or pull requests target specific branches.
   Example: Run on push to main branch only:
   ```yaml
    on:
      push:
        branches:
          - main
   ```
   - Tags: Trigger workflows when new tags are created.
     Example: Run workflow when a tag is pushed:
   ```yaml
    on:
      push:
        tags:
          - 'v*' # Matches any tag that starts with 'v'
   ```
   - Paths: Run workflows when changes occur in specific files or directories.
   Example: Trigger when files in the src directory are changed:
     ```yaml
        on:
          push:
            paths:
              - 'scr/**'
     ```
   - Types: Some events, like issues or pull_request, can be filtered by specific types. For instance, you can trigger workflows only when an issue is opened but not when it's edited or closed.
   Example:
     ```yaml
        on:
          issues:
            types: [opened]
     ```
4. **Common Use Cases for Events:**
    - Push and PR Validation: Use the push and pull_request events to run tests and checks on new commit or changes to a repository.
    - Scheduled Tasks: Use the schedule event to trigger automated maintenance tasks,, suc as cleaning up old branches, refreshing a cache, or updating dependencies.
    - Manual Deployment: Use `workflow_dispatch` to trigger deployments or maintenance tasks manually from the GitHub UI.
    - Release Automation: Automate versioning and deployment tasks using the release event when a new release is published. 

#### 3. Jobs
1. What Are Jobs?
   In GitHub Actions, jobs represent a series of steps that are executed in a workflow. A job defines what actions need to be taken and on
   which environment. Each workflow can consist of multiple jobs, and these jobs can run either in parallel or in sequence depending on how they are configured.
   Jobs are isolated from one another, meaning each job runs in a separate virtual environment and doesn't share data unless explicitly configured to do so.

2. Structure of a Job:
   A job typically has the following components:
   1. Name: A label that describes what the job does.
   2. Run-on: Specifies the operating system or runner where the job will execute (e.g., `ubuntu-latest`).
   3. Steps: The individual task or commands that make up the job. Steps are executed in sequence.

   Example of a Simple Job:
   ```yaml
   jobs:
    build:
      runs-on: ubuntu-latest    # Specify the OS
      steps:
        - name: Checkout code
          uses: actions/checkout@v2   # Check out the code from the repository
        - name: Set up Node.js
          uses: actions/setup-node@v2 # Set up Node.js environment
          with:
            node-version: '14'
        - name: Install dependencies
          run: npm install     # Install project dependencies
        - name: Run tests
          run: npm test        # Run test commands
     ```
3. Key Components of a Job
   1. runs-on
      - Defines the environment (runner) on which the job runs.
      - Option include:
        - `ubuntu-latest`: Ubuntu environment.
        - `windows-latest`: Windows environment.
        - `macos-latest`: macOS environment.
      - You can also specify a specific version, such as `ubuntu-20.04` or `windows-2019`.
      Example:
        ```yaml
         runs-on: ubuntu-latest
        ```
   2. steps
      - A list of commands or actions that execute in sequence within a job.
      - Steps can:
        - Run shell commands.
        - Use prebuilt GitHub Actions from the marketplace (use keyword).
        - Call custom actions on run script.
      - Each step can have its own name and run command.
      Example:
      ```yaml
      steps:
        - name: Install dependencies
          run: npm install    # Run a shell command to install dependencies
        - name: Run tests
          run: npm test       # Run the test script
      ```
   3. uses
      - Indicates the use of a third-party or pre-built action from GitHub's Actions MarketPlace or a repository.
      - Predefined actions can perform common tasks such as checking out code, setting up a language environment, or deploying code.
      Example:
      ```yaml
        - name: Checkout code
          uses: actions/checkout@V2  
      ```
   4. run
      - Specifies a shell command or script to execute.
      - You can run any command you would normally run in the specified environment (e.g., Linux, macOS, or Windows shell commands).
      Example:
      ```yaml
      run: npm install   # Run the 'npm install' command
      ```
4. Multiple Jobs in a Workflow
   You can define multiple jobs in a single workflow. By default, these jobs run concurrently, but you can control their execution order using job dependencies.
   Example:
   ```yaml
   jobs:
     build:
       runs-on: ubuntu-latest
     steps:
       - name: Checkout code
         uses: actions/checkout@v2
       - name: Build the project
         run: ./gradlew build

     test:
       runs-on: ubuntu-latest
       steps:
       - name: Checkout code
         uses: actions/checkout@v2
       - name: Run tests
         run: ./gradlew test
   ```
   In this example:
   - The build job builds the project.
   - The test job runs the tests, both on the ubuntu-latest runner.

5. Job Dependencies
   You can make jobs dependent on each other by specifying the needs keyword. This ensures that certain jobs will not start until other finish.
   Example:
   ```yaml
    jobs:
      build:
        runs-on: ubuntu-latest
        steps:
          - name: Checkout code
            uses: actions/checkout@v2
          - name: Build the project
            run: ./gradlew build

      test:
        runs-on: ubuntu-latest
        needs: build    # This job will only run after the 'build' job completes
        steps:
          - name: Run tests
            run: ./gradlew test
   ```
   In this example:
   - The test job runs after the build job, due to the needs: build dependency.

6. Matrix Jobs:
   A matrix job allows you to run the same job across multiple environment, configurations, or language versions in parallel. This is useful for testing across different platforms, such as multiple Node.js version or different operating systems.
   Example of a Matrix Job:
   ```yaml
   jobs:
     test:
       runs-on: ubuntu-latest
       strategy:
         matrix:
           node-version: [12, 14, 16]    # Test on Node.js versions 12, 14, and 16
       steps:
         - name: Checkout code
           uses: actions/checkout@v2
         - name: Set up Node.js
           uses: actions/setup-node@v2
           with:
             node-version: ${{ matrix.node-version }}   # Use each Node.js version from the matrix
         - name: Install dependencies
           run: npm install
         - name: Run tests
           run: npm test
   ```
   In this example :
   - The workflow tests the project on Node.js versions 12, 14, and 16, running them in parallel.

7. Sharing Data Between Jobs:
   By default, jobs do not share data, but you can use artifacts or caches to share files between jobs. 
   - Artifacts: Used to upload and share files (e.g., build outputs, test results) between jobs or download them later.
   
     Example:
     ```yaml
     - name: Upload artifact
       uses: actions/upload-artifact@v2
       with:
         name: build-output
         path: build/
     ```
   - Cache: Used to cache dependencies like npm or Gradle files between jobs to speed up subsequent runs.
      Example:
      ```yaml
        - name: Cache npm dependencies
          uses: actions/cache@v2
          with:
            path: node_modules
            key: ${{ runner.os }}-node-${{ hashFiles('package-lock.json') }}
            restore-keys: |
              ${{ runner.os }}-node-
      ```
8. Common Use Cases for Jobs
   1. CI/CD Pipelines: 
      - Jobs can be used to build, test, and deploy applications across different environments or configurations.
      Example: Running build jobs in parallel for multiple platforms (e.g., Linux, Windows, macOS).
   2. Testing Across Versions:
      - Use matrix jobs to test the same code on different language or platform versions.
   3. Conditional Jobs: 
      - You can define conditions for jobs to run, such as running deployment jobs only on the main branch.











