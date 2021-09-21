pipeline {
    agent any

    tools {
       
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build') {
            steps {
                
               // git 'https://github.com/nehalejazi/Selenium1.git'
                
               // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                bat "clean test "
            }

            post {
                
                success {
                   // junit '**/target/surefire-reports/TEST-*.xml'
                   // archiveArtifacts 'target/*.jar'
                    echo "Got teh success"
                }
            }
        }
    }
}
