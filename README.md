# 🤖 Dummy PR Test Project

[![Vulnerabilities](https://img.shields.io/badge/Vulnerabilities-Intentionally_Included-red.svg)](#included-vulnerabilities)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen.svg)](#prerequisites)
[![Java](https://img.shields.io/badge/Java-17-blue.svg)](#prerequisites)

This is a dummy Spring Boot application created specifically to test the **Gemini PR Reviewer** tool. 

> [!WARNING]
> **DO NOT DEPLOY THIS TO PRODUCTION!**
> This project intentionally contains numerous critical security vulnerabilities, bad practices, and code smells. It is designed to act as a playground to evaluate how well automated code review tools (like the Gemini PR Reviewer) can detect security issues and suggest improvements.

## 🐛 Included Vulnerabilities

The codebase contains several hidden vulnerabilities disguised within normal-looking REST controllers. The PR reviewer must perform deep static analysis as there are no explicit comments about these issues:

*   **SQL Injection (SQLi)**
*   **OS Command Injection**
*   **Path Traversal / Local File Inclusion (LFI)**
*   **Weak Cryptography & Insecure Hashing** (MD5, AES/ECB)
*   **XML External Entity (XXE) Injection**
*   **Hardcoded Secrets & Thread-Safety Issues**

## ⚙️ Prerequisites

*   **Java 17**
*   **Maven 3.8+**

## 🚀 How to Run

To run this application locally, use the provided Maven wrapper or your local Maven installation:

```bash
./mvnw spring-boot:run
```

The application will start on the default port `8080`.

## 🧪 Testing the AI PR Reviewer

To test your Gemini PR Reviewer against this project:

1.  **Push** this codebase to your own GitHub repository.
2.  **Configure the Webhook**: This project includes a GitHub Actions workflow (`.github/workflows/ai-pr-reviewer.yml`) that automatically sends the required webhook payload to your AI Reviewer app. 
    > [!NOTE]
    > Ensure you have updated the webhook URL in `.github/workflows/ai-pr-reviewer.yml` to your active public tunnel (e.g., your `pinggy` or `ngrok` URL) pointing to your local `gemini-pr-reviewer` instance.
3.  **Create a Pull Request**: Make a small change (for example, modifying one of the controllers or adding a new vulnerable feature) and open a PR.
4.  **Review the Action**: The GitHub workflow will execute and trigger the Gemini PR Reviewer.
5.  **Check the Results**: Wait a few moments, and observe if the Gemini PR Reviewer successfully identifies the hidden security vulnerabilities in a PR comment.
