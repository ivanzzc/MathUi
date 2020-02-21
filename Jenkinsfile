pipeline{
    agent any
    triggers{
        pollSCM('*/1 * * * *')
    }
    tools{
        maven 'mvn-3.3.9'
    }
    stages{
        stage('Checking Build'){
            steps{
                sh "mvn clean verify"
            }
        }
    }
}