## ♻️ Selenium Maven Parallel Execution 04/2022

build: mvn compile
run: mvn test 
allure report: allure serve target/allure-results 


***🔥 Lưu ý: nhớ cập nhật thư viện trong pom.xml phiên bản mới nhất***

🔅 Có thể config 2 report là extend or allure , extend report sẽ bị security nên cần chạy lệnh bên dưới

Manage Jenkins->
Manage Nodes->
Click settings(gear icon)->
click Script console on left and type in the following command:

System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")