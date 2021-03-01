job('bootstrap') {
    scm {
      git {
        remote {
          github('rileymiller/livelot-jenkins', 'ssh')
          credentials('git-ssh-key')
        }
        branch 'master'
      }
    }
    triggers {
        scm 'H/5 * * * *'
    }
    steps {
        dsl {
            external 'dsl/**/*.groovy'
        }

    }
    publishers {
    }
}