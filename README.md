# Automated Testing Repository

This repository contains automated tests for Prodly.

## Tools Used

### Java

### RestAssured

### Log4j

### Base64 Encoding

## Getting Started

To get started with running the automated tests locally, follow these steps:

1. Clone this repository to your local machine:

```bash
git clone git@github.com:Karengrigoryan060/prodly.git
```

2. Install the necessary dependencies. You may need to have Maven installed to manage dependencies:

```bash
mvn clean install
```

3. Configure the test environment settings, such as API endpoints or authentication credentials, in the test
   configuration files.

4. Run the tests using Maven:

```bash
mvn test
```

## Parameters

### In the source resources folder you can see configuration file,

1. api_url
2. repo_path
3. api_version
4. api_token

### Following params can be overridden using ENV variables if you would like to use different params in CI. Also is not recommended to push your personal access token