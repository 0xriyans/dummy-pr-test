# Dummy PR Test Project

This is a dummy Spring Boot application created specifically to test the **Gemini PR Reviewer** tool. 

## ⚠️ Warning
**DO NOT DEPLOY THIS TO PRODUCTION!**

This project intentionally contains numerous critical security vulnerabilities, bad practices, and code smells. It is designed to act as a playground to evaluate how well automated code review tools (like the Gemini PR Reviewer) can detect security issues and suggest improvements.

## Included Vulnerabilities
The codebase contains several hidden vulnerabilities disguised within normal-looking REST controllers:
- **SQL Injection (SQLi)**
- **OS Command Injection**
- **Path Traversal / Local File Inclusion (LFI)**
- **Weak Cryptography & Insecure Hashing (MD5, AES/ECB)**
- **XML External Entity (XXE) Injection**
- **Hardcoded Secrets & Thread-Safety Issues**

None of the files contain explicit comments about their vulnerabilities, forcing the PR reviewer to perform deep static analysis.

## Prerequisites
- Java 17
- Maven 3.8+

## How to Run
To run this application locally, use the provided Maven wrapper or your local Maven installation:

```bash
mvn spring-boot:run
```

The application will start on the default port `8080`.

## Testing the PR Reviewer
To test your Gemini PR Reviewer:
1. Push this codebase to a GitHub repository.
2. This project includes a GitHub Actions workflow (`.github/workflows/ai-pr-reviewer.yml`) that automatically sends the required webhook payload to your AI Reviewer app.
   > **Note on the Webhook URL**: The workflow is configured to send the payload to `<YOUR_WEBHOOK_URL>`. You will need to update this placeholder in the `.github/workflows/ai-pr-reviewer.yml` file with the actual public URL where your `gemini-pr-reviewer` bot is running and accessible from GitHub.
3. Create a Pull Request (for example, modifying one of the controllers or adding a new feature).
4. The GitHub workflow will execute and trigger the Gemini PR Reviewer.
5. Wait for the Gemini PR Reviewer to analyze the code and observe if it successfully identifies the hidden security vulnerabilities.
