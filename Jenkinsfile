pipeline{
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage("Test"){
            steps{  
                // mvn test
                bat 'mvn test'
                slackSend channel: 'jenkins-test', message: 'Job started'
            }
        }
        stage("Build"){
            steps{
                // mvn package
                bat 'mvn package'
                echo "========executing Build========"
            }
        }
        stage("Deploy on test"){
            steps{
                // deploy on test -> plugin
                deploy adapters: [tomcat9(credentialsId: 'f3e7db22-e4cc-4384-813e-a5c1e10f13fe', path: '', url: 'http://localhost:2525')], contextPath: '/app', war: '**/*.war'
                echo "========executing Deploy on test========"
            }
        }
        stage("Deploy on Prod"){
            steps{
                // deploy on container -> plugin 
                deploy adapters: [tomcat9(credentialsId: 'f3e7db22-e4cc-4384-813e-a5c1e10f13fe', path: '', url: 'http://localhost:2525')], contextPath: '/app', war: '**/*.war'
                echo "========executing Deploy on Prod========"
            }
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
            slackSend channel: 'jenkins-test', message: 'Job Success'
        }
        failure{
            echo "========pipeline execution failed========"
            slackSend channel: 'jenkins-test', message: 'Job Failed'
        }
    }
}
