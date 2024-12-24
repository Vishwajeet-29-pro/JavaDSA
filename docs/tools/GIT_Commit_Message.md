## GIT commit messages:
Git commits are a way to “record changes to a repository.” A Git repository is the collection of files tracked in the 
.git folder of a project. In simple terms, a commit is a snapshot of your local repository.
It can be helpful to think of a commit as a checkpoint or savepoint for your project. Similarly, a Git commit is usually
performed after a significant contribution is made to your project, and you want to save your progress. 

With that perspective, it’s easy to understand why `git commit` is one of the most frequently used Git commands. Each 
time a developer performs a commit, they’re given the option to write what’s called a commit message. Git commit messages 
are used to explain the function of the commit. 

### What Makes a Good Commit
If by taking a quick look at previous commit messages, you can discern what each commit does and why the change was made, 
you’re on the right track. But if your commit messages are confusing or disorganized, then you can help your future self 
and your team by improving your commit message practices with help from this article.

For example, if you committed after making a simple update to the README file of a project, you might include a message 
that looks something like this: “Updates README for punctuation”. Now imagine a README file update with any of the 
following commit messages: “uPdatEd puNcTUatiOn”, “made fixes”, or “Chipotle rules”. It’s easy to see how this style of 
commit message could get out of control. While you might get away with one or two off-topic or unclear commit messages, 
they can quickly come back to haunt you and your team after they start adding up.

### Git Commit Message Structure
There are two main components of a Git commit message: the title or summary, and the description. The commit message 
title is limited to 72 characters, and the description has no character limit. While those are the established character
limits, most developers suggest that the commit message summary be no longer than 50 characters, and the description be 
limited to 72. 

Ultimately, the trick to structuring an exceptional commit message is to find the proper balance between brevity and 
detail. Brief enough that it’s easy to read, but detailed enough that it’s easy to understand. 

### Standardize Git Commit Message Structure
Establishing a standardized commit message structure helps keep your repository clean, legible, and makes it easier for 
project contributors to understand the purpose behind each commit.

### Quick Git Commit Message Tips
There are a few things you can do to improve your Git commit messages right off the bat:
1. Avoid unnecessary capitalization
2. Double-check your spelling
3. Don’t end commit message summaries with punctuation

Abiding by these simple guidelines makes it easier to search and filter commits, as well as simply making your repository 
look more visually appealing. Not only are these steps quick and easy to apply, but your team members will thank you.

### Using Imperative Verb Form
Another best practice to help you write good Git commit messages is to use imperative verb form. Using imperative verb 
form ensures that potential verbs used in your commit messages, like “fixed” or “updated” are written in the correct 
tense to “fix” and “updated”. 

### Conventional Commits
The conventional commit message style is another way you can level up your commit messages. The conventional commits 
structure involves starting your commit message with a specified commit type. Commit types include:
- Feat– feature
- Fix– bug fixes 
- Docs– changes to the documentation like README
- Style– style or formatting change
- Perf– improves code performance
- Test– test a feature
- build– changes that affect build system
- Chore– changes to the build process
- ci– Changes to our CI configuration files and scripts
- hotfix– Similar to fix, used in some projects for emergency fixes or critical bug fixes.
- deprecated– Marks a feature or method as deprecated
- refactor– change that neither fixes a bug nor adds a feature
- revert– Reverts a previous commit


Using the conventional commit method makes it easy for project contributors to filter and search for specific commits, 
as shown in the example below:
Summary:
```Docs: Fixes typo on in-from-the-depths.md```

Description:
```Closes ticket #54321```

### How to Edit a Git Commit Message
Because committing is so common in Git workflows, it’s almost guaranteed that at some point you’ll need to know how to 
edit a Git commit message. The most common reasons that would require you to change a Git commit message include typos 
and adding clarifying content.
To Git change a commit message in the command line, you can use:
```git commit --amend -m “new commit message”```

You should be aware that you can only edit your most recent commit. That’s why it’s so important to make sure you 
scrutinize the spelling and formatting of each commit message. 

## Common Types of Commit Messages in depth

feat: A new feature
- Description: Introduces new functionality or a new feature to the codebase.
- Example: feat: add user authentication module

fix: A bug fix
- Description: Fixes a bug or corrects an issue in the code.
- Example: fix: resolve crash on login button click

refactor: A code change that neither fixes a bug nor adds a feature
- Description: Refactoring code, such as improving code structure or readability without changing its behavior.
- Example: refactor: optimize database query logic

chore: Changes to the build process or auxiliary tools and libraries such as documentation generation
- Description: Routine tasks, such as updating dependencies or configuration files, that do not affect the application logic.
- Example: chore: update npm dependencies

docs: Documentation only changes
- Description: Changes or updates to documentation files, such as README.md or code comments.
- Example: docs: add API usage examples to README

style: Changes that do not affect the meaning of the code (white-space, formatting, missing semicolons, etc.)
- Description: Code formatting changes, such as fixing indentation or removing unnecessary whitespace.
- Example: style: reformat code according to style guide

test: Adding missing tests or correcting existing tests
- Description: Changes related to adding or updating tests.
- Example: test: add unit tests for user service

perf: A code change that improves performance
- Description: Optimizations that improve the performance or efficiency of the code.
- Example: perf: reduce image load time by optimizing assets

build: Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)
- Description: Updates to build scripts or dependencies that affect the build system.
- Example: build: migrate from Maven to Gradle build system

ci: Changes to our CI configuration files and scripts (example scopes: Travis, Circle, BrowserStack, SauceLabs)
- Description: Modifications to continuous integration configurations or scripts.
- Example: ci: update Travis CI configuration to include new test suite

revert: Reverts a previous commit
- Description: Reverses a previous commit, effectively undoing a change.
- Example: revert: revert commit abc12345 that caused login issues

hotfix: Similar to fix, used in some projects for emergency fixes or critical bug fixes.
- Description: Quick fixes that need to be deployed immediately.
- Example: hotfix: fix payment gateway downtime issue

deprecated: Marks a feature or method as deprecated
- Description: Indicates that a certain part of the codebase is deprecated and should not be used.
- Example: deprecated: mark legacy API methods as deprecated

