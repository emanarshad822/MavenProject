pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -Dtestng.xml.suite=testng.xml'
            }
        }
        stage('Publish Test Results') {
            steps {
                step([$class: 'Publisher', testResults: 'target/surefire-reports/testng-results.xml'])
            }
        }
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts 'target/*.jar'
            }
        }
        stage('Deploy') {
            steps {
                // Add deployment steps here
            }
        }
    }
}