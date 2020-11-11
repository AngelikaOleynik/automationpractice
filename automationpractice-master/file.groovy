pipeline {
    agent any
    stages {
        stage('Download') {
            steps {
                checkout([$class      : 'GitSCM', branches: [[name: 'main']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'CheckoutOption', timeout: 120]],
                          submoduleCfg: [], userRemoteConfigs: [[
                                                                        url: 'https://github.com/AngelikaOleynik/automationpractice.git']]])
            }
        }
        stage('Build') {
            steps {
                script {
                    def WS = pwd()
                    dir(WS) {
                        dir('SCP') {
                            sh 'mvn clean package'
                        }
                    }
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -Dtest=TestRunner -Dcucumber.options="--tags @myScenario"'
            }
        }
    }
}
