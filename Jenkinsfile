pipeline {
    agent any

   
    tools {
        // Define the Maven tool you installed on Jenkins
       jdk 'open-jdk 17' 
       maven 'maven'
        
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the repository
                checkout scm
            //  git branch: 'master', changelog: false, poll: false, url: 'https://github.com/appneural-meenakshirawat/my-springboot-app.git'
            }
        }


        stage('Run Playwright Tests') {
            steps {
                // Run the Maven test command
                sh 'mvn clean test'
            }
        }


    post {
        always {
            echo "pipline has been run"
        }

        success {
            echo "Docker image pushed successfully!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}

