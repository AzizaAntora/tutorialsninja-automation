pipeline {
    agent any
    triggers {
        cron('H 0 * * *') // Run daily at midnight
    }
    environment {
        BROWSER = 'chrome'
        HEADLESS = 'true'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo/automation-framework.git'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test -Dbrowser=${BROWSER} -Dheadless=${HEADLESS}'
            }
        }
        stage('Archive Report') {
            steps {
                archiveArtifacts 'target/extent-reports/**/*'
                junit 'target/surefire-reports/**/*.xml'
            }
        }
    }
    post {
        always {
            emailext (
                subject: 'Automation Test Results',
                body: '${JELLY_SCRIPT,template="html"}',
                to: 'team@example.com'
            )
        }
    }
}