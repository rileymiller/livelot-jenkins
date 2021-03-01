pipelineJob('product-job') {
  definition {
    cps {
      script(readFileFromWorkspace('./Jenkinsfile'))
      sandbox()     
    }
  }
}