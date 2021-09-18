job('NodeJS example with DSL') {
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
        nodejs('NodeJS') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}