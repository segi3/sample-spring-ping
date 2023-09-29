pipeline {
    // Directives
    agent any
    tools {
        maven 'maven 3.9.4:java17'
    }

    stages {

        // stage 1 : build
        stage ('Build') {
            steps {
                sh 'mvn clean install package'
            }
        }

        // stage 2 : testing
        stage('Test') {
            steps {
                echo 'Do testing here..'
            }
        }

        // stage 3 : deployment
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}