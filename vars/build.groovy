#!usr/bin/env groovy
import es.org.com.buildUtils



def call() {
  def buil_utils = new buildUtils()
  
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
                      buil_utils.maven_build('mvn -B -DskipTests clean package')
                  }
              }
          }
          stage('Test') {
              steps {
                  sh 'mvn test'
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
