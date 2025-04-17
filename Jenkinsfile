pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Pull the latest code from the Git repository
                git 'https://github.com/khaled544/WebAutoamtionLearning-1.git'
            }
        }

        stage('Build') {
            steps {
                // Run build commands (adjust as per your project)
                sh 'mvn clean install'  // Example for a Maven project
            }
        }

        stage('Test') {
            steps {
                // Run the tests (e.g., Selenium, Unit Tests)
                sh 'mvn test'  // Example for running tests using Maven
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the app (adjust with your deployment process)
                sh './deploy.sh'
            }
        }
    }

    post {
        always {
            // Clean up, send notifications, or generate reports
            junit '**/target/test-*.xml'  // Example for test report
        }
    }
}
