#!usr/bin/env groovy

import org.com.utils.buildUtils

def call() {
    def build_utils = new buildUtils()

    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    script {
                        echo "HELLO FROM THE OTHER SIDE"
                    }
                }
            }
            stage('Test') {
                steps {
                    script{
                        echo "testing"
                  }
                }
                post {
                    always {
                        echo "post from the pipeline"
                    }
                }
            }
        }
    }
}
