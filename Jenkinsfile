pipeline {
    agent any

    environment {
        PLAYWRIGHT_BROWSERS_PATH = "/path/to/playwright/browsers" // Adjust path if necessary
    }

    tools {
        // Define the Maven tool you installed on Jenkins
       jdk 'open-jdk 17' 
       maven 'Maven-3.6.3'
        
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the repository
              git branch: 'master', changelog: false, poll: false, url: 'https://github.com/appneural-meenakshirawat/my-springboot-app.git'
            }
        }

        stage('Install Playwright Dependencies') {
            steps {
                // Install Playwright (if not done in the pipeline or system setup)
                sh 'npx playwright install' // You may need to run this on the first time
            }
        }

        stage('Run Playwright Tests') {
            steps {
                // Run the Maven test command
                sh 'mvn clean test'
            }
        }

        stage('Publish Results') {
            steps {
                // Archive the test results (Optional)
                junit '**/target/test-*.xml'
            }
        }
    }

    post {
        always {
            // Clean up or perform any final steps
        }
    }
}

