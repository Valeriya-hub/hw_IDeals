# hw_IDeals framework

In the hw_IDeals repository implemented a registration test using two approaches: Page Object + Selenium and Page Object + Selenide.

---

### Tech stack:
- Java 8
- Maven
- JUnit

---
### Use this command to download code base:

`git clone https://github.com/Valeriya-hub/hw_IDeals.git`

---

### Run tests

Local run

Common execution variables and rules:

`mvn clean test -Dbrowser=chrome -Dheadless=true -Dremote=false`

#### Where:
- -Dbrowser=chrome (Optional, by default "chrome", options: "edge, chrome, firefox)
- -Dheadless=true (Optional, by default "false" applicable to "chrome" and firefox only)
- -Dremote=false (Optional, by default "false")

---
