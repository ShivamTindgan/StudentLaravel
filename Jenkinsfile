// pipeline {
//     agent any
//
//     tools {
//         jdk 'myjava'
//         maven 'mymaven'
//     }
//
//     stages {
//         stage('Checkout') {
//             steps {
//                 checkout scm
//             }
//         }
//
//         stage('Build') {
//             steps {
//                 sh 'mvn clean package'
//             }
//         }
//     }
// }
pipeline {
    agent any

    tools {
        jdk 'myjava'
        maven 'mymaven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate HTML Report') {
            steps {
                sh 'mvn site'
            }
        }
//         stage('Debug Report Files') {
//             steps {
//                 sh 'find target/site -type f | sort'
//             }
//         }
    }

   post {
       always {
           junit 'target/surefire-reports/*.xml'

           publishHTML(target: [
               allowMissing: true,
               alwaysLinkToLastBuild: true,
               keepAll: true,
               reportDir: 'target/surefire-reports',
               reportFiles: 'index.html',
               reportName: 'Surefire Test HTML Report'
           ])

           publishHTML(target: [
               allowMissing: true,
               alwaysLinkToLastBuild: true,
               keepAll: true,
               reportDir: 'target/site',
               reportFiles: 'index.html',
               reportName: 'Maven Site Report'
           ])
       }
   }
}