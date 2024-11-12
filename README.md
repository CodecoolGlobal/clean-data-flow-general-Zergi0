# About The Project
This is a learning project created under CodeCool for testing the website of Aegir with automated testing. The System Under Testing is included below. \
The SUT is found here : https://github.com/CodecoolGlobal/system-under-testing-registration-form-general-Zergi0 \
This is a practice project made with the intention of learning how to handle more complex and flawed forms in Selenium. \
Since the information required for each test is massive, the project uses Parameterized tests as a way to help readability. 

## Built With
- Java
- JUnit
- Selenium
- Maven

# Getting Started

## Instructions to run SUT

### Prerequisites

Ensure you have the following installed:

- Python 3.6 or later
- pip (Python package installer)

### Installation
- Install and run SUT:

1. **Clone the SUT repository:**
   ```bash
   git clone https://github.com/CodecoolGlobal/system-under-testing-registration-form-general-Zergi0.git
   ```

2. **Create a virtual environment (optional but recommended):**
    ```bash
    python -m venv venv
    ```

3. **Activate the virtual environment:**
  - On Windows:
    ```bash
    .\venv\Scripts\activate
    ```
  - On Unix systems (macOS and Linux distros):
    ```bash
    source venv/bin/activate`
    ```

4. **Install the dependencies:**
    ```bash
    pip install -r requirements.txt
    ```

5. **Run the application:**
    ```bash
    python app.py
    ```

- Install and run tests:
1. **Clone this repository:**
```bash
git clone https://github.com/CodecoolGlobal/clean-data-flow-general-Zergi0.git
```

2. **Navigate to the folder and install dependencies:**
```bash
mvn clean install
```
The install should run tests on startup, if it doesnt use:
```bash
mvn test
```
