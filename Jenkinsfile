pipeline {
    agent any
    triggers {
        githubPush()
    }
    tools {
        maven 'maven_Akshay_name' // Make sure it's configured in Jenkins tools
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
