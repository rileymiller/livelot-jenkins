pipelineJob('product-job') {
  definition {
    cps {
      script(readFileFromWorkspace("jobs/pipeline_test/Jenkinsfile"))
      sandbox()     
    }
  }
}