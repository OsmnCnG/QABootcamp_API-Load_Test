# PetStore API Test Otomasyonu

Bu proje, [Swagger PetStore API](https://petstore.swagger.io/) üzerinde temel CRUD işlemleri (GET, POST, PUT, DELETE) için yazılmış otomatik API testlerini içermektedir. Testler, Java ile yazılmış olup [RestAssured](https://rest-assured.io/), [TestNG](https://testng.org/) ve [Allure Report](https://docs.qameta.io/allure/) kullanılarak oluşturulmuştur.

---

## Kullanılan Teknolojiler

- **RestAssured**
- **TestNG**
- **Jenkins**
- **Allure Report**
- **Postman**
- **Swagger PetStore API**

---

## Postman Collection

Postman Collection dosyasını 1.ApiTest klasörü içerisine ekledim. Postman içerisine import edebilirsiniz.

## Test Raporları ve Allure Görselleri

Testlerimiz Jenkins aracı ile otomatik olarak çalıştırılmakta ve sonuçlar **Allure** raporları halinde oluşturulmaktadır.
### Jenkins Allure Test Raporu

<img src="https://i.imgur.com/v8D33D2.png" width="400" height="300" />
<img src="https://i.imgur.com/DyuOwSt.png" width="400" height="300" />

## Locust Reports

- HTML Rapor: [`reports/report.html`](2.LoadTest/reports/Locust_2025-06-09-17h14_Main.py_https___petstore.swagger.io.html)
- Detaylı açıklama: [`docs/LoadTest-Raporu.md`](docs/LoadTest-Raporu.md)
