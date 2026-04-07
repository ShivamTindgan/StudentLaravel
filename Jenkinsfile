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
        stage('Checkout StudentLaravel') {
            steps {
                 dir('StudentLaravel'){
                 checkout scm
                 }
            }
        }
        stage('Checkout Laravel_New') {
                    steps {
                        dir('Laravel_New') {
                            git branch: 'main', url: 'https://github.com/ShivamTindgan/Laravel_New.git'
                        }
                    }
                }
        stage('StudentLaravel Build/Deploy') {
                    steps {
                        dir('StudentLaravel') {
                            echo 'Add your StudentLaravel stages here'
                        }
                    }
                }


        stage('Clean Automation') {
            steps {
                dir('Laravel_New') {
                    sh 'mvn clean'
                }
            }
        }
        stage('Run Automation Tests') {
            steps {
                dir('Laravel_New') {
                    sh 'mvn test'
                }
            }
        }

        stage('Generate HTML Report') {
            steps {
            dir('Laravel_New') {
                   sh 'mvn site'
               }
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
           junit 'Laravel_New/target/surefire-reports/*.xml'

           publishHTML(target: [
               allowMissing: true,
               alwaysLinkToLastBuild: true,
               keepAll: true,
               reportDir: 'Laravel_New/target/surefire-reports',
               reportFiles: 'index.html',
               reportName: 'Surefire Test HTML Report'
           ])

           publishHTML(target: [
               allowMissing: true,
               alwaysLinkToLastBuild: true,
               keepAll: true,
               reportDir: 'Laravel_New/target/site',
               reportFiles: 'index.html',
               reportName: 'Maven Site Report'
           ])
       }
   }
}