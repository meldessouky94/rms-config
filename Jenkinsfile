node{

   stage('Clear Docker Images & Containers'){
     sh "docker system prune -af"
   }
   
   stage('SCM Checkout'){
     git 'https://github.com/1809-Spark-usf/rms-config'
     sh 'git checkout cloud-dev' 
   }
   
   stage('Compile-Package'){
      // Get maven home path
      def mvnHome =  tool name: 'mitchell-rms-mvn', type: 'maven'   
      sh "${mvnHome}/bin/mvn clean"
      sh "${mvnHome}/bin/mvn install"
   }
   
   stage('Build Docker Image'){
    sh 'docker build -t rms-config .'
      }
   
   stage('Tag Docker Image'){
    sh 'docker tag rms-config:latest 367484709954.dkr.ecr.us-west-1.amazonaws.com/rms-config:latest'
      }
   
   stage('Docker Login & Push to ECR'){
      sh '$(AWS_SHARED_CREDENTIALS_FILE=/var/lib/jenkins/credentials AWS_CONFIG_FILE=/var/lib/jenkins/config aws ecr get-login --no-include-email --region us-west-1 )' 
      sh 'docker push 367484709954.dkr.ecr.us-west-1.amazonaws.com/rms-config:latest'
   }
  
   
   stage('Force New Deployment'){
    sh 'AWS_SHARED_CREDENTIALS_FILE=/var/lib/jenkins/credentials AWS_CONFIG_FILE=/var/lib/jenkins/config aws ecs update-service --cluster mitchell-rms --service rms-config-service --task-definition rms-config-task --force-new-deployment'      
      }
   
}
