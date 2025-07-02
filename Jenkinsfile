pipeline {
    agent any
    triggers {
        githubPush()
    }
    tools {
        maven 'Maven3' // Make sure it's configured in Jenkins tools
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
