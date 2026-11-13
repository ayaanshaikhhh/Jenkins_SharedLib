
def call() {
    dependencyCheck(
        odcInstallation: 'OWASP',
        additionalArguments: '''
            --scan ./
            --data /var/lib/jenkins/.dependency-check-data
            --noupdate
            --disableNodeAudit
        '''.stripIndent().trim()
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
