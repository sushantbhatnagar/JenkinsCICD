job('NodeJS Docker example') {
    scm {
        git('https://github.com/sushantbhatnagar/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Sushant Bhatnagar')
            node / gitConfigEmail('sushantbhatnagar91@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('sushantbhatnagar/nodejsdockerdsl')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}