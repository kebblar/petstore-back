pipeline {
    // https://www.jenkins.io/doc/book/pipeline/syntax/
    agent any
    triggers {
        // ver: Job DSL Plugin
        // https://github.com/jenkinsci/generic-webhook-trigger-plugin
        // https://plugins.jenkins.io/generic-webhook-trigger/
        GenericTrigger(
            genericVariables: [
                [
                    key: 'referencia', 
                    value: '$.ref', 
                    regexpFilter:'', 
                    defaultValue:'x'
                ]
            ],

            causeString: 'Triggered on $ref',

            token: '1234',
            tokenCredentialId: 'webhook-secret',

            printContributedVariables: true,
            printPostContent: true,

            silentResponse: false,

            regexpFilterText: '$referencia',
            regexpFilterExpression: 'refs/heads/develop'
        )
    }
  
    tools {
        maven "maven-first"
    }
    environment {
        BASE_PATH = "/var/jenkins_home/workspace"
        PRAGMA_USER = "Gustavo Arellano"
        PROJECT_ROOT = "pipeline-petstore-back"
        EMAIL_ADDRESS = "arellano.gustavo@gmail.com"
    }
    stages {
        stage('Obten Código Fuente') {
            steps {
                git branch: 'develop',
                    credentialsId: '31459996-f0c4-44ad-a81b-f8d9b3e81e72',
                    url: 'https://github.com/kebblar/petstore-back.git'     
            }
        }
        stage('Compila & Construye') {
            steps {
                sh "mvn -Dmaven.test.skip=true package"
            }
        }
        stage('Ejecuta Pruebas Unitarias & jacoco') {
            steps {
                // Genera jacoco reports
                sh "mvn clean test"
            }
            post {
                // en caso de éxito haz algo....
                success {
                    //junit '**/target/surefire-reports/*.xml'
                    //archiveArtifacts 'target/*.jar'
                    sh "echo 'todo bien con jacoco'"
                    sh "ls -la"
                    sh "pwd"
                }
            }
        }

        stage("Corre Escaneo de Sonar") {
            environment {
                scannerHome = tool 'sonar-scanner'
            }
            
            steps {
                withSonarQubeEnv('sonar-scanner') {
                    sh "${scannerHome}/bin/sonar-scanner \
                    -Dsonar.projectKey=pipeline-petstore-back \
                    -Dsonar.projectName=pipeline-petstore-back \
                    -Dsonar.projectVersion=0.${BUILD_NUMBER} \
                    -Dsonar.sources=${BASE_PATH}/${PROJECT_ROOT}/src/main/java \
                    -Dsonar.test.sources=${BASE_PATH}/${PROJECT_ROOT}/src/test/java \
                    -Dsonar.language=java \
                    -Dsonar.java.binaries=${BASE_PATH}/${PROJECT_ROOT}/target/classes \
                    -Dsonar.java.test.binaries=${BASE_PATH}/${PROJECT_ROOT}/target/test-classes \
                    -Dsonar.junit.reportPaths=${BASE_PATH}/${PROJECT_ROOT}/target/jacoco.exec \
                    -Dsonar.coverage.jacoco.xmlReportPaths=${BASE_PATH}/${PROJECT_ROOT}/target/site/jacoco/jacoco.xml \
                    -Dsonar.java.coveragePlugin=jacoco"
                }
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: qualityGateValidation(waitForQualityGate())
                }                
            }
            
        }

    }
}

def qualityGateValidation(qg) {
    if(qg.status != 'OK') {
        emailext body: "El código no pasó el Quality Gate de Sonar", subject: "Error Sonar Scan, Quality Gate", to: "${EMAIL_ADDRESS}"
        return true
    }
    emailext body: "El código ha pasado el Quality Gate de sonar exitosamente", subject: "Info -Ejecucion pipeline", to: "${EMAIL_ADDRESS}"
    return false
}
