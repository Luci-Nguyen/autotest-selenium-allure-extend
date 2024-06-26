pipeline {
    agent any
    stages {
        stage('Get source code') {
            steps {
                git credentialsId: '1', url: 'https://github.com/HOAN-NGUYEN-98/allureAndExtend.git'
                echo 'Source code retrieved'
            }
        }
        stage('Build code') {
            steps {
                bat script: 'mvn compile'
            }
        }
        stage('Run tests') {
            steps {
                bat script: 'mvn test -Dbrowser=localchrome'
            }
        }
        stage('Generate Allure Report') {
            steps {
                 bat script: 'mvn allure:report'
            }
        }
        stage('Publish Allure Report') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    reportName: 'Extent Report',
                    reportDir: 'target/reports',
                    reportFiles: 'ExtentReport.html',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
