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
            }
        }
        stage("Build"){
            steps{
                // mvn package
                bat 'mvn package'
            }
        }
        stage("Deploy on test"){
            steps{
                // deploy on test -> plugin
                deploy adapters: [tomcat9(credentialsId: 'f3e7db22-e4cc-4384-813e-a5c1e10f13fe', path: '', url: 'http://localhost:2525')], contextPath: '/app', war: '**/*.war'
            }
        }
        stage("Deploy on Prod"){
            steps{
                // deploy on container -> plugin 
                deploy adapters: [tomcat9(credentialsId: 'f3e7db22-e4cc-4384-813e-a5c1e10f13fe', path: '', url: 'http://localhost:2525')], contextPath: '/app', war: '**/*.war'
            }
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}
