pipeline{
    agent any
    tools {
        maven 'Maven' 
    }
    stages{
        stage("Test"){
            steps{
                // mvn test
                sh "mvn --version"
                echo "========executing A========"
            }
        }
        stage("Build"){
            steps{
                sh "mvn package"
                echo "========executing A========"
            }
        }
        stage("Deploy on Test"){
            steps{
               deploy adapters: [tomcat9(credentialsId: 'vishnuuuuuuu', path: '', url: 'http://3.88.194.126:8080/')], contextPath: '/app', war: '**/*.war'
                echo "========executing A========"
            }
        }
        stage("Deploy on Prod"){
            steps{
               deploy adapters: [tomcat9(credentialsId: 'vishnuuuuuuu', path: '', url: 'http://http://18.212.18.97:8080/')], contextPath: '/app', war: '**/*.war'
                echo "========executing A========"
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
