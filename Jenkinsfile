pipeline {
    environment { 
        registryCredential = 'dockerhub-jenkins' 
        dockerImage = '' 
    }
    agent any

    stages {
        stage('Step 1: Git Pull'){ 

                steps{ 

                    git url: 'https://github.com/akilalakshmanan/ScientificCalculator_DevOps.git'
                }           

            }
        stage('Step 2: Maven Build'){ 

                steps{ 

                    script{ 

                        sh 'mvn clean install' 
                        sh 'sudo cp /var/lib/jenkins/workspace/SPE-Mini-Project/target/ScientificCalculator_DevOps-1.0-SNAPSHOT-jar-with-dependencies.jar  /home/akila/Desktop/ScientificCalculator_DevOps/target/' 
                    } 

                } 

            }
        stage('Step 3: Build docker image') 

            { 
                steps{ 
                    script{ 
                        dockerImage = docker.build 'akila1811/spe-mini-project'  

                    } 
                } 
            } 
        stage('Step 4: Push docker image')
            {
                steps{
                    script {  
                       docker.withRegistry('',registryCredential) { 
                           dockerImage.push() 
                       }
                    }
                }
            }
        stage('Step 5: Ansible pull docker image')
            {
                steps{
                    ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'calculator-playbook.yml'
                }
            }
        
    }
}

