#!usr/bin/env groovy

import org.com.utils.buildUtils

def call() {
  def build_utils = new buildUtils()
  
  pipeline {
      agent {
          label 'agent_maven'
      }
      stages {
          stage('Build') {
              steps {
                  script {
                      image = build_utils.get_image()
                      version = build_utils.get_version()
                      build_utils.maven('-B -DskipTests clean package')
                  }
              }
          }
          stage('Test') {
              steps {
                build_utils.maven('test')
              }
              post {
                  always {
                      junit 'target/surefire-reports/*.xml'
                  }
              }
          }
      }
  }
}
