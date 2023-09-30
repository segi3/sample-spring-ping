pipeline {
    // Directives
    agent any
    tools {
        maven 'maven 3.9.4:java17'
    }

    // read values from pom.xml
    environment{
        ArtifactId = readMavenPom().getArtifactId()
        Version = readMavenPom().getVersion()
        Name = readMavenPom().getName()
        GroupId = readMavenPom().getGroupId()
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

        // temporary stage 3a : print environments variables
        stage('Print Environment Variables') {
            steps {
                echo "ArtifactId is '${$ArtifactId}'"
                echo "Version is '${Version}'"
                echo "GroupId is '${GroupId}'"
                echo "Name is '${Name}'"
            }
        }

        // stage 3 : publish artifact to nexus
        stage('Publish') {
            steps {
                nexusArtifactUploader artifacts: [[
                    artifactId: 'demo',
                    classifier: '',
                    file:'target/demo-0.0.4-SNAPSHOT.war',
                    type: 'war'
                ]],
                credentialsId: '92392516-babb-4782-af42-f2945db4e328', groupId: 'org.springframework.boot',
                nexusUrl: '172.20.10.124:8081',
                nexusVersion: 'nexus3',
                protocol: 'http',
                repository: 'SPRING-SNAPSHOT',
                version: '0.0.4-SNAPSHOT'
            }
        }

        // stage 4 : deployment
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}