pipeline {
    agent any
    stages {
        stage ('AWS ECR Authentication') {
            steps {
               sh ''' echo ECR Authentication small changes to trigger webhoook '''
               sh ''' sudo -H -u i21177 bash -c 'aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 510567620487.dkr.ecr.ap-south-1.amazonaws.com' '''
            }
        }
        stage ('Build') {
            steps {
                sh ''' sudo -H -u i21177 bash -c 'docker build -t applicationtier /mnt/c/Application-Tier/demo/backend' '''
            }
        }
        stage ('Push Image to ECR') {
            steps {
                sh ''' sudo -H -u i21177 bash -c 'docker tag applicationtier:latest 510567620487.dkr.ecr.ap-south-1.amazonaws.com/application-tier:latest' '''
                sh ''' sudo -H -u i21177 bash -c 'docker push 510567620487.dkr.ecr.ap-south-1.amazonaws.com/application-tier:latest' '''
            }
        }
        stage ('EKS Deployment') {
            steps {
                sh ''' sudo -H -u i21177 bash -c 'kubectl delete deployment application-layer-deployment 2> /dev/null' '''
                sh ''' sudo -H -u i21177 bash -c 'kubectl apply -f /mnt/c/Application-Tier/demo/bootappdeployment.yaml' '''
            }
        }
    }
}