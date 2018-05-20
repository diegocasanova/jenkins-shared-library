def call(body) {
    echo "Testing input step..."
    def summiter = 'admin,master'
    input message: 'Release to production?', submitter: summiter
}