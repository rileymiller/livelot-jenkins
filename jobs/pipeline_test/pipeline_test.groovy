pipelineJob('product-job') {
  definition {
    cps {
      script(readFileFromWorkspace("${env.WORKSPACE}/jobs/pipeline_test/Jenkinsfile"))
      sandbox()     
    }
  }
}