pipeline{
    agent any
    triggers{
        pollSCM('*/1 * * * *')
    }
    tools{
        maven 'mvn-3.3.9'
    }
    stages{
        stage('Release Build'){
            steps{
                sh "mvn clean install"
            }
        }
        stage('Release'){
            steps{
                sh "mv /Users/zhengzhichao/.m2/repository/org/example/MathUi/1.0-SNAPSHOT/MathUi-1.0-SNAPSHOT.jar ~/Downloads/MathUi.jar"
            }
        }
    }
}