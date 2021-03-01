folder('camera') {
  displayName('Camera Example')
  description('Folder for the GitLab test example')
}
pipelineJob('camera/example') {
  definition {
    cps {
      script(readFileFromWorkspace("dsl/camera/Jenkinsfile"))
      sandbox()     
    }
  }
}