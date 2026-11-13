
def call() {
    retry(conditions: [nonresumable()], count: 2) {
        dependencyCheck(
            odcInstallation: 'OWASP',
            nvdCredentialsId: 'nvd-api-key',
            additionalArguments: '''
                --scan ./
                --data /var/lib/jenkins/.dependency-check-data
                --nvdApiDelay 6000
                --nvdMaxRetryCount 20
                --disableNodeAudit
            '''.stripIndent().trim()
        )

        dependencyCheckPublisher(
            pattern: '**/dependency-check-report.xml'
        )
    }
}
